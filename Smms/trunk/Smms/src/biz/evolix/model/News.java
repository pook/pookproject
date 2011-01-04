package biz.evolix.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "NEWS")
public class News implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	public News() {
		super();
	}
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	public String getNewsId() {
		return newsId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	@Id
	@Column(name = "NEWS_ID",columnDefinition="CHAR(10)")
	private String newsId;
	@Column(name = "CONTENT",columnDefinition="TEXT(500)")
	private String content;   
}
