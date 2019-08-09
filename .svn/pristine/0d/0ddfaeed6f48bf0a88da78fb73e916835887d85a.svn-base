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
 * Home object for domain model class Ragazzi.
 * @see it.crem.db.conf.Ragazzi
 * @author Hibernate Tools
 */
public class RagazziHome {

	private static final Log log = LogFactory.getLog(RagazziHome.class);

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

	public void persist(Ragazzi transientInstance) {
		log.debug("persisting Ragazzi instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ragazzi instance) {
		log.debug("attaching dirty Ragazzi instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ragazzi instance) {
		log.debug("attaching clean Ragazzi instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ragazzi persistentInstance) {
		log.debug("deleting Ragazzi instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ragazzi merge(Ragazzi detachedInstance) {
		log.debug("merging Ragazzi instance");
		try {
			Ragazzi result = (Ragazzi) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ragazzi findById(int id) {
		log.debug("getting Ragazzi instance with id: " + id);
		try {
			Ragazzi instance = (Ragazzi) sessionFactory.getCurrentSession()
					.get("it.crem.db.conf.Ragazzi", id);
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

	public List findByExample(Ragazzi instance) {
		log.debug("finding Ragazzi instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("it.crem.db.conf.Ragazzi")
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
