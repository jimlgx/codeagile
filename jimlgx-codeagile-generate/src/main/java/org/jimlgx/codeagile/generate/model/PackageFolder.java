/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file PackageFolder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>PackageFolder</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class PackageFolder extends Folder implements Package {

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
	 * List<FileModel> fileModels :其它文件
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private List<FileModel> fileModels = new ArrayList<FileModel>();

	/**
	 * @return the fileModels
	 */
	public List<FileModel> getFileModels() {
		return fileModels;
	}

	/**
	 * @param fileModels
	 *            the fileModels to set
	 */
	public void setFileModels(List<FileModel> fileModels) {
		this.fileModels = fileModels;
	}

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

	public PackageFolder(PackageFolder folder, String code) {
		super(folder.getCode() + "." + code);

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

		for (JavaFile javaFile : javaFiles) {
			javaFile.setPackageFolder(this);
		}
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("{} generate", this);
		for (JavaFile javaFile : javaFiles) {
			javaFile.generate();
		}
	}

}
