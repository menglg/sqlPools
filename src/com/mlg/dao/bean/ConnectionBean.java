package com.mlg.dao.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * 数据库操作的各种方法封装
 * @author menglg
 *
 */
public class ConnectionBean {
	private static Logger logger = Logger.getRootLogger();
	private Connection conn;
	private String url;
	private String user;
	private String password;
	private long updateTime;

	public ConnectionBean(String url, String user, String password) throws SQLException {
		if (conn != null || !conn.isClosed()) {
			destroy();
		}
		this.url = url;
		this.user = user;
		this.password = password;
		conn = DriverManager.getConnection(url, user, password);
	}
	
	public void release() {
		
	}

	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("destroy conn error.", e);
		} finally {
			conn = null;
		}
	}

}
