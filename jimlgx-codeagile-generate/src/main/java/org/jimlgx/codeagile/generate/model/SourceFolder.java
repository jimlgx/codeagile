/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file SourceFolder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>SourceFolder</code>
 * 
 * 源码目录
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class SourceFolder extends Folder {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private static final long serialVersionUID = 1L;

	public SourceFolder() {
	}

	/**
	 * @param code
	 */
	public SourceFolder(String code) {
		this.setCode(code);
	}

	/**
	 * @param code
	 * @param basedir
	 */
	public SourceFolder(String code, String basedir) {
		this.setCode(code);
		this.setBasedir(basedir);
	}

	/**
	 * <code>mavenSourceFolders</code>
	 * 
	 * 默认的mavne源码包结构
	 * 
	 * @return
	 * @since 2013-7-17 wangjunming
	 */
 
	public static List<SourceFolder> mavenSourceFolders(String basedir) {

		List<SourceFolder> list = new ArrayList<SourceFolder>();

		list.add(new SourceFolder("src/main/java", basedir));
		list.add(new SourceFolder("src/main/resources", basedir));
		list.add(new SourceFolder("src/test/java", basedir));
		list.add(new SourceFolder("src/test/resources", basedir));

		return list;
	}
}
