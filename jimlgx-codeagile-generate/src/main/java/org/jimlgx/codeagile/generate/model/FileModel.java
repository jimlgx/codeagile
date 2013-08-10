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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.generate.util.FreemarkerUtils;
import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.jimlgx.codeagile.template.DefaultTemplate;

import freemarker.template.TemplateException;

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
	 * String template : 模板名称
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private String template;
	/**
	 * String extension :文件后缀
	 * 
	 * @since 2013-8-2 wangjunming
	 */
	protected String extension = StringUtils.EMPTY;

	/**
	 * String author :
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	protected String author = StringUtils.EMPTY;
	/**
	 * String version :版本号
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	protected String version = "1.0";

	/**
	 * String description :描述
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	protected String description = StringUtils.EMPTY;
	protected String copyRight = StringUtils.EMPTY;
	protected String projectName = StringUtils.EMPTY;
	protected String fileName = StringUtils.EMPTY;

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
	 * @return the copyRight
	 */
	public String getCopyRight() {
		return copyRight;
	}

	/**
	 * @param copyRight
	 *            the copyRight to set
	 */
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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
	 * @param code
	 *            文件名
	 * @param template
	 *            模板
	 */
	public FileModel(String code, String template) {
		super(code);
		this.template = template;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension
	 *            the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		if (StringUtils.isEmpty(template)) {
			return DefaultTemplate.EMPTY;
		}
		return template;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("{} generate", this.getPath());
		Object object = this;
		generate(object);
	}

	/**
	 * <code>remove</code> 移除文件对象
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	public void remove() {
		File file = new File(getPath());
		GenerateUtils.remove(file);
	}

	/**
	 * <code>generate</code>
	 * 
	 * @param object
	 * @since 2013-7-30 wangjunming
	 */
	public void generate(Object object) {
		// XXX 生成文件
		try {
			FreemarkerUtils.createFile(getTemplate(), new File(getPath()
					+ getExtension()), object);
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} catch (TemplateException e) {
			logger.warn(e.getMessage(), e);
		}
	}

	/**
	 * <code>mavneFile</code>
	 * 
	 * @param path
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	public static List<FileModel> mavneFile(String path) {
		Map<String, FileModel> map = mapMavneFile(path);
		return new ArrayList<FileModel>(map.values());
	}

	public static Map<String, FileModel> mapMavneFile(String path) {
		// List<FileModel> fileModels = new ArrayList<FileModel>();
		Map<String, FileModel> map = new HashMap<String, FileModel>();
		map.put("pom.xml", new FileModel("pom.xml", DefaultTemplate.XML.pom));
		map.put("doc/readme.txt", new FileModel("doc/readme.txt",
				DefaultTemplate.EMPTY));
		map.put("doc/changelog.txt", new FileModel("doc/changelog.txt",
				DefaultTemplate.EMPTY));

		return map;
	}
}
