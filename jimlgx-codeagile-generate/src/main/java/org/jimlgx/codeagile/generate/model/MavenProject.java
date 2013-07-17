/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file MavenProject.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.io.File;
import java.util.List;

import org.apache.maven.model.Parent;
import org.jimlgx.codeagile.generate.util.GenerateUtils;
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
	 * SourceFolder sourceFolders :源码目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<SourceFolder> sourceFolders;

	/**
	 * List<Package> packages :
	 * 
	 * 包结构
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<Package> packages;

	/**
	 * List<MavenModule> modules :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<MavenModule> modules;
	/**
	 * List<Folder> folders : 文件夹
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<Folder> folders;
	/**
	 * List<FileModel> fileModels : 文件对象
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private List<FileModel> fileModels;

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
	 * @return the packages
	 */
	public List<Package> getPackages() {
		return packages;
	}

	/**
	 * @param packages
	 *            the packages to set
	 */
	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	/**
	 * @return the modules
	 */
	public List<MavenModule> getModules() {
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(List<MavenModule> modules) {
		this.modules = modules;
	}

	/**
	 * @return the sourceFolder
	 */
	public List<SourceFolder> getSourceFolders() {
//
//		if (CollectionUtils.isEmpty(sourceFolders)) {
//
//			this.sourceFolders = SourceFolder.mavenSourceFolder(this
//					.getBasedir() + this.getCode());
//
//		}

		return sourceFolders;
	}

	/**
	 * @param sourceFolders
	 *            the sourceFolders to set
	 */
	public void setSourceFolder(List<SourceFolder> sourceFolders) {
		this.sourceFolders = sourceFolders;
	}

	/**
	 * @return the folders
	 */
	public List<Folder> getFolders() {
		return folders;
	}

	/**
	 * @param folders
	 *            the folders to set
	 */
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

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
	 * @param sourceFolders
	 *            the sourceFolders to set
	 */
	public void setSourceFolders(List<SourceFolder> sourceFolders) {
		this.sourceFolders = sourceFolders;
	}

	// public void generate(File file) {
	// setParentFile(file);
	// generate();
	// }

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("{} generate", this.getArtifactId());

		generateFolder();
		// this.getf

		if (!CollectionUtils.isEmpty(getFileModels())) {
			for (FileModel fileModel : getFileModels()) {
				fileModel.generate();
			}
		} else {
			logger.debug("MavenProject:{} fileModels is empty",
					this.getArtifactId());
		}
	}

	/**
	 * <code>generateFolder</code>
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	@Override
	public void generateFolder() {
		GenerateUtils.createFile(new File(getBasedir(), this.getArtifactId()));

		if (!CollectionUtils.isEmpty(this.getSourceFolders())) {
			for (SourceFolder sourceFolder : this.getSourceFolders()) {
				sourceFolder.generate();
			}
		} else {
			logger.debug("MavenProject:{} sourceFolders is empty",
					this.getArtifactId());
		}

		if (!CollectionUtils.isEmpty(this.getFolders())) {
			for (Folder folder : this.getFolders()) {
				folder.generate();
			}
		} else {
			logger.debug("MavenProject:{} folders is empty",
					this.getArtifactId());
		}
	}

	// /**
	// * <code>defaultFloder</code>
	// *
	// * @since 2013-7-17 wangjunming
	// */
	// public void defaultFloder() {
	// // TODO Auto-generated method stub
	//
	// }
}
