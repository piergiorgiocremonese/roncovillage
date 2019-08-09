package it.crem.server.actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;

import it.ash.graphical.Dimension;
import it.ash.graphical.ImageMng;
import it.crem.common.Utility;
import it.crem.db.conf.GruppiFoto;
import it.crem.db.mng.DbMng;
import it.crem.server.beans.Foto;

public class FotoAction extends RoncoAction{
	
	private Foto picture = null;
	private String op = null;
	private String anno = null;
	private List gruppi;
	private Integer oid = 0;
	private String[] files = null;
	private GruppiFoto gruppo = null;
	private String tipo = null;
	private String foto = "";
	private ArrayList<Foto> fotoList = null;
	private Logger logger = Logger.getLogger(this.getClass());
	private File[] fileUpload = null;
	private Integer gruppoOid = null;
	private String nomeGruppo = null;
	private File iconFile = null;
	private String nome = null;
	private String esito = null;
	private String html = null;
	
	private Integer dimensioneRiga = 5;
	private Integer dimensionePage = 5;
	
	private Foto getFoto(String fileName, GruppiFoto gruppo){
		Foto picture = null;
		try{
		String f = gruppo.getPath()+"/"+ gruppo.getCartella()+"/"+fileName;
		String url = gruppo.getUrl()+"/"+fileName;
		File cf = new File(f);
		
		picture = new Foto();
		picture.setUrl(url);
		picture.setFile(f);
		picture.setNome(fileName);
		logger.debug("leggo il file " +picture.getFile());
		BufferedImage bimg = ImageIO.read(new File(picture.getFile()));
		Integer width          = bimg.getWidth();
		Integer height         = bimg.getHeight();
		picture.setWidth(width);
		picture.setHeight(height);
		Double iconHeight = Double.parseDouble(Utility.RONCO.getString("ronco.img.icon.height"));
		Double iconWidth = width*iconHeight/height;
		picture.setIconheight(iconHeight);
		picture.setIconwidth(iconWidth);
		}
		catch (Exception E){
			E.printStackTrace();
			
		}
		return picture;
	}
	
	public String listSetOfFoto(){
		DbMng db = new DbMng();
		String msgOut = "fotolist";
		try{
				if (gruppoOid!=null){
					gruppo = (GruppiFoto)db.getObject(gruppoOid,"GruppiFoto");
					if (gruppo!=null){
						String path = gruppo.getPath();
						String filePath = path + "/"+gruppo.getCartella();
						File dir = new File(filePath);
						logger.debug("cerco files presenti in "+filePath);
						String[] list = dir.list();
						if (list!=null){
							logger.debug("Numero files presenti:" +list.length);
							
							fotoList = new ArrayList<Foto>();
							for (int i=0;i<list.length;i++){
								logger.debug("aggiungo a fotoList " +list[i]);
								Foto foto = this.getFoto(list[i],gruppo);
					//foto.setFile(filePath + "/"+list[i]);
					//foto.setUrl(gruppo.getUrl()+"/"+list[i]);
					//foto.setNome(list[i]);
								fotoList.add(foto);
					
							}
						}else{
							logger.debug("Esito ricerca files: NULL");
								
						}
					}
				}
			
		}
		catch (Exception E){
			E.printStackTrace();
			msgOut = "esito";
			esito = " erropre " + E.toString();
		}
		return msgOut;
	}
	
	
	public String addSetOfFoto(){
		
		DbMng db = new DbMng();
		String msgOut = "";
		Integer width = Integer.parseInt(Utility.RONCO.getString("ronco.img.width"));
		logger.debug("dimensione attesa: " +width);
		try{
			if (gruppoOid!=null){
				gruppo = (GruppiFoto)db.getObject(gruppoOid,"GruppiFoto");
				if (gruppo!=null){
					if (fileUpload!=null){
						msgOut="esito";
				
							logger.debug("sono presenti " + fileUpload.length + " foto");
							String path = gruppo.getPath();
							int numOfFoto = 0;
							for (int i=0;i<fileUpload.length;i++){
								ImageMng imgMng = new ImageMng(fileUpload[i].getAbsolutePath());
								imgMng.updStringType();
								String ext = imgMng.getOutType();
								String name = i+ "_"+fileUpload[i].getName();
								if (name.indexOf('.')>0){
									name = name.substring(0,name.lastIndexOf('.')-1);
									name = name + "." +ext;
								}
								String nf = path + "/"+gruppo.getCartella()+"/"+name;
								Dimension dim = imgMng.getDimension();
								logger.debug("dimensione = " + dim.getWidth()+","+dim.getHeight()+ " atteso " +width);
								if (dim.getWidth()>width){
									logger.debug("devo fare resizing da "+dim.getWidth() + " a  "+width);
									imgMng.updResizeByWidth(width);
									imgMng.resize(nf);
									logger.debug("resized in  "+nf);
										
								}else{
									logger.debug("dim ok save in "+nf);
										
									FileUtils.copyFile(fileUpload[i], new File(nf));
								}
								numOfFoto++;
								
							}
							esito = " caricate con successo "+numOfFoto + " foto";
						
					}else{
						msgOut = "foto";
					}
				}else{
						msgOut = "esito";
						esito = " Gruppo non trovato : impossibile caricare foto";
					}
				}else{
					esito = " Gruppo non specificato : impossibile caricare foto";
					msgOut = "esito";
				}
			
		}
		catch (Exception E){
			E.printStackTrace();
			esito = "Errore: " + E.getMessage();
			msgOut = "esito";
		}
		return msgOut;
	}
	
	
	
