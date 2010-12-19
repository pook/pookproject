package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Brance;

public interface BranceService {
	public List<Brance>findAll();
	public int size();
	public boolean insert(String name,String address,String tel,String provinceId,String postCode);
	public boolean update(Integer id,String name,String address,String tel,String provinceId,String postCode);
	public boolean delete(Integer id);
	public List<Brance> find(int from,long max);
}
