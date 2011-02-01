package biz.evolix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import biz.evolix.connect.DatabasesMysql;

public class UserCommission {

	private static final int COMMISSION_BONUS = 99999;
	private static Logger log = Logger.getLogger(UserCommission.class);

	private DatabasesMysql db;
	private int count = 0;

	public UserCommission(DatabasesMysql db) {
		super();
		this.db = db;
	}

	private static final String QUERY_INVIT = "select N.SMILE_ID,N.DISPLAYNAME,U.USER_ID from NODE1 N,USERS U where U.USER_ID=N.USER_ID";

	public void execute() {
		Connection conn = getDb().connect();
		Statement stmt = null;
		ResultSet rs = null;
		String smileId = "", inviter = "";
		long userId = -2;
		init();
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(QUERY_INVIT);
			rs = stmt.getResultSet();
			int c = countUser();
			log.info("All Reccord = "+c);
			while (rs.next()) {
				smileId = rs.getString(1);
				inviter = rs.getString(2);
				userId = rs.getLong(3);
				int headbonus = xBonus(userId, inviter);
				int teambonus = xBonus(userId);
				BeanClazz<Integer> com = com(userId);
				updateBonus(teambonus, headbonus, userId);
				insert(userId, teambonus, headbonus, com.getArg0(),
						com.getArg1(), com.getArg2());
				clear(userId,smileId);
				log.info("Read Reccord :"+(++count)+"User id:" + userId + " Inviter bonus:" + headbonus
						+ " Team Bonus :" + teambonus);				
			}
			log.info("Readed All Reccord = "+count);
			export();
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
	}
	private static final String QUERY_COUNT = "select count(0) from NODE1 ";
	public int countUser(){
		int c = 0;
		Connection conn = getDb().connect();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();			
			ResultSet rs = stmt.executeQuery(QUERY_COUNT);
			if(rs.first())c = rs.getInt(1);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				stmt.close();				
				conn.close();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return c;
	}

	public DatabasesMysql getDb() {
		return db;
	}

	public void setDb(DatabasesMysql db) {
		this.db = db;
	}

	// team commission
	private static final String QUERY_COMM_TEAM = "select (N.COMMISSIONS) from NODE1 N where N.USER_ID =? and N.STATUS='A'";

	private int xBonus(long userId) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		int bonus = 0;
		try {
			pstmt = conn.prepareStatement(QUERY_COMM_TEAM);
			pstmt.setLong(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.first()) {
				bonus = rs.getInt(1);
			}
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
		return bonus;
	}

	// bonus header from inviter
	private static final String QUERY_COMM = "select sum(c) as x from NODE1 N1,(select N.COMMISSIONS as c, N.INVITER as inv,N.`STATUS` as st from NODE1 N) as m where c >"
			+ COMMISSION_BONUS
			+ " and st='A' and N1.STATUS='A' and inv =?  and N1.USER_ID=?";

	private int xBonus(long userId, String inviter) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		int bonus = 0;
		try {
			pstmt = conn.prepareStatement(QUERY_COMM);
			pstmt.setString(1, inviter);
			pstmt.setLong(2, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.first()) {
				bonus = rs.getInt(1);
				bonus /= 10;
			}
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
		return bonus;
	}

	private static final String QUERY_COMMISSIONS = "select COMMISSIONS,SMILE_VALUE,TOTAL_SV from NODE1 where USER_ID=?";

	private BeanClazz<Integer> com(long userId) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null;
		BeanClazz<Integer> b = new BeanClazz<Integer>(0, 0, 0);
		try {
			pstmt = conn.prepareStatement(QUERY_COMMISSIONS);
			pstmt.setLong(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.first()) {
				b.setArg0(rs.getInt(1));
				b.setArg1(rs.getInt(2));
				b.setArg2(rs.getInt(3));
			}
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
		return b;
	}

