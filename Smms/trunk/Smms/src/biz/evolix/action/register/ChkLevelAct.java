package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.RegisterService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class ChkLevelAct extends ActionSupport {
	
	private static final long serialVersionUID = 2573218985911513062L;

	@Action(value = "/check-level", results = {
			@Result(name = "success", location = "echo/success.jsp")
	})			
	public String execute(){
		if(registerService.checkLevel()){
			addActionMessage("ข้อมูลสมาชิกเต็ม 16 ชั้นแล้ว");
		}
		return SUCCESS;
	}
	private RegisterService registerService;

	public ChkLevelAct(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	
}
