package it.crem.server.actions;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;



import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import it.crem.db.conf.Allegati;
import it.crem.db.conf.Documenti;
import it.crem.db.conf.Partecipanti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.conf.Sconti;
import it.crem.db.conf.Tipologie;
import it.crem.db.mng.DbMng;
import it.crem.db.mng.DbMngExt;
import it.ash.mail.MailClient;
import it.ash.mail.SendMail;
import it.crem.cms.beans.PageCmsBean;
import it.crem.cms.common.CmsUtility;
import it.crem.common.Utility;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;




public class Registrazione extends RoncoAction{
	private List<Object> periodiList = null;
	private Integer[] tipologiaOid = null;
	private String esito = null;
	private String html = null;
	private String code = null;
	private Integer oid = null;
	private String[] settimana = null;
	private Integer[] settimanaOid = null;
	
	private String nome=null;
	private String cognome=null;
	private String indirizzo=null;
	private String citta=null;
	private String cap=null;
	
	private String classe = null;
	private String fratelli = null;
	private String nomepadre = null;
	private String nomemadre = null;
	private String cognomepadre = null;
	private String cognomemadre = null;
	
	private String accompagnatore = null;
	private String telcasa = null;
	private String cellpadre = null;
	private String cellmadre = null;
	private String telwp = null;
	private String telwm = null;
	private String telacc = null;
	private String emailpadre = null;
	private String emailmadre = null;
	private String allal = null;
	private String allsan = null;
	private String sconto = null;
	private String san = null;
	private String anno = null;
	private String nascita = null;
	private String cittaNascita = null;
	private String codfiscpadre = null;
	private String codfiscmadre = null;
	private Ragazzi ragazzo = null;
	private String periodi = "";
	private File[] fileUpload = null;
	private String[] fileType = null;
	private String[] fileDesc = null;
	private String[] fileName = null;
	private String[] anni = Utility.RONCO.getString("ronco.anni").split(";");;
	private String[] classi = Utility.RONCO.getString("ronco.classi").split(";");
	private Logger logger = Logger.getLogger(this.getClass());
	private String[] settimanaStato = null;
	private Integer[] settimanaStatoOid = null;
	
	private List<Object> tipologie = null;
	private String fratellonome = null;
	private String myanno = "";
	private String backUrl = "/ronco/iscrizione";
	
	private boolean admin = false;
	private HashMap<String,String> docList = null;
	
	private Integer pageOid = null;
	private PageCmsBean pcb = null;
	private CmsUtility cmsUtil = new CmsUtility();  
	
	private String[] headercnt = null;
	private String[] headercode = null;
	private String[] footercnt = null;
	private String[] footercode = null;
	private String[] contentuti = null;
	
	
	private String mkHtml(){
		String html = "<html><body><center><b>Nuova richiesta di iscrizione</b></center><br/><br/>";
		
		
		html = html+"<table>";
		html = html + "<tr><td>Nome:</td><td>"+nome+" " + cognome+"</td></tr>";
		html = html + "<tr><td>Indirizzo:</td><td>"+indirizzo+"</td></tr>";
		html = html + "<tr><td>Citta:</td><td>"+citta+"</td></tr>";
		html = html + "<tr><td>CAP:</td><td>"+cap+"</td></tr>";
		html = html + "<tr><td>Telefono:</td><td>"+telcasa+"</td></tr>";
		html = html + "<tr><td>periodo richiesto:</td><td>"+periodi+" " + anno + "</td></tr>";
		html = html + "<tr><td>Classe/anno:</td><td>"+nascita+"</td></tr>";
		html = html + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
		html = html + "<tr><td>Padre:</td><td>"+nomepadre+ " " + cognomepadre+":"+codfiscpadre+":"+cellpadre+":"+emailpadre+"</td></tr>";
		html = html + "<tr><td>Madre:</td><td>"+nomemadre+ " " + cognomemadre +": "+codfiscmadre+":"+cellmadre+":"+emailmadre+"</td></tr>";
		html = html + "<tr><td>Accompagnatore:</td><td>"+accompagnatore+"</td></tr>";
		html = html + "<tr><td>Fratelli:</td><td>"+fratelli+"</td></tr>";
		html = html + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
		html = html + "<tr><td>Allergie Alimentari:</td><td>"+this.allal+"</td></tr>";
		html = html + "<tr><td>Precauzioni Sanitarie :</td><td>"+this.allsan+"</td></tr>";
		
		
		html = html + "</table>";
		html = html+ "<p><img src=\""+MailClient.MAIL.getString("mail.logo.mail.url")+"\" /></p>";
		html = html + "</body></html>";
		return html;
	}
	
		
	public String show(){
		DbMngExt db = new DbMngExt();
		CmsUtility cmsUtil = new CmsUtility();
		admin = this.isPrivate();
		String outMsg = "form";
		if (admin){
			
			outMsg = "privform";
			logger.debug("caso privato "+admin+ " out="+outMsg);
		}else{
			if (pageOid!=null){
			logger.debug("caso pubblico "+admin);;
			pcb = cmsUtil.getPage(pageOid, null);
			outMsg = "registrazione-new";
			}
		}
		logger.debug("parte visualizzazione");
		Date now = Calendar.getInstance().getTime();
		String annoNascita = null;
		
		if (anno==null)
			anno = Utility.getAnno(now);
		HashMap<String,String> pars = new HashMap<String,String>();
		pars.put("anno", anno);
		//periodiList = db.getListObject("Periodi", pars);
		periodiList = db.getListObjectOrdered("Periodi", "anno", anno, "ordine");
		if (periodiList!=null)
		for (Object o: periodiList){
			Periodi p = (Periodi)o;
			if (p.getLibero()){
				List iscritti = db.getIscrittiPeriodo(p);
				if (iscritti!=null){
					p.setNumeroIscritti(iscritti.size());
					if (iscritti.size()>=p.getNumeroMassimo()){
						p.setLibero(false);
						db.updObject(p);
					}
					
				}
			}else{
				logger.debug("questp periodo pieno " + p.getOrdine());
				p.setNumeroIscritti(p.getNumeroMassimo());
				
			}	
		}
		else
			logger.error("non ho trovato periodi nell'anno "+anno);
		tipologie =  db.getListObject("Tipologie", null);
		Set<Partecipanti> parts = null;
		logger.debug("oid=#"+oid+"# code="+code);
		if (code!=null && oid!=null){
			logger.debug("aggiornamento ragazzo: "+oid);
			ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
			if (ragazzo!=null){
				logger.debug("triovato ragazzo: "+ragazzo.getCognome());
				parts = db.getPartecipantiPerAnno(ragazzo, anno);
				if (parts==null)
					logger.debug("no periodi scelti");
				else
					logger.debug("periodi scelti: "+parts.size());
			if (code.equals(ragazzo.getCode())){
				//outMsg = "form";
				myanno = ragazzo.getAnnoNascita()+"";
				classe = ragazzo.getClasseFrequentata();
			}	
			}else{
				logger.debug("NON triovato ragazzo: "+oid);
				
				ragazzo = new Ragazzi();
				classe="Seleziona la classe frequentata";
				myanno="Seleziona data di nascita";
			}
			
			for (int i=0;i<periodiList.size();i++){
				Periodi p = (Periodi)periodiList.get(i);
				logger.debug("controllo se " + ragazzo.getCognome() + " ha scelto il periodo " + p.getOrdine()+ " -"+p.getAnno());
				
				if (Utility.isIn(p,parts)){
					logger.debug("periodo scelto " + p.getOrdine()+ " -" + p.getAnno());
					
					p.setAttivo(true);
					p.setConfermato(Utility.getStatoPeriodo(p, parts));
					p.setTipologia(Utility.getTipologiaPeriodo(p, parts));
				}else{
					p.setAttivo(false);
					logger.debug("periodo NON   scelto " + p.getOrdine()+ " -" + p.getAnno());
				}
			}
			Sconti mySconto = db.getSconto(ragazzo, Integer.parseInt(anno));
			if (mySconto!=null)
				ragazzo.setSconto(mySconto.getSconto());
			else
				ragazzo.setSconto(0.0);
		}else{
			logger.debug("nuovo");
			ragazzo = new Ragazzi();
			classe="Seleziona la classe frequentata";
			myanno="Seleziona data di nascita";
		}
		logger.debug("2si esce su " + outMsg);
		return outMsg;
	}
	
	
	
