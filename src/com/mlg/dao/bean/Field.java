package com.mlg.dao.bean;

import org.apache.log4j.Logger;

/**
 * 一个字段
 * @author menglg
 *
 */
public class Field {
	private static Logger logger = Logger.getRootLogger();

	private String fieldName;
	private Object value;

	public Field() {

	}

	public Field(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}

	public Field(String fieldName) {
		this.fieldName = fieldName;
	}

	public Field(Object value) {
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
