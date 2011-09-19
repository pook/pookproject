package biz.evolix.model.dao.callback.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import biz.evolix.model.bean.UserDowlineBean;

public class UserPreparedStatementCallback implements PreparedStatementCallback<List<UserDowlineBean>> {

	@Override
	public List<UserDowlineBean> doInPreparedStatement(PreparedStatement pstmt)
			throws SQLException, DataAccessException {
		pstmt.setMaxRows(this.max+this.start);						
		List<UserDowlineBean>users = new ArrayList<UserDowlineBean>();
		ResultSet rs = pstmt.executeQuery();int i=0;
		while(rs.next()){
			if(rs.getRow()<this.start)continue;			
			users.add(new UserDowlineBean(i++,rs.getString(1),rs.getString(2) , rs.getString(4),status(rs.getString(5))));
		}
		return users;
	}
	private int max,start;
	
	public UserPreparedStatementCallback(int start,int max) {
		super();
		this.max = max;
		this.start = start;
	}
	private static String status(String status){
		return (status.equalsIgnoreCase("A"))?"ACTIVE":"INACTIVE";
	}

}
