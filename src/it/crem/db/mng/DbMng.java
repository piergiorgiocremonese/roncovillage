package it.crem.db.mng;


//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.crem.db.InitSessionFactory;
import it.crem.db.conf.Documenti;
import it.crem.common.Utility;
import it.crem.db.BaseObject;
//import it.ash.db.beans.Users;






import org.apache.log4j.Logger;
//import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

public class DbMng {
Logger logger = Logger.getLogger(this.getClass());

public static java.util.ResourceBundle DB = java.util.ResourceBundle.getBundle("db");
	
	Session session;
	
	
	public int deleteObject(Object o){
		int err=1;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
		try{
			logger.debug("salvataggio generico");
			transaction = session.beginTransaction();
			session.delete(o);
			transaction.commit();
			logger.debug("cancellazione " + o.getClass().getCanonicalName());
		}
		catch (Exception hibernateexception)
		{
			logger.error("HibernateException aggiornamento oggetto generico"+hibernateexception.toString(), hibernateexception);
			hibernateexception.printStackTrace();
			if(transaction != null && transaction.isActive())
				transaction.rollback();
			err=-1;
		}
		
		
		return err;
	}
	
	public int updObject(Object o){
		int err=1;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		
		try{
		logger.debug("salvataggio generico");
			transaction = session.beginTransaction();
		session.update(o);
		transaction.commit();
		logger.debug("aggiornamento di " + o.getClass().getCanonicalName());
		}
		catch (Exception hibernateexception)
		{
			logger.error("HibernateException aggiornamento oggetto generico"+hibernateexception.toString(), hibernateexception);
			hibernateexception.printStackTrace();
			if(transaction != null && transaction.isActive())
				transaction.rollback();
			err=0;
		}
		
		
		return err;
	}
	
	
	public int insertObject(BaseObject o){
		logger.debug("inserimento generico");
		
		int err=1;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		String objName = o.getClass().getSimpleName();
	//	String seq = DB.getString("db.seq."+objName);
		try{
			transaction = session.beginTransaction();
			//String sql = "select nextval('"+seq+"') as oid";
			//SQLQuery q = session.createSQLQuery(sql);
			//q.addScalar("oid",StandardBasicTypes.INTEGER);
			//Integer oid = (Integer)q.uniqueResult();
			//System.out.println("nuovo elemento vale "+oid);
			//o.setOid(oid);
			session.save(o);
			transaction.commit();
			logger.debug("inserimento di " + o.getClass().getCanonicalName());
			err = o.getOid();
		}
		catch (Exception E)
		{
			logger.error("HibernateException aggiornamento oggetto generico"+E.toString());
			E.printStackTrace();
			if(transaction != null && transaction.isActive())
				transaction.rollback();
			err=-1;
		}
		
		
		return err;
	}
	
	public int insertObject(BaseObject o, String seq){
		int err=1;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		System.out.println("obj="+o.getClass().getSimpleName());
		try{
			logger.debug("inserimento generico");
			transaction = session.beginTransaction();
			String sql = "select nextval('"+seq+"') as oid";
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("oid",StandardBasicTypes.INTEGER);
			Integer oid = (Integer)q.uniqueResult();
			System.out.println("nuovo elemento vale "+oid);
			o.setOid(oid);
			session.save(o);
			transaction.commit();
			logger.debug("inserimento di " + o.getClass().getCanonicalName());
			err = o.getOid();
		}
		catch (Exception hibernateexception)
		{
			logger.error("HibernateException aggiornamento oggetto generico"+hibernateexception.toString());
			hibernateexception.printStackTrace();
			if(transaction != null && transaction.isActive())
				transaction.rollback();
			err=-1;
		}
		
		
		return err;
	}
	public Object getObject(int oid, String obj){
		Object o = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj + " con oid = " + oid);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			Query query = session.createQuery("from " + obj +" where id = ?");
			query.setParameter(0, oid, StandardBasicTypes.INTEGER);
			logger.debug("creata query ");

			o = query.uniqueResult();
			logger.debug("eseguita query ");
			if (o != null)
			{
				logger.debug("trocato elemento ");
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return o;
		
	}
	
