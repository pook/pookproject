package com.smms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.smms.service.Customer;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Test extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7903902533882296948L;

		private int id;
		private String name;
	@Action(value = "/json-test", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		if (gridModel == null) {
			List<Customer> l = new ArrayList<Customer>();
			l.add(new Customer(1, "aaa"));
			l.add(new Customer(3, "bbb"));
			l.add(new Customer(4, "bbb"));
			l.add(new Customer(5, "bbb"));
			setGridModel(l);
			System.out.println("yyyyy");
		} else {
			System.out.println(getGridModel());
			gridModel.add(new Customer(id,name));
			System.out.println("xxxx"+id+"uuu"+name);
		}
		return SUCCESS;
	}

	@Action(value = "/json-edit", results = { @Result(name = "success", type = "json") })
	public String execute1() throws Exception {
		//new Customer(2,"xxxx");
		System.out.println("x>"+id+"d>"+name);
		return execute();
	}

	public String getJSON() throws Exception {

		return execute();
	}

	private List<Customer> gridModel;

	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer records = 0;

	public List<Customer> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Customer> gridModel) {
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
