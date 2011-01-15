package com.smms.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.bean.OrderBean;
import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class BlackOffice extends ActionSupport {

	private static final long serialVersionUID = 9197620900860026907L;
	private PurcheseService purcheseService;

	@Action(value = "/json-ordering", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getJSON() throws Exception {
		List<biz.evolix.model.Order> ordering = purcheseService.odering();
		List<OrderBean> orders = new ArrayList<OrderBean>();
		if (ordering.size() > 0) {
			long l = ordering.get(0).getOrderId();
			OrderBean ob = new OrderBean((int) l, ordering.get(0).getUser()
					.getNode1().getSmileId(), ordering.get(0).getUser()
					.getDetail().getName(), ordering.get(0).getDate(), ordering
					.get(0).getTotalPrice(), ordering.get(0).getTotalSv());
			orders.add(ob);
		}		
		setGridModel(orders);
		return SUCCESS;
	}

	private List<OrderBean> gridModel;
	private Integer orderId;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;

	// private Map<String, Object> session;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public BlackOffice(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setGridModel(List<OrderBean> gridModel) {
		this.gridModel = gridModel;
	}

	public List<OrderBean> getGridModel() {
		return gridModel;
	}

}