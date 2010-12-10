package biz.evolix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import biz.evolix.connect.DatabasesMysql;

public class UserCommission {

	private static final int COMMISSION_BONUS = 100000;
	private static Logger log = Logger.getLogger(UserCommission.class);

	private DatabasesMysql db;

	public UserCommission(DatabasesMysql db) {
		super();
		this.db = db;
	}

	private static final String QUERY_INVIT = "select USER_ID,DISPLAYNAME,`STATUS` from NODE1";
	public void execute() {
		Connection conn = getDb().connect();
		Statement stmt = null;
		ResultSet rs = null;
		String userId ="";
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(QUERY_INVIT);			
			rs = stmt.getResultSet();
			LBL:
			while (rs.next()) {
				if(!rs.getString(3).equals("A"))continue LBL;
				userId=rs.getString(1);
				int headbonus = xBonus(userId, rs.getString(2));
				int teambonus = xBonus(userId);
				if (headbonus > 0 || teambonus > 0)updateBonus(teambonus, headbonus, userId);				
			}
		} catch (Exception e) {
			log.error("User :"+userId+" : "+e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :"+userId+" : "+e.getMessage());
			}
		}
	}

	public DatabasesMysql getDb() {
		return db;
	}

	public void setDb(DatabasesMysql db) {
		this.db = db;
	}

	private static final String QUERY_COMM_TEAM = "select ((N.SMILE_VALUE*0.02)+N.COMMISSIONS) from NODE1 N where N.USER_ID =? and N.STATUS='A'";

	private int xBonus(String userId) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		int bonus = 0;
		try {
			pstmt = conn.prepareStatement(QUERY_COMM_TEAM);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.first()) {
				bonus = rs.getInt(1);			
			}
		} catch (Exception e) {
			log.error("User :"+userId+" : "+e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :"+userId+" : "+e.getMessage());
			}
		}
		return bonus;
	}

	// bonus header from inviter
	private static final String QUERY_COMM = "select sum(c) as x from  (select ((N.SMILE_VALUE*0.02)+N.COMMISSIONS) as c, N.INVITER as inv,N.`STATUS` as st from NODE1 N) as m where c>='"
			+ COMMISSION_BONUS + "' and inv =? and st='A'";

	private int xBonus(String userId, String inviter) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		int bonus = 0;
		try {
			pstmt = conn.prepareStatement(QUERY_COMM);
			pstmt.setString(1, inviter);
			ResultSet rs = pstmt.executeQuery();
			if (rs.first()) {				
				bonus = rs.getInt(1);
				bonus /=10;
			}
		} catch (Exception e) {
			log.error("User :"+userId+" : "+e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :"+userId+" : "+e.getMessage());
			}
		}
		return bonus;
	}

	private static final String QUERY_UPDATE_BONUS = "update USERS N set N.BONUS_LAST=(N.BONUS_TEAM + N.BONUS_INV),N.BONUS_TEAM = ?,N.BONUS_INV =? where N.USER_ID =?";

	private void updateBonus(int teamBonus, int headBonus, String userId) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY_UPDATE_BONUS);
			pstmt.setInt(1, teamBonus);
			pstmt.setInt(2, headBonus);
			pstmt.setString(3, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			log.error("User :"+userId+" : "+e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :"+userId+" : "+e.getMessage());
			}
		}
	}
}
