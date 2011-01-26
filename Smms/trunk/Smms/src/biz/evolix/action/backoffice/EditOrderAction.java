package biz.evolix.action.backoffice;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.service.OrderService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditOrderAction extends ActionSupport {

	private static Logger log = Logger.getLogger(EditOrderAction.class);
	private static final long serialVersionUID = 1823826248858579804L;
	private String id;
	private String oper;

	@Action(value = "/edit-order-grid-staff", results = { @Result(name = "success", location = "showordered.jsp") })
	public String execute() {
		if (getOper().equals(ConstType.DEL)) {
			del();
		}
		return SUCCESS;
	}
	private String del(){
		int idx = -1;			
		try{
			idx = Integer.parseInt(getId());				
		}catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
		if(idx<1)return ERROR;
		orderService.del(idx-1);
		return SUCCESS;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	private OrderService orderService;

	public EditOrderAction(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

}
