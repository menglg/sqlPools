package com.mlg.dao.bean;

import org.apache.log4j.Logger;

import com.mlg.dao.exception.DbDataException;

/**
 * 一个表的数据封装
 * @author menglg
 *
 */
public class Table {
	private static Logger logger = Logger.getRootLogger();
	private Row rows[];
	private int length;

	public Table() {

	}

	public Table(int length) throws DbDataException {
		if (length <= 0)
			throw new DbDataException("error table length.length=" + length);
		this.rows = new Row[length];
		this.length = length;
	}

	public Row[] getRows() {
		return rows;
	}

	public void setRows(Row[] rows) {
		this.rows = rows;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