	private static final String QUERY_UPDATE_BONUS = "update USERS U,NODE1 N set U.BONUS_LAST=(U.BONUS_TEAM + U.BONUS_INV),U.LST_TOTAL_SV=N.TOTAL_SV,U.BONUS_TEAM = ?,U.BONUS_INV =? where U.USER_ID=N.USER_ID and U.USER_ID =?";
	
	private boolean updateBonus(int teamBonus, int headBonus, long userId) {
		Connection conn = getDb().connect();
		boolean b = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY_UPDATE_BONUS);
			pstmt.setInt(1, teamBonus);
			pstmt.setInt(2, headBonus);
			pstmt.setLong(3, userId);
			pstmt.executeUpdate();
			b = true;
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
		return b;
	}

	private static final String QUERY_CLEAR = "update NODE1 N  set N.COMMISSIONS=0 ,N.TOTAL_SV=0 ,N.`STATUS`='I',N.SMILE_VALUE=0 where N.USER_ID=?";
	private static final String QUERY_CLEAR2 = "update USERS U  set U.READED ="
			+ Boolean.TRUE + " where U.USER_ID=?";

	private void clear(long userId, String smileId) {
		Connection conn = getDb().connect();
		PreparedStatement pstmt = null, pstmt2 = null;
		try {
			pstmt = conn.prepareStatement(QUERY_CLEAR);
			pstmt.setLong(1, userId);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement(QUERY_CLEAR2);
			pstmt2.setLong(1, userId);
			pstmt2.executeUpdate();
		} catch (Exception e) {
			log.error("User :" + smileId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				pstmt2.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + smileId + " : " + e.getMessage(), e);
			}
		}
	}

	private static final String QUERY_INIT = "update USERS U  set U.READED ="
			+ Boolean.FALSE;
	private static final String QUERY_INIT_ORDER = "update ORDER1 O  set O.READED ="
			+ Boolean.TRUE;

	private void init() {
		Connection conn = getDb().connect();
		Statement stmt = null, stmt1 = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(QUERY_INIT);
			stmt1 = conn.createStatement();
			stmt1.executeUpdate(QUERY_INIT_ORDER);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				stmt.close();
				stmt1.close();
				conn.close();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private static final String QUERY_INSERT_BONUSPERIOD = "insert into BONUSPERIOD(USER_ID,BONUS_TEAMS,BONUS_INV,BONUS,COMMISSIONS,SMILE_VALUE,TOTAL_SV,DATE)VALUES(?,?,?,?,?,?,?,NOW())";

	private boolean insert(long userId, int bteams, int binv, int com, int sv,
			int totalSV) {
		Connection conn = getDb().connect();
		boolean b = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(QUERY_INSERT_BONUSPERIOD);
			pstmt.setLong(1, userId);
			pstmt.setInt(2, bteams);
			pstmt.setInt(3, binv);
			pstmt.setInt(4, bteams + binv);
			pstmt.setInt(5, com);
			pstmt.setInt(6, sv);
			pstmt.setInt(7, totalSV);
			pstmt.executeUpdate();
			b = true;
		} catch (Exception e) {
			log.error("User :" + userId + " : " + e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				log.error("User :" + userId + " : " + e.getMessage(), e);
			}
		}
		return b;
	}

	private void export() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select B.`DATE`,N.SMILE_ID,M.NAME,M.SURNAME,M.BANK_ACCOUNT,M.BANK,M.TYPE_ACCOUNT,M.BANK_BRANCE,B.BONUS into OUTFILE ")
				.append(" '/opt/bonus/")
				.append("smile_com_")
				.append(dateString())
				.append(".cvs' ")
				.append(" FIELDS TERMINATED BY ','  from USERS U,BONUSPERIOD B,USERS_DETAIL M,NODE1 N where U.USER_ID=N.USER_ID and U.USER_ID=B.USER_ID and U.DETAIL_ID=M.DETAIL_ID and B.`DATE`>SUBDATE(NOW(),INTERVAL 1 MONTH)");
		Connection conn = getDb().connect();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(sb.toString());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private static String dateString() {
		final String dateFormat = "MM:yyyy:dd-HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(dateFormat,
				Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(new Date());
	}
}
