package biz.evolix.service;

import java.util.Collection;

import biz.evolix.model.Node1;

public interface RegisterService {
	public void save(Node1 m,Long id);	
	public Collection<Node1> listUpline();
}
