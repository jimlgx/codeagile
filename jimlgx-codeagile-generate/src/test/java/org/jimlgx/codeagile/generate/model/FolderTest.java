/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file FolderTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import org.junit.Test;

/**
 * <code>FolderTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-1
 */
public class FolderTest {

	@Test
	public void testgenerate() {

		Folder folder = new Folder("target");

		folder.setFileModels(FileModel.mapMavneFile("target"));

		folder.setFolders(Folder.mapDocFolder());
		folder.generate();

	}
}
