/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file FileModel.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.io.File;

import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.generate.util.GenerateUtils;

/**
 * <code>FileModel</code>
 * 
 * 用于生成实体文件的对象
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class FileModel extends Folder implements Generate {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private static final long serialVersionUID = -7200333743290920517L;

	/**
	 * 
	 */
	public FileModel() {
		super();
	}

	/**
	 * @param code
	 */
	public FileModel(String code) {
		super(code);
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		// TODO Auto-generated method stub
		logger.debug("{} generate", this);
		GenerateUtils.createFileDirectory(new File(this.getBasedir(), this.getCode()));
		// this.getFile().c
	}
}
