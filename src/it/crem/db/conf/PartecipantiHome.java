package it.crem.db.conf;

// Generated May 1, 2016 7:22:18 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Partecipanti.
 * @see it.crem.db.conf.Partecipanti
 * @author Hibernate Tools
 */
public class PartecipantiHome {

	private static final Log log = LogFactory.getLog(PartecipantiHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Partecipanti transientInstance) {
		log.debug("persisting Partecipanti instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Partecipanti instance) {
		log.debug("attaching dirty Partecipanti instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Partecipanti instance) {
		log.debug("attaching clean Partecipanti instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Partecipanti persistentInstance) {
		log.debug("deleting Partecipanti instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Partecipanti merge(Partecipanti detachedInstance) {
		log.debug("merging Partecipanti instance");
		try {
			Partecipanti result = (Partecipanti) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Partecipanti findById(int id) {
		log.debug("getting Partecipanti instance with id: " + id);
		try {
			Partecipanti instance = (Partecipanti) sessionFactory
					.getCurrentSession()
					.get("it.crem.db.conf.Partecipanti", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Partecipanti instance) {
		log.debug("finding Partecipanti instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("it.crem.db.conf.Partecipanti")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
