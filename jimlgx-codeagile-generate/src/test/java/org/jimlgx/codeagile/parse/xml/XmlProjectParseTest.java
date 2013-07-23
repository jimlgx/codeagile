/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlProjectParseTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.jimlgx.codeagile.generate.model.MavenProject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>XmlProjectParseTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-23
 */
public class XmlProjectParseTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	XmlProjectParse parse = null;

	/**
	 * <code>testparse</code>
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 * @since 2013-7-11 wangjunming
	 */
	@Test
	public void testparse() throws IOException, DocumentException {

		String filePath = "src/test/resources/data/xml/coder_project_module.xml";
		File file = new File(filePath);
		parse = new XmlProjectParse(file);

		List<MavenProject> projects = parse.parse();

		logger.info("projects = {}", projects);
	}
}
