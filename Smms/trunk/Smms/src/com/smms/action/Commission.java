package com.smms.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	private static final long serialVersionUID = 7657873894220487780L;	
	@Action(value = "/commission", results = { @Result( name = "success",location="commission.jsp")
	})
	public String execute() throws Exception {				
		return SUCCESS;
	}
	@Action(value = "/commission1-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smile_com_test.cvs"})
	})
	public String execute1() throws Exception {
		File f = new File("/opt/bonus/");
		File[]fs = f.listFiles(new FileLastMod("12"));
		int j=0;
		long last = fs[j].lastModified();		
		for(int i=1;i<fs.length;i++){
			if(fs[i].lastModified()>last){
				last = fs[i].lastModified();j=i;
			}
		}
		try{
			fileInputStream = new FileInputStream(fs[j]);
		}catch (FileNotFoundException e) {
			log.error(e.getMessage());
			return ERROR;
		}				
		return SUCCESS;
	}	
	@Action(value = "/commission2-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute2() throws Exception {
			
		return SUCCESS;
	}
	@Action(value = "/commission3-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute3() throws Exception {
			
		return SUCCESS;
	}
	@Action(value = "/commission4-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute4() throws Exception {
				
		return SUCCESS;
	}
	@Action(value = "/commission5-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute5() throws Exception {
				
		return SUCCESS;
	}
	@Action(value = "/commission6-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute6() throws Exception {
		fileInputStream = new FileInputStream(new File("D:\\smms-batch.log"));		
		return SUCCESS;
	}
	@Action(value = "/commission7-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute7() throws Exception {
				
		return SUCCESS;
	}
	@Action(value = "/commission8-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute8() throws Exception {
			
		return SUCCESS;
	}
	@Action(value = "/commission9-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute9() throws Exception {
				
		return SUCCESS;
	}
	@Action(value = "/commission10-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=xxx1.txt"})
	})
	public String execute10() throws Exception {
			
		return SUCCESS;
	}
	@Action(value = "/commission11-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute11() throws Exception {
				
		return SUCCESS;
	}
	@Action(value = "/commission12-cvs", results = { @Result( name = "success",type ="stream"
		,params={"contentType","application/octet-stream","inputName","fileInputStream"
			,"contentDisposition","attachment;filename=smms-batch.log"})
	})
	public String execute12() throws Exception {
				
		return SUCCESS;
	}

	
	private InputStream fileInputStream;
	 
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	
}
