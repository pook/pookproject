package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;


public interface AuthoritiesDAO {
	public boolean authorization(final Users id,String role);
	public List<Authorities> findAuth(final String id);
	public Users authentication(String username,String password);
	public Users findUser(String userId);
}
