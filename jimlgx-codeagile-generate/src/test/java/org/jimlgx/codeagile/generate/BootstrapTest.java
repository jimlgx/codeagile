/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate
 * @file BootstrapTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-29
 */
package org.jimlgx.codeagile.generate;

import org.junit.Test;

/**
 * <code>BootstrapTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-29
 */
public class BootstrapTest {

	/**
	 * <code>testGenerate</code>
	 * 
	 * @since 2013-7-29 wangjunming
	 */
	@Test
	public void testGenerate() {
		String filePath = "src/test/resources/data/xml/jimlgx-base-task.xml";
		Bootstrap.generage(filePath);
	}
}
