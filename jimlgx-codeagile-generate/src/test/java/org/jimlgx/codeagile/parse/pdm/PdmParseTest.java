/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.pdm
 * @file PdmParseTest.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-11
 */
package org.jimlgx.codeagile.parse.pdm;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>PdmParseTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-11
 */
public class PdmParseTest {
	Logger logger = LoggerFactory.getLogger(getClass());

	PdmDomainParse parse = null;

	/**
	 * <code>testparseDomains</code>
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 * @since 2013-7-11 wangjunming
	 */
	@Test
	public void testparseDomains() throws IOException, DocumentException {

		String filePath = "src/test/resources/data/pdm/TestModel.pdm";
		File file = new File(filePath);
		parse = new PdmDomainParse(file);

		List<DomainModel> domains = parse.parse();

		logger.info("domains = {}", domains);
	}

}
