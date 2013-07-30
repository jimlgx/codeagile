/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenModule.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.util.List;

/**
 * <code>MavenModule</code>
 * 
 * 定义一个模块
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-11
 */
public class MavenModule extends MavenProject {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = -611759642951309378L;

	/**
	 * 
	 */
	public MavenModule() {
		super();
	}

	/**
	 * MavenModule parent :父结构
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private MavenModule parentModule;

	
	/**
	 * @return the parentModule
	 */
	public MavenModule getParentModule() {
		return parentModule;
	}

	/**
	 * @param parentModule
	 *            the parentModule to set
	 */
	public void setParentModule(MavenModule parentModule) {
		this.parentModule = parentModule;
	}
}
