package it.crem.server.actions;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import antlr.collections.List;
import it.crem.common.Utility;
import it.crem.db.conf.Documenti;
import it.crem.db.mng.DbMngExt;

public class UploadDocAction extends RoncoAction{
	
	
	private File fileUpload = null;
	private Integer anno = null;
	private String tipo = null;
	private String keywords = null;
	private String nome = null;
	private String fileName = null;
	private String descrizione = null;
	private Logger logger = Logger.getLogger(this.getClass());
	private Integer oid = null;
	private DbMngExt db = new DbMngExt();
	private ArrayList<Documenti> list = null;
	private String esito = null;
	private String op = "new";
	private String[] keytype = null;
	private Documenti doc = null;
	
	public String showList(){
		ArrayList<Object> lista = null;
		if (anno != null){
			lista = (ArrayList<Object>) db.getListObject("Documenti", "anno", anno);
			
			
		}else{
			lista = (ArrayList<Object>) db.getListObject("Documenti", (String)null, (String)null);
			
			
		}
		if (lista!=null){
			list = new ArrayList<Documenti>();
			for (Object o: lista){
				list.add((Documenti)o);
			}
		}
		
		return SUCCESS;
	}
	
	public String showForm(){
		// doc = null;
		keytype=Utility.RONCO.getString("ronco.doc.keywords").split(",");
		if (oid!=null){
			op="upd";
			doc = (Documenti)db.getObject(oid, "Documenti");
			nome = doc.getNome();
			anno = doc.getAnno();
			tipo = doc.getTipo();
			keywords = doc.getKeywords();
			descrizione = doc.getDescrizione();
			fileName = doc.getPath();
		}else{
			op="new";
			nome = "";
			anno = Integer.parseInt(Utility.getAnno(Calendar.getInstance().getTime()));
			tipo = "";
			keywords = "";
			descrizione = "";
			fileName = "";
		}
		
		return SUCCESS;
	}
	
	
	public String updDoc(){
		
		Documenti doc = (Documenti)db.getObject(oid, "Documenti");
		op="upd";
		if (doc!=null){
			doc.setKeywords(keywords);
			doc.setTipo(tipo);
			doc.setNome(nome);
			doc.setDescrizione(descrizione);
			doc.setAnno(anno);
			if (fileUpload!=null){
				try {
					String url = doc.getUrl();
					String fn = "";
					String mime = Files.probeContentType(fileUpload.toPath());
					String ext = "";
					if ((mime != null)&&(!"".equals(mime))){
						if (mime.contains("/"))
							ext = mime.substring(mime.indexOf('/')+1);
							if ("msword".equals(ext)){
								ext = "doc";
							}
			    	   
					}
					if (fileName==null){
						fileName = Utility.sdftpar.format(Calendar.getInstance().getTime())+"-"+fileUpload.getName();
					}else{
						fileName=fileName+"."+ext;
					}
					doc.setMime(mime);
					String path = Utility.RONCO.getString("ronco.area.documenti");
					//fn = fn+"."+ext;
					String filePath = path+"/"+fileName;
					doc.setNome(nome);
					logger.debug("salvo il file in : "+filePath);
			        File f = new File(filePath);
			        FileUtils.copyFile(fileUpload, f);
			        byte[] data = FileUtils.readFileToByteArray(f);
			        filePath = f.getPath();
			        doc.setPath(filePath);
			        url = url+filePath+"&mimetype="+mime;
			        doc.setUrl(url);
			        	
				}
			
				catch (Exception E){
					E.printStackTrace();
				}
			}
		}
		return SUCCESS;
		
	}	
	
	
	public String uploadDoc(){
		
		if (("upd".equals(op))||(oid!=null))
			return updDoc();
		
		logger.debug("caricamento nuovo doc");
		Documenti doc = new Documenti(); 
		doc.setAnno(anno);
		doc.setTipo(tipo);
		doc.setKeywords(keywords);
		String url = "download?file=";
		logger.debug("caricamento nuovo doc: anno"+anno+" tipo="+tipo+" keywords="+keywords+" nome="+fileName);
		
		try{
			String fn = "";
			String mime = Files.probeContentType(fileUpload.toPath());
			String ext = "";
			if ((mime != null)&&(!"".equals(mime))){
				if (mime.contains("/"))
					ext = mime.substring(mime.indexOf('/')+1);
					if ("msword".equals(ext)){
						ext = "doc";
					}
	    	   
			}
			if (fileName==null){
				fileName = Utility.sdftpar.format(Calendar.getInstance().getTime())+"-"+fileUpload.getName();
			}else{
				fileName=fileName+"."+ext;
			}
			doc.setMime(mime);
			String path = Utility.RONCO.getString("ronco.area.documenti");
			//fn = fn+"."+ext;
			String filePath = path+"/"+fileName;
			doc.setNome(nome);
			logger.debug("salvo il file in : "+filePath);
	        File f = new File(filePath);
	        FileUtils.copyFile(fileUpload, f);
	        byte[] data = FileUtils.readFileToByteArray(f);
	        filePath = f.getPath();
	        doc.setPath(filePath);
	        url = url+filePath+"&mimetype="+mime;
	        doc.setUrl(url);
	        doc.setDescrizione(descrizione);
	        doc.setImage(data);
	        oid = db.insertObject(doc);
	        logger.debug("salvato il file  "+filePath + " oid= "+oid);
	        esito = "successo";
		//File f = new File(path+"/"+fn);
		}
		catch (Exception E){
			E.printStackTrace();
			logger.error(E.getMessage());
			esito = "fallimento";
		}
		
		return SUCCESS;
	}
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public ArrayList<Documenti> getList() {
		return list;
	}

	public void setList(ArrayList<Documenti> list) {
		this.list = list;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String[] getKeytype() {
		return keytype;
	}

	public void setKeytype(String[] keytype) {
		this.keytype = keytype;
	}

	public Documenti getDoc() {
		return doc;
	}

	public void setDoc(Documenti doc) {
		this.doc = doc;
	}
	
	
	

}
