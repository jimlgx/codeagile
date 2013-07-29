/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate
 * @file Bootstrap.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-17
 */
package org.jimlgx.codeagile.generate;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.jimlgx.codeagile.generate.model.MavenProject;
import org.jimlgx.codeagile.parse.ParseUtils;
import org.jimlgx.codeagile.parse.xml.XmlProjectParse;

/**
 * <code>Bootstrap</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-17
 */
public class Bootstrap {

	// /**
	// * <code>main</code>
	// *
	// * @param args
	// * @since 2013-7-29 wangjunming
	// */
	// public static void main(String[] args) {
	//
	//
	// }

	/**
	 * <code>generage</code>
	 * 
	 * @param filePath
	 * @since 2013-7-29 wangjunming
	 */
	public static void generage(String filePath) {
		// String filePath = "src/test/resources/data/xml/jimlgx-base-task.xml";

		File file = new File(filePath);

		Document document = ParseUtils.loadAsDocument(file);

		XmlProjectParse parse = new XmlProjectParse(document.getRootElement());

		List<MavenProject> projects = parse.parse();

		for (MavenProject mavenProject : projects) {
			mavenProject.generate();
		}
	}
}
