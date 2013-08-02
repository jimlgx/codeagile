/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file FileModelTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/**
 * <code>FileModelTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-1
 */
public class FileModelTest {

	@Test
	public void testgenerate() {

		FileModel model = new FileModel("test.txt");

		model.setBasedir("target");
		model.generate();

		// model.remove();

		// FilenameUtils.getExtension(filename)
	}
}
