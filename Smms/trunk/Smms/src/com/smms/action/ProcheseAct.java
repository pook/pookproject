package com.smms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Purchese;
import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class ProcheseAct extends ActionSupport{

	/**
	 *  work with Black office
	 */
	private static final long serialVersionUID = -8259383990285606982L;
	private PurcheseService purcheseService;


	@Action(value = "/json-purchese", results = { @Result(name = "success", type = "json") })
	public String execute(){
		//purcheseService
		return SUCCESS;
	}
	@Action(value = "/json-addpurchese", results = { @Result(name = "success", type = "json") })
	public String addPurchese(int idxOrder, Purchese p) throws Exception {
		purcheseService.getPurcheseFromOrders(idxOrder).add(p);
		return execute();
	}	
	
	
	public String getJSON() throws Exception {
		return execute();
	}

	private List<biz.evolix.model.Purchese> gridModel;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;

	public List<biz.evolix.model.Purchese> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<biz.evolix.model.Purchese> gridModel) {
		this.gridModel = gridModel;
	}

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
	public ProcheseAct(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

}
