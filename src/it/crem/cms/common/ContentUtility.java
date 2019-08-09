package it.crem.cms.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import it.crem.db.conf.Blocchi;
import it.crem.db.conf.BloccoItem;
import it.crem.db.conf.Documenti;
import it.crem.db.conf.Periodi;
import it.crem.db.mng.DbMngExt;
import it.crem.server.beans.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import it.crem.common.Utility; 

public class ContentUtility {
	
	private DbMngExt  db = new DbMngExt();  
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	
	
	public HashMap<String,Documenti> getModuli(){
		Integer anno = Integer.parseInt(Utility.getAnno(Calendar.getInstance().getTime()));
		return getModuli(anno);
	}
	public HashMap<String,Documenti>  getModuli(Integer anno){
		
		HashMap<String,Documenti> docs = new HashMap<String,Documenti>();
		List<Object> list = db.getListObject("Documenti", "anno", anno);
		for (Object o: list){
			Documenti d = (Documenti)o;
			docs.put(d.getKeywords(), d);
			
		}
		return docs;
	}
	
	
	
	public String getHtmlModuli( HashMap<String,Documenti> docs){
		String html = "<ul>";
		
		if (docs.containsKey("iscrizione")){
			html = html + "<li> Modulo di iscrizione con la liberatoria per la privacy:";
			html = html + "<a href=\""+docs.get("iscrizione").getUrl()+"\"><input type=\"button\" value=\"Scarica Modulo Iscrizione\" name=\"scarica\"/></a></li>";
		}
		if (docs.containsKey("liberatoria")){
			html = html + "<li> Informativa trattamento dati personali:";
			html = html + "<a href=\""+docs.get("liberatoria").getUrl()+"\"><input type=\"button\" value=\"Scarica Informativa\" name=\"scarica\"/></a></li>";
		}
		if (docs.containsKey("vaccinazioni")){
			html = html + "<li> Modulo relativo alla copertura sanitaria (vaccinazioni):";
			html = html + "<a href=\""+docs.get("vaccinazioni").getUrl()+"\"><input type=\"button\" value=\"Scarica Modulo\" name=\"scarica\"/></a></li>";
		}
		html = html + "</ul>";
		return html;
		
	}
	
	
	public  PageInfo getAppInfo(String name, Integer oid, String divId){
		 
		PageInfo info = new PageInfo();
		JSONObject json = new JSONObject();
		JSONArray jsonList = new JSONArray();
		JSONObject jin = new JSONObject();
		Date now = Calendar.getInstance().getTime();
		String anno = Utility.getAnno(now);
		Blocchi b = null;
		String code = "";
		logger.debug("devo fare il blocco di di tipo : "+name);
		switch (name){
		case "info-mod":
			HashMap<String,Documenti> docs= getModuli();
			for (String k : docs.keySet()){
				JSONObject jinInfo = new JSONObject();
				String key = "modulo-"+k;
				jinInfo.put("href", docs.get(k).getUrl());
				json.put(key, jinInfo);
				JSONObject jinInfo2 = new JSONObject();
				
				jinInfo2.put("disabled", false);
				key = "button-"+key;
				json.put(key,jinInfo2);
			}
			//json.put("moduli", jin);
			b =  (Blocchi)db.getObject(oid,"Blocchi");	
			//info.setContent(getHtmlModuli(docs));
			info.setContent(b.getInfo());
			code = "var infomod="+json.toString()+";\n updateAttributes(infomod);";
			info.setCode(code);
			break;
		case "home-per":
			Integer annoIntero = Integer.parseInt(anno);
			Integer annoInizio = annoIntero-6;
			Integer annoFine = annoIntero-14;
			json.put("inizio", annoInizio);
			json.put("fine", annoFine);
			b =  (Blocchi)db.getObject(oid,"Blocchi");		
			List periodi = db.getListObjectOrdered("Periodi", "anno", anno, "ordine");
			if (periodi!=null){
				for (int i=0;i<periodi.size();i++){
					Periodi p = (Periodi)periodi.get(i);
					String e = "";
					String gi = Utility.getGiorno(p.getInizio());
					String mi = Utility.getMese(p.getInizio());
					String ge = Utility.getGiorno(p.getFine());
					String me = Utility.getMese(p.getFine());
					if (mi.equals(me)){
						e = p.getOrdine() + " Settimana: "+gi+"-"+ge +" "+ me;
					}else{
						e = p.getOrdine() + " Settimana: "+gi+" " + mi+"-"+ge +" "+ me;
					}
					jsonList.add(e);
					
				}
			}
			json.put("periodi", jsonList);
			logger.debug("jsondata = "+json.toString());
			code = "var infoper="+json.toString()+";\n updateInfo(infoper);";
			info.setCode(code);
			info.setContent(b.getInfo());
			break;
		case "footer-blk":
			HashMap<String,Object> par = new HashMap<String,Object>();
			par.put("anno", Integer.parseInt(anno));
			par.put("keywords", "liberatoria");
			List documenti = db.getList("Documenti", par);
			
			if ((documenti!=null)&&(documenti.size()>0)){
				Documenti d = (Documenti)documenti.get(0);
				jin.put("href", d.getUrl());
			}
			json.put("liberatoria-footer", jin);
			b =  (Blocchi)db.getObject(
					oid,"Blocchi");
			logger.debug("jsondata = "+json.toString());
			code = "var infofooter="+json.toString()+";\n updateAttributes(infofooter);";
			info.setCode(code);
			info.setContent(b.getInfo());
			break;			
		case "slider-app":
			String[] lista = null;
			b =  (Blocchi)db.getObject(oid,"Blocchi");
			String  cnt = b.getInfo();
			if (b.getItems()!=null){
				for (BloccoItem bi: b.getItems()){
					JSONObject foto = new JSONObject();
					foto.put("src",bi.getInfo());
					if (bi.getWidth()!=null&&bi.getWidth()>0)
						foto.put("width",bi.getWidth());
					if (bi.getHeight()!=null&&bi.getHeight()>0)
						foto.put("height",bi.getHeight());
					jsonList.add(foto);
				}
				
				
				
			}
			json.put("images", jsonList);
			code = "var info="+json.toString()+";\n updImage(info);\n refreshId('link-iscr');\n setInterval(function(){updImage(info);refreshId('link-iscr');},5000);";
			info.setCode(code);
			break;
		case "slider-app-bg":
			logger.debug("caso di slider su background");
			String[] mylista = null;
			b =  (Blocchi)db.getObject(oid,"Blocchi");
			String  mycnt = b.getInfo();
			if (b.getItems()!=null){
				for (BloccoItem bi: b.getItems()){
					JSONObject foto = new JSONObject();
					foto.put("src",bi.getInfo());
					if (bi.getWidth()!=null&&bi.getWidth()>0)
						foto.put("width",bi.getWidth());
					if (bi.getHeight()!=null&&bi.getHeight()>0)
						foto.put("height",bi.getHeight());
					jsonList.add(foto);
				}
				
				
				
			}
			json.put("images", jsonList);
			code = "var info="+json.toString()+";\n updBgImage('"+divId+"',info);\n setInterval(function(){updBgImage('"+divId+"',info);},5000);";
			info.setCode(code);
			break;
		case "modulistica":
			 Integer curranno = Integer.parseInt(Utility.getAnno(Calendar.getInstance().getTime()));
			
			docs= getModuli(curranno);
			//jsonList = new JSONArray();
			for (String k : docs.keySet()){
				JSONObject jinInfo = new JSONObject();
				String key = "modulo-"+k;
				jinInfo.put("href", docs.get(k).getUrl());
				jinInfo.put("info", docs.get(k).getDescrizione());
				jinInfo.put("tag", docs.get(k).getNome());
				jinInfo.put("disabled",false);
				
				jsonList.add(jinInfo);
				/*
				JSONObject jinInfo2 = new JSONObject();
				
				jinInfo2.put("disabled", false);
				key = "button-"+key;
				json.put(key,jinInfo2);
				*/
			}
			json.put("lista-moduli", jsonList);
			json.put("anno", curranno);
			//json.put("moduli", jin);
			b =  (Blocchi)db.getObject(oid,"Blocchi");	
			//info.setContent(getHtmlModuli(docs));
			info.setContent(b.getInfo());
			code = "var infomod="+json.toString()+";\n updateInfoItemList(infomod);";
			info.setCode(code);
			break;
		case "default":
			break;
		}
		return info;
	}

}
