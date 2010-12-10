package biz.evolix.connect;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DatabasesMysql {
	private static Logger log = Logger.getLogger(DatabasesMysql.class);
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public DatabasesMysql(String connection,String username,String passwd){
		this.connection=connection;
		this.username = username;
		this.passwd = passwd;
	}
	public DatabasesMysql(){
		
	}
	public String connection;
	public String username;
	public String passwd;
	public Connection connect(){
		try{
			Class.forName(MYSQL_DRIVER);
			Connection conn = DriverManager.getConnection(this.connection, this.username,this.passwd);
			return conn;
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	public Connection connect(String connection,String user,String passwd){
		try{
			Class.forName(MYSQL_DRIVER);
			Connection conn = DriverManager.getConnection(connection, user,passwd);
			return conn;
		}catch (Exception e) {
			System.err.println("can't connection!!");
		}
		return null;

	}
}
