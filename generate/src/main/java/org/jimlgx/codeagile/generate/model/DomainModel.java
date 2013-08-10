/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file DomainModel.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.util.List;

import org.jimlgx.codeagile.generate.MvcConstants;

/**
 * <code>DomainModel</code>
 * 
 * 模型对象
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-11
 */
public class DomainModel extends AbstractModel {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = 2170681849291764804L;
	/**
	 * MVCModule module :
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private MvcConstants module;
	/**
	 * List<ModelField> fields :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private List<ModelField> fields;

	/**
	 * String primaryKey :主键标志
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private String primaryKey;
	/**
	 * String extendsClass :继承类
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String extendsClass = "EntityLongImpl";

	/**
	 * @return the primaryKey
	 */
	public String getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * @param primaryKey
	 *            the primaryKey to set
	 */
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
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
	 * @return the fields
	 */
	public List<ModelField> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<ModelField> fields) {
		this.fields = fields;
	}

	/**
	 * @return the module
	 */
	public MvcConstants getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(MvcConstants module) {
		this.module = module;
	}

}
