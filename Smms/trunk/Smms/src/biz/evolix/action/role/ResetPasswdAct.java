package biz.evolix.action.role;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswdAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622495338803920907L;
	@Action(value = "/resetpasswd", results = {
			@Result(location = "smmsrole.jsp", name = "success"),
			@Result(location = "smmsrole.jsp", name = "input") })
	public String execute() throws Exception {
			
		return SUCCESS;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getRows() {
		return rows;
	}
	private String rows;
	
	
}
