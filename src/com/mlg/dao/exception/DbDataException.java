package com.mlg.dao.exception;

/**
 * 数据异常
 * @author menglg
 *
 */
public class DbDataException extends Exception {
	private static final long serialVersionUID = 6635266029165365034L;

	public DbDataException(String msg) {
		super(msg);
	}
}
