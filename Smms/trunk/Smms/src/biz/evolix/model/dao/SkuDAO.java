package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Sku;

public interface SkuDAO {
	public void addItem(Sku p);
	public List<Sku> showAllItem();
}
