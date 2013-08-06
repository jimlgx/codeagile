/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file PackageFolder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import hidden.org.codehaus.plexus.interpolation.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.springframework.util.CollectionUtils;

/**
 * <code>PackageFolder</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class PackageFolder extends Folder {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = 777515909524858649L;

	/**
	 * SourceFolder sourceFolder :源码目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private SourceFolder sourceFolder;
	/**
	 * List<JavaFile> javaFiles :类文件
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<JavaFile> javaFiles = new ArrayList<JavaFile>();

	/**
	 * 
	 */
	public PackageFolder() {
		super();
	}

	/**
	 * @param code
	 */
	public PackageFolder(String code) {
		super(code);
	}

	public PackageFolder(PackageFolder parent, String code) {

		super(parent.getCode() + "." + code);

		// 设置 basedir
		this.setBasedir(parent.getBasedir());
		this.setSourceFolder(parent.getSourceFolder());

	}

	/**
	 * <code>getJavaFiles</code>
	 * 
	 * @return
	 * @since 2013-7-14 wangjunming
	 */
	public List<JavaFile> getJavaFiles() {
		return this.javaFiles;
	}

	/**
	 * @return the sourceFolder
	 */
	public SourceFolder getSourceFolder() {
		return sourceFolder;
	}

	/**
	 * @param sourceFolder
	 *            the sourceFolder to set
	 */
	public void setSourceFolder(SourceFolder sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	/**
	 * @param javaFiles
	 *            the javaFiles to set
	 */
	public void setJavaFiles(List<JavaFile> javaFiles) {
		this.javaFiles = javaFiles;

		if (!CollectionUtils.isEmpty(this.javaFiles)) {
			for (JavaFile javaFile : this.javaFiles) {
				javaFile.setPackageFolder(this);
			}
		}
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("generate {} ", this.getPath());
		generatePacakgeFolder();
		for (JavaFile javaFile : javaFiles) {
			javaFile.generate();
		}
	}

	/**
	 * <code>getPath</code>
	 * 
	 * 返回 package名称对应的目录文件结构
	 * 
	 * @return
	 * @since 2013-8-2 wangjunming
	 */
	@Override
	public String getPath() {

		String folderCode = ModuleUtils.buildFolderCode(this.getCode());

		return getBasedir() + folderCode;
	}

	/**
	 * <code>generatePacakgeFolder</code>
	 * 
	 * @since 2013-8-2 wangjunming
	 */
	private void generatePacakgeFolder() {

		GenerateUtils.createFileDirectory(new File(getPath()));

	}

}
