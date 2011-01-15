package biz.evolix.model.dao;

import java.util.Collection;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;

public interface AuthoritiesDAO {
	public void insert(Authorities auth);
	public Authorities findByName(String name,Users user);
	public Collection<Authorities> findAuth(final String id);
	//public Users findUser(String userId)throws NullPointerException;
    public boolean chgpw(long uid,String newpw);
    public boolean ckpasswd(String uid,String pw);  
    public void remove(long userId); 
    public void remove1(Authorities auth);
    public void merg(Authorities auth);
}