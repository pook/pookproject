package biz.evolix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import biz.evolix.connect.DatabasesMysql;
public class Main {
	public static void main(String... args) throws FileNotFoundException, IOException {
		Properties conf = new Properties();		
		conf.load(new FileInputStream("mysql.properties")); 
		DatabasesMysql db = new DatabasesMysql(
				conf.getProperty("url"), conf.getProperty("user"), conf.getProperty("passwd"));		
		UserCommission users = new UserCommission(db);
		users.execute();
	}
}