	public String updGruppo(){
		DbMng db = new DbMng();
		String msgOut = "gruppo";
		Boolean nuovo = false;
		if (anno==null){
			anno = Utility.getAnno(Calendar.getInstance().getTime());
		
		}
		if ((gruppoOid!=null)&&(gruppoOid>0)){
			gruppo = (GruppiFoto)db.getObject(gruppoOid, "GruppiFoto");
		}else{
			gruppo = new GruppiFoto();
			nuovo = true;
		
		}
		gruppo.setNome(nome);
		if (gruppo.getAnno()==null)
			gruppo.setAnno(anno);
		
		String path = Utility.RONCO.getString("ronco.area.gruppi.root");
		String uri = Utility.RONCO.getString("ronco.area.gruppi.uri.root");
		String iconPath = path;
		String iconUrl = uri;
		String cartella = nome.replaceAll(" ", "_");
		path = path + "/"+anno+"/foto";
		iconPath = iconPath + "/"+anno+"/etichette";
		File dir = new File(path);
		if (!dir.isDirectory()){
			dir.mkdirs();
		}
		dir = new File(iconPath);
		if (!dir.isDirectory()){
			dir.mkdirs();
		}
		
		uri = uri + "/"+anno+"/foto/"+nome;
		try{
		if (iconFile!=null){
			logger.debug("nuova icona");
			ImageMng imgMng = new ImageMng();
			imgMng.setSource(iconFile.getAbsolutePath());
			logger.debug("icona nel file: " + iconFile.getAbsolutePath());
			imgMng.inizialize();
			imgMng.updStringType();
			Integer iconWidth = Integer.parseInt(Utility.RONCO.getString("ronco.img.icon.width"));
			String iconName = cartella+"."+imgMng.getOutType();
			String target = iconPath+"/"+iconName;
			Dimension dim = imgMng.getDimension();
			logger.debug("dimensione immagine caricata: " + dim.getWidth()+","+dim.getHeight()+ " richiesta: "+iconWidth);
			if (iconWidth<dim.getWidth()){
				logger.debug("file rande: attuale " + imgMng.getWidth() + " resize " +iconWidth);
				imgMng.updResizeByWidth(iconWidth);
				imgMng.resize(target);
				
			}else{
				File f = new File (target);
					
				FileUtils.copyFile(iconFile, f);
			}
			iconUrl = iconUrl+"/"+anno+"/etichette/"+iconName;
			gruppo.setIcona(iconUrl);
			gruppo.setIconaPath(target);
			logger.debug("icona: " + iconUrl);
			  
		}else{
			logger.debug("icona non presente in input");
		}
		gruppo.setUrl(uri);
		
		String fotodir = path+"/"+cartella;
		File fdir = new File(fotodir)
				;
		if (!fdir.isDirectory()){
			fdir.mkdirs();
		}
		
		gruppo.setCartella(cartella);
		gruppo.setPath(path);
		if (nuovo){
			db.insertObject(gruppo);
		}else
			db.updObject(gruppo);
		}
		catch (Exception E){
			E.printStackTrace();
		}
		
		
		return msgOut;
	}
	
