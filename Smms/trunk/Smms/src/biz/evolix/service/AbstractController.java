package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.secure.SmileUser;

public abstract class AbstractController {
	private static Logger log = Logger.getLogger(AbstractController.class);

	public SmileUser getUsers(){
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
