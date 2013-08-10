/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse
 * @file DomainParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-11
 */
package org.jimlgx.codeagile.parse;

import java.util.List;

import org.jimlgx.codeagile.generate.model.DomainModel;

/**
 * <code>DomainParse</code>
 * 
 * 解析出 DomainModel
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-11
 */
public interface DomainParse {
	/**
	 * <code>parse</code>
	 * 
	 * 解析Domains
	 * 
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	public List<DomainModel> parse();
}
