package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.dao.CheckDNameDAO;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class CheckDisplayName extends ActionSupport {

	private String displayName;
	private Boolean test;
	private static final long serialVersionUID = 818911213537613837L;	

	@Action(value = "/check-displayname-member", results = {
			@Result(name = "success", location = "echo/checkeddisplayname.jsp"),
			@Result(name = "error", location = "echo/checkeddisplaynameErr.jsp") })
	public String execute() {		
		if(getDisplayName().length() < 3){
			addActionError("ข้อมูลที่กรอก ชื่อแสดงในสายงาน ควรมีระหว่าง 3 และ 30 ตัวอักษร");			
			setTest(false);
			return ERROR;
		}
		boolean b = checkNameDAO.test(getDisplayName());
		if (b) {			
			addActionError("ไม่สามารถใช้ชื่อนี้ได้");
			addActionError("ชื่อแสดงมีผู้ใช้แล้ว");
			setTest(false);
			return ERROR;
		} else {			
			setTest(true);
			
		}
		return SUCCESS;
	}

	private CheckDNameDAO checkNameDAO;

	public CheckDisplayName(CheckDNameDAO checkNameDAO) {
		super();
		this.checkNameDAO = checkNameDAO;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	public Boolean getTest() {
		return test;
	}

}
