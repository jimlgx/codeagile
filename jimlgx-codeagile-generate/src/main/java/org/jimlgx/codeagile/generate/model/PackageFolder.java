/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file PackageFolder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

/**
 * <code>PackageFolder</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class PackageFolder extends Folder implements Package {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = 777515909524858649L;

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		// TODO Auto-generated method stub
		logger.debug("{} generate", this);
	}
}
