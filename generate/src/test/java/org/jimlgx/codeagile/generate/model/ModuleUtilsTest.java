/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file ModuleUtilsTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * <code>ModuleUtilsTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-1
 */
public class ModuleUtilsTest {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testbuildFolderCode() {

		String folder = ModuleUtils.buildFolderCode("org.jimlgx.codeagile");
		logger.info("folder = {}", folder);
	}

	@Test
	public void testcreateMVCPackages() {

		PackageFolder folder = new PackageFolder("org.jimlgx.showcase.demo1");
		folder.setBasedir("target");
		Map<String, PackageFolder> packages = ModuleUtils
				.createMVCPackages(folder);

		logger.info("packages = {}", packages);

	}
}
