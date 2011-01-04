package biz.evolix.action.index;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.dao.NewsDAO;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class NoticeAct extends ActionSupport{

	private static final long serialVersionUID = 7865499216846614032L;
	@Action(value = "/notice", results = { @Result(name = "success", location = "echo/echo.jsp") })
	public String execute() {
		setEcho(newsDAO.loadNotice().getContent());
		return SUCCESS;
	}	
	private String echo;
	private NewsDAO newsDAO;
	public NoticeAct(NewsDAO newsDAO) {
		super();
		this.newsDAO = newsDAO;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public String getEcho() {
		return echo;
	}
	
}
