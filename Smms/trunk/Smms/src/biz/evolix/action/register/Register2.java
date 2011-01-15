package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.RegisterService;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
public class Register2 extends ActionSupport{

	
	@Action(value = "/save2", results = {
			@Result(location = "echo/error.jsp", name = "error"),
			@Result(location = "echo/redirect.jsp", name = "success") })
	public String execute() throws Exception {
		return save();
	}
	private String save(){
		boolean test = true;
		test= test && getUpline().trim().length()>0;
		test= test && getDisplayName().trim().length()>0;
		if(test){
			registerService.save(getUpline(), getDisplayName());
		}else{
			return ERROR;
		}
		return SUCCESS;
	}
	
	private static final long serialVersionUID = 4402132984028131747L;
	private String displayName;
	private String upline;
	private RegisterService registerService;
	public Register2(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUpline() {
		return upline;
	}
	public void setUpline(String upline) {
		this.upline = upline;
	}
	

}
