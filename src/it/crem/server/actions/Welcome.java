package it.crem.server.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import it.ash.mail.SendMail;
import it.crem.common.Utility;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.mng.DbMng;
import it.crem.db.mng.DbMngExt;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import it.crem.db.conf.Documenti;
public class Welcome extends RoncoAction implements
ServletRequestAware,ServletResponseAware  {
	private static Logger logger = Logger.getLogger(Utility.class);
	private String from=null;
	private String subject=null;
	private String body = null;
	private String esito = null;
	private String url = null;
	private String doc = null;
	private Integer ragazzoOid = null;
	private String pdf = null;
	private String[] periodi = null;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private Integer annoInizio = null;
    private Integer annoFine = null;
	private String oidList = null;
	private String mode = "struct";
	private List<Object> documenti  = null;
	private Documenti iscrizione = null;
	private Documenti vaccinazioni = null;
	private Documenti liberatoria = null;
	
	
	public String sendPdf(){
		String mail = null;
		String name = null;
		SendMail sm = new SendMail();
		ArrayList<String> dests = new ArrayList<String>();
		
		try{
			DbMngExt db = new DbMngExt();
			if ((ragazzoOid!=null)&&(ragazzoOid>0)){
				Ragazzi r = (Ragazzi)db.getObject(ragazzoOid,"Ragazzi");
				if (r!=null){
					name = r.getCognome()+"-"+r.getNome();
					if (name!=null)
						name = name.replaceAll("\b", "_");
					if ((r.getEmailMadre()!=null)&&(!"".equals(r.getEmailMadre())))
						mail=r.getEmailMadre();
					else
						mail = r.getEmailPadre();
					dests.add(mail);
					dests.add(Utility.MAIL.getString("mail.fattura.dest"));
					logger.debug("mail di invio: " + mail);
					
				}else{
					logger.debug("ragazzo non trovato: "+ragazzoOid);
				}
			}else{
				logger.debug("oid ragazzo non fornito in input: "+ragazzoOid);
			}
			
			ServletInputStream in = request.getInputStream();
			StringBuffer sb = new StringBuffer();
			int c=0;
			while ((c=in.read())!=-1){
				sb.append((char)c);
			}
			doc = sb.toString();
			doc = Utility.updateEuro(doc);
			logger.debug("testo da convertire: "+doc);
			String fn = "file.pdf";
			if (name!=null){
				fn = name + ".pdf";
			}
			pdf = Utility.htmlText2pdf(doc, fn);
			ArrayList<String> atts = new ArrayList<String>();
			atts.add(pdf);
			subject  = Utility.MAIL.getString("mail.fattura.subject");
			from = Utility.MAIL.getString("mail.fattura.sender");
			//from = Utility.getSender(dests,"mail.fattura.sender");
			String body =  Utility.MAIL.getString("mail.fattura.text") + name;
			String html = "<html><body>"+body+"</body></html>";
			
			
			String msglog = "invio messaggio:  "+body+"\na: "+mail;
			/*
			String destinatari  = Utility.MAIL.getString("mail.dest.list");
			if (destinatari!=null){
				String[] list = destinatari.split(",");
				if (list!=null){
					for (int i=0;i<list.length;i++){
						dests.add(list[i]);
						msglog = msglog + ", " + list[i];
					}
				}
			}
			*/
			sm.sender(from, subject, dests, body, html, atts);
			logger.debug("inviato messaggio: " +msglog + " da " + from);
			ServletOutputStream out = response.getOutputStream();
			out.println(pdf);
			
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return null;
	}
	private String getHtml(){
		String html = "<html><body><center><b>Richiesta Informazioni</b></center><br/><br/>";
		
		
		html = html+"<table>";
		html = html + "<tr><td>From:</td><td>"+from+"</td></tr>";
		html = html + "<tr><td>Subject:</td><td>"+subject+"</td></tr>";
		html = html + "<tr><td colspan=\"2\">"+body+"</td></tr>";
		html = html + "</table></body></html>";
		
		return html;
	}
	
	public String sendMail(){
		SendMail sm = new SendMail();
		DbMng db = new DbMng();
		logger.debug("devo inviare " + body + " a "+oidList + " in modo "+mode);
		String outMsg = SUCCESS;
		try{
		String destinatari  = Utility.MAIL.getString("mail.dest.list");
		JSONObject json = new JSONObject();
		if ((subject==null)||("".equals(subject)))
			subject  = Utility.MAIL.getString("mail.info.detailed.subject");
		String fd = "";
		String nor="";
		
		if ((oidList != null)&&(!"".equals(oidList))){
			logger.debug("lista destinatari = " + oidList);
			String[] list = oidList.split(";");
			for (int i=0;i<list.length;i++){
				Integer oid = Integer.parseInt(list[i]);
				Ragazzi r =(Ragazzi) db.getObject(oid, "Ragazzi");
				if (r!=null){
					if ((r.getEmailPadre()!=null)&&(!"".equals(r.getEmailPadre()))){
						destinatari = destinatari +","+ r.getEmailPadre();
						if ("".equals(fd))
							fd =r.getEmailPadre();
						else
							fd =fd + ","+r.getEmailPadre();
					}
					
					if ((r.getEmailMadre()!=null)&&(!"".equals(r.getEmailMadre()))){
						destinatari = destinatari +","+ r.getEmailMadre();
						if ("".equals(fd))
							fd =r.getEmailMadre();
						else
							fd =fd + ","+r.getEmailPadre();
					}
					if ((((r.getEmailMadre()==null)&&(r.getEmailPadre()==null)))||(("".equals(r.getEmailPadre())&&"".equals(r.getEmailMadre())))){
						if ("".equals(nor))
							nor =r.getNome()+ " "+r.getCognome();
						else
							nor =nor + ","+r.getNome()+ " "+r.getCognome();;
					}
				}else{
					logger.debug("non trovo il ragazzo per " + oid);
				}
			}
			
			
			logger.debug("lista destinatari = "+destinatari);
		}else{
			logger.debug("non ci sono destinatari");
		}
		from = Utility.MAIL.getString("mail.sender");
		logger.debug("invio msg: "+body + " come + html");
		String html = body;
		if (!mode.equals("flat")){
			html = getHtml();
		
		}
		else  {
			if (!html.contains("http://www.roncovillage.it/ronco/images/logo2-mini.png"))
				html = html + "<p><img src=\"http://www.roncovillage.it/ronco/images/logo2-mini.png\" /></p>";
			
	
		}
		ArrayList<String> dests = new ArrayList<String>(); 
		if (destinatari!=null){
			String[] list = destinatari.split(",");
			if (list!=null){
				for (int i=0;i<list.length;i++){
					if ((list[i] != null)&&(!"".equals(list[i]))&&(list[i].contains("@")))
						dests.add(list[i]);
					else
						logger.debug(list[i] + " non sembra un indirizzo valido");
				}
				sm.sender(from, "Richiesta Informazioni", dests, "", html, null);
				esito = "Mail inviata con successo da : " +from;
			}else{
				esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
			}
			
		}else{
			esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
		}
		//ServletOutputStream out = response.getOutputStream();
		//out.println(pdf);
		
		}
		catch (Exception E){
			E.printStackTrace();
			
		}
			
		return SUCCESS;
	}
	
	
	public String sendMailToCustomer(){
		SendMail sm = new SendMail();
		DbMng db = new DbMng();
		logger.debug("devo inviare " + body + " a "+oidList + " in modo "+mode);
		String outMsg = SUCCESS;
		try{
		String destinatari  = Utility.MAIL.getString("mail.dest.list");
		JSONObject json = new JSONObject();
		if ((subject==null)||("".equals(subject)))
			subject  = Utility.MAIL.getString("mail.info.detailed.subject");
		String fd = "";
		String nor="";
		
		if ((oidList != null)&&(!"".equals(oidList))){
			logger.debug("lista destinatari = " + oidList);
			String[] list = oidList.split(";");
			for (int i=0;i<list.length;i++){
				Integer oid = Integer.parseInt(list[i]);
				Ragazzi r =(Ragazzi) db.getObject(oid, "Ragazzi");
				if (r!=null){
					if ((r.getEmailPadre()!=null)&&(!"".equals(r.getEmailPadre()))){
						destinatari = destinatari +","+ r.getEmailPadre();
						if ("".equals(fd))
							fd =r.getEmailPadre();
						else
							fd =fd + ","+r.getEmailPadre();
					}
					
					if ((r.getEmailMadre()!=null)&&(!"".equals(r.getEmailMadre()))){
						destinatari = destinatari +","+ r.getEmailMadre();
						if ("".equals(fd))
							fd =r.getEmailMadre();
						else
							fd =fd + ","+r.getEmailPadre();
					}
					if ((((r.getEmailMadre()==null)&&(r.getEmailPadre()==null)))||(("".equals(r.getEmailPadre())&&"".equals(r.getEmailMadre())))){
						if ("".equals(nor))
							nor =r.getNome()+ " "+r.getCognome();
						else
							nor =nor + ","+r.getNome()+ " "+r.getCognome();;
					}
				}else{
					logger.debug("non trovo il ragazzo per " + oid);
				}
			}
			
			
			logger.debug("lista destinatari = "+destinatari);
		}else{
			logger.debug("non ci sono destinatari");
		}
		from = Utility.MAIL.getString("mail.sender");
		logger.debug("invio msg: "+body + " come + html");
		String html = body;
		if (!mode.equals("flat")){
			html = getHtml();
		
		}
		else  {
			if (!html.contains("http://www.roncovillage.it/ronco/images/logo2-mini.png"))
				html = html + "<p><img src=\"http://www.roncovillage.it/ronco/images/logo2-mini.png\" /></p>";
			if (!fd.equals("")){
				json.put("esito", "OK");
				json.put("destok",fd);
			}else{
				json.put("esito", "KO");
				json.put("destok", "NO OK");
			}
			if (nor.equals("")){
				json.put("destko", "NO KO");
			}else{
				json.put("destko", nor);
			}
	
		}
		ArrayList<String> dests = new ArrayList<String>(); 
		if (destinatari!=null){
			String[] list = destinatari.split(",");
			if (list!=null){
				for (int i=0;i<list.length;i++){
					if ((list[i] != null)&&(!"".equals(list[i]))&&(list[i].contains("@")))
						dests.add(list[i]);
					else
						logger.debug(list[i] + " non sembra un indirizzo valido");
				}
				sm.sender(from, "Richiesta Informazioni", dests, "", html, null);
				esito = "Mail inviata con successo da : " +from;
				String txtmsg ="Mail inviata con successo da : " +from + " a "+destinatari;
				if (!nor.equals("")){
					txtmsg = txtmsg + "  ma non oinviata a "+nor;
					
				}
				json.put("msg", txtmsg);
			}else{
				esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
				json.put("msg", "Mail non inviata " );
			}
			
		}else{
			esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
			json.put("esito", "KO");
			json.put("msg", "Mail non inviata " );
		}
		logger.debug("invio "+json.toString());
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("application/json");
		out.println(json.toString());
		
		}
		catch (Exception E){
			E.printStackTrace();
			try {
				JSONObject json = new JSONObject();
				json.put("esito", "KO");
				json.put("msg", "Mail non inviata " );
				ServletOutputStream out = response.getOutputStream();
				response.setContentType("application/json");
				out.println(json.toString());
						
			}
			catch (Exception F){
				F.printStackTrace();
				logger.error(F.toString());
			}
			
		}
			
		return (String)null;
	}
	
	
	public String getOidList() {
		return oidList;
	}
	public void setOidList(String oidList) {
		this.oidList = oidList;
	}
	public String send(){
		SendMail sm = new SendMail();
		DbMng db = new DbMng();
		String destinatari  = Utility.MAIL.getString("mail.dest.list");
		if ((oidList != null)&&(!"".equals(oidList))){
			String[] list = oidList.split(";");
			for (int i=0;i<list.length;i++){
				Integer oid = Integer.parseInt(list[i]);
				Ragazzi r =(Ragazzi) db.getObject(oid, "Ragazzi");
				if (r!=null){
					if (r.getEmailPadre()!=null)
						destinatari = destinatari +","+ r.getEmailPadre();
					if (r.getEmailMadre()!=null)
						destinatari = destinatari +","+ r.getEmailMadre();
					
				}
			}
		}
		String html = getHtml();
		ArrayList<String> dests = new ArrayList<String>(); 
		if (destinatari!=null){
			String[] list = destinatari.split(",");
			if (list!=null){
				for (int i=0;i<list.length;i++)
					dests.add(list[i]);
				sm.sender(from, "Richiesta Informazioni", dests, "", html, null);
				esito = "Mail inviata con successo da : " +from;
			}else{
				esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
			}
			
		}else{
			esito = "Non &egrave; possibile inviare la mail: riprovare in seguito";
		}
		
		return SUCCESS;
	}
	
	public String welcome(){
		url = Utility.RONCO.getString("ronco.url");
		DbMng db = new DbMng();
		Date now = Calendar.getInstance().getTime();
		String anno = Utility.getAnno(now);
		Integer annoIntero = Integer.parseInt(anno);
		annoInizio = annoIntero-6;
		annoFine = annoIntero-14;
		
		HashMap<String,String> pars = new HashMap<String,String>();
		pars.put("annon",anno);
		List periodi = db.getListObjectOrdered("Periodi", "anno", anno, "ordine");
		if (periodi!=null){
			this.periodi = new String[periodi.size()];
			for (int i=0;i<periodi.size();i++){
				Periodi p = (Periodi)periodi.get(i);
				String e = "";
				String gi = Utility.getGiorno(p.getInizio());
				String mi = Utility.getMese(p.getInizio());
				String ge = Utility.getGiorno(p.getFine());
				String me = Utility.getMese(p.getFine());
				if (mi.equals(me)){
					e = p.getOrdine() + " Settimana: "+gi+"-"+ge +" "+ me;
				}else{
					e = p.getOrdine() + " Settimana: "+gi+" " + mi+"-"+ge +" "+ me;
				}
				this.periodi[i]=e;
				
			}
		}
		Integer ianno = Integer.parseInt(Utility.getAnno(now));
		documenti = db.getListObject("Documenti", "anno", ianno);
		for (Object o: documenti){
			Documenti d = (Documenti)o;
			if ("vaccinazioni".equals(d.getKeywords())){
				vaccinazioni = d;
			}else if ("iscrizione".equals(d.getKeywords())){
				iscrizione = d;
			}else if ("liberatoria".equals(d.getKeywords())){
				liberatoria = d;
			}
			else{
				logger.debug("non so che doc sia ");
			}
			
		}
	
		return SUCCESS;
	}

	public List<Object> getDocumenti() {
		return documenti;
	}
	public void setDocumenti(List<Object> documenti) {
		this.documenti = documenti;
	}
	public Documenti getIscrizione() {
		return iscrizione;
	}
	public void setIscrizione(Documenti iscrizione) {
		this.iscrizione = iscrizione;
	}
	public Documenti getVaccinazioni() {
		return vaccinazioni;
	}
	public void setVaccinazioni(Documenti vaccinazioni) {
		this.vaccinazioni = vaccinazioni;
	}
	public String show(){
		DbMng db = new DbMng();
		
		url = Utility.RONCO.getString("ronco.url");
		Date now = Calendar.getInstance().getTime();
		Integer anno = Integer.parseInt(Utility.getAnno(now));
		documenti = db.getListObject("Documenti", "anno", anno);
		for (Object o: documenti){
			Documenti d = (Documenti)o;
			if ("vaccinazioni".equals(d.getKeywords())){
				vaccinazioni = d;
			}else if ("iscrizione".equals(d.getKeywords())){
				iscrizione = d;
			}else if ("liberatoria".equals(d.getKeywords())){
				liberatoria = d;
			}
			else{
				logger.debug("non so che doc sia ");
			}
			
		}
		return SUCCESS;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public Integer getRagazzoOid() {
		return ragazzoOid;
	}

	public void setRagazzoOid(Integer ragazzoOid) {
		this.ragazzoOid = ragazzoOid;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String[] getPeriodi() {
		return periodi;
	}
	public void setPeriodi(String[] periodi) {
		this.periodi = periodi;
	}
	public Integer getAnnoInizio() {
		return annoInizio;
	}
	public void setAnnoInizio(Integer annoInizio) {
		this.annoInizio = annoInizio;
	}
	public Integer getAnnoFine() {
		return annoFine;
	}
	public void setAnnoFine(Integer annoFine) {
		this.annoFine = annoFine;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Documenti getLiberatoria() {
		return liberatoria;
	}
	public void setLiberatoria(Documenti liberatoria) {
		this.liberatoria = liberatoria;
	}

	
	
	
	
}
