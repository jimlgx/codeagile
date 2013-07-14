/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file Folder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.io.File;

import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.springframework.util.Assert;

/**
 * <code>Folder</code>
 * 
 * 文件夹 目录
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class Folder extends AbstractModel implements Generate {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = -6733067602012379748L;

	/**
	 * File file :文件对象
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private File file;

	/**
	 * String BaseDir :父目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String baseDir;

	/**
	 * @return the BaseDir
	 */
	public String getBaseDir() {
		Assert.notNull(baseDir, "please set BaseDir");
		return baseDir;
	}

	/**
	 * @param BaseDir
	 *            the BaseDir to set
	 */
	public void setBaseDir(String baseDir) {
		Assert.notNull(baseDir, "baseDir not null");
		this.baseDir = baseDir;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * <code>generateFolder</code>
	 * 
	 * 生成目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	public void generateFolder() {
		GenerateUtils.createFile(new File(getBaseDir(), this.getCode()));

	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		// TODO Auto-generated method stub
		logger.debug("{} generate", this);
		generateFolder();
	}
}
