package biz.evolix.action.role;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Province;
import biz.evolix.service.BranceService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditBrance extends ActionSupport {

	private static final long serialVersionUID = -5539029562838837864L;

	@Action(value = "/edit-grid-brance", results = {
			@Result(location = "smmsrole.jsp", name = "success"),
			@Result(location = "smmsrole.jsp", name = "input") })
	public String execute() throws Exception {
		if (getOper().equals(ConstType.ADD)) {
			return add();
		} else if (getOper().equals(ConstType.DEL)) {
			return remove();
		} else if (getOper().equals(ConstType.EDIT)) {
			return edit();
		}
		return SUCCESS;
	}

	private String add() {
		if (branceService.insert(getBName(), getBAddress(), getBTel(),
				getProvince().getPname(), getPostcode()))
			return SUCCESS;
		return ERROR;
	}

	private String remove() {
		int bc = -1;
		try {
			bc = Integer.parseInt(getId());
			branceService.delete(bc-1);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	private String edit() {
		int bcode = -1;
		try {
			bcode = Integer.parseInt(getId());
			if (branceService.update(new Integer(bcode-1), getBName(), getBAddress(), getBTel(),
					getProvince().getPname(), getPostcode()))
				return SUCCESS;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
		
		return ERROR;
	}

	private String oper;
	private BranceService branceService;
	private String id;
	private String BName, BAddress, BTel, postcode, branceCode;
	private Province province;

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public EditBrance(BranceService branceService) {
		super();
		this.branceService = branceService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Province getProvince() {
		return province;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String getBAddress() {
		return BAddress;
	}

	public void setBAddress(String bAddress) {
		BAddress = bAddress;
	}

	public String getBTel() {
		return BTel;
	}

	public void setBTel(String bTel) {
		BTel = bTel;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setBranceCode(String branceCode) {
		this.branceCode = branceCode;
	}

	public String getBranceCode() {
		return branceCode;
	}

	private static Logger log = Logger.getLogger(EditBrance.class);
}
