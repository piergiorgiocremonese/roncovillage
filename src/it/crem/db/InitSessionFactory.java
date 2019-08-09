package it.crem.db;






import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 * @author hennebrueder This class garanties that only one single SessionFactory
 *         is instanciated and that the configuration is done thread safe as
 *         singleton. Actually it only wraps the Hibernate SessionFactory.
 *         When a JNDI name is configured the session is bound to to JNDI,
 *         else it is only saved locally.
 *         You are free to use any kind of JTA or Thread transactionFactories.
 */
public class InitSessionFactory {

	/**
	 * Default constructor.
	 */
	private InitSessionFactory() {
	}

	/**
	 * Location of hibernate.cfg.xml file. NOTICE: Location should be on the
	 * classpath as Hibernate uses #resourceAsStream style lookup for its
	 * configuration file. That is place the config file in a Java package - the
	 * default location is the default Java package.<br>
	 * <br>
	 * Examples: <br>
	 * <code>CONFIG_FILE_LOCATION = "/hibernate.conf.xml".
	 * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code>
	 */
	
	private static String CONFIG_FILE_LOCATION = "/ronco.cfg.xml";

	/** The single instance of hibernate configuration */
	private static final Configuration cfg = new Configuration();

	/** The single instance of hibernate SessionFactory */
	private static org.hibernate.SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger("it.crem.db");

	/**
	 * initialises the configuration if not yet done and returns the current
	 * instance
	 *
	 * @return
	 */
	public static SessionFactory getInstance() {
		if (sessionFactory == null)
			initSessionFactory();
		return sessionFactory;
	}

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 *
	 * @return Session
	 * @throws HibernateException
	 */
	public Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * The behaviour of this method depends on the session context you have
	 * configured. This factory is intended to be used with a hibernate.cfg.xml
	 * including the following property <property
	 * name="current_session_context_class">thread</property> This would return
	 * the current open session or if this does not exist, will create a new
	 * session
	 *
	 * @return
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * initializes the sessionfactory in a safe way even if more than one thread
	 * tries to build a sessionFactory
	 */
	public static synchronized void initSessionFactory() {

		//Logger log = Logger.getLogger(InitSessionFactory.class);
		if (sessionFactory == null) {


			try {
				log.debug("lettura cfg engage hibernate");
				cfg.configure(CONFIG_FILE_LOCATION);
				String sessionFactoryJndiName = cfg
				.getProperty(Environment.SESSION_FACTORY_NAME);
				if (sessionFactoryJndiName != null) {
					cfg.buildSessionFactory();
					log.debug("get a jndi session factory");
					sessionFactory = (SessionFactory) (new InitialContext())
							.lookup(sessionFactoryJndiName);
				} else{
					
					log.debug("classic factory");
					sessionFactory = cfg.buildSessionFactory();
					log.debug("creata SessionFactory");
				}

			} catch (Exception e) {
				log.error("%%%% Error Creating HibernateSessionFactory %%%%" + e.toString());
				e.printStackTrace();
				throw new HibernateException(
						"Could not initialize the Hibernate configuration");
			}
		}
	}

	public static void close(){
		if (sessionFactory != null)
			sessionFactory.close();
		sessionFactory = null;

	}
}

