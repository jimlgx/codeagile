/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MVCModule.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-30
 */
package org.jimlgx.codeagile.generate.model;

import java.util.ArrayList;
import java.util.List;

import org.jimlgx.codeagile.generate.Generate;

/**
 * <code>MVCModule</code>
 * 
 * 具有mvc 层级的对象
 * 
 * 管理了规范的报名称及类名称
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-30
 */
public class MVCModule extends AbstractModel implements Generate {
	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * MavenProject project :
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private MavenProject project;

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
	 * List<DomainModel> domains :
	 * 
	 * @since 2013-7-26 wangjunming
	 */
	private List<DomainModel> domains;
	/**
	 * String parseType :解析类型 pdm,xml,database
	 * 
	 * @since 2013-7-29 wangjunming
	 */
	private String parseType;

	/**
	 * @return the parseType
	 */
	public String getParseType() {
		return parseType;
	}

	/**
	 * @param parseType
	 *            the parseType to set
	 */
	public void setParseType(String parseType) {
		this.parseType = parseType;
	}

	/**
	 * @return the domains
	 */
	public List<DomainModel> getDomains() {
		return domains;
	}

	/**
	 * @param domains
	 *            the domains to set
	 */
	public void setDomains(List<DomainModel> domains) {
		this.domains = domains;
	}

	/**
	 * List<PackageFolder> folders :包结构
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	protected List<PackageFolder> folders = new ArrayList<PackageFolder>();

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	public void generate() {
		buildFolders();
	}

	/**
	 * <code>buildFolders</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private void buildFolders() {

		SourceFolder mj = new SourceFolder(SourceFolder.MAIN_JAVA, this
				.getProject().getPath());

		SourceFolder mr = new SourceFolder(SourceFolder.MAIN_RESOURCES, this
				.getProject().getPath());

		SourceFolder tj = new SourceFolder(SourceFolder.TEST_JAVA, this
				.getProject().getPath());

		SourceFolder tr = new SourceFolder(SourceFolder.TEST_RESOURCES, this
				.getProject().getPath());

		folders.add(new PackageFolder());
	}

}
