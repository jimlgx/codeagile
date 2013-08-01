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
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("{} generate", this);
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
			FreemarkerUtils.createFile(getTemplate(), new File(getPath()),
					object);
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
