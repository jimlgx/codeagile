/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.template
 * @file DefaultTemplate.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-29
 */
package org.jimlgx.codeagile.template;

/**
 * <code>DefaultTemplate</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-29
 */
public class DefaultTemplate {

	public static final String EMPTY = "empty.txt";

	public static class ABSTRACT {

		public static final String Action = "AbstractAction.ftl";
		public static final String Dao = "AbstractDao.ftl";
		public static final String Manager = "AbstractManager.ftl";
		public static final String Model = "AbstractModel.ftl";

	}

	public static class MVC {

		public static final String Action = "MVCAction.ftl";
		public static final String Manager = "MVCManager.ftl";
		public static final String Service = "MVCService.ftl";
		public static final String Dao = "MVCDao.ftl";
		public static final String Model = "MVCModel.ftl";

	}

	public static class PAGE {

		public static final String editNew = "editNew.html";
		public static final String edit = "edit.html";
		public static final String index = "index.html";
		public static final String list = "list.html";
		public static final String page = "page.html";
		public static final String search = "search.html";

	}

	public static class TESTCASE {

		public static final String TemplateCommon = "TemplateCommon.ftl";
		public static final String TemplateJunitTest = "TemplateJunitTest.ftl";
		public static final String TemplateSpringTest = "TemplateSpringTest.ftl";
		public static final String TemplateStruts2Test = "TemplateStruts2Test.ftl";
		public static final String TemplateSuiteTests = "TemplateSuiteTests.ftl";
	}

	/**
	 * <code>PROPERTIES</code>
	 * 
	 * 属性文件 配置
	 * 
	 * @version 1.0
	 * @author wangjunming
	 * @since 1.0 2013-7-29
	 */
	public static class PROPERTIES {
		public static final String application = "application.properties";
		public static final String jdbc = "jdbc.properties";
		public static final String log4j = "log4j.properties";
		public static final String field = "field.properties";

	}

	public static class XML {
		public static final String pom = "pom.xml";
		public static final String web = "web.xml";
		public static final String struts = "struts.xml";
		public static final String webdefault = "webdefault.xml";
		public static final String log4j = "log4j.xml";

	}

}
