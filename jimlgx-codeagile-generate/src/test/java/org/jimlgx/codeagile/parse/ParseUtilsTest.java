/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse
 * @file ParseUtilsTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-25
 */
package org.jimlgx.codeagile.parse;

import java.lang.reflect.Method;

import org.jimlgx.codeagile.generate.model.MavenProject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * <code>ParseUtilsTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-25
 */
public class ParseUtilsTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	MavenProject modle = new MavenProject();

	@Test
	public void testfindMethod() {
		String name = "getName";
		Method method = ParseUtils.findMethod(modle, name);

		logger.info("method = {}", method);
		name = "setName";
		method = ParseUtils.findMethod(modle, name);

		logger.info("method = {}", method);
	}

	@Test
	public void testfindMethod1() {
		MavenProject modle = new MavenProject();
		String name = "getName";
		Method method = ParseUtils.findMethod(modle, name);

		logger.info("method = {}", method);
		name = "setName";
		method = ParseUtils.findMethod(modle, name);

		logger.info("method = {}", method);
	}

	@Test
	public void testfindMethod_Spring() {

		Method method = ReflectionUtils.findMethod(modle.getClass(), "getName");

		Method method2 = ReflectionUtils
				.findMethod(modle.getClass(), "setName");

		logger.info("method = {}", method);

		logger.info("method2 = {}", method2);

	}
}
