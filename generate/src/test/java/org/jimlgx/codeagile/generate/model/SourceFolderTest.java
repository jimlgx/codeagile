/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file SourceFolderTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-2
 */
package org.jimlgx.codeagile.generate.model;

import java.util.Map;

import org.junit.Test;

/**
 * <code>SourceFolderTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-2
 */
public class SourceFolderTest {

	@Test
	public void testgenerate() {
		// SourceFolder folder = new SourceFolder();
		Map<String, SourceFolder> map = SourceFolder
				.mapMavenSourceFolders("target");

		for (SourceFolder folder : map.values()) {
			folder.generate();
		}
	}
}
