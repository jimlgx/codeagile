/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file PackageFolderTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-2
 */
package org.jimlgx.codeagile.generate.model;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * <code>PackageFolderTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-2
 */
public class PackageFolderTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	PackageFolder folder = new PackageFolder("org.jimlgx.showcase.demo1");

	@Before
	public void init() {
		folder.setBasedir("target");
	}

	@Test
	public void testgenerate() {
		logger.info("packages = {}", folder);
		folder.generate();
	}

	@Test
	public void testgenerate1() {

		PackageFolder folder2 = new PackageFolder(folder, "model");
		logger.info("packages = {}", folder2);
		folder2.generate();
	}

	@Test
	public void testcreateMVCPackages() {

		Map<String, PackageFolder> packages = ModuleUtils
				.createMVCPackages(folder);

		logger.info("packages = {}", packages);

		if (!CollectionUtils.isEmpty(packages)) {
			for (PackageFolder fileModel : packages.values()) {
				fileModel.generate();
			}
		}
	}
}
