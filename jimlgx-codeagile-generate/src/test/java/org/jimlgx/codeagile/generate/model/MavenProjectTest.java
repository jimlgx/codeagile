/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenProjectTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.junit.Test;

/**
 * <code>MavenProjectTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class MavenProjectTest {

	/**
	 * <code>testGenerate</code>
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	@Test
	public void testGenerate() {

		MavenProject project = new MavenProject();

		project.setBaseDir(GenerateUtils.getBaseDir());
		project.setArtifactId("jimlgx-codeagile-demo");
		project.generate();

	}
}
