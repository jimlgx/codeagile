/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenProjectTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>MavenProjectTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class MavenProjectTest {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * <code>testGenerate</code>
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	@Test
	public void testGenerate() {

		MavenProject project = new MavenProject();

		// project.setBasedir(GenerateUtils.getUserDir());
		project.setBasedir("target");

		project.setArtifactId("jimlgx-codeagile-demo");
		project.setCode("base/demo");

		Map<String, SourceFolder> sourceFolders = SourceFolder
				.mapMavenSourceFolders(project.getBasedir() + project.getCode());
		project.setSourceFolders(sourceFolders);

		Map<String, FileModel> fileModels = new HashMap<String, FileModel>();

		project.setFileModels(fileModels);
		// project.defaultFloder();
		project.generate();

	}
}
