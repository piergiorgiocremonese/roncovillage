package it.crem.server.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoncoAction  extends ActionSupport implements SessionAware{
	
	
	
	private Map session      = ActionContext.getContext().getSession();
     
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	public Map getSession(){
        return session;
	}
	
	
	public String execute(){
		return SUCCESS;
	}
	
	public boolean isPrivate(){
		return session.containsKey("LOGIN");
	}
	
	public String getUser(){
		String userName = null;
		if (session.containsKey("LOGIN")){
			userName = (String)session.get("LOGIN");
			if ("".equals(userName)){
				userName=null;
			}
		}
		return userName;
	}

}
