package biz.evolix.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import biz.evolix.model.Node1;
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.Users;

public interface RegisterService {
	public String save(SmileUsersDetails n,String id,String pv,Node1 node,Users user)throws UsernameNotFoundException;		
	public boolean checkLevel();
	public String save(String cid,String displayName)throws UsernameNotFoundException;
}
