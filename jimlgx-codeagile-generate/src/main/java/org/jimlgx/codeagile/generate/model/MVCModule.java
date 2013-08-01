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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.generate.MvcConstants;
import org.springframework.util.CollectionUtils;

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
public class MVCModule extends Folder implements Generate, MvcConstants {
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
	 * Map<String,SourceFolder> sourceFolders :源码目录
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private Map<String, SourceFolder> sourceFolders = new HashMap<String, SourceFolder>(
			4);

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
	 * List<DomainGenerate> domainGenerates :模型对象生成器
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	private List<DomainGenerate> domainGenerates = new ArrayList<DomainGenerate>();

	/**
	 * 
	 */
	public MVCModule() {
		super();
	}

	/**
	 * @param code
	 */
	public MVCModule(String code) {
		super(code);
	}

	/**
	 * @return the sourceFolders
	 */
	public Map<String, SourceFolder> getSourceFolders() {
		if (CollectionUtils.isEmpty(sourceFolders)) {
			this.sourceFolders = SourceFolder.mapMavenSourceFolders(getPath());
		}
		return sourceFolders;
	}

	/**
	 * @param sourceFolders
	 *            the sourceFolders to set
	 */
	public void setSourceFolders(Map<String, SourceFolder> sourceFolders) {
		this.sourceFolders = sourceFolders;
	}

	/**
	 * @return the domainGenerates
	 */
	public List<DomainGenerate> getDomainGenerates() {
		return domainGenerates;
	}

	/**
	 * @param domainGenerates
	 *            the domainGenerates to set
	 */
	public void setDomainGenerates(List<DomainGenerate> domainGenerates) {
		this.domainGenerates = domainGenerates;
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
	 * <code>generate</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	public void generate() {
		parseDomains();

		generateSourceFolder();
		generateFolder();
		generateFileModels();

	}

	/**
	 * <code>generateSourceFolder</code>
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	protected void generateSourceFolder() {
		Collection<SourceFolder> values = getSourceFolders().values();
		for (SourceFolder sourceFolder : values) {
			sourceFolder.generate();
		}
	}

	/**
	 * <code>parseDomains</code>
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	protected void parseDomains() {

		List<DomainModel> domains = getDomains();

		for (DomainModel domainModel : domains) {
			List<DomainGenerate> domainGenerates = getDomainGenerates();
			for (DomainGenerate domainGenerate : domainGenerates) {
				domainGenerate.generate(domainModel);
			}
		}
	}

	/**
	 * <code>buildFolders</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	protected Map<String, PackageFolder> buildPackages() {

		PackageFolder folder = ModuleUtils.createPackage(getProject(), this);
		Map<String, PackageFolder> packages = ModuleUtils
				.createMVCPackages(folder);
		return packages;
	}

}
