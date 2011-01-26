package biz.evolix.action.order;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import biz.evolix.service.OrderService;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class SubOrder extends ActionSupport {
	
	private static final long serialVersionUID = -8770006569548425345L;
	private String id;

	@Action(value = "/json-list-purchese1-member", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getJSON() throws Exception {
		setGridModel(orderService.purcheses(Integer.parseInt(getId())));
		return execute();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private OrderService orderService;

	public SubOrder(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	public void setGridModel(List<biz.evolix.model.Purchese> gridModel) {
		this.gridModel = gridModel;
	}

	public List<biz.evolix.model.Purchese> getGridModel() {
		return gridModel;
	}

	private List<biz.evolix.model.Purchese> gridModel;

}
