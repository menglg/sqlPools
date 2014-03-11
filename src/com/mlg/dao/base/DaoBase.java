package com.mlg.dao.base;

import java.sql.Connection;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.mlg.dao.bean.ConnectionBean;

/**
 * 数据库连接池的封装
 * @author menglg
 *
 */
public class DaoBase {
	private static Logger logger = Logger.getRootLogger();
	/**
	 * 储存数据库链接的堆栈
	 */
	private static Stack<ConnectionBean> conns = null;

	private static Connection getConn() {
//		conns.
		return null;
	}
}
