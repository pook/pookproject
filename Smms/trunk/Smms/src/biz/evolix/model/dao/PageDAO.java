package biz.evolix.model.dao;

import biz.evolix.model.Page;

public interface PageDAO {
	public String lookup(String id);
	public void insert(Page p);
}