	private Boolean ckDati(){
		Boolean ok = true;
		ok = ok&&nome!=null&&!"".equals(nome);
		logger.debug("nome="+nome);
		ok = ok&&cognome!=null&&!"".equals(cognome);
		logger.debug("cognome="+cognome);
		ok=ok&&indirizzo!=null&&!"".equals(indirizzo);
		logger.debug("ind="+indirizzo);
		ok=ok&&citta!=null&&!"".equals(citta);
		logger.debug("citta="+citta);
		ok=ok&&cap!=null&&!"".equals(cap);
		ok=ok&&this.cittaNascita!=null&&!"".equals(cittaNascita);
		logger.debug("citta="+cittaNascita);
		logger.debug("cap="+cap);
		logger.debug("cf="+codfiscpadre);
		logger.debug("cfm="+codfiscmadre);
		logger.debug("dell="+cellpadre);
		logger.debug("mell="+cellmadre);
			
		ok=ok&&this.nascita!=null&&!"".equals(nascita);
		
		ok = ok&&((this.codfiscpadre!=null)||(this.codfiscmadre!=null));
		ok = ok&&((this.emailpadre!=null&&!"".equals(emailpadre))||(this.emailmadre!=null&&!"".equals(emailmadre)));
		ok = ok&&((this.cellmadre!=null&&!"".equals(cellmadre))||(this.cellpadre!=null&&!"".equals(cellpadre)));
		logger.debug("ck dati: "+ok);
		long tonow = Calendar.getInstance().getTime().getTime();
		if (ok){
			if (Utility.getDate(nascita)==null)
				ok = false;
			else{
				logger.debug("data di nascita = " + nascita);
				Integer annoNascita = Integer.valueOf(Utility.getAnno(Utility.getDate(nascita)));
				Integer annoCorrente = Integer.valueOf(Utility.getAnno(Calendar.getInstance().getTime()));
				Integer na = annoCorrente-annoNascita;
				logger.debug(" eta del bimbo="+ na);
				if (na<6){
					ok = false;
					logger.debug(" il bimbo troppo piccolo < 2 anni eta="+ na);
				}
				/*
				long d = tonow - Utility.getDate(nascita).getTime();
				long min = 2*365*24*60*60*1000L;
				long minsec = tonow- min;
				logger.debug("num ms di d = " +d );
				if (d<minsec){
					ok = false;
					logger.debug(" il bimbo troppo piccolo < 2 anni + "+ d + " minimo = "+minsec);
				}
				*/	
				if ((cognomepadre!=null&&!"".equals(cognomepadre))||(cognomemadre!=null&&!"".equals(cognomemadre))){
					if (cognomepadre!=null&&!"".equals(cognomepadre)){
						if (nomepadre==null||"".equals(nomepadre)){
							if (nomemadre==null||cognomemadre==null){
								ok = false;
								logger.debug("nome genitore non completamente specificato");
							}
						}
					}else{
						if (nomemadre==null||"".equals(nomemadre)){
							ok = false;
							logger.debug("nome genitore non completamente specificato");
						}
					}
				}else{
					logger.debug("entrambi i nomi genitori non specificati");
					ok=false;
				}
			}
		}else{
			logger.debug("dati insufficienti");
		}
		backUrl = "iscrizione";
		return ok;
	}
	
	
	public String save(){
		logger.debug("inizio salvataggio registrazione");
		logger.debug("requested page: "+pageOid);
		admin = this.isPrivate();
		DbMngExt db = new DbMngExt();
		boolean nuovo = false;
		boolean ok = false;
		boolean logged = isPrivate();
		String msgOut = SUCCESS;
		Date today = Calendar.getInstance().getTime();
		if (anno==null){
			anno = Utility.getAnno(today);
		}else{
			
		}
		if (settimanaOid!=null){
			for (int i=0;i<settimanaOid.length;i++){
				logger.debug("la settimana richiesta: " +settimanaOid[i]);
			}
		}
		if (settimanaStatoOid!=null){
			for (int i=0;i<settimanaStatoOid.length;i++){
				logger.debug("la settimana richiesta stato: " +settimanaStatoOid[i]);
			}
		}
		if (pageOid!=null){
		this.pcb=this.cmsUtil.getPage(pageOid, null);
		this.headercnt = pcb.getHeadercnt();
		this.headercode = pcb.getHeadercode();
		this.footercnt = pcb.getFootercnt();
		this.footercode = pcb.getFootercode();
		}else{
			msgOut="oldsuccess";
		}
		
		logger.debug("salvataggio relatvo d anno " + anno);
		Set parts = null;
		//code = "";
		if ((oid!=null)&&(oid>0)){
			logger.debug("aggiornamento ragazzo: oid = "+oid);
			ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
			if (ragazzo!=null){
				//code = ragazzo.getCode();
				if (code!=null){
					
					ok = code.equals(ragazzo.getCode());
					if (!ok){
						esito = "aggiornamento non eseguibile: codice errato";
						return "failure";
					}
					parts = db.getPartecipantiPerAnno(ragazzo,anno);
					
				}
			}else{
				ragazzo = new Ragazzi();
				nuovo = true;
				code = nome+"_"+cognome;
				code = code.replace(" ", "_");
				code = code.replace('\'', '_');
				code = code+"_"+Calendar.getInstance().getTimeInMillis();
				ragazzo.setCode(code);
			}
		}else{
			
			logger.debug("ragazzo nuovo: oid = "+oid);
			if (!this.ckDati()){
				esito = "Fallimento";
				html="Operazione non possibile: Dati non sufficienti. Verificare dati mancanti<br>";
				html = html + "Verificare che siano presenti dati ragazzo: nome, cognome ragazzzo, indirizzo completo, date e cita di nascita <br>";
				html = html + "dati di almeno un genitore: Nome, Cognome, CodiceFiscale, Celluaure. Email<br>";
				msgOut="failure";
				return msgOut;
			}
			HashMap<String,Object> map = new HashMap<String,Object>();
			nome = Utility.cleanString(nome);
			cognome = Utility.cleanString(cognome);
			
			nome = nome.toUpperCase();
			cognome = cognome.toUpperCase();
			
			map.put("nome", nome);
			map.put("cognome", cognome);
			map.put("cittaNascita", this.cittaNascita);
			map.put("nascita", Utility.getDate(nascita));
			if (!db.verificaRagazzo(nome, cognome, this.cittaNascita, Utility.getDate(nascita))){
				ragazzo = db.getRagazzo(nome, cognome, this.cittaNascita, Utility.getDate(nascita));
				parts = db.getPartecipantiPerAnno(ragazzo,anno);
				 //Set parts = ragazzo.getPartecipantis();
				if ((parts==null)||(parts.size()==0)){
					code = nome+"_"+cognome;
					code = code.replace(" ", "_");
					code = code.replace('\'', '_');
					code = code+"_"+Calendar.getInstance().getTimeInMillis();
					ragazzo.setCode(code);
					oid = ragazzo.getOid();
					nuovo = false;
				}else{
					esito = "Fallimento";
					html="Operazione non possibile: Utente gi&agrave; registrato.";
					msgOut="failure";
					return msgOut;
				}
				
			}else{
				
				ragazzo = new Ragazzi();
				nuovo = true;
				code = nome+"_"+cognome;
				code = code.replace(" ", "_");
				code = code.replace('\'', '_');
				code = code+"_"+Calendar.getInstance().getTimeInMillis();
				ragazzo.setCode(code);
					
			}
			/*	
			if (db.verificaRagazzo(nome, cognome, this.cittaNascita, Utility.getDate(nascita))){
			ragazzo = new Ragazzi();
			nuovo = true;
			code = nome+"_"+cognome;
			code = code.replace(" ", "_");
			code = code.replace('\'', '_');
			code = code+"_"+Calendar.getInstance().getTimeInMillis();
			ragazzo.setCode(code);
			}else{
				esito = "Fallimento";
				html="Operazione non possibile: Utente gi&agrave; registrato.";
				msgOut="failure";
				return msgOut;
			}
			*/
		}
		
		String respto = null;
		Allegati a = null;
		
		ragazzo.setNome(nome);
		ragazzo.setCognome(cognome);
		ragazzo.setCodifiscPadre(codfiscpadre);
		ragazzo.setCodfiscMadre(codfiscmadre);
		ragazzo.setIndirizzo(indirizzo);
		ragazzo.setCitta(citta);
		ragazzo.setCap(cap);
		
		ragazzo.setNomePadre(nomepadre);
		ragazzo.setNomeMadre(nomemadre);
		ragazzo.setCognomePadre(cognomepadre);
		ragazzo.setCognomeMadre(cognomemadre);
		
		ragazzo.setAllergie(allsan);
		ragazzo.setIntolleranze(allal);
		ragazzo.setCellMadre(cellmadre);
		ragazzo.setCellPadre(cellpadre);
		ragazzo.setEmailMadre(emailmadre);
		ragazzo.setEmailPadre(emailpadre);
		ragazzo.setClasseFrequentata(classe);
		ragazzo.setFamiliari("si".equals(fratelli));
		ragazzo.setCittaNascita(cittaNascita);
		ragazzo.setDataNascita(Utility.getDate(nascita));
		if  ((sconto!=null)&&(!"".equals(sconto))){
			try{
				Double s=Double.parseDouble(sconto);
				ragazzo.setSconto(s);
			}
			catch (Exception E){
				E.printStackTrace();
			}
		}
		if (ragazzo.getFamiliari()){
			ragazzo.setFratelli(fratellonome);
		}
		if ((emailmadre!=null)&&(!"".equals(emailmadre))){
			respto = emailmadre;
		}
		if ((emailpadre!=null)&&(!"".equals(emailpadre))){
			if (respto==null)
				respto = emailpadre;
			else{
				respto = respto + ";"+emailpadre;
			}
		}
		
		if ((nascita != null)&&("".equals(nascita))){
				//ragazzo.setAnnoNascita(Utility.getAnnoByString(nascita));
				ragazzo.setDataNascita(Utility.getDate(nascita));
		}
		if (nuovo){
			
			oid = db.insertObject(ragazzo);
			logger.debug("inserito nuovo ragazzo: "+oid);
			
		}
		else{
			
			int err = db.updObject(ragazzo);
			oid = ragazzo.getOid();
			logger.debug("aggiornato ragazzo: "+oid+ " esito: " + err);
		}
		if (tipologiaOid!=null)
			logger.debug("numero tipologie pagamenti impostati: "+tipologiaOid.length);
		if (settimanaOid!=null){
			ArrayList<Partecipanti> list = new ArrayList<Partecipanti>();
			
			for (int i=0;i<settimanaOid.length;i++){
				logger.debug("controllo settmiana " + settimanaOid[i]);
				Periodi p = (Periodi)db.getObject(settimanaOid[i], "Periodi");
				
				if (!isBookedFor(settimanaOid[i],parts)){
					logger.debug("controllo settmiana OK non prenotato" );
					//Periodi p = (Periodi)db.getUniqueObject("Periodi", "ordine", settimana[i]);
					Partecipanti pp = new  Partecipanti();
					//Periodi p = (Periodi)db.getPeriodoPerAnno(settimana[i], anno);
					if (p==null){
						
						logger.error("non trovato periodo " + settimana[i] + " del  " + anno);
					}else{
						pp.setPeriodi(p);
					}
					//pp.setPeriodi(p);
					pp.setRagazzi(ragazzo);
					if ((tipologiaOid!=null)&& (this.tipologiaOid.length>i)){
						Tipologie t = (Tipologie)db.getObject(tipologiaOid[i], "Tipologie");
						if (t!=null)
							pp.setTipologie(t);
			
					}
					int poid = db.insertObject(pp);
					list.add(pp);
				}
				if (!"".equals(periodi))
					periodi = periodi + ";";
				if (p!=null)
					periodi = periodi + p.getOrdine();
			}
			if (!isPrivate()){
				if (list.size()>0){
					Boolean fam = false;
					fam = "si".equals(fratelli);
					logger.debug("cerco tipologia per " + settimanaOid.length + " - "+fam);
				Tipologie t  = Utility.getRightTipology(settimanaOid.length,fam);
				if (t!=null){
					logger.debug("tipologia vale : " + t.getForma());
					if (parts!=null)
					//if (ragazzo.getPartecipantis()!=null)
					{
					//Iterator<Partecipanti> iter= ragazzo.getPartecipantis().iterator();
					Iterator<Partecipanti> iter= parts.iterator();
					while (iter.hasNext()){
						Partecipanti p = iter.next();
						p.setTipologie(t);
						db.updObject(p);
					}
					}
					Iterator<Partecipanti> iter= list.iterator();
					while (iter.hasNext()){
						Partecipanti p = iter.next();
						p.setTipologie(t);
						db.updObject(p);
					}
				}else{
					logger.debug("non trovato tipologia corretta");
				}
				}
			}
		}
		if (this.isPrivate()){
			
		Set<Partecipanti> periodiAnno = db.getPartecipantiPerAnno(ragazzo, anno);
		if (periodiAnno!=null){
			Iterator<Partecipanti> iter = periodiAnno.iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				if (p.getStato()){
					if (!Utility.contains(p.getPeriodi().getOid(),settimanaStatoOid)){
						p.setStato(false);
						db.updObject(p);
					}
				}
			}
		}
			
		if (settimanaStatoOid!=null){
			for (int i=0;i<settimanaStatoOid.length;i++){
				Partecipanti pp = this.getPartecipazione(settimanaStatoOid[i], ragazzo.getPartecipantis());
				logger.debug("controoloo se confermato o richiesta coferma: "+settimanaStatoOid[i]);
				if (isBookedFor(settimanaStatoOid[i],ragazzo.getPartecipantis())){
						//Boolean stato = Boolean.parseBoolean(true);
					logger.debug("richiesta conferma per "+settimanaStatoOid[i]);
					pp.setStato(true);
						
					if ((tipologiaOid!=null)&&(this.tipologiaOid.length>i)){
						if (tipologiaOid[i]!=null){
							Tipologie t = (Tipologie)db.getObject(tipologiaOid[i], "Tipologie");
							if (t!=null)
								pp.setTipologie(t);
						}
				
					}
						
				
				}else{
					logger.debug("conferma non richiesta"+settimanaStatoOid[i]+": metto afalse indipendentemente");
					pp.setStato(false);
					
				}
				db.updObject(pp);	
					
			}
		}
		logger.debug("sconto: nalisi");
		if (sconto!=null){
			Integer an = Integer.parseInt(anno);
			logger.debug("verifico se ga scontato per " + an);
			Sconti mySconto = db.getSconto(ragazzo, an);
			if (mySconto!=null){
				mySconto.setSconto(Double.parseDouble(sconto));
				if (mySconto.getOid()>0){
					db.updObject(mySconto);
				}else{
					mySconto.setRagazzo(ragazzo);
					mySconto.setAnno(an);
					db.insertObject(mySconto);
				}
					
			}else{
				logger.debug("non ci sono sconti");
				mySconto = new Sconti();
				mySconto.setRagazzo(ragazzo);
				mySconto.setAnno(an);
				mySconto.setSconto(Double.parseDouble(sconto));
				db.insertObject(mySconto);
			}
		}
		//if (ragazzo.getPartecipantis()!=null)
		if (parts!=null)
		{
		//Iterator<Partecipanti> partiter = ragazzo.getPartecipantis().iterator();
		Iterator<Partecipanti> partiter = parts.iterator();
		while (partiter.hasNext()){
			Partecipanti p = partiter.next();
			logger.debug("xconfronto " );
			if (!this.isSelected(p, settimanaOid)){
				db.deleteObject(p);
			}
			
		}
		
		}
		
		
		
		}else{
			if (parts!=null)
			{
			//Iterator<Partecipanti> partiter = ragazzo.getPartecipantis().iterator();
			Iterator<Partecipanti> partiter = parts.iterator();
			while (partiter.hasNext()){
				Partecipanti p = partiter.next();
				logger.debug("xconfronto " );
				if (!this.isSelected(p, settimanaOid)){
					db.deleteObject(p);
				}
				
			}
			
			}
		}
		//ragazzo.setPeriodi(periodi);
		//db.updObject(ragazzo);
		
