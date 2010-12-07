package biz.evolix.service;

import java.util.Collection;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;

public interface RegisterService {
	public void save(Users n,Long id,String pv);	
	public Collection<Node1> listUpline();
	public void chgpw(String newpw);
	public boolean checkPassword(String pw);
}
