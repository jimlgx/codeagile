/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file JavaTestFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-11
 */
package org.jimlgx.codeagile.generate.model;

/**
 * <code>JavaTestFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-11
 */
public class JavaTestFile extends JavaDomainFile {
	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-8-11 wangjunming
	 */
	private static final long serialVersionUID = 227985338286266557L;
	/**
	 * String testClass : 测试的类
	 * 
	 * @since 2013-8-11 wangjunming
	 */
	private String testClass;

	/**
	 * 
	 */
	public JavaTestFile() {
		super();
	}

	/**
	 * @param domainModel
	 */
	public JavaTestFile(DomainModel domainModel) {
		super(domainModel);
	}

	/**
	 * @return the testClass
	 */
	public String getTestClass() {
		return testClass;
	}

	/**
	 * @param testClass
	 *            the testClass to set
	 */
	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	/**
	 * <code>getTestClassField</code>
	 * 
	 * @return
	 * @since 2013-8-11 wangjunming
	 */
	public String getTestClassField() {
		StringBuffer sb = new StringBuffer();
		if (testClass != null) {
			sb.append("protected ");
			sb.append(testClass);
			sb.append(" ");
			sb.append(ModuleUtils.standardizationObjecjtName(testClass));
		} else {
			throw new RuntimeException("the testClass not null!");
		}
		return sb.toString();
	}
}