		ArrayList<String> alls = null; 
		//Tika tika = new Tika();
		if (fileUpload!=null){
			if (fileName==null){
				fileName = new String[fileUpload.length];
			}
			alls = new ArrayList<String>();
			String fn=null;
			
			for (int i=0;i<fileUpload.length;i++)
			try{
				//File fu = fileUpload[i];
			logger.debug("file caricato:"+this.fileName+" type="+this.fileType);
			String mime = Files.probeContentType(fileUpload[i].toPath());
			String ext = "";
			if ((mime != null)&&(!"".equals(mime))){
				if (mime.contains("/"))
					ext = mime.substring(mime.indexOf('/')+1);
	    	   
	       }
			String path = Utility.RONCO.getString("ronco.area.documenti");
            if (fileName.length>i){
            	if ((fileName[i]==null||("".equals(fileName[i])))){
            	//this.fileName[i] = fileUpload[i].getName();
            		fn = fileUpload[i].getName();
            	}else{
            		fn = fileName[i];
            	}
			}else{
				fn = fileUpload[i].getName();	
			}
            String tfn = fn;
            fn = Utility.sdftpar.format(Calendar.getInstance().getTime())+"-"+fn+"."+ext;
            File f = new File(path+"/"+fn);
           
            FileUtils.copyFile(fileUpload[i], f);
            a =  new Allegati();
            a.setPath(f.getPath());
            if ((fileType!=null)&&(fileType.length>i))
        		a.setTipo(fileType[i]);
            if ((fileDesc!=null)&&(fileDesc.length>i))
            		a.setDescrizione(fileDesc[i]);
            a.setNome(tfn);
            a.setMime(mime);
            if (a!=null){
    			a.setRagazzo(ragazzo);
    			int aoid = db.insertObject(a);
    			logger.debug("nuovo allegatio: "+aoid);
    			alls.add(a.getPath());
    		}
			}
			catch (Exception E){
				E.printStackTrace();
				logger.error("ERRORE in upload " + E.toString());
				
				
			}

		}
		logger.debug("inizio salvataggio");
		String subject = "";
		String text = "";
		if (!logged){
		String html = mkHtml();
		logger.debug("inizio invio mail di " + html);
		SendMail sm = new SendMail();
		String from = Utility.MAIL.getString("mail.sender");
		if (nuovo){
			subject  = Utility.MAIL.getString("mail.new.subject");
			text =  Utility.MAIL.getString("mail.new.text");
		}else{
			subject  = Utility.MAIL.getString("mail.upd.subject");
			text =  Utility.MAIL.getString("mail.upd.text");
		}
		String destinatari  = Utility.MAIL.getString("mail.dest.list");
		logger.debug(" invio mail a " + destinatari);
		ArrayList<String> dests = new ArrayList<String>(); 
		if (destinatari!=null){
			String[] list = destinatari.split(",");
			if (list!=null){
				for (int i=0;i<list.length;i++)
					dests.add(list[i]);
				sm.sender(from, subject, dests, text, html, alls);
				logger.debug("inviata mail");
				ragazzo.setMailInviata("OK");
			}else{
				logger.debug("inviata mail NO list null");
				ragazzo.setMailInviata("KO");
			}
			
		}else{
			logger.debug("inviata mail NO: destinatari null");
			
			ragazzo.setMailInviata("KO");
		}
		Integer ianno = Integer.parseInt(anno);
		List<Object> listaDoc = db.getListObject("Documenti", "anno", ianno);
		if (listaDoc!=null){
			this.docList= new HashMap<String,String>();
			for (Object o: listaDoc){
				Documenti d = (Documenti)o;
				logger.debug("in esame "+ d.getNome());
				logger.debug("aggiungo in " +d.getKeywords()+" la url "+d.getUrl());
				docList.put(d.getKeywords(), d.getUrl());
			}
		}
		
		if (respto!=null){
			if (nuovo){
				subject = Utility.MAIL.getString("mail.user.new.subject");
				text = Utility.MAIL.getString("mail.user.new.text");
				
			}else{
				subject = Utility.MAIL.getString("mail.user.upd.subject");;
				text = Utility.MAIL.getString("mail.user.upd.text");
				
			}
	
			String htmlText = "<html><body>";
			htmlText =htmlText+ text + "<a href=\""+Utility.MAIL.getString("mail.site.upd.url")+"?oid="+oid+"&code="+code+"\">Aggiorna</a>";
			htmlText = htmlText+"<p><img src=\""+Utility.MAIL.getString("mail.logo.mail.url")+"\" /></p></body></html>";
			text = text + "<a href=\""+Utility.MAIL.getString("mail.site.upd.url")+"?oid="+oid+"&code="+code+"\">Aggiorna</a>";
			
			String[] list = respto.split(";");
			if (list!=null){
				dests = new ArrayList<String>();
				
				for (int i=0;i<list.length;i++)
					dests.add(list[i]);
				//text = text + "<p><img src=\""+MailClient.MAIL.getString("mail.logo.mail.url")+"\" /></p>";
				sm.sender(from, subject, dests, text, htmlText, null);
				logger.debug("mail inviata a utebte " );
			}
			
		}
		}
		if (logged){
			msgOut = "privsuccess";
		}else{
			if (!nuovo){
				msgOut="pubsuccess";
			}
			/*
			 else{
				msgOut = SUCCESS;
			}
			*/
		}
		return msgOut;
	}

	private boolean isBookedFor(String p, Set<Partecipanti> parts){
		Boolean ok = false;
		if (parts!=null){
			Iterator<Partecipanti> iter = parts.iterator();
			while (!ok && iter.hasNext())
				ok = p.equals(iter.next().getPeriodi().getOrdine());
		}
		return ok;
	}
	private boolean isBookedFor(Integer oid, Set<Partecipanti> parts){
		Boolean ok = false;
		if (parts!=null){
			Iterator<Partecipanti> iter = parts.iterator();
			while (!ok && iter.hasNext())
				//ok = oid.equals(iter.next().getPeriodi().getOid());
				ok = oid.equals(iter.next().getPeriodi().getOid());
		}
		return ok;
	}
	private boolean isSelected(Partecipanti p, String[] list){
		Boolean ok = false;
		if (list!=null){
			int i=0;
			while (!ok && i<list.length){
				ok = list[i].equals(p.getPeriodi().getOrdine());
				i++;
			}
		}
		return ok;
	}
	private boolean isSelected(Partecipanti p, Integer[] list){
		Boolean ok = false;
		if (list!=null){
			int i=0;
			while (!ok && i<list.length){
				logger.debug("controllo settimana: " +list[i]);
				ok = list[i].equals(p.getPeriodi().getOid());
				i++;
			}
		}
		return ok;
	}
	private Partecipanti getPartecipazione(String p, Set<Partecipanti> parts){
		Boolean ok = false;
		Partecipanti part = null;
		if (parts!=null){
			Iterator<Partecipanti> iter = parts.iterator();
			while (!ok && iter.hasNext()){
				part = iter.next();
				ok = p.equals(part.getPeriodi().getOrdine());
			}
		}
		return part;
	}
	private Partecipanti getPartecipazione(Integer p, Set<Partecipanti> parts){
		Boolean ok = false;
		Partecipanti part = null;
		if (parts!=null){
			Iterator<Partecipanti> iter = parts.iterator();
			while (!ok && iter.hasNext()){
				part = iter.next();
				//ok = p.equals(part.getPeriodi().getOid());
				ok = p==part.getPeriodi().getOid();
			}
		}
		return part;
	}
	
	
	public String aggiorna(){
		logger.debug("inizio registrazione");
		DbMng db = new DbMng();
		admin = this.isPrivate();
		boolean nuovo = false;
		Allegati a = null;
		Date today = Calendar.getInstance().getTime();
		if (anno==null)
			anno = Utility.getAnno(today);
		if (oid !=null){
			ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
			
		}else{
			ragazzo = new Ragazzi();
			nuovo = true;
		}
		if (ragazzo!=null){
		Set<Partecipanti> pars = ragazzo.getPartecipantis(); 
				
		ragazzo.setNome(nome);
		ragazzo.setCognome(cognome);
		ragazzo.setCodifiscPadre(codfiscpadre);
		ragazzo.setCodfiscMadre(codfiscmadre);
		ragazzo.setIndirizzo(indirizzo);
		ragazzo.setPadre(nomepadre);
		ragazzo.setMadre(nomemadre);
		ragazzo.setAllergie(allsan);
		ragazzo.setIntolleranze(allal);
		ragazzo.setCellMadre(cellmadre);
		ragazzo.setCellPadre(cellpadre);
		ragazzo.setEmailMadre(emailmadre);
		ragazzo.setEmailPadre(emailpadre);
		ragazzo.setPeriodi(periodi);
		/*
		if ((nascita != null)&&("".equals(nascita)))
				ragazzo.setAnnoNascita(Utility.getAnnoByString(nascita));
		*/
		ArrayList<String> alls = null; 
		//Tika tika = new Tika();
		
		if (nuovo)
			oid = db.insertObject(ragazzo);
		else
			oid = db.updObject(ragazzo);
		if (settimanaOid!=null){
			for (int i=0;i<settimanaOid.length;i++){
				if (!isBookedFor(settimanaOid[i],pars)){
					//Periodi p = (Periodi)db.getUniqueObject("Periodi", "ordine", settimana[i]);
					Periodi p = (Periodi)db.getObject(settimanaOid[i],"Periodi");
					Partecipanti pp = new  Partecipanti();
					pp.setPeriodi(p);
					pp.setRagazzi(ragazzo);
					int poid = db.insertObject(pp);
				}
				if (!"".equals(periodi))
					periodi = periodi + ";";
				periodi = periodi + settimanaOid[i];
			}
		}
		
		if (fileUpload!=null){
			if (fileName==null){
				fileName = new String[fileUpload.length];
			}
			alls = new ArrayList<String>();
			String fn=null;
			
			for (int i=0;i<fileUpload.length;i++)
			try{
				//File fu = fileUpload[i];
			logger.debug("file caricato:"+this.fileName+" type="+this.fileType);
			String mime = Files.probeContentType(fileUpload[i].toPath());
			String ext = "";
			if ((mime != null)&&(!"".equals(mime))){
				if (mime.contains("/"))
					ext = mime.substring(mime.indexOf('/')+1);
	    	   
	       }
			String path = Utility.RONCO.getString("ronco.area.documenti");
            if (fileName.length>i){
            	if ((fileName[i]==null||("".equals(fileName[i])))){
            	//this.fileName[i] = fileUpload[i].getName();
            		fn = fileUpload[i].getName();
            	}else{
            		fn = fileName[i];
            	}
			}else{
				fn = fileUpload[i].getName();	
			}
            String tfn = fn;
            fn = Utility.sdftpar.format(Calendar.getInstance().getTime())+"-"+fn+"."+ext;
            File f = new File(path+"/"+fn);
           
            FileUtils.copyFile(fileUpload[i], f);
            a =  new Allegati();
            a.setPath(f.getPath());
            if ((fileType!=null)&&(fileType.length>i))
        		a.setTipo(fileType[i]);
            if ((fileDesc!=null)&&(fileDesc.length>i))
            		a.setDescrizione(fileDesc[i]);
            a.setNome(tfn);
            a.setMime(mime);
            if (a!=null){
    			a.setRagazzo(ragazzo);
    			int aoid = db.insertObject(a);
    			logger.debug("nuovo allegatio: "+aoid);
    			alls.add(a.getPath());
    		}
			}
			catch (Exception E){
				E.printStackTrace();
				logger.error("ERRORE in upload " + E.toString());
				
				
			}

		}
		logger.debug("inizio salvataggio");
		
		esito = "successo";
		/*
		String htmlmail = getHtml();
		SendMail sm = new SendMail();
		String from = Utility.MAIL.getString("mail.sender");
		String subject  = Utility.MAIL.getString("mail.subject");
		String destinatari  = Utility.MAIL.getString("mail.dest.list");
		String text =  Utility.MAIL.getString("mail.text");
		ArrayList<String> dests = new ArrayList<String>(); 
		if (destinatari!=null){
			String[] list = destinatari.split(",");
			if (list!=null){
				for (int i=0;i<list.length;i++)
					dests.add(list[i]);
				sm.sender(from, subject, dests, text, htmlmail, alls);
				ragazzo.setMailInviata("OK");
			}else{
				ragazzo.setMailInviata("KO");
			}
			
		}else{
			ragazzo.setMailInviata("KO");
		}
		*/
		}else {
			esito = "Fallimento";
			html="Impossibile trovare la iscrizione richiesta";
		}
		return SUCCESS;
	}
	
	
	public String[] getSettimana() {
		return settimana;
	}

	public void setSettimana(String[] settimana) {
		this.settimana = settimana;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getFratelli() {
		return fratelli;
	}

	public void setFratelli(String fratelli) {
		this.fratelli = fratelli;
	}

	public String getNomepadre() {
		return nomepadre;
	}

	public void setNomepadre(String nomepadre) {
		this.nomepadre = nomepadre;
	}

	public String getNomemadre() {
		return nomemadre;
	}

	public void setNomemadre(String nomemadre) {
		this.nomemadre = nomemadre;
	}

	public String getAccompagnatore() {
		return accompagnatore;
	}

	public void setAccompagnatore(String accompagnatore) {
		this.accompagnatore = accompagnatore;
	}

	public String getTelcasa() {
		return telcasa;
	}

	public void setTelcasa(String telcasa) {
		this.telcasa = telcasa;
	}

	public String getCellpadre() {
		return cellpadre;
	}

	public void setCellpadre(String cellpadre) {
		this.cellpadre = cellpadre;
	}

	public String getCellmadre() {
		return cellmadre;
	}

	public void setCellmadre(String cellmadre) {
		this.cellmadre = cellmadre;
	}

	public String getTelwp() {
		return telwp;
	}

	public void setTelwp(String telwp) {
		this.telwp = telwp;
	}

	public String getTelwm() {
		return telwm;
	}

	public void setTelwm(String telwm) {
		this.telwm = telwm;
	}

	public String getTelacc() {
		return telacc;
	}

	public void setTelacc(String telacc) {
		this.telacc = telacc;
	}

	public String getEmailpadre() {
		return emailpadre;
	}

	public void setEmailpadre(String emailpadre) {
		this.emailpadre = emailpadre;
	}

	public String getEmailmadre() {
		return emailmadre;
	}

	public void setEmailmadre(String emailmadre) {
		this.emailmadre = emailmadre;
	}

	public String getAllal() {
		return allal;
	}

	public void setAllal(String allal) {
		this.allal = allal;
	}

	public String getSan() {
		return san;
	}

	public void setSan(String san) {
		this.san = san;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getNascita() {
		return nascita;
	}

	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	public String getCodfiscpadre() {
		return codfiscpadre;
	}

	public void setCodfiscpadre(String codfiscpadre) {
		this.codfiscpadre = codfiscpadre;
	}

	public String getCodfiscmadre() {
		return codfiscmadre;
	}

	public void setCodfiscmadre(String codfiscmadre) {
		this.codfiscmadre = codfiscmadre;
	}

	public Ragazzi getRagazzo() {
		return ragazzo;
	}

	public void setRagazzo(Ragazzi ragazzo) {
		this.ragazzo = ragazzo;
	}


	public String getAllsan() {
		return allsan;
	}


	public void setAllsan(String allsan) {
		this.allsan = allsan;
	}


	public String getPeriodi() {
		return periodi;
	}


	public void setPeriodi(String periodi) {
		this.periodi = periodi;
	}


	public File[] getFileUpload() {
		return fileUpload;
	}


	public void setFileUpload(File[] fileUpload) {
		this.fileUpload = fileUpload;
	}


	public String[] getFileType() {
		return fileType;
	}


	public void setFileType(String[] fileType) {
		this.fileType = fileType;
	}


	public String[] getFileDesc() {
		return fileDesc;
	}


	public void setFileDesc(String[] fileDesc) {
		this.fileDesc = fileDesc;
	}


	public String[] getFileName() {
		return fileName;
	}


	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}


	public List<Object> getPeriodiList() {
		return periodiList;
	}


	public void setPeriodiList(List<Object> periodiList) {
		this.periodiList = periodiList;
	}


	public String getEsito() {
		return esito;
	}


	public void setEsito(String esito) {
		this.esito = esito;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getOid() {
		return oid;
	}


	public void setOid(Integer oid) {
		this.oid = oid;
	}


	

	public String[] getAnni() {
		return anni;
	}


	public void setAnni(String[] anni) {
		this.anni = anni;
	}


	public String[] getClassi() {
		return classi;
	}


	public void setClassi(String[] classi) {
		this.classi = classi;
	}


	public String[] getSettimanaStato() {
		return settimanaStato;
	}


	public void setSettimanaStato(String[] settimanaStato) {
		this.settimanaStato = settimanaStato;
	}


	public Integer[] getTipologiaOid() {
		return tipologiaOid;
	}


	public void setTipologiaOid(Integer[] tipologiaOid) {
		this.tipologiaOid = tipologiaOid;
	}

	

	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	public List<Object> getTipologie() {
		return tipologie;
	}


	public void setTipologie(List<Object> tipologie) {
		this.tipologie = tipologie;
	}


	public String getFratellonome() {
		return fratellonome;
	}


	public void setFratellonome(String fratellonome) {
		this.fratellonome = fratellonome;
	}


	public String getCittaNascita() {
		return cittaNascita;
	}


	public void setCittaNascita(String cittaNascita) {
		this.cittaNascita = cittaNascita;
	}


	public String getSconto() {
		return sconto;
	}


	public void setSconto(String sconto) {
		this.sconto = sconto;
	}


	public String getMyanno() {
		return myanno;
	}


	public void setMyanno(String myanno) {
		this.myanno = myanno;
	}


	public Integer[] getSettimanaOid() {
		return settimanaOid;
	}


	public void setSettimanaOid(Integer[] settimanaOid) {
		this.settimanaOid = settimanaOid;
	}


	public Integer[] getSettimanaStatoOid() {
		return settimanaStatoOid;
	}


	public void setSettimanaStatoOid(Integer[] settimanaStatoOid) {
		this.settimanaStatoOid = settimanaStatoOid;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getCap() {
		return cap;
	}


	public void setCap(String cap) {
		this.cap = cap;
	}


	public String getCognomepadre() {
		return cognomepadre;
	}


	public void setCognomepadre(String cognomepadre) {
		this.cognomepadre = cognomepadre;
	}


	public String getCognomemadre() {
		return cognomemadre;
	}


	public void setCognomemadre(String cognomemadre) {
		this.cognomemadre = cognomemadre;
	}


	public String getBackUrl() {
		return backUrl;
	}


	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}


	public HashMap<String, String> getDocList() {
		return docList;
	}


	public void setDocList(HashMap<String, String> docList) {
		this.docList = docList;
	}


	public Integer getPageOid() {
		return pageOid;
	}


	public void setPageOid(Integer pageOid) {
		this.pageOid = pageOid;
	}


	public PageCmsBean getPcb() {
		return pcb;
	}


	public void setPcb(PageCmsBean pcb) {
		this.pcb = pcb;
	}


	
	
	
	
	
}