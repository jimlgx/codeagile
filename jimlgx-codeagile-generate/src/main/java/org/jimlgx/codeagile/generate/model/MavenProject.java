/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenProject.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Parent;
import org.springframework.util.CollectionUtils;

/**
 * <code>MavenProject</code>
 * 
 * maven工程项目实现
 * 
 * org.apache.maven.project.MavenProject
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-11
 */
public class MavenProject extends Folder implements Project {
	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	private static final long serialVersionUID = 4189931054874295681L;
	/**
	 * The identifier for this artifact that is unique within the group given by
	 * the group ID. An artifact is something that is either produced or used by
	 * a project. Examples of artifacts produced by Maven for a project include:
	 * JARs, source and binary distributions, and WARs.
	 */
	private String artifactId;

	/**
	 * The current version of the artifact produced by this project.
	 */
	private String version = "1.0";

	/**
	 * 
	 * 
	 * The type of artifact this project produces, for example <code>jar</code>
	 * <code>war</code> <code>ear</code> <code>pom</code>. Plugins can create
	 * their own packaging, and therefore their own packaging types, so this
	 * list does not contain all possible types.
	 * 
	 * 
	 */
	private String packaging = "jar";

	/**
	 * Declares to which version of project descriptor this POM conforms.
	 */
	private String modelVersion;

	/**
	 * The location of the parent project, if one exists. Values from the parent
	 * project will be the default for this project if they are left
	 * unspecified. The location is given as a group ID, artifact ID and
	 * version.
	 */
	private Parent parent;

	/**
	 * 
	 * 
	 * A universally unique identifier for a project. It is normal to use a
	 * fully-qualified package name to distinguish it from other projects with a
	 * similar name (eg. <code>org.apache.maven</code>).
	 * 
	 * 
	 */
	private String groupId;
	/**
	 * Map<String,SourceFolder> sourceFolders :源码目录
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private Map<String, SourceFolder> sourceFolders = new HashMap<String, SourceFolder>(
			4);

	/**
	 * List<MVCModule> modules :功能模块
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<MVCModule> modules = new ArrayList<MVCModule>(0);

	/**
	 * 
	 */
	public MavenProject() {
		super();
	}

	/**
	 * @param code
	 */
	public MavenProject(String code) {
		super(code);
	}

	/**
	 * @return the modelVersion
	 */
	public String getModelVersion() {
		return modelVersion;
	}

	/**
	 * @param modelVersion
	 *            the modelVersion to set
	 */
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	/**
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the artifactId
	 */
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * @param artifactId
	 *            the artifactId to set
	 */
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the packaging
	 */
	public String getPackaging() {
		return packaging;
	}

	/**
	 * @param packaging
	 *            the packaging to set
	 */
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	/**
	 * @return the modules
	 */
	public List<MVCModule> getModules() {
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(List<MVCModule> modules) {
		this.modules = modules;

		for (MVCModule mvcModule : this.modules) {
			mvcModule.setProject(this);
		}
	}

	/**
	 * @return the sourceFolders
	 */
	public Map<String, SourceFolder> getSourceFolders() {
		return sourceFolders;
	}

	/**
	 * @param sourceFolders
	 *            the sourceFolders to set
	 */
	public void setSourceFolders(Map<String, SourceFolder> sourceFolders) {
		this.sourceFolders = sourceFolders;
		for (Map.Entry<String, SourceFolder> entry : this.getSourceFolders()
				.entrySet()) {
			entry.getValue().setProject(this);
		}

	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {

		logger.debug("generate artifactId : {} ", this.getArtifactId());

		generateFolder();

		generateSourceFolders();

		generateFileModels();

		generateModules();
	}

	/**
	 * <code>generateModules</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private void generateModules() {
		List<MVCModule> modules = getModules();

		for (MVCModule mavenModule : modules) {
			mavenModule.generate();
		}
	}

	/**
	 * <code>generateSourceFolders</code>
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	protected void generateSourceFolders() {

		if (!CollectionUtils.isEmpty(this.getSourceFolders())) {
			for (Map.Entry<String, SourceFolder> entry : this
					.getSourceFolders().entrySet()) {
				entry.getValue().generate();
			}
		} else {

			logger.debug("empty sourceFolders artifactId :{}",
					this.getArtifactId());
		}

	}

}
