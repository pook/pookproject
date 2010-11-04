package com.smms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Sku;
import biz.evolix.service.InventoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.smms.service.Item;
import com.smms.service.ItemDAO;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class EditProduct extends ActionSupport {

	
	private static final long serialVersionUID = 1720423244713713847L;
	@Action(value = "/jsoneditproduct", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		gridModel = ItemDAO.getItems();		
		total = (int) Math.ceil((double) records / (double) rows);
		
		return SUCCESS;
	}
	public String getJSON() throws Exception {	
	
	//	List<Sku> skus =inventoryService.showItem();// new ArrayList<Sku>();
		/*
		Sku s1 = new Sku();
		s1.setDescription("descriptioncc");
		s1.setDiscount(2);
		s1.setMemberPrice(80.0);
		s1.setName("ผงซักฟอก สไมล์");
		s1.setPrice(100.0);
		s1.setSv(99);
		s1.setPriceDiscount(90.0);
		
		skus.add(s1);
		inventoryService.addItem(skus);
		
		for(Sku k:skus)
		System.out.println(k.getDescription()+"\n"+k.getMemberPrice()
				);
		*/	
		return execute();
	}
	private InventoryService inventoryService;
	private List<Item> gridModel;
	//grid att
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
	public EditProduct(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}


}
