package edu.ssafy.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
	
	public static final String DRIVERCLASSNAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/memberdb?serverTimezone=UTC";
	public static final String USER = "ssafy";
	public static final String PASSWORD = "ssafy";
	public static DataSource ds;
	
	static {
		
		// jdbc 설정
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(DRIVERCLASSNAME);
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		
		// datasource 설정
		config.setMaximumPoolSize(5);
		config.setMinimumIdle(3);
		config.setIdleTimeout(1000 * 60 * 10);
		config.setConnectionTimeout(1000 * 60 * 10);
		ds = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void close(AutoCloseable... closeable) {
		for (AutoCloseable close : closeable) {
			try {
				close.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
