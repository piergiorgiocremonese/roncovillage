package it.ash.mail;

import it.crem.common.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.mail.Message;

import org.apache.log4j.Logger;
public class Tester {
	public static final  java.util.ResourceBundle MAIL = java.util.ResourceBundle.getBundle("mail");
	
	
	public static void readImap(MailClient mc){
		Logger logger = Logger.getLogger(Tester.class);

		mc.init("imap");
		try{
			Message[] list = mc.readNewMessage("inbox");
			if (list!=null){
				System.out.println("No msgs:"+list.length);
					for (int i=0;i<list.length;i++){
					Message m = list[i];
					String subj = m.getSubject();
					String o = m.getContent().toString();
					System.out.println("subj="+subj);
					if (subj!=null){
						if ("personal information".equalsIgnoreCase(subj)){
							
							ArrayList<Attachment> attList = mc.getAllAttachments(m);
							if (attList!=null){
								logger.debug("numero atts " + attList.size());
								
								for (int j=0;j<attList.size();j++){
									Attachment a = attList.get(j);
									logger.debug("il file vale " + a.getFile());
									if (a.isInline()){
										logger.debug(a.getContent());
									}else{
										logger.debug("msg in "+a.getFile());
									}
									HashMap<String,String> rec = mc.getRecord("$", a);
									
									if (rec!=null){
										if (rec.containsKey("email")){
										Iterator<String> iter = rec.keySet().iterator();
										while (iter.hasNext()){
											String key = iter.next();
											
											String val = rec.get(key);
											logger.info("el: #"+key+"="+val);
											System.out.println("el: #"+key+"="+val);
												
										}
										String psw = "";
										/*
										if (!rec.containsKey("password")){
											psw = UtilityTi.getNewPsw();
											rec.put("password", psw);
										}else
											psw=rec.get("password");
										logger.debug("password for user"+rec.get("email")+" : " + psw);
										*/
										//int nc = UtilityTi.addCustomer(rec);
										String msg = Utility.MSGS.getString("message.mail.reg.body");
										String outsubj = Utility.MSGS.getString("message.mail.reg.subj");
										
										msg = msg.replace("<EMAIL>", rec.get("email"));
										msg = msg.replace("<PSW>", psw);
										String from = Utility.MAIL.getString("mail.sender");
										ArrayList<String> to = new ArrayList<String>();
										to.add(rec.get("email"));
										//to.add("pg@cremonese.org");
										System.out.println("invio il msg a "+to);
										
										int err = mc.send(from, to, outsubj, msg, (ArrayList)null);
										System.out.println("inviato il msg a "+to+" esito:"+err);
										}else{
											logger.debug("rec non corretto: ?");
										}
										
									}
									
									
								}
							}
						}
					}
					System.out.println("sunj="+subj);
					System.out.println("cnt="+o);
					
				}
			}else{
				System.out.println("No msgs 0");
				
			}
			mc.markReadMessage(list);
		}
		catch (Exception E){
			System.out.println("ERR "+E.toString());
			E.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args){
		Logger logger = Logger.getLogger(Tester.class);
		String host = MAIL.getString("mail.host");
		String user = MAIL.getString("mail.user");
		String password = MAIL.getString("mail.password");
		String sport = MAIL.getString("mail.port");
		Integer port = Integer.parseInt(sport);
		MailClient mc = new MailClient(true);
		
		
		mc.setHost("smtp.gmail.com");
		mc.setPort(465);
		mc.setUser("piergiorgiocremonese@gmail.com");
		mc.setPassword("vi00lo03");
		mc.setAttDir("/tmp/mail");
		ArrayList<String> dests = new ArrayList<String>();
		dests.add("piergiorgio.cremonese@consultant.aruba.it");
		SendMail sm = new SendMail();
		sm.sender("info@roncovillage.it", "test from java", dests, "prova messaggio","<html><body>prova messaggio</body></html>", null);
		
	}
}
