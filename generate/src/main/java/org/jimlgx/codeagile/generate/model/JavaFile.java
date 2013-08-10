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

import org.apache.commons.lang3.StringUtils;

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
	 * String simpleName :类名简称
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String simpleName;

	/**
	 * String extendsClass :继承的类名
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String extendsClass;
	/**
	 * String modifiers : 修饰符
	 * 
	 * @since 2013-7-19 wangjunming
	 */
	private String modifiers = "public";

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
	 * @return the modifiers
	 */
	public String getModifiers() {
		return modifiers;
	}

	/**
	 * @param modifiers
	 *            the modifiers to set
	 */
	public void setModifiers(String modifiers) {
		this.modifiers = modifiers;
	}

	/**
	 * @return the simpleName
	 */
	public String getSimpleName() {
		if (StringUtils.isEmpty(simpleName)) {
			return this.getCode();
		}
		return simpleName;
	}

	/**
	 * @param simpleName
	 *            the simpleName to set
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
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

	/**
	 * <code>getPackages</code>
	 * 
	 * @return
	 * @since 2013-8-10 wangjunming
	 */
	public String getPackages() {
		if (this.getPackageFolder() != null) {
			return getPackageFolder().getCode();
		}
		return StringUtils.EMPTY;
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
