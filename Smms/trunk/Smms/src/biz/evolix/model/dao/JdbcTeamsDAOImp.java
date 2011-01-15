package biz.evolix.model.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.bean.UserDowlineBean;
import biz.evolix.model.dao.callback.jdbc.UserPreparedStatementCallback;
import biz.evolix.secure.SmileUser;

public class JdbcTeamsDAOImp extends JdbcDaoSupport implements JdbcTeamsDAO {

	private static Logger log = Logger.getLogger(JdbcTeamsDAOImp.class);

	@Override
	public int size() {
		String sql = "select count( distinct N.DISPLAYNAME) from (select distinct N.DISPLAYNAME from NODE1 as N where N.INVITER='aaa')as D,NODE1 as N where D.DISPLAYNAME=N.INVITER OR N.INVITER='aaa' ";
		int size = -1;
		try {
			size = getJdbcTemplate().queryForInt(sql);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return size;
	}

	@Override
	public List<UserDowlineBean> find(int from, int max) {
		StringBuilder sql = new StringBuilder();
		String dname = getUsers().getDisplayName();
		sql.append(
				"select N.SMILE_ID,M.NAME,N.DISPLAYNAME,M.ADDRESS,N.STATUS from USERS U,USERS_DETAIL M,NODE1 N ")
				.append(" where U.SMILE_ID=M.SMILE_ID and N.USER_ID=U.USER_ID  and U.USER_ID in")
				.append("(select distinct N.USER_ID from NODE1 N where N.INVITER in")
				.append("(select distinct N.DISPLAYNAME from NODE1 N where N.INVITER='")
				.append(dname).append("')")
				.append("union select distinct N.USER_ID from NODE1 N where N.INVITER='")
				.append(dname).append("')");				
		List<UserDowlineBean> users = getJdbcTemplate().execute(sql.toString(),
				new UserPreparedStatementCallback(from, max));		
		return users;
	}
	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
