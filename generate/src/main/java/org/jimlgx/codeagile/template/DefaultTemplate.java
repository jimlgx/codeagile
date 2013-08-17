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

		public static final String ACTION = "AbstractAction.ftl";
		public static final String DAO = "AbstractDao.ftl";
		public static final String MANAGER = "AbstractManager.ftl";
		public static final String SERVICE = "AbstractService.ftl";
		public static final String MODEL = "AbstractModel.ftl";

	}

	public static class MVC {

		public static final String ACTION = "MVCAction.ftl";
		public static final String MANAGER = "MVCManager.ftl";
		public static final String SERVICE = "MVCService.ftl";
		public static final String DAO = "MVCDao.ftl";
		public static final String MODEL = "MVCModel.ftl";

	}

	public static class PAGE {

		public static final String EDIT_NEW = "editNew.html";
		public static final String EDIT = "edit.html";
		public static final String INDEX = "index.html";
		public static final String LIST = "list.html";
		public static final String PAGE = "page.html";
		public static final String SEARCH = "search.html";

	}

	public static class TESTCASE {

		public static final String TEMPLATE_COMMON = "TemplateCommon.ftl";
		public static final String TEMPLATE_JUNIT_TEST = "TemplateJunitTest.ftl";
		public static final String TEMPLATE_SPRING_TEST = "TemplateSpringTest.ftl";
		public static final String TEMPLATE_STRUTS2_TEST = "TemplateStruts2Test.ftl";
		public static final String TEMPLATE_SUITE_TESTS = "TemplateSuiteTests.ftl";
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
		public static final String APPLICATION = "application.properties";
		public static final String JDBC = "jdbc.properties";
		public static final String LOG4J = "log4j.properties";
		public static final String FIELD = "field.properties";

	}

	public static class XML {
		public static final String pom = "pom.xml";
		public static final String web = "web.xml";
		public static final String struts = "struts.xml";
		public static final String webdefault = "webdefault.xml";
		public static final String log4j = "log4j.xml";

	}

}
