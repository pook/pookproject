package biz.evolix.action.organization;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.bean.NodeBean;
import biz.evolix.service.OrchartService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class OrganizationBackward extends ActionSupport {

	private OrchartService orchartService;	
	private String nodeId;
	private String treeId;
	private Integer back;
	private List<NodeBean> teams;
	private List<Integer> level;
	private static final long serialVersionUID = -7992937997674968155L;
	private static Logger log = Logger
			.getLogger(OrganizationBackward.class);

	@Action(value = "/json-organization-backward-member", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	private void setTeamOrg(long u) {		
		setTeams(orchartService.getTeamLevel(getTreeId(),u,getBack()));
		setLevel(orchartService.levelCommissions());
	}

	public String getJSON() throws Exception {	
		long u = Long.parseLong(getNodeId());
		setTeamOrg(u);
		return execute();
	}	
	

	public OrganizationBackward(OrchartService orchartService) {
		super();
		this.orchartService = orchartService;	
		this.orchartService.init();
	}	
	public void setLevel(List<Integer> level) {
		this.level = level;
	}

	public List<Integer> getLevel() {
		return level;
	}
	public void setBack(Integer back) {
		this.back = back;
	}

	public Integer getBack() {
		return back;
	}

	public void setTeams(List<NodeBean> teams) {
		this.teams = teams;
	}

	public List<NodeBean> getTeams() {
		return teams;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}
}
