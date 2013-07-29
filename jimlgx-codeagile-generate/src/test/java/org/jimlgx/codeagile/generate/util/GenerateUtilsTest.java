/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.util
 * @file GenerateUtilsTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-29
 */
package org.jimlgx.codeagile.generate.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>GenerateUtilsTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-29
 */
public class GenerateUtilsTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testgetUserDir() {

		String userdir = GenerateUtils.getUserDir();
		logger.debug("userdir = {}", userdir);
	}

	@Test
	public void testbuildBasedir() {

		String basedir = GenerateUtils.buildBasedir("base");
		logger.debug("basedir = {}", basedir);
	}

	@Test
	public void testcreateNewFile() {
		File file = new File(GenerateUtils.buildBasedir("target\\test.txt"));

		// FileUtils.class
		GenerateUtils.createNewFile(file);
	}

	@Test
	public void testcreateFileDirectory() {
		File file = new File(GenerateUtils.buildBasedir("target\\test"));
		
		// FileUtils.class
		GenerateUtils.createFileDirectory(file);
	}
}
