package biz.evolix.model.dao;

import biz.evolix.model.Province;
import biz.evolix.model.SmileUsersDetails;

public interface SmileUsersDetailDAO {
	public void register(SmileUsersDetails smileuser);
	public Province province(String id);	
}