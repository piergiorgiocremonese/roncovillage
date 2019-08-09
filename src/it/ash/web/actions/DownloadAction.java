package it.ash.web.actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import it.ash.graphical.ImageMng;
import it.crem.common.Utility;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport implements 
ServletRequestAware,ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Integer oid = null;
	private Logger logger = Logger.getLogger(this.getClass());
	private String url = null;
	private String file = null;
	private String message = "";
	private String mimetype = null;	
	
	public String execute(){
		String outMsg = SUCCESS;
		logger.debug("inizio download pdf");
		//String root = Utility.TICINO.getString("ticino.area.xml.root");
		//String file = root + url;
		String mime = "application/pdf";
		
		if (mimetype != null){
			mime = mimetype;
		}
		
		logger.debug("mimetype= " +mime);
		try{
			File myFile = new File(file);
			FileInputStream fis = new FileInputStream(new File(file));
			response.setContentType(mime);
			
			if (!mime.equals("application/pdf")){
				String name = myFile.getName();
				response.setHeader("Content-Disposition", "attachment; filename="+name);
			}
			ServletOutputStream out = response.getOutputStream();
			int c;
			StringBuffer sb = new StringBuffer();
			while ((c=fis.read())!=-1){
				//sb.append((char)c);
				out.write(c);
				
			}
			//out.write(sb.toString().getBytes());
			logger.debug(sb.toString());
			
			message = "Download effettuato";
		
		}
		catch (Exception E){
			logger.error("errore nel download:"+E.toString());
			E.printStackTrace();
			outMsg = "failure";
		}
		return null;
	}
	
	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String download(){
		String outMsg = SUCCESS;
		
		logger.debug("inizio download generico");
		//String root = Utility.TICINO.getString("ticino.area.xml.root");
		//String file = root + url;
		String mime = "application/octet-stream";
		if (mimetype != null){
			mime = mimetype;
		}
		
		try{
			
			FileInputStream fis = new FileInputStream(new File(file));
			response.setContentType(mime);
			response.setCharacterEncoding("UTF-8");
		
			ServletOutputStream out = response.getOutputStream();
			int c;
			//StringBuffer sb = new StringBuffer();
			while ((c=fis.read())!=-1){
				//sb.append((char)c);
				out.write(c);
			}
			//out.write(sb.toString().getBytes());
			//logger.debug(sb.toString());
			
			message = "Download effettuato";
		
		}
		catch (Exception E){
			logger.error("errore nel download"+E.toString());
			E.printStackTrace();
			
			outMsg = "failure";
		}
		return null;
	}
	
	
	public String showImage(){
		String outMsg = SUCCESS;
		logger.debug("inizio downloadin");
		//String root = Utility.TICINO.getString("ticino.area.xml.root");
		//String file = root + url;
		try{
			String mime = "";
			ImageMng imgMng = new ImageMng(file);
			imgMng.updStringType();
			String type = imgMng.getOutType();
			
			if  ("png".equals(type))
				mime = "image/png";
			else if  ("jpg".equals(type))
				mime = "image/jpeg";
			else if  ("gif".equals(type))
				mime = "image/gif";
			else
				mime = "application/octet-stream";
			FileInputStream fis = new FileInputStream(new File(file));
			response.setContentType(mime);
			response.setCharacterEncoding("UTF-8");
			ServletOutputStream out = response.getOutputStream();
			int c;
			//StringBuffer sb = new StringBuffer();
			while ((c=fis.read())!=-1){
				//sb.append((char)c);
				out.write(c);
			}
			//out.write(sb.toString().getBytes());
			//logger.debug(sb.toString());
			
			message = "Download effettuato";
		
		}
		catch (Exception E){
			logger.error("errore nel download"+E.toString());
			E.printStackTrace();
			
			outMsg = "failure";
		}
		return null;
	}
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}


	public HttpServletResponse  getServletResponse() {
		// TODO Auto-generated method stub
		return this.response;
	}

	public HttpServletRequest getServletRequest() {
		// TODO Auto-generated method stub
		return this.request;
	}

	
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
}