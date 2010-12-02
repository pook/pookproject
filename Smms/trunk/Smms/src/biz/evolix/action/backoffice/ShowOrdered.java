package biz.evolix.action.backoffice;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evlix.customconst.ConstType;
import biz.evolix.service.OrderService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class ShowOrdered extends ActionSupport {

	private static final long serialVersionUID = 1203067266428303543L;
	private static Logger log = Logger.getLogger(ShowOrdered.class);
	
	@Action(value = "/json-list-order", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {			
		return SUCCESS;
	}

	public String getJSON() throws Exception {		
		setRecord( orderService.sizeOrderStaff());
		System.out.println("page "+getPage() );
		int to = (getRows() * getPage());
		int from = to - getRows();		
		setGridModel(orderService.ordersByStaff(from , to,getRows()));	
		setTotal();
		return execute();
	}

	private List<biz.evolix.model.Order> gridModel;
	private Integer orderId;
	private Integer rows = 0;
	private Integer page = 0;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper;
	private Integer total = 0;
	private Integer record = 0;	
	
	
	public List<biz.evolix.model.Order> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<biz.evolix.model.Order> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;this.setTotal();
	}

	private OrderService orderService;
	
	public ShowOrdered(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	private void setTotal(){
		if (getRecord() > 0 && getRows() > 0) {
			setTotal( (int) Math.ceil((double) this.record
					/ (double) this.rows));
		} else {
			setTotal(ConstType.ZERO);
		}		
	}		
	
	
}
