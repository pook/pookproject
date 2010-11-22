package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class CheckDisplayName extends ActionSupport {

	
	private static final long serialVersionUID = 818911213537613837L;
	public String execute(){
		
		return SUCCESS;
	}
}
