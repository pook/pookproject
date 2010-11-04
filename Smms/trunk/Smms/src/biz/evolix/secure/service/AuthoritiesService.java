package biz.evolix.secure.service;

import java.util.Collection;

import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;

public interface AuthoritiesService {
	public Users findUsers(String userid);
	public Node1 fimdNode1(String userid);
	public Collection<Authorities> getAuthorities(String userid);
}
