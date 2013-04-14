/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenProject.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import org.apache.maven.model.Parent;

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
public class MavenProject extends AbstractModel implements Project {
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
	private String version;

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
	 * The full name of the project.
	 */
	private String name;

	/**
	 * A detailed description of the project, used by Maven whenever it needs to
	 * describe the project, such as on the web site. While this element can be
	 * specified as CDATA to enable the use of HTML tags within the description,
	 * it is discouraged to allow plain text representation. If you need to
	 * modify the index page of the generated web site, you are able to specify
	 * your own instead of adjusting this text.
	 */
	private String description;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		// TODO Auto-generated method stub

	}

}
