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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	 * String Basedir :当前目录 ${basedir}
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String basedir = StringUtils.EMPTY;

	/**
	 * 
	 */
	public Folder() {
	}

	/**
	 * @param code
	 */
	public Folder(String code) {
		super();
		this.setCode(code);

	}

	/**
	 * @return the Basedir
	 */
	public String getBasedir() {
		Assert.notNull(basedir, "please set dasedir");
		this.basedir = GenerateUtils.buildBasedir(basedir);
		return basedir;
	}

	/**
	 * @param Basedir
	 *            the Basedir to set
	 */
	public void setBasedir(String basedir) {
		Assert.notNull(basedir, "basedir not null");
		this.basedir = basedir;
	}

	/**
	 * <code>getPath</code>
	 * 
	 * 获得该目录路径 ${basedir}${code}
	 * 
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	public String getPath() {
		return getBasedir() + this.getCode();
	}

	// /**
	// * @return the file
	// */
	// public File getFile() {
	// return file;
	// }
	//
	// /**
	// * @param file
	// * the file to set
	// */
	// public void setFile(File file) {
	// this.file = file;
	// }

	/**
	 * <code>generateFolder</code>
	 * 
	 * 生成目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	public void generateFolder() {

		GenerateUtils.createFileDirectory(new File(getPath()));

	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("generate {} ", this.getPath());
		generateFolder();
	}

	/**
	 * <code>docFolder</code>
	 * 
	 * 默认文档结构
	 * 
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	public static List<Folder> docFolder() {
		List<Folder> folders = new ArrayList<Folder>();
		folders.add(new Folder("doc"));
		folders.add(new Folder("doc\\db"));
		folders.add(new Folder("doc\\temp"));

		return folders;
	}
}
