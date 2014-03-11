package com.mlg.dao.exception;

/**
 * 配置信息错误异常
 * @author menglg
 *
 */
public class DbConfigException extends Exception {
	private static final long serialVersionUID = -947823071211643963L;

	public DbConfigException(String msg) {
		super(msg);
	}
}
