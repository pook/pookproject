package biz.evolix.action.role;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.bean.UserRoleBean;
import biz.evolix.service.sub.RoleService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class RoleManAct extends ActionSupport {

	private static final long serialVersionUID = -1859780521426943662L;
	private static Logger log = Logger.getLogger(RoleManAct.class);

	@Action(value = "/json-role-admin", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		try {
			if (searchString != null && searchOper != null
					&& !searchString.equals("") && !searchOper.equals("")) {
				if (searchOper.equalsIgnoreCase("eq")) {					
					if (searchField.equals("smileId")) {
						setGridModel(roleService.search(searchString));						
					}else if (searchField.equals("name")) 
						setGridModel(roleService.searchByName(searchString));
					setTotal(1);					
				}
			} else {
				setRecord(roleService.sizeMember());
				int to = (getRows() * getPage());
				int from = to - getRows();
				setGridModel(roleService.userRole(from, getRecord()));
				setTotal();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String getJSON() throws Exception {
		return SUCCESS;
	}

	private List<UserRoleBean> gridModel;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer record = 0;
	private Boolean loadonce = false;
	private String id;

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

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
		this.setTotal();
	}

	private void setTotal() {
		if (getRecord() > 0 && getRows() > 0) {
			setTotal((int) Math.ceil((double) this.record / (double) this.rows));
		} else {
			setTotal(ConstType.ZERO);
		}
	}

	public void setGridModel(List<UserRoleBean> gridModel) {
		this.gridModel = gridModel;
	}

	public List<UserRoleBean> getGridModel() {
		return gridModel;
	}

	public void setLoadonce(Boolean loadonce) {
		this.loadonce = loadonce;
	}

	public Boolean getLoadonce() {
		return isLoadonce();
	}

	public Boolean isLoadonce() {
		return loadonce;
	}

	private RoleService roleService;

	public RoleManAct(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
