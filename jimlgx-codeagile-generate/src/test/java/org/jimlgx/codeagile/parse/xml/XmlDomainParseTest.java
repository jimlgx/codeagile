/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlDomainParseTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-22
 */
package org.jimlgx.codeagile.parse.xml;

import java.io.IOException;

import org.dom4j.DocumentException;
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
	Logger logger = LoggerFactory.getLogger(getClass());

	XmlDomainParse parse = null;

	/**
	 * <code>testparseDomains</code>
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 * @since 2013-7-11 wangjunming
	 */
	@Test
	public void testparseDomains() throws IOException, DocumentException {

		String filePath = "src/test/resources/data/xml/coder_project_module.xml";

		// File file = new File(filePath);
		// parse = new XmlDomainParse(file);
		//
		// List<DomainModel> domains = parse.parseDomains();
		//
		// logger.info("domains = {}", domains);
	}
}
