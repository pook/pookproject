package biz.evolix.action.register;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.sub.ChangePasswdService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class ChangePasswdAct extends ActionSupport {
	
	private String oldpassword;
	private String newpasswd;	
	private static final long serialVersionUID = 5112968657449123659L;
	private static Logger log = Logger.getLogger(ChangePasswdAct.class);
	@Action(value = "/changepasswd-member", results = {
			@Result(name = "success", location = "echo/success.jsp"),
			@Result(name = "error", location = "echo/error.jsp") })
	public String execute(){
		if(changePasswdService.checkPassword(getOldpassword())){
				changePasswdService.chgpw(getNewpasswd());
				addActionMessage("Success !!");
				return SUCCESS;
		}else{
			addActionError("error can't change password!!");
		}
		return ERROR;
	}	
	private ChangePasswdService  changePasswdService;
	public ChangePasswdAct(ChangePasswdService changePasswdService) {
		super();
		this.changePasswdService = changePasswdService;
	}
	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}
	public String getNewpasswd() {
		return newpasswd;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	
}
