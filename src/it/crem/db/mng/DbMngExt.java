package it.crem.db.mng;

import it.crem.common.Utility;
import it.crem.db.BaseObject;
import it.crem.db.InitSessionFactory;
import it.crem.db.conf.Documenti;
import it.crem.db.conf.Pagamenti;
import it.crem.db.conf.Partecipanti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Presenze;
import it.crem.db.conf.Ragazzi;
import it.crem.db.conf.Sconti;
import it.crem.db.conf.Tipologie;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jcraft.jsch.Session;

import java.util.Calendar;

public class DbMngExt extends DbMng {

	
	public ArrayList<Integer> getAnniDocs(){
		ArrayList<Integer> list = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			logger.debug("ricerca iscritti" );
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Documenti.class);
			c.setProjection(Projections.distinct(Projections.property("anno")));
			List mylist = c.list();
			if (mylist!=null){
				list = new ArrayList<Integer>();
				for (int i=0;i<mylist.size();i++){
					Integer a = (Integer)mylist.get(i);
					list.add(a);
				}
			}
		}
		catch (Exception E){
			E.printStackTrace();
			list = null;
		}
		return list;
	}
	
	public List getIscrittiPeriodo(Periodi periodo){
		List list = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			logger.debug("ricerca iscritti" );
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class);
			//c.createAlias("ragazzo", "ragazzo");
			c.add(Restrictions.eq("periodi",periodo));
			c.add(Restrictions.eq("stato",true));
			list = c.list();
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return list;
		
	}
	
	
	public List getOrderedList(java.lang.Class obj,  Map<String,Object> map, String field){
		List list = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			logger.debug("ricerca oggetti" + obj.getName());
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(obj);
			//c.createAlias("ragazzo", "ragazzo");
			if (map!=null)
			for (String key: map.keySet()){
				logger.debug("restriction : "+key + " = "+map.get(key));
				c.add(Restrictions.eq(key,map.get(key)));
		
			}
			c.addOrder(Order.asc(field));
			
			list = c.list();
			
			
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return list;
		
	}
	
	public List getList(java.lang.Class obj, Map<String,Object> map){
		ArrayList<Ragazzi> ragazzi = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
			
		try{
			logger.debug("ricerca oggetti" + obj.getName());
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(obj);
			//c.createAlias("ragazzo", "ragazzo");
			if (map!=null)
			for (String key: map.keySet()){
				logger.debug("restriction : "+key + " = "+map.get(key));
				c.add(Restrictions.eq(key,map.get(key)));
		
			}
			
			List<Object[]> list = c.list();
			
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return ragazzi;
	}
	
	
	
	public ArrayList<Ragazzi> getIscrittiAnno(String anno, Boolean stato){
		ArrayList<Ragazzi> ragazzi = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
			
		try{
			logger.debug("ricerca ragazzi attesa" +" in anno " + anno);
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class);
			//c.createAlias("ragazzo", "ragazzo");
			c.createAlias("periodo", "periodo");
			ProjectionList projectionList = Projections.projectionList()
					.add(Projections.distinct(Projections.property("ragazzi")));
			c.add(Restrictions.eq("periodo.anno",anno));
			if (stato!=null)
				c.add(Restrictions.eq("stato",stato));
			else{
				projectionList.add(Projections.distinct(Projections.property("stato")));
			}
			
					
			c.setProjection(projectionList);
			List<Object[]> list = c.list();
			if (list!=null){
				ragazzi = new ArrayList<Ragazzi>();
				for (int i=0;i<list.size();i++){
					Ragazzi r = (Ragazzi)list.get(0)[0];
					r.setApproved((Boolean)list.get(0)[1]);
				}
			}
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return ragazzi;
	}
	
	
	public List getPagamentiPerAnno(Ragazzi ragazzo, Integer anno){
		List<Pagamenti> pagamenti = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			logger.debug("ricerca pagamenti" +ragazzo.getCognome()+ " in anno " + anno);
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Pagamenti.class);
			c.add(Restrictions.eq("anno",anno));
			c.add(Restrictions.eq("ragazzo",ragazzo));
			pagamenti = c.list();
			
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return pagamenti;
	}
	
	
	
	
	public Periodi getPeriodoPerAnno(String num,String anno){
		Periodi periodo = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			logger.debug("ricerca periodo settimana " +num + " in anno " + anno);
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Periodi.class);
			c.add(Restrictions.eq("anno",anno));
			c.add(Restrictions.eq("ordine",num));
			periodo = (Periodi)c.uniqueResult();
			
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return periodo;
	}
	
	public ArrayList<Ragazzi> getRagazzi(Map<String,Object> map){
		ArrayList<Ragazzi> ragazzi =null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			logger.debug("ricerca ragazzi ");
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class);
			c.createAlias("ragazzi", "r");
			if (map.containsKey("stato")){
				c.add(Restrictions.eq("stato",map.get("stato")));
				logger.debug("applico filtro au stato "+map.get("stato"));
			}
			
			if (map.containsKey("anno")){
				c.createAlias("periodi", "p");
				c.add(Restrictions.eq("p.anno",map.get("anno")));
				logger.debug("applico filtro au anno "+map.get("anno"));
			}
			if (map.containsKey("periodi")){
				Periodi p = (Periodi)map.get("periodi");
				if (p!=null){
					c.add(Restrictions.eq("periodi",p));
					logger.debug("applico filtro periodo "+p.getOid());
				}
			}
			if (map.containsKey("nome")){
				c.add(Restrictions.eq("r.nome",map.get("nome")));
			}
			if (map.containsKey("cognome")){
				c.add(Restrictions.eq("r.cognome",map.get("cognome")));
			}
			c.addOrder(Order.asc("r.cognome"));
			
			List l = c.list();
			if (l!=null){
				ragazzi = new ArrayList<Ragazzi>();
				//logger.debug("Numero partecipazionei nel " + anno+ " di "+ragazzo.getCognome()+ " "+ ragazzo.getNome()+ " : " + l.size());
				for (int i=0;i<l.size();i++){
					
					Partecipanti p = (Partecipanti)l.get(i);
					Ragazzi r = p.getRagazzi();
					if (!ragazzi.contains(r)){
						r.setApproved(p.getStato());
						ragazzi.add(r);
					}else{
						if (!r.getApproved()){
							Ragazzi rag = Utility.getElement(r, ragazzi);
							rag.setApproved(false);
						}
					}
						
				}
			}else{
				
			}
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return ragazzi;
	}
	
	
	
	public TreeSet<Partecipanti> getPartecipantiPerAnno(Ragazzi ragazzo,String anno){
		TreeSet<Partecipanti> partecipanti = new TreeSet();
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			logger.debug("ricerca ragazzi presenti nel " + anno+ " di "+ragazzo.getCognome()+ " "+ ragazzo.getNome());
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class);
			c.createAlias("periodi", "p");
			c.add(Restrictions.eq("p.anno",anno));
			c.add(Restrictions.eq("ragazzi",ragazzo));
			
			List l = c.list();
			if (l!=null){
				logger.debug("Numero partecipazionei nel " + anno+ " di "+ragazzo.getCognome()+ " "+ ragazzo.getNome()+ " : " + l.size());
				for (int i=0;i<l.size();i++){
					
					Partecipanti p = (Partecipanti)l.get(i);
					partecipanti.add(p);
					logger.debug("add partecipazionei nel " + anno+ " per " +p.getPeriodi().getOrdine()+ " in "+ p.getPeriodi().getAnno());
						
				}
			}else{
				logger.debug("Numero partecipazionei nel " + anno+ " di "+ragazzo.getCognome()+ " "+ ragazzo.getNome()+ " : NULL");
				
			}
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			//transaction.rollback();
		}
		return partecipanti;
	}
	
	public TreeSet<Ragazzi> getRagazziPerAnno(String anno){
		TreeSet<Ragazzi> ragazzi = new TreeSet();
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			logger.debug("ricerca ragazzi presenti nel " + anno);
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class);
			c.createAlias("periodi", "p");
			c.add(Restrictions.eq("p.anno",anno));
			
			
			List l = c.list();
			if (l!=null){
				for (Object o: l){
					Partecipanti p = (Partecipanti)o;
					ragazzi.add(p.getRagazzi());
				}
			}
			transaction.commit();
		}
		catch (Exception E){
			E.printStackTrace();
			transaction.rollback();
		}
		return ragazzi;
	}
	
	public Periodi getPeriodo(Date date){
		Periodi p = null;
		//Date now = Calendar.getInstance().getTime();
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Periodi.class);
			c.add(Restrictions.and(Restrictions.le("inizio", date),Restrictions.ge("fine", date) ));
			p = (Periodi)c.uniqueResult();
		
		}
		catch(Exception E){
			E.printStackTrace();
		}
		return p;
	}
	
	
	public Presenze getPresenza(Ragazzi r, Date giorno){
		Presenze p= null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		String s = Utility.getFormattedData(giorno);
		String s0 = s + " 00:00:00";
		String s1 = s + " 23:59:59";	
		try{
			transaction = session.beginTransaction();
			Date d0 = Utility.getFullDate(s0);
			Date d1 = Utility.getFullDate(s1);
			Criteria c = session.createCriteria(Presenze.class);
			c.add(Restrictions.between("giorno", d0,d1));
			c.add(Restrictions.eq("ragazzi", r));
			p = (Presenze)c.uniqueResult();
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return p;
	}
	public ArrayList<Presenze> getPresenze(Date d){
		ArrayList<Presenze> list = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		String s = Utility.getFormattedData(d);
		String s0 = s + " 00:00:00";
		String s1 = s + " 23:59:59";	
		
		try{
			transaction = session.beginTransaction();
			Date d0 = Utility.getFullDate(s0);
			Date d1 = Utility.getFullDate(s1);
			Criteria c = session.createCriteria(Presenze.class);
			c.add(Restrictions.between("giorno", d0,d1));
			//String hsql = "from Presenze as P where to_char(giorno,'YYYYMMDD')=?";
			//Query query = session.createQuery(hsql);
			//query.setParameter(0, date);
			List mylist = c.list();
			if (mylist!=null){
				list = new ArrayList<Presenze>();
				for (int i=0;i<mylist.size();i++){
					list.add((Presenze)mylist.get(i));
				}
			}
		
		}
		catch(Exception E){
			E.printStackTrace();
		}
		return list;
	}
	
	public Presenze getPresenzaRagazzo(Date d, Ragazzi ragazzo){
		Presenze p = null;;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		String s = Utility.getFormattedData(d);
		String s0 = s + " 00:00:00";
		String s1 = s + " 23:59:59";	
		
		try{
			transaction = session.beginTransaction();
			Date d0 = Utility.getFullDate(s0);
			Date d1 = Utility.getFullDate(s1);
			Criteria c = session.createCriteria(Presenze.class);
			c.add(Restrictions.between("giorno", d0,d1));
			c.add(Restrictions.eq("ragazzi",ragazzo));
			//String hsql = "from Presenze as P where to_char(giorno,'YYYYMMDD')=?";
			//Query query = session.createQuery(hsql);
			//query.setParameter(0, date);
			p = (Presenze)c.uniqueResult();
			
			
		}
		catch(Exception E){
			E.printStackTrace();
		}
		return p;
	}
	
	public List<Object> getPresenzePeriodo(Ragazzi ragazzo,Periodi periodo ){
		List<Object> list = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Presenze.class);
			c.add(Restrictions.eq("ragazzi", ragazzo));
			c.add(Restrictions.between("giorno", periodo.getInizio(), periodo.getFine()));
			c.add(Restrictions.eq("presente",true));
			list = c.list();
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	public Tipologie getTipologia(String tipo, Integer np, Boolean fd, Boolean fam ){
		Tipologie t = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Tipologie.class);
			
			c.add(Restrictions.eq("tipo",tipo) );
			c.add(Restrictions.eq("numSettimane",np) );
			c.add(Restrictions.eq("fullDay",fd) );
			c.add(Restrictions.eq("familiare",fam) );
			
			t = (Tipologie)c.uniqueResult();
			
		}
		catch(Exception E){
			E.printStackTrace();
		}
		
		return t;
	}
	
	public ArrayList<Ragazzi> getIscritti(Date date){
		ArrayList<Ragazzi> ragazzi = null;
		//Date now = Calendar.getInstance().getTime();
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			Periodi p = this.getPeriodo(date);
			if (p!=null){
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Partecipanti.class, "part");
			c.createAlias("part.periodi", "per");
			c.add(Restrictions.eq("periodi", p) );
			// il seguito aggiunto per ordinamento
			c.createAlias("part.ragazzi", "rag");
			c.addOrder(Order.asc("rag.cognome"));
			// fine ordinamento
			//c.add(Restrictions.eq("part.stato", true));
			List list = c.list();
			if (list!=null){
				ragazzi = new ArrayList<Ragazzi>();
				for (int i=0;i<list.size();i++){
					Partecipanti pt = (Partecipanti)list.get(i);
					if (pt.getStato())
						ragazzi.add(pt.getRagazzi());
					else
						logger.debug(  pt.getRagazzi().getNome()+ " - "+ pt.getRagazzi().getCognome()+"   " + pt.getRagazzi().getOid()+"  questo non lo aggiungo causa stato");
				}
			}
			}else{
				logger.debug(  "Periodo non trovato");
			}
		
		}
		catch(Exception E){
			E.printStackTrace();
		}
		return ragazzi;
	}
		
	/*
	public Integer getLastNumeroPagamento(){
		Integer num = 0;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			transaction = session.beginTransaction();
			String query = "select max(numero) from Pagamenti";
			SQLQuery sq = session.createSQLQuery(query);
			//c.add(Restrictions.eq("part.stato", true));
			num = (Integer)sq.uniqueResult();
			if (num==null)
				num=0;
		}
		catch(Exception E){
			E.printStackTrace();
		}
		
		
		return num;
	}
	
	*/
	public Integer getLastNumeroPagamento(Integer anno){
		Integer num = 0;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			transaction = session.beginTransaction();
			String query = "select max(numero) from Pagamenti where anno = "+anno;
			SQLQuery sq = session.createSQLQuery(query);
			//c.add(Restrictions.eq("part.stato", true));
			num = (Integer)sq.uniqueResult();
			if (num==null)
				num=0;
		}
		catch(Exception E){
			E.printStackTrace();
		}
		
		
		return num;
	}
	
	public boolean  verificaRagazzo(String nome, String cognome, String citta, Date data){
		Boolean ok = true;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			String sd = Utility.getFormattedData(data);
			Date start = Utility.getFullDate(sd + " 00:00:00");
			Date end = Utility.getFullDate(sd + " 23:59:59");
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Ragazzi.class, "isc");
			//c.createAlias("part.periodi", "per");
			c.add(Restrictions.eq("nome", nome).ignoreCase() );
			c.add(Restrictions.eq("cognome", cognome).ignoreCase() );
			c.add(Restrictions.eq("cittaNascita", citta).ignoreCase() );
			c.add(Restrictions.ge("dataNascita", start));
			c.add(Restrictions.le("dataNascita", end));
			//c.add(Restrictions.eq("dataNascita", data));
			List list = c.list();
			ok = ((list==null)||(list.size()==0));
			
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return ok;
	}
	
	
	public Sconti getSconto(Ragazzi ragazzo, Integer anno){
		Sconti s = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Sconti.class, "asc");
			c.add(Restrictions.eq("ragazzo",ragazzo));
			c.add(Restrictions.eq("anno",anno));
			List list = c.list();
			if (list!=null){
				//s = new Sconti();
				for (int i=0;i<list.size();i++){
					Sconti ns = (Sconti)list.get(i);
					if (s==null)
						s = ns;
					else{
						s.setSconto(s.getSconto()+ns.getSconto());
					//s.setOid(ns.getOid());
					//s.setRagazzo(ragazzo);
					}
					
					
				}
			}
			
		}
		catch (Exception E){
			E.printStackTrace();
			s = new Sconti();
		}
		return s;
	}
	
	public Ragazzi  getRagazzo(String nome, String cognome, String citta, Date data){
		Boolean ok = true;
		Ragazzi ragazzo = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
			
		try{
			String sd = Utility.getFormattedData(data);
			Date start = Utility.getFullDate(sd + " 00:00:00");
			Date end = Utility.getFullDate(sd + " 23:59:59");
			transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Ragazzi.class, "isc");
			//c.createAlias("part.periodi", "per");
			c.add(Restrictions.eq("nome", nome).ignoreCase() );
			c.add(Restrictions.eq("cognome", cognome).ignoreCase() );
			c.add(Restrictions.eq("cittaNascita", citta).ignoreCase() );
			c.add(Restrictions.ge("dataNascita", start));
			c.add(Restrictions.le("dataNascita", end));
			//c.add(Restrictions.eq("dataNascita", data));
			List list = c.list();
			if ((list!=null)||(list.size()==1))
				ragazzo = (Ragazzi)list.get(0);
					
			//ok = ((list==null)||(list.size()==0));
			
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return ragazzo;
	}
	
	public static void main(String[] args){
		String d = "25/11/2009";
		String citta="PAVULLO NEL FRIGNAGNO";
		String nome = "RICCARDO";
		String cognome = "CROVETTI";
		
		
		
		Date data = Utility.getDate(d);
		DbMngExt db = new DbMngExt();
		Boolean ok = db.verificaRagazzo(nome, cognome, citta, data);
		System.out.println("esito= " +ok);
	//	Ragazzi r  = (Ragazzi)db.getObject(21, "Ragazzi");
		/*
		Tipologie t = db.getTipologia("S", 2, true, false);
		if (t!=null){
			System.out.println("rgazzo " + t.getForma());
		}else{
			System.out.println("NULLA");
		}
		*/
		/*
		if (p!=null){
			System.out.println("lista " + p.size());
			for (int i = 0;i<p.size();i++){
				Ragazzi r = (Ragazzi)p.get(i);
				System.out.println("rgazzo " + r.getNome()+"-"+r.getCognome()+"   "+ r.getOid());
			}
		}
		 
		else
			System.out.println("lista NULL");
			*/
	}
	
}