package biz.evolix.model.dao;

import biz.evolix.model.Users;

public interface UsersDAO {
	public Users userDetail(Long id);
	public void persist(Users user);
	public void update(Users user);
}
