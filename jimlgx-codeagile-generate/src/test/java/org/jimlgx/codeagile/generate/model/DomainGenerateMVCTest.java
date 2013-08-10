/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file DomainGenerateMVCTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-10
 */
package org.jimlgx.codeagile.generate.model;

import org.junit.Test;

/**
 * <code>DomainGenerateMVCTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-10
 */
public class DomainGenerateMVCTest {

	/**
	 * <code>testgenerate</code>
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	@Test
	public void testgenerate() {
		MVCModule mvcModule = new MVCModule("test");
		DomainGenerateMVC generateMVC = new DomainGenerateMVC(mvcModule);

		DomainModel domainModel = new DomainModel();

		generateMVC.generate(domainModel);
	}
}
