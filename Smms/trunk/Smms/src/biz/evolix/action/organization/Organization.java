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
public class Organization extends ActionSupport {

	private OrchartService orchartService;
	private String nodeId;
	private String treeId;
	private List<NodeBean> teams;
	private List<Integer> level;
	private static final long serialVersionUID = -7992937997674968155L;
	private static Logger log = Logger.getLogger(Organization.class);

	@Action(value = "/json-organization-member", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	private void setTeamOrg(long u) {
		this.setTeams(orchartService.getTeamLevel(getTreeId(), u));
		this.level = orchartService.levelCommissions();
	}

	public String getJSON() throws Exception {
		long u = -2L;
		try {
			String x = (getNodeId() == null || getNodeId() == "") ? "-2"
					: getNodeId();
			u = Long.parseLong(x);
		} catch (Exception e) {
			log.error(e.getMessage() + " :" + u, e);
			return ERROR;
		}
		setTeamOrg(u);
		return execute();
	}

	public Organization(OrchartService orchartService) {
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

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setTeams(List<NodeBean> teams) {
		this.teams = teams;
	}

	public List<NodeBean> getTeams() {
		return teams;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}
}