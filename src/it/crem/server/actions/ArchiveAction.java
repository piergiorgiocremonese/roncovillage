package it.crem.server.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import it.ash.mail.SendMail;
import it.crem.common.Utility;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.mng.DbMngExt;

public class ArchiveAction extends RoncoAction{
	
	
	private ArrayList<Ragazzi> ragazzi = new ArrayList();
	
	private ArrayList anni = new ArrayList();
	private Integer[] advice = null; 
	private Logger logger = Logger.getLogger(this.getClass());
	private String html = "";
	private String esito = null;
	private HashMap<Integer,List<Object>> periodi = null;
	
	private String getTextMailInfo(Ragazzi r){
		
		//String text = "Ciao " + r.getNome()+ " " + r.getCognome()+"\n" + Utility.MAIL.getString("mail.info.text");
		String text =  Utility.MAIL.getString("mail.info.text");;
		String link = "<a href=\""+Utility.RONCO.getString("ronco.url")+Utility.RONCO.getString("ronco.invito.uri")+"?oid="+r.getOid()+"&code="+r.getCode()+"\"> Link </a>";
		
		text=text.replaceAll("<LINK>", link);
		return text;
	}
	
	private String mkHtml(Ragazzi r, String text){
		logger.debug("text da trasgormare in html:"+text);
		String myhtml="<html><img src=\""+Utility.RONCO.getString("ronco.url")+Utility.RONCO.getString("ronco.logo.uri")+"\"/><br>";
		myhtml = myhtml + "<p>Ciao " + r.getNome()+ " " + r.getCognome()+"</p>";
		myhtml=myhtml+"<p>"+text+"</p>";
		myhtml = myhtml.replaceAll("! ", "!<br>");
		myhtml=myhtml.replaceAll("\\. ", ".<br>");
		logger.debug("html da inviare:"+myhtml);
		return myhtml;
		
	}
	public String inform(){
		logger.debug("inizio azione informazione");
		DbMngExt db = new DbMngExt();
		html="<p>Messaggio inviato a tutti gli utenti:</p>";
		if (advice!=null){
			for (int i=0;i<advice.length;i++){
				Ragazzi ragazzo = (Ragazzi)db.getObject(advice[i], "Ragazzi");
				SendMail sm = new SendMail();
				String from = Utility.MAIL.getString("mail.sender");
				String subject  = Utility.MAIL.getString("mail.info.subject");
				
				ArrayList<String> dests = new ArrayList<String>();
				String email = "";
				Boolean ok=false;
				if ((ragazzo.getEmailMadre()!=null)&&(ragazzo.getEmailMadre().contains("@"))){
					email = ragazzo.getEmailMadre();
					dests.add(email);
					ok=true;
					
				}
				if ((ragazzo.getEmailPadre()!=null)&&(ragazzo.getEmailPadre().contains("@"))){
					email = email + " " + ragazzo.getEmailPadre();
					dests.add(ragazzo.getEmailPadre());
					ok=true;
				}
				if (ok){
				String text =  this.getTextMailInfo(ragazzo);
				logger.debug("test mail da inviare" + text);
				String htm = mkHtml(ragazzo,text);
				logger.debug("invio html: "+htm);
				sm.sender(from, subject, dests, "", htm, null);
				ragazzo.setMailInviata("OK");
				html = html + "<p>"+ragazzo.getNome()+" "+ragazzo.getCognome()+ " "+ email+"</p>";
				esito = "SUCCESS";
				}
			}
		}
		
		
		return SUCCESS;
	}	
	
	public String execute(){
		Date today = Calendar.getInstance().getTime();
		Integer inizio = 2016;
		Integer anno = Integer.parseInt(Utility.getAnno(today));
		Integer i=inizio;
		DbMngExt db = new DbMngExt();
		periodi = new HashMap<Integer,List<Object>>();
		while (i<anno){
			anni.add(i);
			List<Object> list = db.getListObject("Periodi", "anno",i+"");
			periodi.put(i,list);
			
			i++;
		}
		return SUCCESS;
	}

	public ArrayList getAnni() {
		return anni;
	}

	public void setAnni(ArrayList anni) {
		this.anni = anni;
	}
	public ArrayList<Ragazzi> getRagazzi() {
		return ragazzi;
	}
	public void setRagazzi(ArrayList<Ragazzi> ragazzi) {
		this.ragazzi = ragazzi;
	}
	public Integer[] getAdvice() {
		return advice;
	}
	public void setAdvice(Integer[] advice) {
		this.advice = advice;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}

	public HashMap<Integer, List<Object>> getPeriodi() {
		return periodi;
	}

	public void setPeriodi(HashMap<Integer, List<Object>> periodi) {
		this.periodi = periodi;
	}

}
