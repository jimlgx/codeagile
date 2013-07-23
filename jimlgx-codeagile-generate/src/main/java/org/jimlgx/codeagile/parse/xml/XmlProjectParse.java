/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlProjectParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.jimlgx.codeagile.generate.model.MavenProject;
import org.jimlgx.codeagile.parse.ParseUtils;
import org.jimlgx.codeagile.parse.ProjectParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>XmlProjectParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-23
 */
public class XmlProjectParse implements ProjectParse {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Document document;

	/**
	 * 
	 */
	public XmlProjectParse(File file) {
		super();
		SAXReader sr = new SAXReader();
		try {
			document = sr.read(file);
		} catch (DocumentException e) {
			throw new IllegalArgumentException("the " + file.getPath()
					+ " not pdm file", e);
		}
	}

	/**
	 * 
	 */
	public XmlProjectParse() {
		super();
	}

	/**
	 * <code>parse</code>
	 * 
	 * @return
	 * @since 2013-7-23 wangjunming
	 */
	public List<MavenProject> parse() {
		if (document != null) {

			@SuppressWarnings("unchecked")
			List<Element> itr = document.selectNodes("//projects//project");
			List<MavenProject> projects = new ArrayList<MavenProject>(
					itr.size());

			for (Element projectElement : itr) {
				MavenProject project = parseProject(projectElement);

				projects.add(project);
			}
			return projects;
		}
		return null;
	}

	/**
	 * <code>parseProject</code>
	 * 
	 * @param projectElement
	 * @return
	 * @since 2013-7-23 wangjunming
	 */
	private MavenProject parseProject(Element projectElement) {
		MavenProject project = new MavenProject();

		// String name = projectElement.attributeValue("name");
		// project.setName(name);
		// name="任务模型管理" groupId="org.jimlgx.base" artifactId="jimlgx-base-task"
		// code="task" workspace="jimlgx-codeagile/base/"
		ParseUtils.parse(projectElement, project, "name", "artifactId",
				"groupId", "code", "workspace", "version");
		
		return project;
	}

}
