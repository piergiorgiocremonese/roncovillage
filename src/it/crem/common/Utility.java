package it.crem.common;


import it.crem.db.BaseObject;
import it.crem.db.conf.Partecipanti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.conf.Tipologie;
import it.crem.db.mng.DbMngExt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;







import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.apache.log4j.Logger;

public class Utility {
	public static String[] mesi = {"Gennaio", "Febraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
	public static Logger logger = Logger.getLogger(Utility.class);
	public static java.util.ResourceBundle MSGS = java.util.ResourceBundle.getBundle("ronco-messages");
	public static java.util.ResourceBundle MAIL = java.util.ResourceBundle.getBundle("mail");
	public static java.util.ResourceBundle RES = java.util.ResourceBundle.getBundle("web");
	public static java.util.ResourceBundle RONCO = java.util.ResourceBundle.getBundle("ronco");
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdftpar = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat sdfc = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
	private static SimpleDateFormat sdfd = new SimpleDateFormat("dd");
	private static SimpleDateFormat sdfm = new SimpleDateFormat("MM");
	
	
	public static String getMese(Date date){
		Integer m = Integer.parseInt(sdfm.format(date));
		return mesi[m-1];
	}
	
	public static String getTime(Date date){
		try{
		return sdftime.format(date);
		}
		catch (Exception E){
			return null;
		}
	}
	public static String getGiorno(Date date){
		String d = null;
		try{
			d =  sdfd.format(date);;
		}
		catch (Exception E){
			E.printStackTrace();
		}
		
		return d;
	}
	
	public static String getAnno(Date date){
		
		String d = null;
		try{
			d =  sdfy.format(date);;
		}
		catch (Exception E){
			E.printStackTrace();
		}
		
		return d;
		
	}
	
	public static String getFormattedData(Date data){
		String d = null;
		try{
			d = sdf.format(data);
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return d;
	}
	
	public static Date getDate(String data){
		Date date = null;
		try{
			date = sdf.parse(data);
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return date;
	}
	
	public static Date getFullDate(String data){
		Date date = null;
		try{
			date = sdft.parse(data);
		}
		catch (Exception E){
			
		}
		return date;
	}
	public static String getFullDateString(Date data){
		String date = null;
		try{
			date = sdftpar.format(data);
		}
		catch (Exception E){
			
		}
		return date;
	}
	
	
	public static Integer getAnnoByString(String data){
		
		Integer anno = null;
		try{
		Date date = sdf.parse(data);
		String sanno = getAnno(date);
		anno = Integer.parseInt(sanno);
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return anno;
		
	}
	
	public static boolean isIn(Periodi p, Set<Partecipanti> pl){
		boolean ok=false;
		if (pl==null)
			logger.debug("inutile confronto : NULL");
			
		else{
			logger.debug("confronto periodo con partecipazioni: "+pl.size());
			Iterator<Partecipanti> iter = pl.iterator();
			while (!ok && iter.hasNext()){
				Partecipanti pn = iter.next();
				logger.debug("confronto " + pn.getPeriodi().getOrdine() + " con "+ p.getOrdine());
				logger.debug("confronto " + pn.getPeriodi().getAnno() + " con "+ p.getAnno());
			
				ok = pn.getPeriodi().getOrdine().equals(p.getOrdine());
				if (ok)
					ok = pn.getPeriodi().getAnno().equals(p.getAnno());
			}
		}
		return ok;
	}
	public static boolean getStatoPeriodo(Periodi p, Set<Partecipanti> pl){
		Boolean ok=false;
		Boolean stato = false;
		Iterator<Partecipanti> iter = pl.iterator();
		while (!ok && iter.hasNext()){
			Partecipanti pn = iter.next();
			ok = pn.getPeriodi().getOrdine().equals(p.getOrdine());
			if (ok){
				if (pn.getStato()!=null)
					stato = pn.getStato();
				
			}
		}
		return stato;
	}
	
	
	public static Tipologie getTipologiaPeriodo(Periodi p, Set<Partecipanti> pl){
		Tipologie t = null;
		Boolean ok=false;
		Iterator<Partecipanti> iter = pl.iterator();
		while (!ok && iter.hasNext()){
			Partecipanti pn = iter.next();
			ok = pn.getPeriodi().getOrdine().equals(p.getOrdine());
			if (ok){
				t = pn.getTipologie();
			}
		}
		
		return t;
	}
	
	
	public static Tipologie getRightTipology(Ragazzi ragazzo){
		Tipologie t = null;
		if (ragazzo == null)
			return t;
		DbMngExt db = new DbMngExt();
		String anno = Utility.getAnno(Calendar.getInstance().getTime());
		Set<Partecipanti> ppl = db.getPartecipantiPerAnno(ragazzo, anno);
		//Set<Partecipanti> ppl = ragazzo.getPartecipantis();
		
		if (ppl!=null){
			//DbMngExt db = new DbMngExt();
			Integer num = ppl.size();
			Boolean fam =(ragazzo.getFratelli()!=null)&&(!"".equals(ragazzo.getFratelli())); 
			t = db.getTipologia("S", num, true, fam);
		}
		
		return t;
	}
	public static Tipologie getRightTipology(Integer num, Boolean fam){
		Tipologie t = null;
		logger.debug("cercop tipo per per: sett "+num+" "+fam);
		DbMngExt db = new DbMngExt();
		//Boolean fam =(fratelli!=null)&&(!"".equals(fratelli)); 
		t = db.getTipologia("S", num, true, fam);
		return t;
	}
	
	public static String translateIntInText(Integer num){
		String text = "";
		String n = Integer.toString(num);
		int lun =  n.length();
		switch (lun){
			case 1:
				
		}
		
		
		
		return text;
	}
	
	public static String translateDigitInText(String sd){
		Integer d = Integer.parseInt(sd);
		return translateDigitInText(d);
	}
	
	public static String translateDigitInText(Integer digit){
		String c="";
		switch (digit){
			case 0:
				c="";
				break;
			case 1:
				c="uno";
				break;
			case 2:
				c="due";
				break;
			case 3:
				c="tre";
				break;
			case 4:
				c="quattro";
				break;
			case 5:
				c="cinque";
				break;
			case 6:
				c="sei";
				break;
			case 7:
				c="sette";
				break;
			case 8:
				c="otto";
				break;
			case 9:
				c="nove";
				break;
				
				
		}
		return c;
	}

	public static String translateDecInText(String num){
		String c="";
		String n=num;
		System.out.println("all dec to int: "+num);
		String x = n.substring(0,1);
		Integer d1 = Integer.parseInt(x);
		System.out.println("dec to int: "+d1);
		switch (d1){
			case 0:
				c="";
				String y = n.substring(1);
				String dec = "";
				Integer d2 = Integer.parseInt(y);
				switch (d2){
				case 0:
					dec = "";
					break;
				case 1:
					dec = "uno";
					break;
				
				case 2:
					dec="due";
					break;
				case 3:
					dec="tre";
					break;
				case 4:
					dec="quattro";
					break;
				case 5:
					dec="cinque";
					break;
				case 6:
					dec="sei";
					break;
				case 7:
					dec="sette";
					break;
				case 8:
					dec="otto";
					break;
				case 9:
					dec="nove";
					break;
					
					
				}
				c = dec;
				break;
			case 1:
				 y = n.substring(1);
				dec = "";
				d2 = Integer.parseInt(y);
				switch (d2){
				case 0:
					dec = "dieci";
					break;
				case 1:
					dec = "undici";
					break;
				
				case 2:
					dec="dodici";
					break;
				case 3:
					dec="tredici";
					break;
				case 4:
					dec="quattordici";
					break;
				case 5:
					dec="quindici";
					break;
				case 6:
					dec="sedici";
					break;
				case 7:
					dec="diciassette";
					break;
				case 8:
					dec="diciotto";
					break;
				case 9:
					dec="diciannove";
					break;
					
					
				}
				c = dec;
				break;
			case 2:
				c="venti"+translateDigitInText(n.substring(1));
				break;
			case 3:
				c="trenta"+translateDigitInText(n.substring(1));
				break;
			case 4:
				c="quaranta"+translateDigitInText(n.substring(1));
				break;
			case 5:
				c="cinquanta"+translateDigitInText(n.substring(1));
				break;
			case 6:
				c="sessanta"+translateDigitInText(n.substring(1));
				break;
			case 7:
				c="settanta"+translateDigitInText(n.substring(1));
				break;
			case 8:
				c="ottanta"+translateDigitInText(n.substring(1));
				break;
			case 9:
				c="novanta"+translateDigitInText(n.substring(1));
				break;
				
				
		}
		return c;
	}

	
	
	
	
	public static String translateDecInText(Integer num){
		String c="";
		String n=Integer.toString(num);
		System.out.println("all dec to int: "+num);
		String x = n.substring(0,1);
		Integer d1 = Integer.parseInt(x);
		System.out.println("dec to int: "+d1);
		switch (d1){
			case 0:
				c="";
				break;
			case 1:
				String y = n.substring(1);
				String dec = "";
				Integer d2 = Integer.parseInt(y);
				switch (d2){
				case 0:
					dec = "dieci";
					break;
				case 1:
					dec = "undici";
					break;
				
				case 2:
					dec="dodici";
					break;
				case 3:
					dec="tredici";
					break;
				case 4:
					dec="quattordici";
					break;
				case 5:
					dec="quindici";
					break;
				case 6:
					dec="sedici";
					break;
				case 7:
					dec="diciassette";
					break;
				case 8:
					dec="diciotto";
					break;
				case 9:
					dec="diciannove";
					break;
					
					
				}
				c = dec;
				break;
			case 2:
				c="venti"+translateDigitInText(n.substring(1));
				break;
			case 3:
				c="trenta"+translateDigitInText(n.substring(1));
				break;
			case 4:
				c="quaranta"+translateDigitInText(n.substring(1));
				break;
			case 5:
				c="cinquanta"+translateDigitInText(n.substring(1));
				break;
			case 6:
				c="sessanta"+translateDigitInText(n.substring(1));
				break;
			case 7:
				c="settanta"+translateDigitInText(n.substring(1));
				break;
			case 8:
				c="ottanta"+translateDigitInText(n.substring(1));
				break;
			case 9:
				c="novanta"+translateDigitInText(n.substring(1));
				break;
				
				
		}
		return c;
	}

	public static String translateCentoInText(Integer num){
		String pref = "cento";
		String c="";
		String n = num.toString();
		String d2 = n.substring(0, 1);
		Integer d = Integer.parseInt(d2);
		switch (d){
			case 0:
				//c = Utility.translateDecInText(Integer.parseInt(n.substring(1))); 
				c = Utility.translateDecInText(n.substring(1));
				break;
			case 1:
				c=pref+Utility.translateDecInText(n.substring(1));
				//c=pref+Utility.translateDecInText(Integer.parseInt(n.substring(1)));
				break;
			default:
				System.out.println(d2 + " "+n.substring(1));
				c=Utility.translateDigitInText(d2)+pref+Utility.translateDecInText(n.substring(1));
				//c=Utility.translateDigitInText(d2)+pref+Utility.translateDecInText(Integer.parseInt(n.substring(1)));
				break;
				
		}
		
		return c;
	}
	public static String translateMilleInText(Integer num){
		String pref = "mila";
		String c="";
		String n = num.toString();
		String d2 = n.substring(0, 1);
		Integer d = Integer.parseInt(d2);
		switch (d){
			case 0:
				c = Utility.translateCentoInText(Integer.parseInt(n.substring(1))); 
				break;
			case 1:
				pref = "mille";
				c=pref+Utility.translateCentoInText(Integer.parseInt(n.substring(1)));
				break;
			default:
				c=Utility.translateDigitInText(d2)+pref+Utility.translateDecInText(Integer.parseInt(n.substring(1)));
				break;
				
		}
		return c;
	}
	
	public static String translateInText(Integer num){
		String text = "";
		if (num<10)
			text= Utility.translateDigitInText(num);
		else if (num<100){
			text = Utility.translateDecInText(num);
		}else if (num<1000){
			text = Utility.translateCentoInText(num);
		}else if (num<10000){
			text = Utility.translateMilleInText(num);
		}else{
			text = "undef";
		}
		
		
		return text;
	}
	
	public static String translateDoubleInText(Double x){
		
		String w = x.toString();
		int n = w.indexOf('.');
		String[] els = new String[2];
		els[0] = w.substring(0,n);
		els[1] = w.substring(n+1);
		Integer a = Integer.valueOf(els[0]);
		Double y = Double.parseDouble("0."+els[1]);		
				
		//Double y = x-a;
		System.out.println("decimale vale " + y);
		
		String t = Utility.translateInText(a);
		String s = y.toString();
		if (s.length()>3)
			s=s.substring(2,4);
		else if (s.length()>2)
			s=s.substring(2,3)+"0";
		else
			s = "00";
		return t+"/"+s;
	}
	
	
	public static String html2pdf(String urlstring, String token){
		String pdf = null;
		URL url;
		 
		  try {
		   //----------------------- HTML CREATTION ------------------------
		   // get URL content
		   url = new URL(urlstring);
		   URLConnection conn = url.openConnection();
		 
		   // open the stream and put it into BufferedReader
		   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		   String inputLine;
		 
		   //save to this filename
		   String fileName = "/tmp/temp_html.html";
		   File file = new File(fileName);
		   if (!file.exists()) {
		    file.createNewFile();
		   }
		   //use FileWriter to write file
		   FileWriter fw = new FileWriter(file.getAbsoluteFile());
		   BufferedWriter bw = new BufferedWriter(fw);
		   while ((inputLine = br.readLine()) != null) {
		    bw.write(inputLine);
		    System.out.println(inputLine);
		   }
		   bw.close();
		   br.close();
		   System.out.println("Html Creation Done");
		   //----------------------- HTML CREATTION ------------------------
		   
		   //----------------------- HTML TO XML CREATTION ------------------------   
		   FileWriter fwOutXml =null;
		   FileReader frInHtml=null;
		   BufferedWriter bwOutXml =null;
		   BufferedReader brInHtml=null;
		   
		   frInHtml = new FileReader("/tmp/temp_html.html");
		      brInHtml = new BufferedReader(frInHtml);
		      SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
		      org.jdom.Document jdomDocument = saxBuilder.build(brInHtml);
		      XMLOutputter outputter = new XMLOutputter();
		   
		      outputter.output(jdomDocument, System.out);
		         fwOutXml = new FileWriter("/tmp/temp_xml.xml");
		         bwOutXml = new BufferedWriter(fwOutXml);
		         outputter.output(jdomDocument, bwOutXml);
		         System.out.flush();
		         System.out.println("XML Creation Done");

		         fwOutXml.flush();
		         fwOutXml.close();
		         bwOutXml.close();
		           //----------------------- HTML TO XML CREATTION ------------------------   
		       
		         //----------------------- XML TO PDF CREATTION ------------------------   
		         Document document = new Document();
		            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/tmp/pdf.pdf"));
		         document.open();
		         XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("/tmp/temp_xml.xml"));
		         document.close();
		         System.out.println( "PDF Created Successfully" );
		         //----------------------- XML TO PDF CREATTION ------------------------ 
		         
		         File html_temp_file = new File("/tmp/temp_html.html");
		         File xml_temp_file = new File("/tmp/temp_xml.xml");
		         //xml_temp_file.delete();
		         //html_temp_file.delete();
		         System.out.println("Both Files Deleted Successfully");
		         pdf = "/tmp/pdf.pdf";
		  } catch (Exception e) {
		   e.printStackTrace();
		   pdf = "KO";
		  } 
		
		return pdf;
		
	}
	
	
	public static String updateEuro(String xml){
		String outxml = null;
		try{
			while (xml.indexOf("<euro>")>0){
				int a = xml.indexOf("<euro>");
				int b = xml.indexOf("</euro>");
				xml = xml.substring(0,a)+"&euro;"+xml.substring(b+7);
			}
			outxml = xml;
		}
		catch (Exception E){
			E.printStackTrace();
		}
		return outxml;
		
	}
	
	public static String htmlText2pdf(String text, String fn){
		String pdf = null;
		  try {
		   StringReader frInHtml=null;
		   BufferedReader brInHtml=null;
		   logger.debug(text);
		   FileInputStream css = new FileInputStream(new File("/var/lib/tomcat7/webapps/ronco/css/style.css"));
		 
		   //frInHtml = new StringReader(text);
		     // brInHtml = new BufferedReader(frInHtml);
		      SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
		      org.jdom.Document jdomDocument = saxBuilder.build(new BufferedReader(new StringReader(text)));
		      XMLOutputter outputter = new XMLOutputter();
		      String xml = outputter.outputString(jdomDocument);
		      
		      //outputter.output(jdomDocument, System.out);
		         //outputter.output(jdomDocument, bwOutXml);
		         //System.out.flush();
		         logger.debug("XML Creation Done: "+xml);
		        
           //----------------------- HTML TO XML CREATTION ------------------------   
		       
		         //----------------------- XML TO PDF CREATTION ------------------------   
		         Document document = new Document(PageSize.A4_LANDSCAPE);
		            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/tmp/"+fn));
		         document.open();
		         document.addAuthor("Ronco");
			      document.addCreator("Ronco");
			      document.addSubject("Ronco Ricevuta");
			      document.addCreationDate();
			      document.addTitle("Ricevuta");

		         XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
		         //HTMLWorker htmlWorker = new HTMLWorker(document);
		         //htmlWorker.parse(new StringReader(text));
		         worker.parseXHtml(writer, document, new StringReader(xml));
		       
		         document.close();
		         /*
		         XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
		         worker.parseXHtml(writer, document, new ByteArrayInputStream(xml.getBytes()));
		         document.close();
		         logger.debug( "PDF Created Successfully" );
		         //----------------------- XML TO PDF CREATTION ------------------------ 
		         //xml_temp_file.delete();
		         //html_temp_file.delete();
		          * 
		          */
		         pdf = "/tmp/"+fn;
		  } catch (Exception e) {
		   e.printStackTrace();
		   pdf = "KO";
		  } 
		
		return pdf;
		
	}
	
	
	public static String html2pdfNew(String urlstring, String token){
		String pdf = null;
		URL url;
		 
		  try {
		   //----------------------- HTML CREATTION ------------------------
		   // get URL content
		   url = new URL(urlstring);
		   URLConnection conn = url.openConnection();
		 
		   // open the stream and put it into BufferedReader
		   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		   	
		   XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
		     Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/tmp/pdf.pdf"));
	         document.open();
	    
		   worker.parseXHtml(writer, document, br);
		      document.close();
		      pdf = "/tmp/pdf.pdf";
		   		  } catch (Exception e) {
		   e.printStackTrace();
		   pdf = "KO";
		  } 
		
		return pdf;
		
	}
	
	
	public static void main (String[] args){
		//Double x = 130.00;
		String s = "Niccol Bonucchi";
		try{
			String ns = Utility.cleanString(s);
			System.out.println("testo: "+ns);
			s="Niccol Bonucchi";
			ns = Utility.cleanString(s);
			System.out.println("testo: "+ns);
			s="Niccol Bonucchi";
			ns = Utility.cleanString(s);
			System.out.println("testo: "+ns);
			s="Niccol Bonucchi";
			ns = Utility.cleanString(s);
			System.out.println("testo: "+ns);
			s="Niccol Bonucchi";
			ns = Utility.cleanString(s);
			System.out.println("testo: "+ns);
			
			/*
			String dest=MAIL.getString("mail.dest.list");
			ArrayList<String> dests = new ArrayList<String>();
			String[] destEls = dest.split(",");
			if (destEls!=null){
				for (String x: destEls)
					dests.add(x);
			}
			//dests.add("mohsen.borumand@tiscali.it");
			dests.add("pg@cremonese.org");
			String from = Utility.getSender(dests, "mail.fattura.sender");
			System.out.println("from = "+from);
			*/
			/*
			File f = new File("ugo");
			FileInputStream fin = new FileInputStream(f);
			int c;
			StringBuffer sb = new StringBuffer();
			while ((c = fin.read())!=-1){
				char p = (char)c;
				if (p == '"')
					p='\'';
				sb.append(p);
			}
			String txt = sb.toString();
			System.out.println("testo: "+txt);
			txt = Utility.updateEuro(txt);
			
			
			String html = "<html><head></head><body>"+
			        "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
			        "<h1>Show your support</h1>" +
			        "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
			        "in personal hardware and software costs to set up test environments, and above all," +
			        "the huge amounts of time it takes for one person to design and write the actual content.</p>" +
			        "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?</p>" +
			        "<p>Donate using PayPal to real@rgagnon.com.</p>" +
			        "<p>Contributions via PayPal are accepted in any amount</p>" +
			        "<P><br/><table border='1'><tr><td>Java HowTo</td></tr><tr>" +
			        "<td style='background-color:red;'>Javascript HowTo</td></tr>" +
			        "<tr><td>Powerbuilder HowTo</td></tr></table></p>" +
			        "</body></html>";
			System.out.println("testo: "+txt);
			*/
			//String pdf = Utility.htmlText2pdf(txt, "txt.pdf");
			//System.out.println("esito: "+pdf);
		}
		catch (Exception E){
			E.printStackTrace();
		}
		//System.out.println(Utility.translateDoubleInText(x));
		//String url = "http://localhost:8080/ronco/informazioni";
		//String url = "http://www.cisco.com";
		//String pdf = Utility.html2pdf(url, null);
		//System.out.println("esito: "+pdf);
	}
	
	
	public static String cleanString(String s){
		
		String ns = "";
		StringBuffer sb = new StringBuffer();
		if (s!=null){
		for (int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if (c<=122){
				sb.append(c);
			}else{
				int n = c;
				logger.debug("carattere strano in "+s+" "+c+ " valore: " +n);
				switch (c){
					case 130:
						sb.append("e'");
						break;
					case 133:
						sb.append("a'");
						break;
					case 138:
						sb.append("e'");
						break;
					case 141:
						sb.append("i'");
						break;
					case 149:
						sb.append("o'");
						break;
					case 151:
						sb.append("u'");
						break;
					case 160:
						sb.append("a'");
						break;
					case 161:
						sb.append("i'");
						break;
					case 162:
						sb.append("o'");
						break;
					case 163:
						sb.append("u'");
						break;
					case 242:
						sb.append("o'");
						break;
					case 224:
						sb.append("a'");
						break;
					case 232:
						sb.append("e'");
						break;
					case 233:
						sb.append("e'");
						break;
						
					case 249:
						sb.append("u'");
						break;
					default:
						sb.append(" ");
						break;
				}
			}
		}
		ns = sb.toString();
		}
		return ns;
	}
	public static Ragazzi getElement(Ragazzi o, Collection<Ragazzi> list){
		
		Ragazzi bo = null;
		Iterator<Ragazzi> iter = list.iterator();
		while (iter.hasNext()&&bo==null){
			bo = iter.next();
			if (o.getOid()!=bo.getOid())
				bo=null;
		}
		return bo;
		
	}
	
	
	public static Boolean contains(Integer id, Integer[] list){
		Boolean ok = false;
		if (list!=null){
			int i=0;
			while (i<list.length&&!ok){
				ok = id.equals(list[i]);
				i++;
			}
		}
		return ok;
	}
	
	
	
	public static String getSender(ArrayList<String>dests, String key){
		String from = MAIL.getString(key);
		Boolean ok = true;
		String rejected = MAIL.getString("mail.rejected.domains");
		String[] rejectedList = rejected.split(";");
		
		int j=0;
		while (j<dests.size()&&ok){
			String x = dests.get(j);
			System.out.println("indirizzo destinatario: " + x);
			int i=0;
			while (i<rejectedList.length&&ok){
				System.out.println("confronton con rejected: " + rejectedList[i]);
				if (x.endsWith(rejectedList[i]))
					ok=false;
				else
					i++;
			}
			j++;
		}	
		if (!ok)
			from = MAIL.getString(key+".alternate");
		
		return from;
	}
}