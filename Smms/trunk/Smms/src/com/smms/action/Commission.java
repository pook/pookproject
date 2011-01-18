package com.smms.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.action.global.FileLastMod;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Commission extends ActionSupport {

	private static Logger log = Logger.getLogger(Commission.class);
	private static final String PATH = "/opt/bonus/";

	private static final long serialVersionUID = 7657873894220487780L;

	@Action(value = "/commission", results = { @Result(name = "success", location = "commission.jsp") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "/commission1-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_jan.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute1() throws Exception {
		return export("01");
	}

	private String export(String mount) {
		File f = null;
		File[] fs = null;
		try {
			f = new File(PATH);
			fs = f.listFiles(new FileLastMod(mount));
			int j = 0;
			long last = fs[j].lastModified();
			for (int i = 1; i < fs.length; i++) {
				if (fs[i].lastModified() > last) {
					last = fs[i].lastModified();
					j = i;
				}
			}
			fileInputStream = new FileInputStream(fs[j]);
		} catch (Exception e) {
			addActionError("ไม่พบข้อมูล");
			log.error(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "/commission2-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_feb.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute2() throws Exception {
		return export("02");
	}

	@Action(value = "/commission3-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_mar.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute3() throws Exception {
		return export("03");
	}

	@Action(value = "/commission4-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_april .cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute4() throws Exception {
		return export("04");
	}

	@Action(value = "/commission5-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_may.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute5() throws Exception {
		return export("05");
	}

	@Action(value = "/commission6-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_june.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute6() throws Exception {
		return export("06");
	}

	@Action(value = "/commission7-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_july.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute7() throws Exception {
		return export("07");
	}

	@Action(value = "/commission8-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_august.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute8() throws Exception {
		return export("08");
	}

	@Action(value = "/commission9-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_september.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute9() throws Exception {
		return export("09");
	}

	@Action(value = "/commission10-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_october.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute10() throws Exception {
		return export("10");
	}

	@Action(value = "/commission11-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_november.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute11() throws Exception {
		return export("11");
	}

	@Action(value = "/commission12-cvs", results = {
			@Result(name = "success", type = "stream", params = {
					"contentType", "application/octet-stream", "inputName",
					"fileInputStream", "contentDisposition",
					"attachment;filename=smile_com_december.cvs" }),
			@Result(location = "echo/error.jsp", name = "error") })
	public String execute12() throws Exception {
		return export("12");
	}

	private InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return fileInputStream;
	}
}
