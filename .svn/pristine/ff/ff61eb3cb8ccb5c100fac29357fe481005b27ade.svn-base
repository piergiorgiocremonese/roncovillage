package it.ash.web.security;


import org.apache.log4j.*;
import it.crem.db.mng.*;
import it.crem.db.conf.*;
import java.util.ArrayList;
//import it.ash.web.common.Utility;
public class Auth {
	private static Logger logger =Logger.getLogger(Auth.class);
	public static java.util.ResourceBundle RES = java.util.ResourceBundle.getBundle("web");
	
	private static String  prefix =RES.getString("security.prefix");
	public static boolean checkUser(String username,String password){
		boolean ret=false;
		String storedpsw="";
		DbMng db = new DbMng();
        
		PasswordService ps = PasswordService.getInstance();
    	try {
    		storedpsw = prefix + ps.encrypt(password);
    		logger.debug("password:"+password);
    		logger.debug("cryptpassword:"+storedpsw);
    		Utenti utente = (Utenti)db.getUniqueObject("Utenti","login", username);
    		
			logger.debug("recuperato utente " + username);
			logger.debug("recuperato utente psw" + utente.getPassword());
			
    		if (storedpsw.equals(utente.getPassword())){
    			ret=true;
    			logger.debug("autenticazione OK per " + username);
    			
    		} else {
    			logger.debug("password errata per " + username);
    			ret=false;
    		}
    	}
    	
    	catch (Exception E){
    		logger.error("errore "+E.toString());
    		ret=false;
    	}
		return ret;
		
	}
	
	
	public static boolean checkEndUser(String username,String password){
		boolean ret=false;
		String storedpsw="";
		DbMng db = new DbMng();
        
		PasswordService ps = PasswordService.getInstance();
    	try {
    		storedpsw = prefix + ps.encrypt(password);
    		logger.debug("password:"+password);
    		logger.debug("cryptpassword:"+storedpsw);
    		Utenti utente = (Utenti)db.getUniqueObject("Utenti","login", username);
    		
			logger.debug("recuperato utente " + username);
			logger.debug("recuperato utente psw" + utente.getPassword());
			
    		if (storedpsw.equals(utente.getPassword())){
    			ret=true;
    			logger.debug("autenticazione OK per " + username);
    			
    		} else {
    			logger.debug("password errata per " + username);
    			ret=false;
    		}
    	}
    	
    	catch (Exception E){
    		logger.error("errore "+E.toString());
    		ret=false;
    	}
		return ret;
		
	}
	
	
	public static String getCyptedPsw(String password){
		
		String psw=null;
		
		PasswordService ps = PasswordService.getInstance();
    	try {
    		psw = ps.encrypt(password);
    	}
    	catch (Exception E){
    		logger.error("errore in cryption "+E.toString());
    		psw=null;
    	}
    	return psw;
	}
	
	public static String getCyptedStoredPassword(String password){
		String psw=getCyptedPsw( password);
		return prefix + psw;
		
	}
	
	
	public static void main(String[] args){
		String p = "tarallo";
		System.out.println(getCyptedPsw(p));
	}

}
