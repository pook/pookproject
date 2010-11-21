package biz.evolix.service;
import java.util.List;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;

public interface AuthoritiesService {
	public List<Authorities> getAuthorities(Users user);
	
	
}
