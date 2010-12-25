package com.smms.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Sku;
import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class ProcheseAct extends ActionSupport {

	/**
	 * work with Black office
	 */
	private static final long serialVersionUID = -8259383990285606982L;
	private PurcheseService purcheseService;
	private String oper;	
	private Sku sku; // name,descript
	private Integer quantity;
	private double totalPrice;
	private Integer psv;
	private String id;
	
	@Action(value = "/edit-grid-purchese", results = {
			@Result(location = "blackoffice.jsp", name = "success"),
			@Result(location = "blackoffice.jsp", name = "input") })
	public String execute() {		

		if (oper.equals(ConstType.ADD)) {
			Sku k = null;
			try {
				k = purcheseService.loadSku(Integer.parseInt(sku.getName()));
			} catch (Exception e) {
				//addActionError(e.getMessage());
				System.err.println(e);
			}
			if(k==null || quantity==0){
				//addActionMessage("Item not found");
				System.out.println("Item not found");
			}else{
				purcheseService.buyItem(k,quantity);
			}

		} else if (oper.equals(ConstType.DEL)) {
			try {
				del(Integer.parseInt(id));
				} catch (Exception e) {
				addActionError(e.getMessage());
				System.err.println(e);
			}				
		} else if (oper.equals(ConstType.EDIT)) {
			
		}
		return SUCCESS;
	}
	private void del(int sku){
		System.out.println("sku11 "+sku);
		purcheseService.del(sku-1);
	}
	private void edit(int id,Sku sku,Integer quantity){
		
	}

	public ProcheseAct(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

	public PurcheseService getPurcheseService() {
		return purcheseService;
	}

	public void setPurcheseService(PurcheseService purcheseService) {
		this.purcheseService = purcheseService;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	
	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setPsv(int psv) {
		this.psv = psv;
	}

	public double getPsv() {
		return psv;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}


}
