/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file JavaDomainFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

/**
 * <code>JavaDomainFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class JavaDomainFile extends JavaFile {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private static final long serialVersionUID = -1758005973976383665L;
	/**
	 * DomainModel domainModel :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private DomainModel domainModel;

	/**
	 * String tableName :对应表名称
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String tableName;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the domainModel
	 */
	public DomainModel getDomainModel() {
		return domainModel;
	}

	/**
	 * @param domainModel
	 *            the domainModel to set
	 */
	public void setDomainModel(DomainModel domainModel) {
		this.domainModel = domainModel;
	}

}
