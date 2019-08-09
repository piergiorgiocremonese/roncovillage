package it.ash.mail;
import java.io.*;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

import org.apache.log4j.*;



public class MailClient {
	
	private String prot = null; 
	private Folder liveFolder = null;
	private Folder repFolder = null;
	private String host = null;
	private Integer port = null;
	private String user = null;
	private String password = null;
	private Session session = null;
	private Store store = null;
	private String attDir=null;
	private int error = 0;
	private String errorMessage = null;
	private Logger logger = Logger.getLogger(this.getClass());
	Properties properties = null;
	
	public static java.util.ResourceBundle MAIL = java.util.ResourceBundle.getBundle("mail");

	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public MailClient(){
		properties = System.getProperties();
		prot=MAIL.getString("mail.protocol");
		properties.setProperty("mail."+prot+".host",MAIL.getString("mail.host"));
	    properties.setProperty("mail."+prot+".port", MAIL.getString("mail.port"));
	    properties.put("mail.smtp.auth", "false");
	    
		session = Session.getDefaultInstance(properties);
	 	
	}
	public MailClient(boolean auth){
		properties = System.getProperties();
		prot=MAIL.getString("mail.protocol");
		properties.setProperty("mail."+prot+".host",MAIL.getString("mail.host"));
		properties.setProperty("mail."+prot+".port", MAIL.getString("mail.port"));
		properties.put("mail.smtp.auth", auth);
	    
	     if (!auth){
	    	session = Session.getDefaultInstance(properties);
	    }else{
	    	
	    	//SMTPAuthenticator myauth = new SMTPAuthenticator();
	       	//session = Session.getDefaultInstance(properties,myauth);
	    	//myauth.setUsername("piergi");
	    	//myauth.setPassword("strunz97");
	    	if (MAIL.containsKey("mail.security")){
		    	if (MAIL.getString("mail.security").equals("ssl")){
		    		properties.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		    		properties.put("mail.smtp.socketFactory.class",
		    				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		    	   
		    	}
		    }
	    	password=MAIL.getString("mail.password");
	    	user= MAIL.getString("mail.user");
	    	
	    	//myauth.setUsername(MAIL.getString("mail.user"));
	    	//myauth.setPassword(MAIL.getString("mail.password"));
	    	 properties.setProperty("mail.user", user);
	    	 properties.setProperty("mail.password", password);
	    	  
	    	session = Session.getDefaultInstance(properties);
	    }
	 	
	}
	public void init(String repository){
		// repository is "imap" or "pop3"
		try{
			store = session.getStore(repository);
		 	store.connect(host, user, password);
		 	
		}
		catch (Exception E){
			logger.error("errore inizializzazione mail client "+E.toString());
		}
	}
	
	
	public Message[] readNewMessage(String folder)throws Exception{
		liveFolder = store.getFolder("inbox");
		liveFolder.open(Folder.READ_WRITE);
		  //Message[] message = inbox.getMessages();
		  FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN),false); 
		