	public Object getUniqueObject(String obj, String field, String val){
		Object o = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			Query query = session.createQuery("from " + obj +" where " + field + " = ?");
			query.setParameter(0, val, StandardBasicTypes.STRING);
			logger.debug("creata query ");

			o = query.uniqueResult();
			logger.debug("eseguita query ");
			if (o != null)
			{
				logger.debug("trocato elemento ");
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return o;
		
	}
	
	private String getQuery(String obj, String field, Integer value){
		String sql = "from " + obj;
			if ((field!=null)&&(!"".equals(field))){
			sql = sql + " where " + field+ "="+value+" ";
		}
		
		return sql;
	}
	
	
	private String getQuery(String obj, String field, String value){
		String sql = "from " + obj;
			if ((field!=null)&&(!"".equals(field))){
			sql = sql + " where " + field+ "='"+value+"'";
		}
		
		return sql;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getListObjectOrdered(String obj, String field, Object value, String ordfield){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			String sql = "from " + obj;
			logger.debug("inizio transazione ");
			if ((field!=null)&&(!"".equals(field))){
				if (value instanceof String){
					String v = (String)value;
					sql=this.getQuery(obj, field, v);
				}else if (value instanceof Integer){
					Integer v = (Integer)value;
					sql=this.getQuery(obj, field, v);
			
				}else{
					logger.debug("campo value non supportato");
					return null;
				}
			}	
			sql = sql + " order by "+ordfield;
			Query query = session.createQuery(sql );
			//query.setParameter(0, oid, Hibernate.INTEGER);
			logger.debug("creata query ");

			l = query.list();
			logger.debug("eseguita query ");
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getListObject(String obj, String field, Object value){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			String sql = "from " + obj;
			logger.debug("inizio transazione ");
			if ((field!=null)&&(!"".equals(field))){
				if (value instanceof String){
					String v = (String)value;
					sql=this.getQuery(obj, field, v);
				}else if (value instanceof Integer){
					Integer v = (Integer)value;
					sql=this.getQuery(obj, field, v);
			
				}else{
					logger.debug("campo value non supportato");
					return null;
				}
			}	
			Query query = session.createQuery(sql );
			//query.setParameter(0, oid, Hibernate.INTEGER);
			logger.debug("creata query ");

			l = query.list();
			logger.debug("eseguita query ");
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getListObject(String obj, Map<String,String> pars){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			String q = "from " + obj +" ";
			if ((pars !=null)&&(pars.size()>0)){
				Iterator<String> iter = pars.keySet().iterator();
				String f=iter.next();
				String v=pars.get(f);
				q = q + " where "+ f + "='"+v+"' ";
				while (iter.hasNext()){
					f=iter.next();
					v=pars.get(f);
					
					q = q + " AND "+ f + "='"+v+"' ";
					
				}
			}	
			//query.setParameter(0, oid, Hibernate.INTEGER);
			Query query = session.createQuery(q);
			logger.debug("creata query "+q);

			l = query.list();
			logger.debug("eseguita query " + q);
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getListObjectOrdered(String obj, Map<String,String> pars, String field){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			String q = "from " + obj +" ";
			if ((pars !=null)&&(pars.size()>0)){
				Iterator<String> iter = pars.keySet().iterator();
				String f=iter.next();
				String v=pars.get(f);
				q = q + " where "+ f + "='"+v+"' ";
				while (iter.hasNext()){
					f=iter.next();
					v=pars.get(f);
					
					q = q + " AND "+ f + "='"+v+"' ";
					
				}
			}	
			if ((field!=null)&&((!"".equals(field))))
				q = q + " order by "+field;
			//query.setParameter(0, oid, Hibernate.INTEGER);
			Query query = session.createQuery(q);
			logger.debug("creata query "+q);

			l = query.list();
			logger.debug("eseguita query " + q);
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}

	
	
	public List<Object> getList(String obj,Map<String,Object> pars){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			ArrayList<Object> mypars = new ArrayList<Object>();
			
			String q = "from " + obj +" ";
			if (pars!=null){
				for (String x: pars.keySet()){
					if (mypars.size()==0){
						q = q + " WHERE " + x + " = ? ";
					}else{
						q = q + " AND " + x + " = ? ";
					}
					mypars.add(pars.get(x));
				}
		
			}
			
			Query query = session.createQuery(q);
			logger.debug("query da eseguire : "+query.getQueryString());
			for (int i=0;i<mypars.size();i++){
				query.setParameter(i, mypars.get(i));
				logger.debug("aggiorno parametro : " + mypars.get(i) );
			}
			l = (List<Object>) query.list();
		}
		catch(Exception E){
			E.printStackTrace();
			logger.error(E.getMessage());
		}
		return l;
	}
	
	
	
	public List<Object> getListObject(String obj, Map<String,String> strPars, Map<String,Integer> intPars){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			String q = "from " + obj +" ";
			boolean p = false;
			if ((strPars !=null)&&(strPars.size()>0)){
				Iterator<String> iter = strPars.keySet().iterator();
				String f=iter.next();
				String v=strPars.get(f);
				q = q + " where "+ f + "='"+v+"' ";
				p=true;
				while (iter.hasNext()){
					f=iter.next();
					v=strPars.get(f);
					
					q = q + " AND "+ f + "='"+v+"' ";
					
				}
			}	
			if ((intPars !=null)&&(intPars.size()>0)){
				Iterator<String> iter = intPars.keySet().iterator();
				String f=iter.next();
				Integer v=intPars.get(f);
				if (!p)
					q = q + " where "+ f + "="+v+" ";
				else
					q = q + " AND "+ f + "="+v+" ";
				while (iter.hasNext()){
					f=iter.next();
					v=intPars.get(f);
					
					q = q + " AND "+ f + "="+v+" ";
					
				}
			}
			//query.setParameter(0, oid, Hibernate.INTEGER);
			Query query = session.createQuery(q);
			logger.debug("creata query ");

			l = query.list();
			logger.debug("eseguita query ");
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}
	public List<Object> getRowListObject(String obj, Map<String,Object> objPars){
		List<Object> l = null;
		session = InitSessionFactory.getInstance().getCurrentSession();
		Transaction transaction = null;
		try
		{
			logger.debug("cerco obj "+obj);
			transaction = session.beginTransaction();
			logger.debug("inizio transazione ");
			String q = "from " + obj +" ";
			boolean p = false;
			ArrayList<Object> list = new ArrayList<Object>();
			if ((objPars !=null)&&(objPars.size()>0)){
				Iterator<String> iter = objPars.keySet().iterator();
				String f=iter.next();
				Object v=objPars.get(f);
				list.add(v);
				q = q + " where "+ f + "=? ";
				p=true;
				while (iter.hasNext()){
					f=iter.next();
					list.add(v);
					
					q = q + " AND "+ f + "=?  ";
					
				}
			}	
			Query query = session.createQuery(q);
			for (int i=0;i<list.size();i++){
				query.setParameter(i, list.get(i));
			}
			logger.debug("creata query ");

			l = query.list();
			logger.debug("eseguita query ");
			if (l != null)
			{
				logger.debug("trovati elementi "+l.size());
			}
			else
			{
				logger.debug("query nulla ");
			}
			transaction.commit();
			logger.debug("commit ");

		}
		catch (HibernateException hibernateexception)
		{
			logger.error("HibernateException cmsuser" + hibernateexception.toString());
			hibernateexception.printStackTrace();
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		catch (Exception hibernateexception)
		{
			logger.error("General ev: " + hibernateexception.toString());
			hibernateexception.printStackTrace();
			// logger.error(hibernateexception.getStackTrace());
			if (transaction != null && transaction.isActive())
				transaction.rollback();
		}
		
		return l;
		
	}
	
	
	
	public static void main(String[] args){
		Logger logger = Logger.getLogger(DbMng.class);
		java.util.Date now = Calendar.getInstance().getTime();
		Integer anno = Integer.parseInt(Utility.getAnno(now));
		String key = "liberatoria";
		System.out.println("si cerca valore per "+key + " anno=" + anno);
		DbMng db = new DbMng();
		HashMap<String,Object> pars = new HashMap<String,Object>();
		pars.put("keywords",key);
		pars.put("anno",anno);
		List<Object> lista = db.getList("Documenti", pars);
		if (lista!=null){
			for (Object o: lista){
				Documenti d = (Documenti)o;
				System.out.println("url = "+d.getUrl()+ " nome = "+d.getNome());
			}
		}
		
	}
}