/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate
 * @file GenerateUtilsTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate;

import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>GenerateUtilsTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class GenerateUtilsTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void test1() {

		String text = GenerateUtils.getBaseDir();
		logger.debug("text = {}", text);
		text = GenerateUtils.buildBaseDir("test");
		logger.debug("text = {}", text);
		text = GenerateUtils.buildBaseDir("D:\\test");
		logger.debug("text = {}", text);
		
		text = GenerateUtils.buildBaseDir("classpath:test");
		
		logger.debug("text = {}", text);
	}
}
