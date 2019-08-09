package it.crem.server.actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import it.ash.mail.SendMail;
import it.crem.common.Utility;
import it.crem.db.conf.Documenti;
import it.crem.db.conf.Periodi;
import it.crem.db.conf.Ragazzi;
import it.crem.db.mng.DbMng;
import it.crem.db.mng.DbMngExt;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class Informazioni extends RoncoAction implements
ServletRequestAware,ServletResponseAware  {
	private static Logger logger = Logger.getLogger(Utility.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Integer anno = null;
	private List oidList = null;
	private List<Integer> anni = null;
	private HashMap<Integer,List> quadro = null;
	private List documenti = null;
	
	public String show(){
		String msgOut = SUCCESS;
		quadro = new HashMap<Integer,List>();
		DbMngExt db = new DbMngExt();
		anni = db.getAnniDocs();
		if (anni!=null)
		for (Integer a: anni){
			quadro.put(a, new ArrayList());
		}
		if (anno==null){
			Date now = Calendar.getInstance().getTime();
			anno = Integer.valueOf(Utility.getAnno(now));
		}
		documenti = db.getListObjectOrdered("Documenti", "anno", anno, "nome");
		quadro.put(anno, documenti);
		return msgOut;
	}
	
	public List<Integer> getAnni() {
		return anni;
	}

	public void setAnni(List<Integer> anni) {
		this.anni = anni;
	}

	public HashMap<Integer, List> getQuadro() {
		return quadro;
	}

	public void setQuadro(HashMap<Integer, List> quadro) {
		this.quadro = quadro;
	}

	public List getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List documenti) {
		this.documenti = documenti;
	}

	public List getOidList() {
		return oidList;
	}
	public void setOidList(List oidList) {
		this.oidList = oidList;
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
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
