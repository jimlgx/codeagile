/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MVCModuleTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-2
 */
package org.jimlgx.codeagile.generate.model;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>MVCModuleTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-2
 */
public class MVCModuleTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	MVCModule folder = new MVCModule("demomodeule");

	@Before
	public void init() {
		folder.setBasedir("target");

	}

	@Test
	public void testgenerate() {
		folder.generate();

	}

	@Test
	public void testgenerate2() {
		MavenProject project = new MavenProject("jimlg-showcase-demo");
		project.setBasedir("target");
		folder.setProject(project);
		folder.generate();

	}
}
