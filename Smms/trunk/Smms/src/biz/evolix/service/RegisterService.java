package biz.evolix.service;

import biz.evolix.model.Users;

public interface RegisterService {
	public Users save(Users n,Long id,String pv);		
	public void chgpw(String newpw);
	public boolean checkPassword(String pw);
	public boolean checkLevel();
}
