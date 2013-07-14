/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file Package.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.List;

/**
 * <code>Package</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public interface Package {

	/**
	 * <code>getName</code>
	 * 
	 * 
	 * 获得包名
	 * 
	 * @return
	 * @since 2013-7-14 wangjunming
	 */
	public String getName();

	/**
	 * <code>getJavaFiles</code>
	 * 
	 * @return
	 * @since 2013-7-14 wangjunming
	 */
	public List<JavaFile> getJavaFiles();

}
