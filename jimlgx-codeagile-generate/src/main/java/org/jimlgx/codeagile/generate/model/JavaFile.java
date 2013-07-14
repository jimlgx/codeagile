/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file JavaFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.List;

/**
 * <code>JavaFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class JavaFile extends FileModel {
	/** 
	 * long serialVersionUID :       
	 * @since  2013-7-14 wangjunming
	 */
	private static final long serialVersionUID = 2602095103265813886L;

	/**
	 * String simpleNam :类名简称
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String simpleNam;

	/**
	 * String extendsClass :继承的类名
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String extendsClass;
	/**
	 * List<String> implClass : 实现的接口
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<String> implClass;
	/**
	 * List<String> importClass :引入的classes
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<String> importClass;

	/**
	 * Package _package :包结构
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private Package _package;

	/**
	 * @return the simpleNam
	 */
	public String getSimpleNam() {
		return simpleNam;
	}

	/**
	 * @param simpleNam
	 *            the simpleNam to set
	 */
	public void setSimpleNam(String simpleNam) {
		this.simpleNam = simpleNam;
	}

	/**
	 * @return the extendsClass
	 */
	public String getExtendsClass() {
		return extendsClass;
	}

	/**
	 * @param extendsClass
	 *            the extendsClass to set
	 */
	public void setExtendsClass(String extendsClass) {
		this.extendsClass = extendsClass;
	}

	/**
	 * @return the implClass
	 */
	public List<String> getImplClass() {
		return implClass;
	}

	/**
	 * @param implClass
	 *            the implClass to set
	 */
	public void setImplClass(List<String> implClass) {
		this.implClass = implClass;
	}

	/**
	 * @return the importClass
	 */
	public List<String> getImportClass() {
		return importClass;
	}

	/**
	 * @param importClass
	 *            the importClass to set
	 */
	public void setImportClass(List<String> importClass) {
		this.importClass = importClass;
	}

	/**
	 * @return the _package
	 */
	public Package getPackage() {
		return _package;
	}

	/**
	 * @param _package
	 *            the _package to set
	 */
	public void setPackage(Package _package) {
		this._package = _package;
	}
}
