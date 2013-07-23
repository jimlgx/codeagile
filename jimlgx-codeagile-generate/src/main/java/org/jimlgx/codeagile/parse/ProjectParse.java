/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse
 * @file ProjectParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse;

import java.util.List;

import org.jimlgx.codeagile.generate.model.MavenProject;

/**
 * <code>ProjectParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-23
 */
public interface ProjectParse {
	/**
	 * <code>parse</code>
	 * 
	 * 解析MavenProject
	 * 
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	public List<MavenProject> parse();
}
