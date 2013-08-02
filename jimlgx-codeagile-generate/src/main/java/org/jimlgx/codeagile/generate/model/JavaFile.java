/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file JavaFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>JavaFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class JavaFile extends FileModel {
	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private static final long serialVersionUID = 2602095103265813886L;

	/**
	 * String simpleNam :类名简称
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String simpleNam;

	/**
	 * String extendsClass :继承的类名
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String extendsClass;
	/**
	 * String modifier : 修饰符
	 * 
	 * @since 2013-7-19 wangjunming
	 */
	private String modifier;

	/**
	 * List<String> implClass : 实现的接口
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<String> implClass = new ArrayList<String>();
	/**
	 * List<String> importClass :引入的classes
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<String> importClass = new ArrayList<String>();;

	/**
	 * Package _package :包结构
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private PackageFolder packageFolder;

	/**
	 * @return the packageFolder
	 */
	public PackageFolder getPackageFolder() {
		return packageFolder;
	}

	/**
	 * @param packageFolder
	 *            the packageFolder to set
	 */
	public void setPackageFolder(PackageFolder packageFolder) {
		this.packageFolder = packageFolder;
		this.setBasedir(packageFolder.getPath());
	}

	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * @param modifier
	 *            the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	/**
	 * @return the simpleNam
	 */
	public String getSimpleNam() {
		return simpleNam;
	}

	/**
	 * @param simpleNam
	 *            the simpleNam to set
	 */
	public void setSimpleNam(String simpleNam) {
		this.simpleNam = simpleNam;
	}

	/**
	 * @return the extendsClass
	 */
	public String getExtendsClass() {
		return extendsClass;
	}

	/**
	 * @param extendsClass
	 *            the extendsClass to set
	 */
	public void setExtendsClass(String extendsClass) {
		this.extendsClass = extendsClass;
	}

	/**
	 * @return the implClass
	 */
	public List<String> getImplClass() {
		return implClass;
	}

	/**
	 * @param implClass
	 *            the implClass to set
	 */
	public void setImplClass(List<String> implClass) {
		this.implClass = implClass;
	}

	/**
	 * @return the importClass
	 */
	public List<String> getImportClass() {
		return importClass;
	}

	/**
	 * @param importClass
	 *            the importClass to set
	 */
	public void setImportClass(List<String> importClass) {
		this.importClass = importClass;
	}

	/**
	 * <code>getExtension</code>
	 * 
	 * @return
	 * @since 2013-8-2 wangjunming
	 */
	@Override
	public String getExtension() {
		return ".java";
	}

	public SourceFolder getSourceFolder() {
		if (this.getPackageFolder() != null) {
			this.getPackageFolder().getSourceFolder();
		}
		return null;
	}

	public MavenProject getProject() {
		if (this.getSourceFolder() != null) {
			this.getSourceFolder().getProject();
		}
		return null;
	}
}
