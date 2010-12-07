package biz.evolix.action.backoffice;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.OrderService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class SubShowPurcheseAction extends ActionSupport {

	private static final long serialVersionUID = 1468827265467130910L;
	private static Logger log = Logger.getLogger(SubShowPurcheseAction.class);
	private String id;

	@Action(value = "/json-list-purchese2", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getJSON() throws Exception {
		setGridModel(orderService.purcheses(Integer.parseInt(getId())));
		return execute();
	}

	public void setGridModel(List<biz.evolix.model.Purchese> gridModel) {
		this.gridModel = gridModel;
	}

	public List<biz.evolix.model.Purchese> getGridModel() {
		return gridModel;
	}

	private List<biz.evolix.model.Purchese> gridModel;

	private OrderService orderService;

	public SubShowPurcheseAction(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
