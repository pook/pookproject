package biz.evolix.action.organization;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Node1;
import biz.evolix.model.bean.NodeBean;
import biz.evolix.service.OrchartService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class OrganizationSearchMember extends ActionSupport {

	private OrchartService orchartService;
	private String messageError[];
	private String memberid;
	private List<NodeBean> teams;
	private List<Integer> level;
	private static final long serialVersionUID = -7992937997674968155L;
	private static Logger log = Logger
			.getLogger(OrganizationSearchMember.class);

	@Action(value = "/json-organization-search-member", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	private void setTeamOrg(String treeId, long u) {
		setTeams(orchartService.getTeamLevel(treeId, u));
		setLevel(orchartService.levelCommissions());
	}

	public String getJSON() throws Exception {
		Node1 u = orchartService.getNodeId(getMemberid());
		if (u.getPos() == ConstType.NOT_FOUND) {
			setMessageError(new String[] { ConstType.MEMBER_NOT_FOUND + " : "
					+ getMemberid() });
			return ERROR;
		} else if (u.getPos() == ConstType.NOT_ALLOW) {
			setMessageError(new String[] { ConstType.MEMBER_NOT_ALLOW + " : "
					+ getMemberid() });
			return ERROR;
		} else {
			setTeamOrg(u.getTreeId(), u.getPos());
		}
		return execute();
	}

	public OrganizationSearchMember(OrchartService orchartService) {
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

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMessageError(String messageError[]) {
		this.messageError = messageError;
	}

	public String[] getMessageError() {
		return messageError;
	}

	public void setTeams(List<NodeBean> teams) {
		this.teams = teams;
	}

	public List<NodeBean> getTeams() {
		return teams;
	}
}