package biz.evolix.action.index;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.News;
import biz.evolix.model.dao.NewsDAO;

import com.opensymphony.xwork2.ActionSupport;

public class SaveActivityAct extends ActionSupport{

	private static Logger log = Logger.getLogger(SaveActivityAct.class);
	private static final long serialVersionUID = -4255236368852018548L;
	@Action(value = "/save-activity", results = { @Result(name = "success", location = "index.jsp") })
	public String execute() {
		News news = newsDAO.loadActivity();
		news.setContent(getActivity());
		newsDAO.saveActivity(news);
		return SUCCESS;
	}	
	private NewsDAO newsDAO;
	private String activity;
	public SaveActivityAct(NewsDAO newsDAO) {
		super();
		this.newsDAO = newsDAO;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getActivity() {
		return activity;
	}
	
	
}
