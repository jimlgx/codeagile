/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file SourceFolder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.HashMap;
import java.util.Map;

import org.jimlgx.codeagile.generate.Generate;

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
	public static final String MAIN_JAVA = "src/main/java";
	public static final String MAIN_RESOURCES = "src/main/resources";
	public static final String MAIN_WEBAPP = "src/main/webapp";
	public static final String TEST_JAVA = "src/test/java";
	public static final String TEST_RESOURCES = "src/test/resources";

	/**
	 * MavenProject project :
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private MavenProject project;

	/**
	 * Map<String,PackageFolder> packages :
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private Map<String, PackageFolder> packages = new HashMap<String, PackageFolder>();

	public SourceFolder() {
	}

	/**
	 * @return the project
	 */
	public MavenProject getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(MavenProject project) {
		this.project = project;
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
	 * <code>setPackages</code>
	 * 
	 * @param packages
	 * @since 2013-7-31 wangjunming
	 */
	public void setPackages(Map<String, PackageFolder> packages) {

		this.packages = packages;

		for (PackageFolder folder : getPackages().values()) {
			folder.setBasedir(getPath());
		}
	}

	/**
	 * @return the packages
	 */
	public Map<String, PackageFolder> getPackages() {
		return packages;
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-8-2 wangjunming
	 */
	@Override
	public void generate() {

		super.generate();

		for (PackageFolder folder : getPackages().values()) {
			folder.generate();
		}
	}

	/**
	 * <code>mapMavenSourceFolders</code>
	 * 
	 * 默认的mavne源码包结构
	 * 
	 * @return
	 * @since 2013-7-17 wangjunming
	 */
	public static Map<String, SourceFolder> mapMavenSourceFolders(String basedir) {

		Map<String, SourceFolder> map = new HashMap<String, SourceFolder>(5);

		buildMap(map, MAIN_JAVA, basedir);
		buildMap(map, MAIN_RESOURCES, basedir);
		buildMap(map, MAIN_WEBAPP, basedir);
		buildMap(map, TEST_JAVA, basedir);
		buildMap(map, TEST_RESOURCES, basedir);

		return map;
	}

	/**
	 * <code>buildMap</code>
	 * 
	 * @param map
	 * @param code
	 * @param basedir
	 * @since 2013-7-31 wangjunming
	 */
	private static void buildMap(Map<String, SourceFolder> map, String code,
			String basedir) {
		map.put(code, new SourceFolder(code, basedir));
	}
}
