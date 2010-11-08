package biz.evolix.model.dao;

import java.util.Collection;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;


public interface AuthoritiesDAO {
	public boolean authorization(final Users id,String role);
	public Collection<Authorities> findAuth(final String id);
	public Users findUser(String userId)throws NullPointerException;
}
