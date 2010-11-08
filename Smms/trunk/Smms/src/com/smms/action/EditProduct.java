package com.smms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Sku;
import biz.evolix.service.InventoryService;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditProduct extends ActionSupport {

	private static final long serialVersionUID = 1720423244713713847L;

	@Action(value = "/jsoneditproduct", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {		
		return SUCCESS;
	}

	public String getJSON() throws Exception {	
		setGridModel(inventoryService.find(10, 20));
		return execute();
	}

	private InventoryService inventoryService;
	private List<Sku> gridModel;	
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;

	public List<Sku> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Sku> gridModel) {
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

	public EditProduct(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}

}
