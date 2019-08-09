package it.ash.web.actions;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import it.crem.db.conf.Utenti;

import it.crem.db.mng.DbMng;
import it.ash.web.security.Auth;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String username = null;
	private String password = null;
	private Map session	 = ActionContext.getContext().getSession();
	private String message = null;
	//private ArrayList<Messages> messages = null;
	private Integer numMsg = 0;
	private Logger logger = Logger.getLogger(this.getClass());
	public  java.util.ResourceBundle MSGS = null;
	private HashMap<String,String> msgs = new HashMap<String,String>();
	private String country = "IT";
	private String lang = "it";
	
	/*
	private void populateKey(){
		Locale locale = (Locale)session.get("LOCALE");
		if (locale!=null){
		//logger.debug("locale:"+lang+","+country);
			logger.debug("java locale:"+locale.getLanguage()+","+locale.getCountry());
			lang = locale.getLanguage();
			country = locale.getCountry();
		}
		else{
			logger.debug("LOCALE is null: inizializzazione it_IT");
			locale=new Locale(lang,country);
		}
		 MSGS = java.util.ResourceBundle.getBundle("ticino-messages",locale);
		 Enumeration<String> keys = MSGS.getKeys();
		 while (keys.hasMoreElements()){
			 String k = keys.nextElement();
			 String v = MSGS.getString(k);
			 msgs.put(k, v);
			 //logger.debug("aggiungo:"+k+"="+v);
		 }
	}
	*/
	public void setSession(Map session){
		session = this.getSession();
	}
	
	public Map getSession(){
		return session;
	}
	public String execute(){
		return "view";
	}
	public String logout(){
		//String message = SUCCESS;
		logger.debug("inizio azione di logout: ");
		if (session.containsKey("LOGIN")){
			message = "ARRIVEDERCI " + session.get("LOGIN");
			session.remove("LOGIN");
			if (session.containsKey("TYPEOFUSER"))
				session.remove("TYPEOFUSER");
			logger.debug("rimuovo LOGIN da sessione");
			
		}else{
			logger.debug("utente non loggato");
			message = " NON sei LOGGATO come faccio a sloggarti";
		}
		return SUCCESS;
		
	}
	public String custLogout(){
		//String message = SUCCESS;
		logger.debug("inizio azione di logout: ");
		if (session.containsKey("LOGIN")){
			message = "ARRIVEDERCI " + session.get("LOGIN");
			session.remove("LOGIN");
			logger.debug("rimuovo LOGIN da sessione");
			if (session.containsKey("TYPEOFUSER"))
				session.remove("TYPEOFUSER");
			
		}else{
			logger.debug("utente non loggato");
			message = " NON sei LOGGATO come faccio a sloggarti";
		}
		return SUCCESS;
		
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String login(){
		logger.debug("inizio login ");
		DbMng db = new DbMng();
		boolean ok = false;
		if ( (username==null)||("".equals(username))){
			message = "Necessaria autenticazione";
			logger.debug("caso form");
			return "form";
		}
		logger.debug("caso auth "+username);
		
		Utenti user = (Utenti)db.getUniqueObject("Utenti", "login", username);
		
		if (user!=null){
			logger.debug("trovato user: "+user.getNome());
			String p = user.getPassword();
			ok = p.equals(Auth.getCyptedPsw(password));
			logger.debug("esito: "+ok);
			
		}else{
			logger.debug("not found user "+username);
		}
		if (ok){
			//populateKey();
			
			session.put("LOGIN", username);
			
			
			return "success";
		}else{
			message = "user non autenticato";
			return "form";
		}
	}
	
	
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public Integer getNumMsg() {
		return numMsg;
	}

	public void setNumMsg(Integer numMsg) {
		this.numMsg = numMsg;
	}
	public HashMap<String, String> getMsgs() {
		return msgs;
	}
	public void setMsgs(HashMap<String, String> msgs) {
		this.msgs = msgs;
	}
	
	
}
