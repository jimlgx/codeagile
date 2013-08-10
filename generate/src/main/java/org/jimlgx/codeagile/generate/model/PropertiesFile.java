/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file PropertiesFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-31
 */
package org.jimlgx.codeagile.generate.model;

import java.util.Properties;

/**
 * <code>PropertiesFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-31
 */
public class PropertiesFile extends FileModel {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private static final long serialVersionUID = -3925569116779853679L;

	/**
	 * Properties properties :
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private Properties properties = new Properties();
	/**
	 * Package _package :包结构
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private PackageFolder packageFolder;

	/**
	 * @return the packageFolder
	 */
	public PackageFolder getPackageFolder() {
		return packageFolder;
	}

	/**
	 * @param packageFolder
	 *            the packageFolder to set
	 */
	public void setPackageFolder(PackageFolder packageFolder) {
		this.packageFolder = packageFolder;
	}

	/**
	 * 
	 */
	public PropertiesFile() {
		super();
	}

	/**
	 * @param code
	 * @param template
	 */
	public PropertiesFile(String code, String template) {
		super(code, template);
	}

	/**
	 * @param code
	 */
	public PropertiesFile(String code) {
		super(code);
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
