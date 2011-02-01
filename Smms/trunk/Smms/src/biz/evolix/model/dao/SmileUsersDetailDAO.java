package biz.evolix.model.dao;

import biz.evolix.model.Province;
import biz.evolix.model.SmileUsersDetails;

public interface SmileUsersDetailDAO {
	public void register(SmileUsersDetails smileuser);
	public Province province(String id);
	public SmileUsersDetails find(String smileId);
	public void update(SmileUsersDetails smileuser);
	public int findCode(String codeId);
}