package it.ash.mail;

import it.ash.mail.MailClient;
import it.crem.common.Utility;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.log4j.Logger;

import java.io.*;






public class SendMail {
	
		private String user = null;
		private String password = null;
		private Logger logger = Logger.getLogger(this.getClass());
		public SendMail(String user, String password){
			this.user = user;
			this.password = password;
		}
		public SendMail(){
			this.user = MailClient.MAIL.getString("mail.user");
			this.password = MailClient.MAIL.getString("mail.password");
		}
		public int sender(String from,String subject, ArrayList<String> dests,String text,String html,ArrayList<String> atts){
			 boolean auth = true;
		     MailClient mc = new MailClient(auth);
		     logger.debug("invio a "+dests.get(0)+" msg :"+text + " - " +html);
		     String txt =  "<p>"+MailClient.MAIL.getString("mail.info.ext.html")+"</p>";
		     if (html.contains("</body>")){
		    	 txt = txt +"</body>";
		    	 html = html.replaceAll("</body>", txt);
		     }else{
		    	 html = html + txt;
			     	 
		     }
		     int err = mc.sendHtml(from, dests, subject, text, html, atts);
		     return err;
		}
		
		
	

			
	   public static void main(String [] args)
	   {
	      
		  String from = Utility.MAIL.getString("mail.sender");
		  String dest = Utility.MAIL.getString("mail.dest.list");
		  
		  String[] list = dest.split(",");
		  String subject="";
    	  String body = "";
    	  ArrayList<String> dests = new ArrayList<String>();
	      String attsName = ""; 
	      if ((args!=null)&&(args.length>0)){
	    	  for (int i=0;i<args.length;i++)
	    		  dests.add(args[i]);
	      }else{
	    	  if (list!=null){
	    		  for (int i=0;i<list.length;i++)
	    			  dests.add(list[i]);
	    	 // dests.add("piergiorgiocremonese@gmail.com");
	    	  }else
	    		  dests.add(Utility.MAIL.getString("mail.dest"));
	
	      }
	      dests.add("piergiorgiocremonese@gmail.com");
	      String fn = "";
	      String[] atts=null;
	      subject = Utility.MAIL.getString("mail.subject");
	      String text = "pezzo di test plain:\n\nProva di testo da inviare plain\n";
	      body="<html><body><p>\n";
	      body = body + "<table><bold><tr><td>1</td><td>2</td><td>3</td></tr><bold>";
	      body = body + "<tr><td>uno</td><td>due</td><td>tre</td></tr>";
	      body = body + "</table></p><p><img src=\""+MailClient.MAIL.getString("mail.logo.mail.url")+"\" /></p>";
	     // body = body+"</p><p><img src=\""+MailClient.MAIL.getString("mail.logo.mail.url")+"\" /></p>";
	      body = body + "</body></html>\n";
	      
	      ArrayList<String> attaches = new ArrayList<String>();
	      //String file = "/home/netlab/Immagini/mimose.jpg";
	     // attaches.add(file);
		   /*  
	      if (args.length>0){
	    	  attsName = args[0];
	    	  atts = attsName.split(",");
	      }
	      
	      if (atts!=null)
	      {
	    	  for (int i=0;i<atts.length;i++){
	    		  attaches.add(atts[i]);
	    	  }
	      }
	      
	      
	      try{
	    	  FileInputStream fin = new FileInputStream(fn);
	    	  FileReader fr = new FileReader(new File(fn)); 
	    	  BufferedReader bf = new BufferedReader(fr);
	    	  String line = null;
	    	  while ((line = bf.readLine())!=null){
	    		  dests.add(line);
	    	  
	    	  }
	    	  
	      }
	      catch (Exception E){
	    	  System.out.println("Errore invio email:"+E.toString());
	      }
	     
	      boolean auth = true;
	      MailClient mc = new MailClient(auth);
	     
	      mc.sendHtml(from, dests, subject, text, body, attaches);
	       */
	      SendMail sender = new SendMail();
	      sender.sender(from, subject, dests, text, body,attaches);
	      //sender.sender(from, subject, dests, text, "",null);
	   }
	
}
