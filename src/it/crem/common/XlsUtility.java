package it.crem.common;

import org.apache.log4j.Logger;

import it.crem.server.beans.Scheda;
import jxl.CellFormat;
import jxl.CellView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class XlsUtility {
	  private static Logger logger = Logger.getLogger(XlsUtility.class);
	        
	
	public static String getXls(ArrayList<Scheda> schede, String path, String fn){
		//String fn="";
		//String path = "";
		String ofn = path+"/"+fn;
		try{
		if ((schede!=null)&&(schede.size()>0)){
			
				WritableWorkbook workbook = Workbook.createWorkbook(new File(ofn));
				 WritableSheet sheet = workbook.createSheet("Quadro", 0);
				 Label label = new Label(0, 0,  "Cognome");
                 sheet.addCell(label);
            
				  label = new Label(1, 0,  "Nome");
                     sheet.addCell(label);
                      label = new Label(2, 0,  "Periodi");
                     sheet.addCell(label);
                     label = new Label(3, 0,  "Costo Totale");
                     sheet.addCell(label);
                     label = new Label(4, 0,  "Dovuto");
                     sheet.addCell(label);
                   
                     label = new Label(5, 0,  "Pagato");
                     sheet.addCell(label);
                     label = new Label(6, 0,  "Resto");
                     sheet.addCell(label);
                     label = new Label(7, 0,  "Sconto");
                     sheet.addCell(label);
                     label = new Label(8, 0,  "Info");
                     sheet.addCell(label);
                     NumberFormat currency = new NumberFormat(NumberFormat.CURRENCY_EURO_PREFIX);
                     WritableCellFormat wcf = new WritableCellFormat(currency);
                	 
                     for (int i=0;i<schede.size();i++){
                    	 int r=i+1;
                    	 String cognome = schede.get(i).getRagazzo().getCognome(); 
                    	 Label currLabel = new Label(0,r,cognome);
                    	 sheet.addCell(currLabel);;
                    	 String nome = schede.get(i).getRagazzo().getNome(); 
                    	 
                    	 currLabel = new Label(1,r,nome);
                    	 sheet.addCell(currLabel);;
                    	 
                    	 
                    	 int np = 0;
                    	 if (schede.get(i).getNumeroPeriodi()!=null)
                    		 np = schede.get(i).getNumeroPeriodi();
                    	 
                    	 currLabel = new Label(2,r,schede.get(i).getNumeroPeriodi()+"");
                    	 sheet.addCell(currLabel);;
                    	 Double d = schede.get(i).getDovutoNoSconto();
                    	 if (d==null)
                    		 d=0.0;
                    	 String sd = d+"";
                    	 //String sd=String.format("%5.2f", d);
                    	 sd=sd.replace(".",",");
                    	 Number cn = new Number(3,r,d,wcf);
                    	 sheet.addCell(cn);;
                    	  d = schede.get(i).getDovutoSconto();
                    	 if (d==null)
                    		 d=0.0;
                    	 cn=new Number(4,r,d,wcf);
                    	// currLabel = new Label(3,r,d+"");
                    	 sheet.addCell(cn);;
                    	
                    	 d=schede.get(i).getPagato();
                    	 if (d==null)
                    		 d=0.0;
                    	 cn=new Number(5,r,d,wcf);
                     	
                    	 //currLabel = new Label(4,r,d+"");
                    	 sheet.addCell(cn);;
                    	 d=schede.get(i).getResto();
                    	 if (d==null)
                    		 d=0.0;
                    	 //currLabel = new Label(5,r,d+"");
                    	 cn=new Number(6,r,d,wcf);
                      	
                    	 sheet.addCell(cn);;
                    	 d = schede.get(i).getSconto();
                    	 if (d==null)
                    		 d=0.0;
                    	
                    	// currLabel = new Label(6,r,d+"");
                    	 cn=new Number(7,r,d,wcf);
                    	 
                    	 sheet.addCell(cn);;
                    	 currLabel = new Label(8,r,schede.get(i).getInfo());
                    	 sheet.addCell(currLabel);;
                    	 
                    	 
                    	 
                     }
                     
                    workbook.write();
                    workbook.close();
             }else{
     			logger.debug("schede vuote: dove sono?");
     		}

		}
				
			
		catch (Exception E){
				E.printStackTrace();
				ofn=null;
		}
		
		
		return ofn;
				
		
	}

	
	public static String getXls(ArrayList<String> header, ArrayList<HashMap<String,Object>> values,String path, String fn){
		//String fn="";
		//String path = "";
		String ofn = path+"/"+fn;
		try{
		if ((header!=null)&&(header.size()>0)){
			
				WritableWorkbook workbook = Workbook.createWorkbook(new File(ofn));
				 WritableSheet sheet = workbook.createSheet("Quadro", 0);
				 for (int i=0;i<header.size();i++){
					 Label label = new Label(i, 0,  header.get(i));
                     sheet.addCell(label);
                 	 
				 }
				     
                     NumberFormat currency = new NumberFormat(NumberFormat.CURRENCY_EURO_PREFIX);
                     WritableCellFormat wcf = new WritableCellFormat(currency);
                     
                     for (int i=0;i<values.size();i++){
                    	 HashMap<String,Object> map = values.get(i);
                    	 for (int j=0;j<header.size();j++){
                    		 int r=i+1;
                    		 String v = "";
                    		 if (map.containsKey(header.get(j)))
                    			 v = (String) map.get(header.get(j));
                    		 Label currLabel = new Label(j,r,v);
                    		 sheet.addCell(currLabel);;
                    	 }
                   	}
                    workbook.write();
                    workbook.close();
             }

		}
				
			
		catch (Exception E){
				E.printStackTrace();
				ofn=null;
		}
		
		
		return ofn;
				
		
	}
	public static String getTypedXls(ArrayList<Field> header, ArrayList<HashMap<String,Object>> values,String path, String fn){
		//String fn="";
		//String path = "";
		String ofn = path+"/"+fn;
		try{
			NumberFormat currency = new NumberFormat(NumberFormat.CURRENCY_EURO_PREFIX);
            WritableCellFormat wcf = new WritableCellFormat(currency);
       	 
		if ((header!=null)&&(header.size()>0)){
			
				WritableWorkbook workbook = Workbook.createWorkbook(new File(ofn));
				 WritableSheet sheet = workbook.createSheet("Quadro", 0);
				 for (int i=0;i<header.size();i++){
					 Label label = new Label(i, 0,  header.get(i).getName());
                     sheet.addCell(label);
                 	 
				 }
				     
                     
                     
                     
                     for (int i=0;i<values.size();i++){
                    	 HashMap<String,Object> map = values.get(i);
                    	 for (int j=0;j<header.size();j++){
                    		 int r=i+1;
                    		 String v = "";
                    		 if (map.containsKey(header.get(j).getName()))
                    			 v = (String) map.get(header.get(j).getName());
                    		 if (header.get(j).getType().equalsIgnoreCase("number")){
                    			 v = v.replaceAll(",","");
                    			 try{
                    			 Double d = Double.parseDouble(v);
                    			 
                    			 Number cn = new Number(j,r,d,wcf);
                             	 sheet.addCell(cn);
                    			 }
                    			 catch (Exception E){
                    				 Label currLabel = new Label(j,r,v);
                        			 sheet.addCell(currLabel);;
                    			 }
                    		 }else{
                    			 Label currLabel = new Label(j,r,v);
                    			 sheet.addCell(currLabel);;
                    		 }
                    	 }
                   	}
                    workbook.write();
                    workbook.close();
             }

		}
				
			
		catch (Exception E){
				E.printStackTrace();
				ofn=null;
		}
		
		
		return ofn;
				
		
	}
	
	
}
