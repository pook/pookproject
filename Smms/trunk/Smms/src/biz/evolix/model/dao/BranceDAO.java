package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Brance;
import biz.evolix.model.Province;

public interface BranceDAO {
	public List<Brance>findAll();
	public Brance find(Integer id);
	public Long size();
	public boolean insert(Brance b);
	public boolean update(Brance b,String pid);
	public boolean delete(Brance id);
	public Province find(String id);
	public List<Brance> find(int from,long max);
}
