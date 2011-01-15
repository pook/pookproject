package biz.evolix.service.sub.imp;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.secure.SmileUser;
import biz.evolix.service.sub.ChangePasswdService;

public class ChangePasswdServiceImp implements ChangePasswdService{
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Override
	public void chgpw(String newpw) {
		try {
			authoritiesDAO.chgpw(getUsers().getUserid(),
					Generate.generateIdSHA(newpw));
			SecurityContextHolder.clearContext();
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean checkPassword(String pw) {
		try {
			pw = Generate.generateIdSHA(pw);
			return authoritiesDAO.ckpasswd(getUsers().getSmileid(), pw);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
	private static Logger log = Logger.getLogger(ChangePasswdServiceImp.class);
	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {			
			log.error(e.getMessage());
		}
		return null;
	}


}
