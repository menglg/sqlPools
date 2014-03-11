package com.mlg.dao.bean;

import org.apache.log4j.Logger;

import com.mlg.dao.exception.DbDataException;

/**
 * 一行数据
 * @author menglg
 *
 */
public class Row {
	private static Logger logger = Logger.getRootLogger();

	private Field fields[];
	private int length;

	public Row() {

	}

	public Row(int length) throws DbDataException {
		if (length <= 0)
			throw new DbDataException("error row length.length=" + length);
		this.fields = new Field[length];
		this.length = length;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
