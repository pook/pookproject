package biz.evolix.action.managesku;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Sku;
import biz.evolix.service.InventoryService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class AddSkuAct extends ActionSupport {

	private static final long serialVersionUID = 1443126673233497703L;
	private static Logger log = Logger.getLogger(AddSkuAct.class);
	private InventoryService inventoryService;

	@Action(value = "/add-sku-grid", results = { @Result(name = "success", location = "editproduct.jsp") })
	public String execute() {
		if (oper.equals(ConstType.ADD)) {
			add();
		} else if (oper.equals(ConstType.DEL) && getId() != null
				&& getId() != "_empty") {
			int idx = -1;
			try {
				idx = Integer.parseInt(getId());
			} catch (Exception e) {
				log.error(e.getMessage());
				return ERROR;
			}
			del(idx);
		} else if (oper.equals(ConstType.EDIT)) {
			int idx = -1;
			try {
				idx = Integer.parseInt(getId());				
			} catch (Exception e) {
				log.error(e.getMessage());
				return ERROR;
			}
			return edit(idx);
		}
		return SUCCESS;
	}

	private void del(int idx) {
		inventoryService.remove(idx - 1);
	}

	private void add() {
		Sku sk = new Sku();
		sk.setDescription(getDescription());
		sk.setDiscount(getDiscount());
		sk.setMemberPrice(getMemberPrice());
		sk.setName(getName());
		sk.setPrice(getPrice());
		sk.setDiscount(getDiscount());
		sk.setSv(getSv());
		inventoryService.addSku(sk);
	}

	private String edit(int idx) {
		try {
			Sku sku = inventoryService.find(idx - 1);
			System.out.println("noooooo");
			sku.setDescription(getDescription());
			sku.setDiscount(getDiscount());
			sku.setMemberPrice(getMemberPrice());
			sku.setName(getName());
			sku.setPrice(getPrice());
			sku.setPriceDiscount(getPriceDiscount());
			sku.setSv(getSv());
			inventoryService.update(sku);
			return SUCCESS;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ERROR;
		}
	}

	private String oper;
	private String id;
	private Long sku;
	private String name;
	private String description;
	private Double price;
	private Double memberPrice;
	private Integer discount;
	private Double priceDiscount;
	private Integer sv;

	public AddSkuAct(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getPriceDiscount() {
		return priceDiscount;
	}

	public void setPriceDiscount(Double priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	public Integer getSv() {
		return sv;
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
