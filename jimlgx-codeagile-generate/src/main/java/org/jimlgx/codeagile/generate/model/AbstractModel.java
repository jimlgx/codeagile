/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file AbstractModel.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.io.Serializable;

/**
 * <code>AbstractModel</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-11
 */
public class AbstractModel implements Serializable {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	private static final long serialVersionUID = -6529236160284596075L;

	/**
	 * String name : 名称
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String name;
	/**
	 * String uniqueSign :唯一标志
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String uniqueSign;
	/**
	 * String description :描述
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String description;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the uniqueSign
	 */
	public String getUniqueSign() {
		return uniqueSign;
	}

	/**
	 * @param uniqueSign
	 *            the uniqueSign to set
	 */
	public void setUniqueSign(String uniqueSign) {
		this.uniqueSign = uniqueSign;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
