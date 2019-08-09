package it.ash.web.security;





import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import org.myorg.SystemUnavailableException;
import org.apache.log4j.*;
public final class PasswordService
{
  private static Logger logger = Logger.getLogger(PasswordService.class);
  
  private static PasswordService instance;
  private PasswordService()
  {
  }
  
  
  public synchronized String encrypt(String plaintext) throws Exception
  {
	  logger.debug("password service start");
	MessageDigest md = null;
    try
    {
      md = MessageDigest.getInstance("SHA"); //step 2
    }
    catch(NoSuchAlgorithmException e)
    {
    	logger.error("errore:"+e.toString());
      throw new Exception(e.getMessage());
    }
    try
    {
      md.update(plaintext.getBytes("UTF-8")); //step 3
    }
    catch(UnsupportedEncodingException e)
    {
    	logger.error("erroire "+e.toString());
      throw new Exception(e.getMessage());
    }
    byte raw[] = md.digest(); //step 4
    String hash = Base64.encodeBytes(raw);
   // String hash = (new BASE64Encoder()).encode(raw); //step 5
    logger.debug("fine PasswordService");
    return hash; //step 6
  }
  
  public static synchronized PasswordService getInstance() //step 1
  {
	  logger.debug("nuova istanza di PasswordService");
    if(instance == null)
    {
      return new PasswordService();
    }
    else    
    {
      return instance;
    }
  }
  
  
  public static void main(String args[]){
	  System.out.println("parto");
	  /*
	  if (args.length==0){
		  System.out.println("parametri insufficienti");
		  System.exit(1);
	  }
	  */
	 // String psw="fahtih";
	  String psw="cae@school";
	  PasswordService myps = PasswordService.getInstance();
	  try{
		  System.out.println("inizio kenrel");
		  String hashed = myps.encrypt(psw);
		  java.io.FileWriter file = new java.io.FileWriter("/tmp/psw");
		  file.write(hashed);
		  	
		  
		  file.close();
		  System.out.println("psw="+hashed);
		  String newash = myps.encrypt(psw);
		  
		 
		  java.io.FileReader fi = new java.io.FileReader("/tmp/psw");
		  int c;
		  char ch;
		  StringBuffer sb = new StringBuffer();
		  while ((c=fi.read())!=-1){
			  ch = (char)c;
			  sb.append(ch);
			  
		  }
		  
		  String stpass = sb.toString();
		  System.out.println("sw="+stpass);
		  if (newash.equals(stpass)){
			  System.out.println("psw=OK");
			    
		  } else {
			  System.out.println("psw=NOK");
		  }
		  
	  }
	  catch (Exception E){
		  System.out.println("errore" + E.toString());
		  System.exit(1);
	  }
	  
	  
  }
}
