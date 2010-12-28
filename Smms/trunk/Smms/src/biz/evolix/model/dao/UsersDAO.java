package biz.evolix.model.dao;

import biz.evolix.model.Users;

public interface UsersDAO {
	public Users find(Long id);
	public Users findBySmileUser(String smileId);
	public void persist(Users user);
	public void update(Users user);
}