		Message[] ml = liveFolder.search(ft);
		if (ml!=null)
			logger.debug("trovati messaggi: "+ml.length);
		else
			logger.debug("non trovati messaggi");
		return  ml;
		
	}
	
	public void moveProcessed(Message[] list, String proc)throws Exception{
		logger.debug("sposto messaggi");
		repFolder = store.getFolder(proc);
		repFolder.open(Folder.READ_WRITE);
		repFolder.appendMessages(list);
		repFolder.close(true);
		//this.deleteReadMessage(list);
	}
	
	
	public void markReadMessage(Message[] list) throws Exception {
		//liveFolder.setFlags(list, new Flags(Flags.Flag.), true);
		Flags flag = new Flags(Flags.Flag.SEEN);
		
		if (list!=null){
			for (int i=0;i<list.length;i++){
				list[i].setFlags(flag,true);
			}
		}
		//liveFolder.expunge();
		  
	}
	
	
	public void deleteReadMessage(Message[] list) throws Exception {
		liveFolder.setFlags(list, new Flags(Flags.Flag.DELETED), true);
		liveFolder.expunge();
		  
	}
	
	public void closeFolder(Folder folder) throws Exception{
		folder.close(true);
	}
	
	public void stopClient() throws Exception{
		try{
			liveFolder.close(true);
			store.close();
		}
		catch (Exception E){
			logger.error("errore stop client "+E.toString());
			
		}
		
	}
	
	
	public HashMap<String,String> getRecord(String sep,Attachment a){
		String msg = null;
		HashMap<String,String> rec = new HashMap<String,String>();
		try{
		if (!a.isInline()){
			File f = new File(a.getFile());
			FileInputStream fis = new FileInputStream(f);
			int c=0;
			StringBuffer sb = new StringBuffer();
			while( (c=fis.read())!=-1){
				sb.append((char)c);
				
			}
			msg = sb.toString();
			logger.debug(msg);
		}else{
			logger.debug("att is inline nel msg=");
			msg = a.getContent();
			
		}
		logger.debug("msg="+msg);
		ArrayList<String> fields =new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(msg,sep);
		while (st.hasMoreElements()){
			fields.add((String)st.nextElement());
		}
		if (fields!=null){
			int n = fields.size();
			logger.debug("n di elementi="+n);
			if (n>1){
			int k=0;
			boolean end=false;
			while ((k<n)&&(!end)){
				if (n>k+1){
					String key = fields.get(k);
					char g = key.charAt(0);
					while ( (g==10)||(g==13)||(g==32)){
						key = key.substring(1);
						g = key.charAt(0);
							
					}
					String val = fields.get(k+1);
					rec.put(key, val);
					k=k+2;
				}else
					end=true;
			}
			}else{
				logger.debug("allegato non corretto scartato");
				rec = null;
			}
		}
		}
		catch (Exception E){
			rec = null;
			logger.error("ERRORE:"+E.toString());
			
		}
		return rec;
	}
	
	public ArrayList<Attachment> getAllAttachments(Message m){
		
		ArrayList<Attachment> list=null;
		if ((attDir==null)||("").equals(attDir)){
			error=-5;
			errorMessage="attach dir is not set";
			
		}else{
			list = new ArrayList<Attachment>();
			try{
			if (m.getContent() instanceof java.lang.String){
				logger.debug("ramo inline");
				Attachment att = new Attachment();
				  att.setType("text(plain");
				  
				  String text = (String)m.getContent();
				  logger.debug("messaggio vale:"+text);
				  att.setContent(text);
				  att.setInline(true);
				  list.add(att);
				 
			  }else
				  if (m.getContent() instanceof Multipart){
					  logger.debug("ramo multipart");
					  Multipart multipart = (Multipart)m.getContent();
					  for (int i = 0; i < multipart.getCount(); i++) {
						  BodyPart bodyPart = multipart.getBodyPart(i);
						  String ct = bodyPart.getContentType();
						  Attachment att = new Attachment();
						  att.setType(ct);
						  InputStream stream = bodyPart.getInputStream();
					
						  
						  if (ct.startsWith("text/")){
							  StringBuffer sb = new StringBuffer();
							  
							  int c;
							  while ((c=stream.read())!=-1) {
							  		sb.append((char)c);
								  
							  }
							  att.setContent(sb.toString());
							  att.setInline(true);
							  logger.debug("testo att="+sb.toString());
								  
						  }else{
							  String fileName = attDir+"/"+bodyPart.getFileName();
							  File file = new File(fileName)  ;
							  FileOutputStream dos = new FileOutputStream(file);
							  byte[] buf = new byte[4096];
						        int bytesRead;
						        while((bytesRead = stream.read(buf))!=-1) {
						            dos.write(buf, 0, bytesRead);
						        }
						        dos.close();

							  dos.close();
							  att.setFile(fileName);
							  att.setName(bodyPart.getFileName());
							  att.setInline(false);
						  }
						  list.add(att);
					  	}
					  
			 
				  }else{
					  logger.debug("non conosco il messaggio"+m.getContent());
					  
				  }
			}
			catch (Exception E){
				logger.error("Errore nel recupero attachment: "+ E.toString());
			}
			
		}
		
		return list;
		
		
	}
	
	public int send(String from, String[] to, String subject,String body, ArrayList<String> atts){
		int err = 0;
		if (to!=null){
			ArrayList<String> list = new ArrayList<String>();
			for (int i=0;i<to.length;i++){
				list.add(to[i]);
			}
			err = send(from,list,subject,body,atts);
		}else
			err = -2;
		return err;
	}
	
	public int  send(String from, String[] to, String subject,String body, String[] atts){
		int err = 0;
		if (to!=null){
			ArrayList<String> list = new ArrayList<String>();
			for (int i=0;i<to.length;i++){
				list.add(to[i]);
			}
			err = send(from,list,subject,body,atts);
		}else
			err = -2;
		return err;
	}
	
	public int send(String from, ArrayList<String> to, String subject,String body, String[] atts){
		int err = 0;
		ArrayList<String> attachments = new ArrayList<String>();
		if (atts!=null){
			for (int i=0;i<atts.length;i++){
				attachments.add(atts[i]);
			}
			
		}
		err = this.send(from,to,subject,body,attachments);
		return err;
	}
	
	public int send(String from, ArrayList<String> to, String subject,String body, ArrayList<String> atts){

		 //Session session = Session.getDefaultInstance(properties);
		int err = 0;
		 try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.	
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         int n = to.size();
	         for (int i=0;i<n;i++)
	        	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to.get(i)));

	         // Set Subject: header field
	         message.setSubject(subject);
	         message.setSentDate(Calendar.getInstance().getTime());

	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         
	         messageBodyPart.setText(body);
	         
	         Multipart multipart = new MimeMultipart();
	         //Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Create a multipar message
	         if((atts!=null)&&(atts.size()>0)){
	         	// Part of attachments: list of files
	        	 for (int i=0;i<atts.size();i++){
	        		 
	        		 messageBodyPart = new MimeBodyPart();

	        		 String filename = atts.get(i);
	        		 DataSource source = new FileDataSource(filename);
	        		 messageBodyPart.setDataHandler(new DataHandler(source));
	        		 messageBodyPart.setFileName(filename);
	        		 multipart.addBodyPart(messageBodyPart);
	        	 }

	         }
	        	 
	         message.setContent(multipart );

       	 // Send the complete message parts
		        // Transport transport = session.getTransport("smtp");
				//transport.connect(host, port, user, password);
		        
			
	         // Send message
	         //Transport.send(message);
	         //System.out.println("Sent message successfully....");
	         Transport transport = session.getTransport(prot);
		     transport.connect(null,password);
		     transport.sendMessage(message, message.getAllRecipients());
	      
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         logger.error(mex.toString());
	         err = -1;
	      }
		
		return err;
	}
	public int sendHtml(String from, String[] to, String subject,String text, String html, String[] atts){
		int err = 0;
		ArrayList<String> attList = null;
		ArrayList<String> dests = null;
		if (atts!=null){
			attList = new ArrayList<String>();
			for (int i=0;i<atts.length;i++){
				attList.add(atts[i]);
			}
		}
		if (to!=null){
			dests = new ArrayList<String>();
			for (int i=0;i<to.length;i++){
				dests.add(to[i]);
			}
		}
		err = sendHtml(from,dests,subject,text,html,attList);
		return err;
	}
	public int sendHtml(String from, ArrayList<String> to, String subject,String text, String html, ArrayList<String> atts){

		 //Session session = Session.getDefaultInstance(properties);
		int err = 0;
		 try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         
	         // Set From: header field of the header.	
	         message.setFrom(new InternetAddress(from));
	         message.setSentDate(Calendar.getInstance().getTime());
	         // Set To: header field of the header.
	         int n = to.size();
	         for (int i=0;i<n;i++)
	        	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to.get(i)));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         message.setHeader("Disposition-Notification-To:",from);
	         messageBodyPart.setText(text);
	         
	         Multipart multipart = new MimeMultipart();
	         //Set text message part
	         multipart.addBodyPart(messageBodyPart);
			 MimeBodyPart htmlMessageBodyPart = new MimeBodyPart();
			 htmlMessageBodyPart.setDataHandler(new DataHandler(html,"text/html"));
    		 multipart.addBodyPart(htmlMessageBodyPart);

	         // Create a multipar message
	         if((atts!=null)&&(atts.size()>0)){
	         	// Part of attachments: list of files
	        	 for (int i=0;i<atts.size();i++){
	        		 
	        		 messageBodyPart = new MimeBodyPart();

	        		 String filename = atts.get(i);
	        		 DataSource source = new FileDataSource(filename);
	        		 messageBodyPart.setDataHandler(new DataHandler(source));
	        		 messageBodyPart.setFileName(filename);
	        		 multipart.addBodyPart(messageBodyPart);
	        	 }

	         }
	        	 
	         message.setContent(multipart );
	         Transport transport = session.getTransport(prot);
		     transport.connect(null,password);
		     transport.sendMessage(message, message.getAllRecipients());
	     
      	 // Send the complete message parts
		        // Transport transport = session.getTransport("smtp");
				//transport.connect(host, port, user, password);
		        
			
	         // Send message
	        // Transport.send(message);
	         logger.debug("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         logger.error("errore invio msg"+mex.toString());
	         err = -1;
	      }
		
		return err;
	}


	
	public Folder getLiveFolder() {
		return liveFolder;
	}

	public void setLiveFolder(Folder liveFolder) {
		this.liveFolder = liveFolder;
	}

	public Folder getRepFolder() {
		return repFolder;
	}

	public void setRepFolder(Folder repFolder) {
		this.repFolder = repFolder;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getAttDir() {
		return attDir;
	}

	public void setAttDir(String attDir) {
		this.attDir = attDir;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	 public class SMTPAuthenticator extends javax.mail.Authenticator {
		 	private String username = null;
		 	private String password = null;
	        public PasswordAuthentication getPasswordAuthentication() {
	          // String username = SMTP_AUTH_USER;
	          // String password = SMTP_AUTH_PWD;
	           return new PasswordAuthentication(username, password);
	        }
	        
	        public void setUsername(String username){
	        	this.username=username;
	        }
	        public void setPassword(String password){
	        	this.password=password;
	        }
	        
	    }

}
