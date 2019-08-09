package it.ash.web.interceptors;

import it.crem.common.Utility;
import it.crem.db.conf.Documenti;
//import it.ash.ticinohelth.db.conf.UserLog;
import it.crem.db.conf.Utenti;
import it.crem.db.mng.DbMng;
//import it.ash.web.security.Auth;

import it.ash.web.security.Auth;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics
{

	private static final long	serialVersionUID	= 1L;

	private Logger					logger				= Logger.getLogger(this.getClass());
	private HashMap<String,String> vals = null;
	
	public String intercept(ActionInvocation invocation) throws Exception
	{
		// Get the action context from the invocation so we can access the
		// HttpServletRequest and HttpSession objects.
		logger.debug("inizio interceptor");
		String out = "success";
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		String host = request.getRemoteAddr();
		String locHost = request.getLocalAddr();
		logger.debug("remote addr = "+host);
		logger.debug("Local addr = "+locHost);
		HttpSession session = request.getSession(true);
		
		if (("localhost".equals(host))||("127.0.0.1".equals(host)))
			host="localhost";
		if (("localhost".equals(locHost))||("127.0.0.1".equals(locHost)))
			locHost="localhost";
		logger.debug("NOW remote addr = "+host);
		logger.debug("NOW Local addr = "+locHost);
		
		boolean ok = false;
		logger.debug("session =" + request.getSession().getId());
		
		Enumeration<String> list = request.getHeaderNames();
		String username=null;
		String password=null;
		DbMng db = new DbMng();
		Utenti user = null;
		
		
		/*
		logger.debug("analisi per login");
		if (list != null)
		{
			vals = new HashMap<String,String> ();
			while (list.hasMoreElements())
			{
				String name = list.nextElement();
				String val = request.getHeader(name);
				vals.put(name, val);
				logger.debug("header : " + name + "=" + val);
			}
		}
		*/
		String login = (String) session.getAttribute("LOGIN");
		
		//UserLog log = new UserLog();
		//log.setSession(session.getId());
		////log.setIpAddress(host);
		//log.setCtime(Calendar.getInstance().getTime());
		//log.setAction(request.getRequestURL().toString());
		if (("".equals(login)) || (login == null))
		{
			logger.debug("non auth cerco credenziali");
			/*
			if (vals.containsKey("username")){
				username = vals.get("username");
				logger.debug("username presente "+username);
				
				if (vals.containsKey("password")){
					password = vals.get("password");
					logger.debug("password presente "+password);
					
				}
				if (username!=null){
					logger.debug("trovato "+username);
					user = (Utenti)db.getUniqueObject("Utenti", "login", username);
					if (user!=null){
						String p = user.getPassword();
						ok = p.equals(Auth.getCyptedPsw(password));
						logger.debug("esito credenziali check: "+ok);
						//ok=Auth.checkUser(username, password);
						if (ok){
							session.setAttribute("LOGIN", username);
							//log.setUser(username);
						}else{
							//log.setUser("guest");
								
						}
							
					}else{
					//	log.setUser("guest");
					}
					
				}else{
				//	log.setUser("guest");
				}
			}else{
				//log.setUser("guest");
			}
			*/
		}
		else{
			//log.setUser(login);
			ok = true;
		}
		
		//db.insertObject(log);
		if (ok){
			logger.debug("invocazione regolare " + context.getName());

			invocation.invoke();

			logger.debug("eseguita " + context.getName());
		}else{
			String uri = request.getRequestURI();
			logger.debug("confronto uri: "+uri);
			
			if (uri.contains("listaInteresse"))
				out = "collegeLogin";
			else
				out = "mylogin";
			/*
			if (locHost.equals(host)){
				logger.debug(" invocazione locale");

				ok = true;

				invocation.invoke();


			}else{

				logger.debug("login non inizializzato e da remoto");
				out = "mylogin";
			}
			*/
	
		}
		logger.debug("fine interceptor  " + out);

		return out;
	}

	public void init()
	{

	}

	public void destroy()
	{

	}

}
