package biz.evolix.model.dao;

import java.util.Collection;

import biz.evolix.model.Authorities;
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.Users;

public interface AuthoritiesDAO {
	public boolean authorization(Users id,String role);
	public Collection<Authorities> findAuth(final String id);
	public SmileUsersDetails findUser(String userId)throws NullPointerException;
    public boolean chgpw(String uid,String newpw);
    public boolean ckpasswd(String uid,String pw);

}