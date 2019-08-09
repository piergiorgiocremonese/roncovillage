package it.crem.server.actions;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import it.crem.db.conf.Pagamenti;
import it.crem.db.conf.Partecipanti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.conf.Sconti;
import it.crem.db.conf.Tipologie;
import it.crem.db.mng.DbMngExt;
import it.crem.server.beans.Scheda;
import it.crem.common.Field;
import it.crem.common.Utility;
import it.crem.common.XlsUtility;

import java.util.Calendar;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Transaction;






public class PagamentiAction extends RoncoAction implements 
ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer oid = 0;
	private Integer pagamentoOid = 0;
	private Integer ragazzoOid = 0;
	private String tipo = null;
	private String riferimento = null;
	private String amount = null;
	private List<Object> pagamenti = null; 
	private Ragazzi ragazzo = null; 
	private Pagamenti nuovo = null;
	private Pagamenti pagamento = null;
	private String codfiscpadre=null;
	private String codfiscmadre=null;
	private String codicefiscale = null;
	private Boolean showForm = true;
	private Double totDaPagare = 0.0;
	private String[] tipiPagamento = Utility.RONCO.getString("ronco.pagamenti.tipi").split(";");
	private Boolean nuovoPagamento = true;
	private String esito = "";
	private String mode = null;
	private Logger logger = Logger.getLogger(this.getClass());
	private ArrayList<Scheda> schede = null;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String html = "";
	private String soggetto = null;
	private List<Object> objlist = null;
	private String amountAsString = "";
	private String dataPagamento = null;
	private String url = Utility.RONCO.getString("ronco.url");
	private String causale = null;
	private Integer anno=null;
	private Sconti mySconto = null;
	private String annoCorrente = Utility.getAnno(Calendar.getInstance().getTime());
	private Set periodiPagati = null;
	
	
	private boolean isIn(Ragazzi r, ArrayList<Scheda> l){
		boolean ok=false;
		Iterator<Scheda> iter = l.iterator();
		while (!ok && iter.hasNext()){
			Scheda s = iter.next();
			ok = s.getRagazzo().equals(r);
		}
		return ok;
	}
	
	
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

	
	public String downloadRegistro(){
		try{
			DbMngExt db = new DbMngExt();
			logger.debug("aggiornamento pagamento: nuovo="+nuovoPagamento);
			
			if (anno==null){
				anno = Integer.valueOf(this.annoCorrente);
				
			}
			String sanno = anno + "";
			HashMap<String,Object> pars = new HashMap<String,Object>();
			pars.put("anno", anno);
			//objlist = db.getListObjectOrdered("Pagamenti", pars,"numero");
			objlist = db.getOrderedList(Pagamenti.class, pars, "numero");
			if (objlist!=null){
				String area = Utility.RONCO.getString("ronco.area.documenti.privati");
				String fn = "registro-"+Utility.getFullDateString(Calendar.getInstance().getTime())+".xls";
				logger.debug("devo generare il file "+area + "/"+fn);
				ArrayList<Field> typedheader = new ArrayList<Field>();
						
				ArrayList<String> header = new ArrayList<String>();
				Field nf = new Field();
				nf.setName("numero");
				nf.setType("String");
				Field cf = new Field();
				cf.setName("cognome");
				cf.setType("String");
				Field ncf = new Field();
				ncf.setName("nome");
				ncf.setType("String");
				Field dcf = new Field();
				dcf.setName("data");
				dcf.setType("String");
				Field acf = new Field();
				acf.setName("ammontare");
				acf.setType("number");
				Field tcf = new Field();
				tcf.setName("modalita");
				tcf.setType("String");
				header.add("numero");
				header.add("cognome");
				header.add("nome");
				header.add("data");
				header.add("ammontare");
				header.add("modalita");
				
				typedheader.add(nf);
				typedheader.add(cf);
				typedheader.add(ncf);
				typedheader.add(dcf);
				typedheader.add(acf);
				typedheader.add(tcf);
				
				ArrayList<HashMap<String,Object>> values = new ArrayList<HashMap<String,Object>>();
				for (int i=0;i<objlist.size();i++){
					Pagamenti p = (Pagamenti)objlist.get(i);
					if (p.getRagazzo()!=null){
					HashMap<String,Object> map = new HashMap<String,Object>(); 
					map.put("numero",p.getNumero()+"");
					map.put("cognome",p.getRagazzo().getCognome());
					map.put("nome",p.getRagazzo().getNome());
					map.put("data", p.getFormattedData());
					
					if (p.getAmount()!=null)
						map.put("ammontare", p.getFormattedAmount());
					else
						map.put("ammontare", 0);
					if (p.getTipo()!=null)
						map.put("modalita", p.getTipo());
					else
						map.put("modalita", "-");
					
					values.add(map);
					}else{
						logger.debug("esiste un pagamento errato: non associato a nessuno");
					}
					
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
				}

			}else{
				esito = "File non scaricato: dati non diponibili";
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

	
	public String download(){
		try{
		String ok = getQuadro();
		String area = Utility.RONCO.getString("ronco.area.documenti.privati");
		String fn = "quadro-"+Utility.getFullDateString(Calendar.getInstance().getTime())+".xls";
		logger.debug("devo generare il file "+area + "/"+fn);
		String file = XlsUtility.getXls(schede, area, fn);
		logger.debug("generato il file "+area + "/"+fn);
		logger.debug("realmente generato il file "+file);
		
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
		}
		catch (Exception E){
			E.printStackTrace();
			esito = "File non scaricato per errore interno";
			return "failure";
		}
		return null;
	}
	private Boolean isIn(Tipologie o, ArrayList<Tipologie> list){
		Boolean found = false;
		if (list!=null){
			Iterator<Tipologie> iter = list.iterator();
			while (!found&&iter.hasNext()){
				Tipologie b=iter.next();
				found = b.getOid()==o.getOid();
			}
		}
		return found;
	}
	private ArrayList<Tipologie> getTipologieSettimanali(Ragazzi ragazzo){
		ArrayList<Tipologie> list = null;
		Set<Partecipanti> parts = ragazzo.getPartecipantis();
		if (parts!=null){
			list = new ArrayList<Tipologie> ();
			Iterator<Partecipanti> iter = parts.iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				Tipologie t = p.getTipologie();
				if (t!=null)
				if (t.getTipo().equals("S"))
					if (!isIn(t,list)){
						list.add(t);
					}
			}
			
			
		}
		return list;
	}
	
	private ArrayList<Partecipanti> getPeriodiGiornalieri(Ragazzi ragazzo, String anno){
		
		ArrayList<Partecipanti> list = null;
		
		Set<Partecipanti> parts = ragazzo.getPartecipantis();
		if (parts!=null){
			list = new ArrayList<Partecipanti> ();
			Iterator<Partecipanti> iter = parts.iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				if (anno.equals(p.getPeriodi().getAnno())){
					Tipologie t = p.getTipologie();
					if (t!=null){
						if (!t.getTipo().equals("S")){
					
							list.add(p);
						}
					}
				}
			}
		}
	
		return list;
	}
	
	
	private ArrayList<Partecipanti> getPeriodiPerTipologia(Ragazzi ragazzo, Tipologie tipologia, String anno){
		ArrayList<Partecipanti> list = new ArrayList<Partecipanti>();
		DbMngExt db = new DbMngExt();
		Set<Partecipanti> parts= db.getPartecipantiPerAnno(ragazzo, anno);
		//Set<Partecipanti> parts = ragazzo.getPartecipantis();
		if (tipologia!=null)
		if (parts!=null){
			Iterator<Partecipanti> iter = parts.iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				if (p.getTipologie()!=null){
					if (p.getTipologie().getOid()==tipologia.getOid()){
						list.add(p);
					}
				}
			}
			
		}
		return list;
	}
	
	private Double getDovuto(Ragazzi ragazzo, DbMngExt db, String anno){
		Double totDovuto = 0.0;
		if (ragazzo!=null){
			logger.debug("ragazzo OK: "+ragazzo.getCognome());
			
			logger.debug("per ora (senza conteggare il reale totale)totale dovuto: "+totDovuto);
			ArrayList<Tipologie> list = this.getTipologieSettimanali(ragazzo);
			if (list!=null){
				Iterator<Tipologie> iter = list.iterator();
				while (iter.hasNext()){
					
					Tipologie t = iter.next();
					ArrayList<Partecipanti> tlist = this.getPeriodiPerTipologia(ragazzo, t,anno);
					Double numper = tlist.size()*1.0;
					Double dnum = numper/t.getNumSettimane();
					/*
					int num = tlist.size()/t.getNumSettimane();
					
					for (int j=0;j<num;j++){
						totDovuto =t.getCostoTotale() +totDovuto;
					}
					*/
					totDovuto = totDovuto + t.getCostoTotale()*dnum;
				}	
			}
			ArrayList<Partecipanti> partlist = this.getPeriodiGiornalieri(ragazzo,anno);
			if (partlist!=null){
				for (Partecipanti p: partlist){
					List presenze = db.getPresenzePeriodo(ragazzo, p.getPeriodi());
					Double totPer = 0.0;
					if (presenze!=null){
						for (int i=0;i<presenze.size();i++){
							totPer = totPer + p.getTipologie().getCostoUnitario();
						}
						totDovuto =totDovuto+totPer;
					}	
				
				}
			}
			/*
			Iterator<Partecipanti> iter = ragazzo.getPartecipantis().iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				if (p.getTipologie()!=null){
					if (p.getTipologie().getTipo().equals("S")){
						totDovuto = p.getTipologie().getCostoUnitario()+totDovuto;
					}else{
						List presenze = db.getPresenzePeriodo(ragazzo, p.getPeriodi());
						settimanale = false;
						Double totPer = 0.0;
						if (presenze!=null){
							for (int i=0;i<presenze.size();i++){
								totPer = totPer + p.getTipologie().getCostoUnitario();
							}
							totDovuto =totDovuto+totPer;
						}
					}
				}
			}
			*/
			Double mySconto = 0.0;
			Integer a = Integer.parseInt(anno);
			Sconti s = db.getSconto(ragazzo, a);
			if (s!=null)
				mySconto = s.getSconto();
			/*
			if (annoCorrente.equals(anno)){
				if (ragazzo.getSconto()!=null){
					mySconto = ragazzo.getSconto();
				}
			}else{
				Integer a = Integer.parseInt(anno);
				Sconti s = db.getSconto(ragazzo, a);
				mySconto = s.getSconto();
			}
			*/
			totDovuto = totDovuto - mySconto;
			ragazzo.setSconto(mySconto);
			
		}
		return totDovuto;
	}
	
	private Integer getPeriodiPerTipologia(Set<Partecipanti> plist,Tipologie t){
		Integer n=0;
		Iterator <Partecipanti> iter = plist.iterator();
		while (iter.hasNext()){
			Partecipanti p =iter.next();
			if (p.getTipologie().getOid()==t.getOid())
				n++;
		}
		
		return n;
		
	}
	
	public String getQuadro(){
		DbMngExt db = new DbMngExt();
		Date today = Calendar.getInstance().getTime();
		String sanno = null;
		if (anno == null){
			sanno = Utility.getAnno(today);
			anno = Integer.parseInt(sanno);
		}else{
			sanno = anno + "";
		}
		
		schede = new ArrayList<Scheda>(); 
		logger.debug("si parte per lista pagamenti");
		//List ragazzi = db.getListObjectOrdered("Ragazzi", (String)null, (Object)null, "cognome");
		//List ragazzi = db.getListObject("Ragazzi", (String)null, (Object)null);
		TreeSet<Ragazzi> ragazzi = db.getRagazziPerAnno(sanno);
		Iterator iter = ragazzi.iterator();
		while (iter.hasNext()){
			Ragazzi r = (Ragazzi)iter.next();
			if (this.isIn(r,schede)){
				logger.debug(r.getNome()+" " +r.getCognome()+"gia presente ");
			}else{
				
				logger.debug("lo aggiungiamo");
			//Set<Partecipanti> plist = r.getPartecipantis();
			Set<Partecipanti> plist = db.getPartecipantiPerAnno(r, sanno);
			Double costo = 0.0;
			int np = 0;
			if (plist!=null)
				np = plist.size();
			//Double totDovuto=0.0;
			Double totDovuto=this.getDovuto(r, db, sanno);
			logger.debug("dovuto per "+r.getCognome()+ " "+totDovuto);
			costo=totDovuto;
			Scheda scheda = new Scheda();
			scheda.setRagazzo(r);
			scheda.setNumeroPeriodi(np);
			scheda.setDovutoSconto(costo);
			mySconto = db.getSconto(r, anno);
			if (np>0){
				ArrayList<Tipologie> tl = this.getTipologieSettimanali(r);
				Integer nt =  0;
				for (Tipologie t: tl){
					ArrayList<Partecipanti> ntl = this.getPeriodiPerTipologia(r, t,sanno);
					if (ntl!=null){
						int u = ntl.size()/t.getNumSettimane();
						nt = nt + u*t.getNumSettimane();
					}
				}
				ArrayList<Partecipanti> pl =  this.getPeriodiGiornalieri(r,sanno);
				if (pl!=null)
					nt = nt+pl.size();				
				scheda.setOk(np==nt);
				
				if ((mySconto!=null)&&(mySconto.getSconto()>0)){
					scheda.setDovutoNoSconto(costo+mySconto.getSconto());
					scheda.setSconto(mySconto.getSconto());
				}else{
					scheda.setSconto(0.0);
					scheda.setDovutoNoSconto(costo);
				}
			/*	
			if (r.getSconto()!=null){
			//	costo = costo - r.getSconto();
				scheda.setDovutoNoSconto(costo+r.getSconto());
					
				scheda.setSconto(r.getSconto());
			}else{
				scheda.setSconto(0.0);
				scheda.setDovutoNoSconto(costo);
			}
			*/
			Double totPayed = 0.0;
			//pagamenti = db.getListObject("Pagamenti", "ragazzo.oid", r.getOid());
			pagamenti= db.getPagamentiPerAnno(r, anno);
			String ip="";
			for (int i=0;i<pagamenti.size();i++){	
				Pagamenti pay = (Pagamenti)pagamenti.get(i);
				totPayed = totPayed +pay.getAmount();
				ip=ip+","+pay.getTipo();
			}
			if (ip.length()>0){
				ip=ip.substring(1);
			}
			scheda.setInfo(ip);
			scheda.setPagato(totPayed);
			scheda.setResto(costo-totPayed);
			
			}
			schede.add(scheda);
			
		}
		}
		return SUCCESS;
	}
	
	public ArrayList<Scheda> getSchede() {
		return schede;
	}

	public void setSchede(ArrayList<Scheda> schede) {
		this.schede = schede;
	}

	public String lista(){
		DbMngExt db = new DbMngExt();
		logger.debug("si parte per lista pagamenti");
		ragazzo = (Ragazzi)db.getObject(ragazzoOid, "Ragazzi");
		//boolean settimanale = true;
		
		Date today = Calendar.getInstance().getTime();
		String sanno = Utility.getAnno(today);	
		if (anno!=null){
			sanno = anno + "";
			
		}else
			anno = Integer.parseInt(sanno);
		if (ragazzo!=null){
			logger.debug("ragazzo OK: "+ragazzo.getCognome());
			Double totDovuto = this.getDovuto(ragazzo, db,sanno );
			//Double totDovuto = 0.0;
			logger.debug("per ora (senza conteggare il reale totale)totale dovuto: "+totDovuto);
			/*
			Iterator<Partecipanti> iter = ragazzo.getPartecipantis().iterator();
			while (iter.hasNext()){
				Partecipanti p = iter.next();
				if (p.getTipologie()!=null){
					if (p.getTipologie().getTipo().equals("S")){
						totDovuto = p.getTipologie().getCostoUnitario()+totDovuto;
					}else{
						List presenze = db.getPresenzePeriodo(ragazzo, p.getPeriodi());
						settimanale = false;
						Double totPer = 0.0;
						if (presenze!=null){
							for (int i=0;i<presenze.size();i++){
								totPer = totPer + p.getTipologie().getCostoUnitario();
							}
							totDovuto =totDovuto+totPer;
						}
					}
				}
			}
			if (ragazzo.getSconto()!=null){
				totDovuto = totDovuto - ragazzo.getSconto();
			}
			*/
			
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			map.put("anno",anno);
			map.put("ragazzo.oid",ragazzo.getOid());
			pagamenti = db.getListObject("Pagamenti", (HashMap<String,String>)null, map);
			//pagamenti = db.getList(Pagamenti.class,map);
			Double totPagato = 0.0;
			if (pagamenti!=null){
				logger.debug("pagamenti effettuati: "+pagamenti.size());
				for (int i=0;i<pagamenti.size();i++){
					Pagamenti p = (Pagamenti)pagamenti.get(i);
					totPagato = totPagato + p.getAmount();
				}	
			}else
				logger.debug("pagamenti effettuati: NULL");
			totDovuto = totDovuto - totPagato;
			logger.debug("totale pagato: "+totPagato+ " totale Dovuto:"+totDovuto);
			totDaPagare = totDovuto;
			if (totDovuto < 0.1)
				showForm = false;
			dataPagamento = Utility.getFormattedData(Calendar.getInstance().getTime());
		}	
		logger.debug("si esce con "+SUCCESS);
		return SUCCESS;
	}

	public String show(){
		DbMngExt db = new DbMngExt();
		pagamento = (Pagamenti)db.getObject(oid, "Pagamenti");
		String outMsg = "fattura";
		if (pagamento != null){
			Integer anno = pagamento.getAnno();
			
			logger.debug("trovato pagamento cercato: "+pagamento.getAmount());
			dataPagamento = Utility.getFormattedData(pagamento.getData());
			ragazzo = pagamento.getRagazzo();
			periodiPagati = db.getPartecipantiPerAnno(ragazzo, anno+"");
			
			if (ragazzo!=null){
				codfiscpadre = pagamento.getRagazzo().getCodifiscPadre();
				if ("".equals(codfiscpadre))
					codfiscpadre = null;
				codfiscmadre = pagamento.getRagazzo().getCodfiscMadre();
				if ("".equals(codfiscmadre))
					codfiscmadre = null;
				amountAsString = Utility.translateDoubleInText(pagamento.getAmount());
				
			}
			
			if ((codfiscpadre!=null)&&(!"".equals(codfiscpadre))){
				codicefiscale = codfiscpadre;
				if (pagamento.getRagazzo().getCognomePadre()!=null)
					soggetto = pagamento.getRagazzo().getCognomePadre()+" "+pagamento.getRagazzo().getNomePadre();
				else
					soggetto =  pagamento.getRagazzo().getCognome() + " " +pagamento.getRagazzo().getNome();
			}
			else{
				codicefiscale = codfiscmadre;
				if (pagamento.getRagazzo().getCognomeMadre()!=null)
					soggetto = pagamento.getRagazzo().getCognomeMadre()+" " + 	pagamento.getRagazzo().getNomeMadre();
				else
					soggetto =  pagamento.getRagazzo().getCognome() + " " +pagamento.getRagazzo().getNome();
			}
			/*
			soggetto = pagamento.getRagazzo().getPadre();
			if ((soggetto==null)||("".equals(soggetto)))
					soggetto = pagamento.getRagazzo().getMadre();
			if ((soggetto==null)&&("".equals(soggetto)))
				soggetto =  pagamento.getRagazzo().getCognome() + " " +pagamento.getRagazzo().getNome(); 
			*/
		}else{
			logger.debug("NON trovato pagamento cercato: NULL");
			
		}
		if ("upd".equals(mode))
			outMsg = "modifica";
		return outMsg;
	}
	
	
	public String save(){
		DbMngExt db = new DbMngExt();
		logger.debug("aggiornamento pagamento: nuovo="+nuovoPagamento);
		if (nuovoPagamento){
			pagamento = new Pagamenti();
			ragazzo = (Ragazzi)db.getObject(ragazzoOid, "Ragazzi");
			pagamento.setRagazzo(ragazzo);
		}else{
			pagamento = (Pagamenti)db.getObject(oid, "Pagamenti");
		}
		logger.debug("ammontare nuovo pagamento = "+amount);
		if ((amount!=null)&&(!"".equals(amount))){
			Double valore = Double.parseDouble(amount);
			pagamento.setAmount(valore);
		}
		if ((dataPagamento !=null)&&(!"".equals(dataPagamento))){
			
			Date pagamentoDate = Utility.getDate(dataPagamento);
			if (pagamentoDate == null){
				pagamentoDate = Calendar.getInstance().getTime();
			}
			pagamento.setData(pagamentoDate);
				
		}else
			pagamento.setData(Calendar.getInstance().getTime());
		if (anno==null){
			anno = Integer.valueOf(annoCorrente);
			pagamento.setAnno(anno);
		}
		pagamento.setTipo(tipo);
		pagamento.setRiferimento(riferimento);
		
		if (causale!=null){
			//causale = causale.replaceAll("\n", "<br>");
			pagamento.setCausale(causale);
		}
		if (nuovoPagamento){
			Integer np = db.getLastNumeroPagamento(anno)+1;
			pagamento.setNumero(np);
		}else{
			if (pagamento.getNumero()==null){
				Integer np = db.getLastNumeroPagamento(anno)+1;
				pagamento.setNumero(np);
			}
		}
		if (nuovoPagamento){
			oid = db.insertObject(pagamento);
			if ((oid != null)&&(oid>0)){
				esito = " successo.";
				html = "Nuovo Pagamento effettuato: <a href=\"viewPagamento?oid="+oid+"\">Ricevuta</a>";
			}
			else{
				esito = " esito negativo.";
				html = "Registrazione nuovo pagamento NON effettuato";
			}
		}
		else {
			int err = db.updObject(pagamento);
			if (err >0){
				esito = "successo.";
				html = "Aggiornamento  pagamento: effettuato <a href=\"viewPagamento?oid="+pagamento.getOid()+"\">Ricevuta</a>";
			}else{
				esito = " esito negativo.";
				html=" Aggiornamento  pagamento: NON effettuato";
			}
		}
		
		logger.debug("FINE aggiornamento pagamento: "+esito);
		return SUCCESS;
	}

	
	public String showRegistro(){
		DbMngExt db = new DbMngExt();
		Date today = Calendar.getInstance().getTime();
		
		if (anno == null){
			String sanno = Utility.getAnno(today);
			anno = Integer.parseInt(sanno);
		}
		
		logger.debug("cerco pagamenti per anno ="+ anno);
		//HashMap<String,Object> pars = null;
		//pars.put("anno", anno);//.getListObjectOrdered("Pagamenti", pars,"numero");
		objlist = db.getListObjectOrdered("Pagamenti", "anno", anno, "numero");
		return SUCCESS;
	}
	
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getPagamentoOid() {
		return pagamentoOid;
	}

	public void setPagamentoOid(Integer pagamentoOid) {
		this.pagamentoOid = pagamentoOid;
	}

	public Integer getRagazzoOid() {
		return ragazzoOid;
	}

	public void setRagazzoOid(Integer ragazzoOid) {
		this.ragazzoOid = ragazzoOid;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(String riferimento) {
		this.riferimento = riferimento;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<Object> getPagamenti() {
		return pagamenti;
	}

	public void setPagamenti(List<Object> pagamenti) {
		this.pagamenti = pagamenti;
	}

	public Ragazzi getRagazzo() {
		return ragazzo;
	}

	public void setRagazzo(Ragazzi ragazzo) {
		this.ragazzo = ragazzo;
	}

	public Pagamenti getNuovo() {
		return nuovo;
	}

	public void setNuovo(Pagamenti nuovo) {
		this.nuovo = nuovo;
	}

	public Pagamenti getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamenti pagamento) {
		this.pagamento = pagamento;
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

	public Boolean getShowForm() {
		return showForm;
	}

	public void setShowForm(Boolean showForm) {
		this.showForm = showForm;
	}

	public Double getTotDaPagare() {
		return totDaPagare;
	}

	public void setTotDaPagare(Double totDaPagare) {
		this.totDaPagare = totDaPagare;
	}

	public String[] getTipiPagamento() {
		return tipiPagamento;
	}

	public void setTipiPagamento(String[] tipiPagamento) {
		this.tipiPagamento = tipiPagamento;
	}

	public Boolean getNuovoPagamento() {
		return nuovoPagamento;
	}

	public void setNuovoPagamento(Boolean nuovoPagamento) {
		this.nuovoPagamento = nuovoPagamento;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	
	
	
	

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(String soggetto) {
		this.soggetto = soggetto;
	}

	public List<Object> getObjlist() {
		return objlist;
	}

	public void setObjlist(List<Object> objlist) {
		this.objlist = objlist;
	}

	public String getAmountAsString() {
		return amountAsString;
	}

	public void setAmountAsString(String amountAsString) {
		this.amountAsString = amountAsString;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Sconti getMySconto() {
		return mySconto;
	}

	public void setMySconto(Sconti mySconto) {
		this.mySconto = mySconto;
	}

	public String getAnnoCorrente() {
		return annoCorrente;
	}

	public void setAnnoCorrente(String annoCorrente) {
		this.annoCorrente = annoCorrente;
	}

	public Set getPeriodiPagati() {
		return periodiPagati;
	}

	public void setPeriodiPagati(Set periodiPagati) {
		this.periodiPagati = periodiPagati;
	}
	
	
		
}