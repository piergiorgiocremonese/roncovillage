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

public class StdInterceptor extends AbstractInterceptor implements StrutsStatics
{

	private static final long	serialVersionUID	= 1L;

	private Logger					logger				= Logger.getLogger(this.getClass());
	
	public String intercept(ActionInvocation invocation) throws Exception
	{
		// Get the action context from the invocation so we can access the
		// HttpServletRequest and HttpSession objects.
		logger.debug("inizio interceptor standard interceptor");
		String out = "success";
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		String prot = request.getProtocol();
		if (!prot.toLowerCase().startsWith("https"))
			prot = "http";
		else
			prot = "https";
		String url = prot+"://"+request.getServerName();
		int p = request.getServerPort();
		if (p != 80){
			url = url + ":"+p;
		}
		String host = request.getRemoteAddr();
		String locHost = request.getLocalAddr();
		logger.debug("remote addr = "+host);
		logger.debug("Local addr = "+locHost);
		DbMng db = new DbMng();
		Integer anno = Integer.parseInt(Utility.getAnno(Calendar.getInstance().getTime()));
		HttpSession session = request.getSession(true);
		session.setAttribute("URL", url);
		logger.debug("accedo a : " + url + " registrato in URL di session");
		
		if (("localhost".equals(host))||("127.0.0.1".equals(host)))
			host="localhost";
		if (("localhost".equals(locHost))||("127.0.0.1".equals(locHost)))
			locHost="localhost";
		logger.debug("NOW remote addr = "+host);
		logger.debug("NOW Local addr = "+locHost);
		Enumeration attrs = session.getAttributeNames();
		boolean found = false;
		while (!found&&attrs.hasMoreElements()){
			String a = (String) attrs.nextElement();
			found = "PRIVACY".equals(a);
		}
		if (!found){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("keywords", "liberatoria");
			map.put("anno", anno);
			logger.debug("cerco oggetti con anno=" +anno + " e keywords=liberatoria");
			List<Object> lista=db.getList("Documenti",map);
			if (lista!=null&&lista.size()>0){
				Documenti d = (Documenti)lista.get(0);
				session.setAttribute("PRIVACY", d.getUrl());
			}
		}
		invocation.invoke();
		return out;
	}

	public void init()
	{

	}

	public void destroy()
	{

	}

}
