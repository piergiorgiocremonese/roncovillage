package it.crem.server.actions;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.ArrayList;



import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import it.crem.db.conf.Allegati;
import it.crem.db.conf.Pagamenti;
import it.crem.db.conf.Partecipanti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Presenze;
import it.crem.db.conf.Ragazzi;
import it.crem.db.mng.DbMng;
import it.crem.db.mng.DbMngExt;
import it.crem.server.Registro;
import it.ash.mail.SendMail;
import it.crem.common.Field;
import it.crem.common.Utility;
import it.crem.common.XlsUtility;

import java.util.Calendar;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;




public class Ricerca extends RoncoAction implements 
ServletRequestAware,ServletResponseAware{
	
	
	private Periodi periodo = null;
	private Map<String,Object> session = ActionContext.getContext().getSession();
	private Integer periodoOid = null;
	private Integer[] presente = null;
	private String esito = null;
	private Integer[] mensa = null;
	private Integer[] completo = null;
	private Integer[] pomeriggio = null;
	private Integer[] mattina = null;
	private Integer[] ragazzoOid = null;
	private Integer[] presenzaOid = null;
	private String oggi = null;
	private Integer oid = null;
	private Integer[] settimana = null;
	private String nome=null;
	private String cognome=null;
	private String fratelli = null;
	private String san = null;
	private String anno = null;
	private String nascita = null;
	private String codfiscpadre = null;
	private String codfiscmadre = null;
	private Ragazzi ragazzo = null;
	private String periodi = "";
	private File[] fileUpload = null;
	private String[] fileType = null;
	private String[] fileDesc = null;
	private String[] fileName = null;
	private List<Object> periodiList = null;
	private Logger logger = Logger.getLogger(this.getClass());
	private List<Object> partecipanti = null;
	private String sgiorno = null;
	private Date giorno = null;
	private ArrayList<Ragazzi> ragazzi = null;
	private String html = null;
	private ArrayList<Registro> registro = null;
	private HashMap<String,List<Object>> quadro = null;
	//private TreeSet<Ragazzi> ragazziList = null;
	private Integer numeroMensa = 0;
	private Integer presentiFull = 0;
	private Integer presentiMattina = 0;
	private Integer presentiPomeriggio = 0; 
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Set<Ragazzi> listaRagazzi = null; 
	private Boolean stato = null;
	private Integer settimanaOid[] = null;
	private String inizio=null;
	private String fine=null;
	private Boolean libero = true;
	private String ordine = null;
	private Integer numeroMassimo = 60;
	private Integer numeroCorrente = null;
	private Boolean nuovo = false;
		/*
	private String getHtml(){
		String html = "<html><body><center><b>Nuova richiesta di iscrizione</b></center><br/><br/>";
		
		
		html = html+"<table>";
		html = html + "<tr><td>Nome:</td><td>"+nome+" " + cognome+"</td></tr>";
		html = html + "<tr><td>Indirizzo:</td><td>"+indirizzo+"</td></tr>";
		html = html + "<tr><td>Telefono:</td><td>"+telcasa+"</td></tr>";
		html = html + "<tr><td>periodo richiesto:</td><td>"+periodi+"</td></tr>";
		html = html + "<tr><td>Classe/anno:</td><td>"+nascita+"</td></tr>";
		html = html + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
		html = html + "<tr><td>Padre:</td><td>"+nomepadre+":"+codfiscpadre+":"+cellpadre+":"+emailpadre+"</td></tr>";
		html = html + "<tr><td>Madre:</td><td>"+nomemadre+":"+codfiscmadre+":"+cellmadre+":"+emailmadre+"</td></tr>";
		html = html + "<tr><td>Accompagnatore:</td><td>"+accompagnatore+"</td></tr>";
		html = html + "<tr><td>Fratelli:</td><td>"+fratelli+"</td></tr>";
		html = html + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
		html = html + "<tr><td>Allergie Alimentari:</td><td>"+this.allal+"</td></tr>";
		html = html + "<tr><td>Precauzioni Sanitarie :</td><td>"+this.allsan+"</td></tr>";
		
		
		html = html + "</table></body></html>";
		return html;
	}
	*/
	
	
	private boolean isIn(Periodi p, Set<Partecipanti> pl){
		boolean ok=false;
		Iterator<Partecipanti> iter = pl.iterator();
		while (!ok && iter.hasNext()){
			Partecipanti pn = iter.next();
			ok = pn.getPeriodi().getOrdine().equals(p.getOrdine());
		}
		return ok;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
	
	

	public String show(){
		Date now = Calendar.getInstance().getTime();
		if ((anno==null)||("".equals(anno)))
			anno = Utility.getAnno(now);
		DbMng db = new DbMng();
		HashMap<String,String> pars = new HashMap<String,String>();
		pars.put("anno", anno);
		//periodiList = db.getListObject("Periodi", pars);
		periodiList = db.getListObjectOrdered("Periodi", "anno",anno,"ordine");
		return SUCCESS;
	}
	public String periodo(){
		
		Date now = Calendar.getInstance().getTime();
		if ((anno==null)||("".equals(anno)))
			anno = Utility.getAnno(now);
		DbMngExt db = new DbMngExt();
		//periodiList = db.getListObject("Periodi", pars);
		
		if (periodoOid !=null){
			periodo = (Periodi)db.getObject(periodoOid,"Periodi");
			List list = db.getIscrittiPeriodo(periodo);
			if (list!=null){
				this.numeroCorrente=list.size();
			}else
				this.numeroCorrente=0;
		}
		else{
			periodo = new Periodi();
			List list = db.getListObject("Periodi", "anno", anno);
			if (list!=null){
				Integer dim = list.size()+1;
				ordine = dim + "";
				periodo.setOrdine(ordine);
				logger.debug("numero periodi presenti +1 = "+dim);
			}
			nuovo = true;
		}
		return SUCCESS;
	}
	public String updPeriodo(){
		Date now = Calendar.getInstance().getTime();
		Boolean nuovo = false;
		Boolean ok = true;
		String msgOut = SUCCESS;
		logger.debug("nuova versione");
		if ((anno==null)||("".equals(anno)))
			anno = Utility.getAnno(now);
		DbMng db = new DbMng();
		HashMap<String,String> pars = new HashMap<String,String>();
		pars.put("anno", anno);
		//periodiList = db.getListObject("Periodi", pars);
		if ((periodoOid !=null)&&(periodoOid>0))
			periodo = (Periodi)db.getObject(periodoOid,"Periodi");
			
		else{
			periodo = new Periodi();
			periodo.setAnno(Utility.getAnno(Calendar.getInstance().getTime()));
			
			nuovo = true;
		}
		if (periodo == null){
			logger.debug("periodo nullo ma con richiesta: " +periodoOid);
			msgOut= " failure";
			html = "<b> aggionamento periodo non corretto periodo " +periodoOid + "  non trovato </b>";
		}else{
			Date start = Utility.getDate(inizio);
			if (start!=null){
				periodo.setInizio(start);
			
			}else{
				ok = false;
			}
			Date end = Utility.getDate(fine);
			if (end!=null){
				
				if (!"18:00".equals(Utility.getTime(end))){
					Date te = Utility.getFullDate(Utility.getFormattedData(end)+ " 18:00:00");
					//end.setTime(end.getTime()+3600*1000*18);
					periodo.setFine(te);
				}
			}else{
				ok = false;
			}
		
			periodo.setLibero(libero);
			periodo.setOrdine(ordine);
			logger.debug("nunero di ordine = " +ordine);
			periodo.setNumeroMassimo(numeroMassimo);
			if (ordine == null){
				ok = false;
			}
			logger.debug("aggiornamento stato_" +libero );
			if (nuovo&&ok)
				db.insertObject(periodo);
			else
				db.updObject(periodo);
		}
		return SUCCESS;
		
	}
	
	public Integer getNumeroMassimo() {
		return numeroMassimo;
	}

	public void setNumeroMassimo(Integer numeroMassimo) {
		this.numeroMassimo = numeroMassimo;
	}

	public String ragazziAnno(){
		logger.debug("inizio ricerca ragazzi per anno="+anno);
		DbMngExt db = new DbMngExt();	
		HashMap<String,String> pars = null;
		String outMsg = SUCCESS;
		listaRagazzi = db.getRagazziPerAnno(anno);
		for (Ragazzi r: listaRagazzi){
			if (r.getDataNascita()!=null){
			String sanno = Utility.getAnno(r.getDataNascita());
			if (sanno!=null){
				Integer myanno = Integer.parseInt(sanno);
				//r.setAnnoNascita(myanno);
			}
			}else{
				logger.error(r.getNome()+ " "+r.getCognome()+ " "+r.getOid() + " data nascita null");
			}
		}
		return outMsg;
	}

	public String ragazziRegistrati(){
		logger.debug("inizio ricerca ragazzi registrati");
		DbMngExt db = new DbMngExt();	
		HashMap<String,String> pars = null;
		String outMsg = SUCCESS;
		anno = Utility.getAnno(Calendar.getInstance().getTime());
		List ragazzi = db.getListObject("Ragazzi", (String)null, null);
		if (ragazzi!=null){
			listaRagazzi = new TreeSet<Ragazzi>();
		for (Object o: ragazzi){
			Ragazzi r = (Ragazzi)o;
			if (r.getDataNascita()!=null){
			String sanno = Utility.getAnno(r.getDataNascita());
			if (sanno!=null){
				Integer myanno = Integer.parseInt(sanno);
				//r.setAnnoNascita(myanno);
			}
			}else{
				logger.error(r.getNome()+ " "+r.getCognome()+ " "+r.getOid() + " data nascita null");
			}
			listaRagazzi.add(r);
		}
		}
		return outMsg;
	}
	
	
	
	public String search(){
		logger.debug("inizio ricerca ragazzi per anno="+anno);
		DbMngExt db = new DbMngExt();	
		HashMap<String,Object> pars = null;
		String outMsg = "tutti";
		Date today = Calendar.getInstance().getTime();
		Integer curranno = Integer.parseInt(Utility.getAnno(today));
		if (anno==null)
			anno = curranno + "";
		
		pars = new HashMap<String,Object>();
		pars.put("anno", anno);
		Periodi p = null;
		if ((settimana!=null)&&(settimana.length>0)){
			logger.debug("cerco partecipanti alla settimana:"+settimana[0]+ "anno:"+anno);
			
			p = (Periodi)db.getObject(settimana[0], "Periodi");
			pars.put("periodi", p);
			periodoOid = settimana[0];
			//partecipanti = db.getListObjectOrdered("Partecipanti", pars,"ragazzi.cognome");
			//session.put("partecipanti", partecipanti);
		}else{
			/*
			if ((nome !=null)&&(!"".equals(nome))){
				pars = new HashMap<String,Object>();
				pars.put("nome", nome);
			}
			if ((cognome !=null)&&(!"".equals(cognome))){
				if (pars==null)
					pars = new HashMap<String,Object>();
				pars.put("cognome", cognome);
			}
			logger.debug("settimana non impostata anno:"+anno);
			//List list  = db.getListObjectOrdered("Ragazzi", pars,"cognome");
			ragazzi = db.getRagazzi(pars);
			
			if (list!=null){
				ragazzi = new ArrayList<Ragazzi>();
				for (int i=0;i<list.size();i++){
					ragazzi.add((Ragazzi)list.get(i));
				}
				outMsg="tutti";
			}
			*/
			
		}
		if ((nome !=null)&&(!"".equals(nome))){
			pars.put("nome", nome);
		}
		if ((cognome !=null)&&(!"".equals(cognome))){
			pars.put("cognome", cognome);
		}
		if (stato !=null){
			logger.debug("cartteristica = " + stato);
			pars.put("stato", stato);
		}
		
		ragazzi = db.getRagazzi(pars);
		
		if (ragazzi!=null){
			logger.debug("rovati numero: " +ragazzi.size());
			ArrayList<Partecipanti> partecipanti = new ArrayList<Partecipanti>();
			for (Ragazzi r : ragazzi){
				Partecipanti pa = new Partecipanti();
				pa.setRagazzi(r);
				pa.setPeriodi(p);
				pa.setStato(true);
				//pa.setTipologie(tipologie);
			}
		}	
		else
			logger.debug("rovati numero: 0: NUUUL" );
		return outMsg;
	}

	public String downloadIscritti(){
		logger.debug("inizio ricerca ragazzi per anno="+anno);
		try{
		DbMngExt db = new DbMngExt();	
		HashMap<String,Object> pars = null;
		String outMsg = "tutti";
		Date today = Calendar.getInstance().getTime();
		Integer curranno = Integer.parseInt(Utility.getAnno(today));
		if (anno==null)
			anno = curranno + "";
		
		pars = new HashMap<String,Object>();
		pars.put("anno", anno);
		Periodi p = null;
		if (periodoOid !=null)
				p=(Periodi)db.getObject(periodoOid, "Periodi");
		if (p!=null)
			pars.put("periodi", p);
		ragazzi = db.getRagazzi( pars);
			if (ragazzi!=null){
					logger.debug("trovati: " + ragazzi.size());
					String area = Utility.RONCO.getString("ronco.area.documenti.privati");
					String fn = "registro-"+Utility.getFullDateString(Calendar.getInstance().getTime())+".xls";
					logger.debug("devo generare il file "+area + "/"+fn);
					ArrayList<Field> typedheader = new ArrayList<Field>();
							
					ArrayList<String> header = new ArrayList<String>();
					Field nf = new Field();
					nf.setName("numero");
					nf.setType("number");
					//header.add("numero");
					Field cf = new Field();
					cf.setName("cognome");
					cf.setType("String");
					Field ncf = new Field();
					ncf.setName("nome");
					ncf.setType("String");
					Field dcf = new Field();
					dcf.setName("anno");
					dcf.setType("number");
					Field scf = new Field();
					scf.setName("stato");
					scf.setType("String");
					Field acf = new Field();
					acf.setName("presenza");
					acf.setType("String");
					
					header.add("cognome");
					header.add("nome");
					header.add("anno");
					header.add("stato");
					//header.add("presenza");
					//typedheader.add(nf);
					typedheader.add(cf);
					typedheader.add(ncf);
					typedheader.add(dcf);
					typedheader.add(scf);
					//typedheader.add(acf);
					
					ArrayList<HashMap<String,Object>> values = new ArrayList<HashMap<String,Object>>();
					for (int i=0;i<ragazzi.size();i++){
						Ragazzi r = ragazzi.get(i);
						HashMap<String,Object> map = new HashMap<String,Object>(); 
						map.put("numero",i);
						
						map.put("cognome",r.getCognome());
						map.put("nome",r.getNome());
						map.put("anno", r.getAnnoNascita()+"");
						map.put("stato", r.getApproved()+"");
						
						map.put("presenza", "");
						values.add(map);
					}
					String file = XlsUtility.getTypedXls(typedheader, values, area, fn);
					if (file!=null){
						FileInputStream fis = new FileInputStream(new File(file));
						response.setContentType("application/xls");
						response.setCharacterEncoding("UTF-8");
						response.setHeader("Content-disposition","attachment; filename="+fn);

						ServletOutputStream out = response.getOutputStream();
						int c;
						//StringBuffer sb = new StringBuffer();
						while ((c=fis.read())!=-1){
							//sb.append((char)c);
							out.write(c);
						}
						//out.close();
					

				}else{
					esito = "File non scaricato: dati non diponibili";
					return "failure";
				}
			}else{
				esito = "File non scaricato: dati non diponibili";
				return "failure";
			}
		/*
		}else{
			esito = "Periodo non specificato: dati non diponibili";
			return "failure";
		}*/
		}
		catch (Exception E){
			E.printStackTrace();
			//esito = "File non scaricato: dati non diponibili";
			//return "failure";
		}
		
		
		return null;
	}
	

	
	public String searchAnno(){
		logger.debug("inizio ricerca ragazzi per anno="+anno);
		DbMngExt db = new DbMngExt();	
		HashMap<String,String> pars = null;
		String outMsg = "tutti";
		if (anno==null){
			Date today = Calendar.getInstance().getTime();
			anno = Utility.getAnno(today);
		}
		ragazzi = db.getIscrittiAnno(anno,false);
		return outMsg;
	}
	
	

	
	
	
	public String download(){
		try{
		DbMngExt db = new DbMngExt();
		List<Object>	list = (List)session.get("partecipanti");
		String area = Utility.RONCO.getString("ronco.area.documenti.privati");
		String fn = "periodo-"+Utility.getFullDateString(Calendar.getInstance().getTime())+".xls";
		logger.debug("devo generare il file "+area + "/"+fn);
		
		if (list!=null){
			ArrayList<String> header = new ArrayList<String>();
			header.add("nome");
			header.add("cognome");
			header.add("stato");
			header.add("pagato");
			
			ArrayList<HashMap<String,Object>> vals = new ArrayList<HashMap<String,Object>>();
			
			for (Object o: list){
				Partecipanti p = (Partecipanti)o;
				HashMap<String,Object> rec = new HashMap<String,Object>();
				rec.put("nome", p.getRagazzi().getNome());
				rec.put("cognome", p.getRagazzi().getCognome());
				rec.put("stato",p.getStato()+"");
				List plist = db.getListObject("Pagamenti", "ragazzo.oid",p.getRagazzi().getOid());
				Double d = 0.0;
				if (plist!=null){
					
					for (Object obj: plist){
						Pagamenti pag = (Pagamenti)obj;
						d = d+pag.getAmount();
						
					}
					
				}
				rec.put("pagato", d+"");
				vals.add(rec);
			}
			String file = XlsUtility.getXls(header, vals, area, fn);
			logger.debug("generato il file "+area + "/"+fn);
			if (file!=null){
				FileInputStream fis = new FileInputStream(new File(file));
				response.setContentType("application/xls");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Content-disposition","attachment; filename="+fn);

				ServletOutputStream out = response.getOutputStream();
				int c;
				//StringBuffer sb = new StringBuffer();
				while ((c=fis.read())!=-1){
					//sb.append((char)c);
					out.write(c);
				}
				//out.close();
			}
		}else{
			esito = "File non scaricato:dati non disponibili";
			return "failure";
		}
		
		
		}
		catch (Exception E){
			E.printStackTrace();
			esito = "File non scaricato per errore interno";
			return "failure";
		}
		return null;
	}
	public String ragazzo(){
		logger.debug("inizio ricerca ragazzo");
		DbMng db = new DbMng();	
		Date now = Calendar.getInstance().getTime();
		anno = Utility.getAnno(now);
		HashMap<String,String> pars = new HashMap<String,String>();
		pars.put("anno", anno);
		periodiList = db.getListObject("Periodi", pars);
		ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
		
		for (int i=0;i<periodiList.size();i++){
			Periodi p = (Periodi)periodiList.get(i);
			if (isIn(p,ragazzo.getPartecipantis())){
				p.setAttivo(true);
			}else
				p.setAttivo(false);
		}
		return SUCCESS;
	}

	public String presenzeForm(){
		
		
		Date today = Calendar.getInstance().getTime();
		oggi = Utility.getFormattedData(today);
		return SUCCESS;
		
	}
	
	
	public String presenze(){
		logger.debug("inizio ricerca ragazzo");
		DbMngExt db = new DbMngExt();	
		if (giorno == null){
			giorno = Utility.getDate(sgiorno);
		}
		//Giornate g = db.get
		if (giorno==null)
			return "failure";
		ragazzi = db.getIscritti(giorno);
		if (ragazzi != null){
			ArrayList<Presenze> list = db.getPresenze(giorno);
			
			registro = new ArrayList<Registro>();
			for (Ragazzi r: ragazzi){
				Registro rec = new Registro();
				rec.setRagazzi(r);
				rec.setGiorno(giorno);
				Presenze p = db.getPresenza(r, giorno);
				if (p!=null){
					rec.setPresente(p.getPresente());
					rec.setMensa(p.getMensa());
					rec.setCompleto(p.getCompleto());
					rec.setMattina(p.getMattina());
					rec.setPomeriggio(p.getPomeriggio());
					rec.setPresenza(p);
					if (p.getMensa())
						numeroMensa++;
					if (p.getCompleto())
						presentiFull++;
					if (p.getMattina())
						presentiMattina++;
					if (p.getPomeriggio())
						presentiPomeriggio++;
				}
				else{
					rec.setPresente(false);
					rec.setMensa(false);
					rec.setCompleto(false);
					rec.setMattina(false);
					rec.setPomeriggio(false);
					rec.setPresenza(null);
				}
				registro.add(rec);
			}
			presentiMattina = presentiFull+presentiMattina;
			presentiPomeriggio=presentiFull+presentiPomeriggio;
		}
		return SUCCESS;
	}

	
	public String presenzeRagazzo(){
		DbMngExt db = new DbMngExt();
		ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
		if (anno==null)
			anno = Utility.getAnno(Calendar.getInstance().getTime());
		Set<Partecipanti> plist = ragazzo.getPartecipantis();
		if (plist!=null){
			quadro = new HashMap<String,List<Object>>();
			Iterator<Partecipanti> iter = plist.iterator();
			while (iter.hasNext()){
				Periodi p = iter.next().getPeriodi();
				if (p.getAnno().equals(anno)){
					List list = db.getPresenzePeriodo(ragazzo, p);
					quadro.put(p.getOrdine(), list);
				}else{
					logger.debug("periodo di un anno non richiesto: "+p.getAnno()+ " mentre richiesto " +anno);
				}
			}
		}
		
		return SUCCESS;
	}
	
	private boolean contains(Integer n, Integer[]l){
		boolean ok = false;
		int k=0;
		if (l!=null)
		while (!ok&&k<l.length){
			if (n.equals(l[k])){
				ok=true;
			}else{
				k++;
			}
		}
		return ok;
	}
	
	public String salva(){
		logger.debug("partenza salvataggio presenze");
		DbMngExt db = new DbMngExt();
		try{
		giorno = Utility.getDate(sgiorno);
		
		if (ragazzoOid !=null){
			html = "<ul>";
			logger.debug("numero ragzzi da aggionare: " + ragazzoOid.length);
			for (int i=0;i<ragazzoOid.length;i++){
				logger.debug("cerco ragazzo: "+ragazzoOid[i]);
				Ragazzi ragazzo =(Ragazzi) db.getObject(ragazzoOid[i], "Ragazzi");
				if (ragazzo != null){
					int roid = ragazzo.getOid();
					logger.debug("conferma  ragazzo: "+ragazzo.getOid());
					boolean nuovo = false;
					
					Presenze p = db.getPresenzaRagazzo(giorno, ragazzo);
					if (p==null){
						logger.debug("creo nuovo obj presenzao: ");
						
						p = new Presenze();
						p.setGiorno(giorno);
						p.setRagazzi(ragazzo);
						nuovo = true;
					}else{
						logger.debug("esiste obj presenzao: ");
						
					}
					logger.debug("aggionamento presenze ");
					
					if (this.contains(roid, presente)){
						logger.debug(roid+"  presente");
						p.setPresente(true);
						p.setMensa(this.contains(roid, mensa)); 
						p.setCompleto(this.contains(roid, completo));
						p.setMattina(this.contains(roid, mattina));
						p.setPomeriggio(this.contains(roid, pomeriggio));
					}else{
						logger.debug(roid+" OGGI NON  presente");
						
						p.setPresente(false);
						p.setMensa(false);
						p.setCompleto(false);
						p.setMattina(false);
						p.setPomeriggio(false);
					}
					if (nuovo)
						db.insertObject(p);
					else
						db.updObject(p);
					html = html + "<li> Aggiornato:"+ragazzo.getCognome()+"-"+ragazzo.getNome()+"</li>";
				}else{
					logger.info("non trovato ragazzo: "+ragazzoOid[i]);
				}
			}
			html = html + "</ul>";
		}else{
			html = "<p> Nessun aggiornamento possibile</p>";
		}
		}
		catch (Exception E){
			E.printStackTrace();
			html = "<p> Nessun aggiornamento possibile: errore"+E.toString()+"</p>";
		}
		logger.debug("fine salvataggio presenze");
		return SUCCESS;
		
	}
	public String presenzeOggi(){
		logger.debug("inizio ricerca ragazzo");
		DbMngExt db = new DbMngExt();	
		giorno = Calendar.getInstance().getTime();
		return presenze();
	}
	
	public String deleteRagazzo(){
		DbMngExt db = new DbMngExt();
		Boolean ok = true;
		String outMsg = SUCCESS;
		if ((oid!=null)&&(oid>0)){
			ragazzo = (Ragazzi)db.getObject(oid, "Ragazzi");
			if (ragazzo!=null){
				List plist = db.getListObject("Presenze", "ragazzi.oid", oid);
				ok = (plist==null)||(plist.size()==0);
				logger.debug("stato presenze per delete " + ok);
				if (ok){
					plist = db.getListObject("Pagamenti", "ragazzo.oid", oid);
					ok = (plist==null)||(plist.size()==0);
				}else{
					outMsg="failure";
					esito = "Cancellazione non possibile: effettuati presenze";
					return outMsg;
				}
				logger.debug("stato pagamenti per delete "+ok);
				if (ok){
					if (ragazzo.getPartecipantis()!=null){
					Set<Partecipanti> parts = ragazzo.getPartecipantis();
					if (parts!=null){
						Iterator<Partecipanti> iter = parts.iterator();
						while (ok&&iter.hasNext()){
							Partecipanti p = iter.next();
							
							if (!p.getStato()){
								db.deleteObject(p);
							}else{
								ok=false;
							}
						}
					}
					}
				}else{
					logger.debug("numero pagamenti: "+ plist.size());
					outMsg="failure";
					esito = "Cancellazione non possibile: effettuati pagamenti";
					return outMsg;
				}
				
				if (ok){
					if (ragazzo.getAllegati()!=null){
						Iterator<Allegati> iter = ragazzo.getAllegati().iterator();
						while (iter.hasNext()){
							Allegati a = iter.next();
							a.setRagazzo(null);
							db.updObject(a);
							
						}
					}
					esito = "Cancellazione effettuata con successo";
					outMsg = SUCCESS;
					db.deleteObject(ragazzo);
				}else{
					outMsg="failure";
					esito = "Cancellazione non possibile: utente approvato in un periodo";
				}
				return outMsg;
			}
		}
		return outMsg;
	}
	
	public Integer[] getMensa() {
		return mensa;
	}

	public void setMensa(Integer[] mensa) {
		this.mensa = mensa;
	}

	public Integer[] getCompleto() {
		return completo;
	}

	public void setCompleto(Integer[] completo) {
		this.completo = completo;
	}

	public Integer[] getPomeriggio() {
		return pomeriggio;
	}

	public void setPomeriggio(Integer[] pomeriggio) {
		this.pomeriggio = pomeriggio;
	}

	public Integer[] getMattina() {
		return mattina;
	}

	public void setMattina(Integer[] mattina) {
		this.mattina = mattina;
	}

	public Integer[] getRagazzoOid() {
		return ragazzoOid;
	}

	public void setRagazzoOid(Integer[] ragazzoOid) {
		this.ragazzoOid = ragazzoOid;
	}

	public Integer[] getPresenzaOid() {
		return presenzaOid;
	}

	public void setPresenzaOid(Integer[] presenzaOid) {
		this.presenzaOid = presenzaOid;
	}

	public String getSgiorno() {
		return sgiorno;
	}

	public void setSgiorno(String sgiorno) {
		this.sgiorno = sgiorno;
	}

	public Date getGiorno() {
		return giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public ArrayList<Ragazzi> getRagazzi() {
		return ragazzi;
	}

	public void setRagazzi(ArrayList<Ragazzi> ragazzi) {
		this.ragazzi = ragazzi;
	}

	public ArrayList<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(ArrayList<Registro> registro) {
		this.registro = registro;
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


	public String getFratelli() {
		return fratelli;
	}


	public void setFratelli(String fratelli) {
		this.fratelli = fratelli;
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


	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public List<Object> getPartecipanti() {
		return partecipanti;
	}


	public void setPartecipanti(List<Object> partecipanti) {
		this.partecipanti = partecipanti;
	}




	public Integer getOid() {
		return oid;
	}




	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOggi() {
		return oggi;
	}

	public void setOggi(String oggi) {
		this.oggi = oggi;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Integer[] getPresente() {
		return presente;
	}

	public void setPresente(Integer[] presente) {
		this.presente = presente;
	}

	public HashMap<String, List<Object>> getQuadro() {
		return quadro;
	}

	public void setQuadro(HashMap<String, List<Object>> quadro) {
		this.quadro = quadro;
	}

	public Integer getNumeroMensa() {
		return numeroMensa;
	}

	public void setNumeroMensa(Integer numeroMensa) {
		this.numeroMensa = numeroMensa;
	}

	public Integer getPresentiFull() {
		return presentiFull;
	}

	public void setPresentiFull(Integer presentiFull) {
		this.presentiFull = presentiFull;
	}

	public Integer getPresentiMattina() {
		return presentiMattina;
	}

	public void setPresentiMattina(Integer presentiMattina) {
		this.presentiMattina = presentiMattina;
	}

	public Integer getPresentiPomeriggio() {
		return presentiPomeriggio;
	}

	public void setPresentiPomeriggio(Integer presentiPomeriggio) {
		this.presentiPomeriggio = presentiPomeriggio;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}


	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}


	public HttpServletResponse  getServletResponse() {
		// TODO Auto-generated method stub
		return this.response;
	}

	public HttpServletRequest getServletRequest() {
		// TODO Auto-generated method stub
		return this.request;
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

	public Set<Ragazzi> getListaRagazzi() {
		return listaRagazzi;
	}

	public void setListaRagazzi(Set<Ragazzi> listaRagazzi) {
		this.listaRagazzi = listaRagazzi;
	}

	public Integer[] getSettimana() {
		return settimana;
	}

	public void setSettimana(Integer[] settimana) {
		this.settimana = settimana;
	}

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public Integer[] getSettimanaOid() {
		return settimanaOid;
	}

	public void setSettimanaOid(Integer[] settimanaOid) {
		this.settimanaOid = settimanaOid;
	}

	public Integer getPeriodoOid() {
		return periodoOid;
	}

	public void setPeriodoOid(Integer periodoOid) {
		this.periodoOid = periodoOid;
	}

	public Periodi getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodi periodo) {
		this.periodo = periodo;
	}

	public String getInizio() {
		return inizio;
	}

	public void setInizio(String inizio) {
		this.inizio = inizio;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	public Boolean getLibero() {
		return libero;
	}

	public void setLibero(Boolean libero) {
		this.libero = libero;
	}

	public String getOrdine() {
		return ordine;
	}

	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}

	public Integer getNumeroCorrente() {
		return numeroCorrente;
	}

	public void setNumeroCorrente(Integer numeroCorrente) {
		this.numeroCorrente = numeroCorrente;
	}

	public Boolean getNuovo() {
		return nuovo;
	}

	public void setNuovo(Boolean nuovo) {
		this.nuovo = nuovo;
	}

	
	
	

	
	
}
