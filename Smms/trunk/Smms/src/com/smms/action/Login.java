package com.smms.action;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
    @RequiredStringValidator(fieldName = "loginuser", type = ValidatorType.FIELD, message = "Login User is required"), 
    @RequiredStringValidator(fieldName = "loginpassword", type = ValidatorType.FIELD, message = "Password is required")
}, expressions = {
  @ExpressionValidator(expression = "loginpassword.trim().equals('password') == true", message = "Wrong User name or Password.."),
 
})
public class Login extends ActionSupport {

  
  private static final long serialVersionUID = -7308127326053089498L;
//private static final Log  log              = LogFactory.getLog(Login.class);

  private String            loginuser;
  private String            loginpassword;
  private String            echo;
  
  @Action(value = "/login", results = {
    @Result(location = "onSuccess.jsp", name = "success")
  })
  public String execute() throws Exception
  {
    echo = "Welcome " + loginuser;
   // log.info(echo);

    return SUCCESS;
  }

  public String getEcho()
  {
    return echo;
  }

  public String getLoginuser()
  {
    return loginuser;
  }

  public void setLoginuser(String loginuser)
  {
    this.loginuser = loginuser;
  }

  public String getLoginpassword()
  {
    return loginpassword;
  }

  public void setLoginpassword(String loginpassword)
  {
    this.loginpassword = loginpassword;
  }
}
