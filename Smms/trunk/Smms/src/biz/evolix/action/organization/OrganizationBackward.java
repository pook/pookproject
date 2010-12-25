package biz.evolix.action.organization;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Node1;
import biz.evolix.service.OrchartService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class OrganizationBackward extends ActionSupport {

	private OrchartService orchartService;	
	private Integer nodeId;
	private Integer back;
	private List<Node1> teams;
	private List<Integer> level;
	private static final long serialVersionUID = -7992937997674968155L;
	private static Logger log = Logger
			.getLogger(OrganizationBackward.class);

	@Action(value = "/json-organization-backward", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	private void setTeamOrg(long u) {		
		setTeams(orchartService.getTeamLevel(u));
		setLevel(orchartService.levelCommissions());
	}

	public String getJSON() throws Exception {	
		long c = -2L;
		if(getBack() ==ConstType.BACKWARD){
			c = backward(getNodeId());
		}else{
			c = backward6(getNodeId());
		}
		setTeamOrg(c);
		return execute();
	}
	private static long backward(long c) {
		return -2;
	}

	private static long backward6(long c) {
		for (int i = 0; i < ConstType.BACKWARD_6; i++) {
			if (c == 0)
				break;
			c = backward(c);
		}
		return c;
	}


	public OrganizationBackward(OrchartService orchartService) {
		super();
		this.orchartService = orchartService;
		this.orchartService.init();
	}

	public void setTeams(List<Node1> teams) {
		this.teams = teams;
	}

	public List<Node1> getTeams() {
		return teams;
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

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getNodeId() {
		return nodeId;
	}
}
