package biz.evolix.action.index;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.News;
import biz.evolix.model.dao.NewsDAO;

import com.opensymphony.xwork2.ActionSupport;

public class SaveNoticeAct extends ActionSupport{

	private static Logger log = Logger.getLogger(SaveNoticeAct.class);
	private static final long serialVersionUID = -7791839109490937842L;
	@Action(value = "/save-notice-member", results = { @Result(name = "success", location = "index.jsp") })
	public String execute() {
		News news = newsDAO.loadNotice();
		news.setContent(getNotice());
		newsDAO.saveNotice(news);
		return SUCCESS;
	}	
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getNotice() {
		return notice;
	}
	private String notice;
	private NewsDAO newsDAO;
	public SaveNoticeAct(NewsDAO newsDAO) {
		super();
		this.newsDAO = newsDAO;
	}
	
}
