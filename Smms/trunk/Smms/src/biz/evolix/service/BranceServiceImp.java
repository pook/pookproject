package biz.evolix.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Brance;
import biz.evolix.model.Province;
import biz.evolix.model.dao.BranceDAO;

public class BranceServiceImp implements BranceService {

	@Autowired
	private BranceDAO branceDAO;

	@Override
	public List<Brance> findAll() {
		setBrances(branceDAO.findAll());
		return getBrances();
	}

	@Override
	public int size() {
		long s = branceDAO.size();
		return (int)s;
	}

	@Override
	public boolean insert(String name, String address, String tel,
		 String provinceId, String postCode) {
		Brance b = new Brance();
		b.setBAddress(address);
		b.setBName(name);
		b.setBTel(tel);
		b.setPostcode(postCode);
		Province p = branceDAO.find(provinceId);
		if (p == null)return false;
		b.setProvince(p);
		if (branceDAO.insert(b))return true;
		return false;
	}

	@Override
	public boolean update(Integer id, String name, String address, String tel,
			String provinceId, String postCode) {
		Brance b = null;
		try{
			b = getBrances().get(id);			
			b.setBAddress(address);
			b.setBName(name);
			b.setBTel(tel);
			b.setPostcode(postCode);			
			if(branceDAO.update(b,provinceId))return true;
		}catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}		
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		Brance b = null;
		try{
			b = getBrances().get(id);
			branceDAO.delete(b);
			return true;
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}
	
	@Override
	public List<Brance> find(int from, long max) {
		setBrances(branceDAO.find(from, max));
		return getBrances();
	}

	public void setBranceDAO(BranceDAO branceDAO) {
		this.branceDAO = branceDAO;
	}

	public BranceDAO getBranceDAO() {
		return branceDAO;
	}
	public void setBrances(List<Brance> brances) {
		this.brances = brances;
	}

	public List<Brance> getBrances() {
		return brances;
	}
	private List<Brance>brances;
	private static Logger log = Logger.getLogger(BranceServiceImp.class);
}
