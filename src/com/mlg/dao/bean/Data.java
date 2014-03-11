package com.mlg.dao.bean;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

/**
 * 数据库结果集的封装
 * @author menglg
 *
 */
public class Data {
	private static Logger logger = Logger.getRootLogger();
	private ResultSet rs;

	public Data(ResultSet rs) {
		this.rs = rs;
	}

	public Table getTable() {
		if (rs == null) {
			logger.warn("resultSet is null.return null.");
			return null;
		}
		Table res = new Table();
		while(rs.next()) {
			rs.getObject(columnIndex)
		}
		return res;
	}
}
