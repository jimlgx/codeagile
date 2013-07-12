/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file DomainField.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

/**
 * <code>DomainField</code>
 * 
 * 模型属性
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class ModelField extends AbstractModel {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private static final long serialVersionUID = -5743652320301313599L;

	/**
	 * DomainModel domain :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private DomainModel domain;

	/**
	 * Object defaultValue :属性默认值
	 * 
	 * 属性值的类型对应于 Field的类型
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private Object defaultValue;
	/**
	 * String dataType :数据类型
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private String dataType;
	/**
	 * String javaType :映射的java类型
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private String javaType;
	/**
	 * Integer length :数据长度
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private Integer length;
	/**
	 * boolean primaryKey :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private boolean primaryKey;

	/**
	 * 
	 */
	public ModelField() {
		super();
	}

	/**
	 * @return the domain
	 */
	public DomainModel getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(DomainModel domain) {
		this.domain = domain;
	}

	/**
	 * @return the defaultValue
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue
	 *            the defaultValue to set
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @return the javaType
	 */
	public String getJavaType() {
		return javaType;
	}

	/**
	 * @param javaType
	 *            the javaType to set
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/**
	 * @return the primaryKey
	 */
	public boolean isPrimaryKey() {
		return primaryKey;
	}

	/**
	 * @param primaryKey
	 *            the primaryKey to set
	 */
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
}
