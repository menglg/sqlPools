package com.mlg.dao.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mlg.dao.exception.DbConfigException;

/**
 * 数据库相关信息的配置类。
 * @author menglg
 *
 */
public class Config {
	private static Logger logger = Logger.getRootLogger();
	/**
	 * 默认最大连接数为10
	 */
	public static final int DEFAULT_MAX_ACTIVE = 10;
	/**
	 * 默认最小连接数为2
	 */
	public static final int DEFAULT_MIN_ACTIVE = 2;
	/**
	 * 默认最大空闲时间为60（秒）
	 */
	public static final int DEFAULT_MAX_ACTIVE_TIME = 60;
	/**
	 * 最大连接数
	 */
	private int maxActive;
	/**
	 * 最小连接数
	 */
	private int minActive;
	/*
	 * 数据库url
	 */
	private String url;
	/**
	 * 数据库用户名
	 */
	private String user;
	/**
	 * 数据库密码
	 */
	private String passwd;
	/**
	 * 最大空闲时间
	 */
	private int maxActiveTime;
	/**
	 * 数据库的jdbc驱动
	 */
	private String className;

	/**
	 * 根据参数指定的文件进行配置参数解析
	 * @param file
	 * @throws DbConfigException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Config(File file) throws DbConfigException, FileNotFoundException, IOException {
		logger.debug("init config .");
		if (file == null) {
			throw new DbConfigException("db config properties file is not find.file is null.");
		}
		if (!file.exists() || !file.isFile()) {
			throw new DbConfigException("db config properties file is not find.path="
					+ file.toString());
		}
		logger.debug("config properties path is :" + file.toString());
		file.setReadOnly();
		Properties p = new Properties();
		p.load(new FileInputStream(file));
		if (p.isEmpty() || p.size() == 0) {
			throw new DbConfigException("db config properties file is empty or not exist");
		}
		this.maxActive = Integer.parseInt(p.getProperty("maxActive", DEFAULT_MAX_ACTIVE + ""));
		logger.debug("maxActive is :" + this.maxActive);
		this.minActive = Integer.parseInt(p.getProperty("minActive", DEFAULT_MIN_ACTIVE + ""));
		logger.debug("minActive is :" + this.minActive);
		this.maxActiveTime = Integer.parseInt(p.getProperty("maxActiveTime",
				DEFAULT_MAX_ACTIVE_TIME + ""));
		logger.debug("maxActiveTime is :" + this.maxActiveTime);
		this.url = p.getProperty("url", null);
		if (!isUrl(this.url)) {
			throw new DbConfigException("db url error.url=" + this.url);
		}
		logger.debug("url is :" + this.url);
		this.user = p.getProperty("user", null);
		if (user == null || user.length() == 0) {
			throw new DbConfigException("db user error.user is null.");
		}
		logger.debug("user is :" + this.user);
		this.passwd = p.getProperty("passwd", null);
		if (this.passwd == null || this.passwd.length() == 0) {
			throw new DbConfigException("db passwd error.passwd is null.");
		}
		logger.debug("passwd is :********");
		this.className = p.getProperty("className", null);
		if (isClassName(className)) {
			throw new DbConfigException("jdbc className error.className=" + this.className);
		}
		logger.debug("className is :" + this.className);
	}

	/**
	 * 判断是否是常见jdbc驱动，只验证是否为null，长度是否大于5，以及是否包含“.”
	 * @param className
	 * @return
	 */
	private static boolean isClassName(String className) {
		if (className == null || className.length() <= 5)
			return false;
		if (className.indexOf(".") == -1) {
			return false;
		}
		return true;
	}

	/**
	 * 验证是否是数据库的url，只验证长度，是否为null，以及是否有jdbc:
	 * @param url
	 * @return
	 */
	private static boolean isUrl(String url) {
		if (url == null || url.length() <= 5)
			return false;
		if (url.indexOf("jdbc:") == -1)
			return false;
		return true;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMinActive() {
		return minActive;
	}

	public void setMinActive(int minActive) {
		this.minActive = minActive;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getMaxActiveTime() {
		return maxActiveTime;
	}

	public void setMaxActiveTime(int maxActiveTime) {
		this.maxActiveTime = maxActiveTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
