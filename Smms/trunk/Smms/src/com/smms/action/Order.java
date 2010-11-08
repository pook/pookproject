package com.smms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.smms.service.Item;
import com.smms.service.ItemDAO;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Order extends ActionSupport {

	private static final long serialVersionUID = 8619781837424132878L;

	@Action(value = "/jsonorder", results = { @Result(name = "success", type = "json") })
	public String execute() {

		// int to = (rows * page);
		// int from =0;// to - rows;

		// Count Rows (select count(*) from custumer)
		// records = CustomerDAO.count();

		// Your logic to search and select the required data.
		gridModel = ItemDAO.getItems();
		System.out.println("vvt"+getSidx());
		System.out.println("vvr"+getRows());
		System.out.println("vve"+getRecords());
		System.out.println("vppp"+getSearchString());
		System.out.println("vvoo"+getSearchField());
		// calculate the total pages for the query
		total = (int) Math.ceil((double) records / (double) rows);
		
		return SUCCESS;
	}

	public String getJSON() {
		return execute();
	}

	private List<Item> gridModel;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;

	public List<Item> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Item> gridModel) {
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

}
