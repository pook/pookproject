package biz.evolix.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.dao.NewsDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ActivityAct extends ActionSupport {

	private static final long serialVersionUID = -8020285958469699339L;
	@Action(value = "/activity", results = { @Result(name = "success", location = "echo/echo.jsp") })
	public String execute() {
		setEcho(newsDAO.loadActivity().getContent());
		return SUCCESS;
	}	
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public String getEcho() {
		return echo;
	}
	private String echo;
	private NewsDAO newsDAO;
	public ActivityAct(NewsDAO newsDAO) {
		super();
		this.newsDAO = newsDAO;
	}
}