	public String showGruppo(){
		DbMng db = new DbMng();
		if (gruppoOid!=null){
			gruppo = (GruppiFoto)db.getObject(gruppoOid, "GruppiFoto");
		}else{
			gruppo = new GruppiFoto();
		}
		
		return "gruppo";
	}
	
	
	
	public String listaGruppi(){
		DbMng db = new DbMng();
		HashMap<String,String> pars = new HashMap<String,String>();
		if ((anno!=null)&&(!"".equals(anno)))
			pars.put("anno", anno);	
		else{
			anno = Utility.getAnno(Calendar.getInstance().getTime());
			pars.put("anno", anno);
		}
		gruppi = db.getListObject("GruppiFoto", pars);
		if (this.isPrivate()){
			if ("mng".equals(op))
				return "gallerymng";
			else{
				return SUCCESS;		
			}
		}else
			return SUCCESS;
	}
	
	public String showAlbum(){
		DbMng db = new DbMng();
		try{
			dimensioneRiga = Integer.parseInt(Utility.RONCO.getString("ronco.album.riga.dim"));
			dimensionePage = Integer.parseInt(Utility.RONCO.getString("ronco.album.page.dim"));
		}
		catch (Exception E){
			E.printStackTrace();
			dimensioneRiga=5;
			dimensionePage=5;
		}
		gruppo = (GruppiFoto)db.getObject(oid, "GruppiFoto");
		String rd = gruppo.getPath()+"/"+gruppo.getCartella();
		File dir = new File(gruppo.getPath()+"/"+gruppo.getCartella());
		files = dir.list();
		fotoList = new ArrayList<Foto>();
		if ((files!=null)&&(files.length>0)){
			
			for (int i=0;i<files.length;i++){
				String f = files[i];
				File cf = new File(f);
				String fn = cf.getName();
				files[i]=gruppo.getUrl()+"/"+fn;
				try{
					 Foto currPicture = this.getFoto(fn, gruppo);
					/*
					 * Foto picture = new Foto();
					
					picture.setUrl(files[i]);
					picture.setFile(rd + "/"+fn);
					logger.debug("leggo il file " +picture.getFile());
					BufferedImage bimg = ImageIO.read(new File(picture.getFile()));
					Integer width          = bimg.getWidth();
					Integer height         = bimg.getHeight();
					picture.setWidth(width);
					picture.setHeight(height);
					Double iconHeight = Double.parseDouble(Utility.RONCO.getString("rongo.img.icon.height"));
					Double iconWidth = width*iconHeight/height;
					picture.setIconheight(iconHeight);
					picture.setIconwidth(iconWidth);
					*/
					this.fotoList.add(currPicture);
					
				}
				catch (Exception E){
					E.printStackTrace();
					logger.error("errore: " + E.toString());
				}
			}
			foto = files[0];
			picture = fotoList.get(0);
		}
		
		return tipo;
	}
	
	
	
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public List getGruppi() {
		return gruppi;
	}
	public void setGruppi(List gruppi) {
		this.gruppi = gruppi;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public GruppiFoto getGruppo() {
		return gruppo;
	}

	public void setGruppo(GruppiFoto gruppo) {
		this.gruppo = gruppo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public ArrayList<Foto> getFotoList() {
		return fotoList;
	}

	public void setFotoList(ArrayList<Foto> fotoList) {
		this.fotoList = fotoList;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public File[] getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File[] fileUpload) {
		this.fileUpload = fileUpload;
	}

	public Integer getGruppoOid() {
		return gruppoOid;
	}

	public void setGruppoOid(Integer gruppoOid) {
		this.gruppoOid = gruppoOid;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}

	public File getIconFile() {
		return iconFile;
	}

	public void setIconFile(File iconFile) {
		this.iconFile = iconFile;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Integer getDimensioneRiga() {
		return dimensioneRiga;
	}

	public void setDimensioneRiga(Integer dimensioneRiga) {
		this.dimensioneRiga = dimensioneRiga;
	}

	public Integer getDimensionePage() {
		return dimensionePage;
	}

	public void setDimensionePage(Integer dimensionePage) {
		this.dimensionePage = dimensionePage;
	}

	public Foto getPicture() {
		return picture;
	}

	public void setPicture(Foto picture) {
		this.picture = picture;
	}

	
	
}
