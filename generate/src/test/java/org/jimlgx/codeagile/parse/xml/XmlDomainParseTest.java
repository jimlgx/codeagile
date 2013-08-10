/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlDomainParseTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-22
 */
package org.jimlgx.codeagile.parse.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>XmlDomainParseTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-22
 */
public class XmlDomainParseTest {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected XmlDomainParse parse = null;

	/**
	 * <code>testparseDomains</code>
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 * @since 2013-7-11 wangjunming
	 */
	@Test
	public void testparseDomains() throws IOException, DocumentException {

		// String filePath =
		// "src/test/resources/data/xml/coder_project_module.xml";
		String filePath = "src/test/resources/data/xml/jimlgx-base-task.xml";

		File file = new File(filePath);
		parse = new XmlDomainParse(file);

		List<DomainModel> domains = parse.parse();

		logger.info("domains = {}", domains);
	}
}
