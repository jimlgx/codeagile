/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlProjectParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.jimlgx.codeagile.generate.model.FileModel;
import org.jimlgx.codeagile.generate.model.Folder;
import org.jimlgx.codeagile.generate.model.MVCModule;
import org.jimlgx.codeagile.generate.model.MavenProject;
import org.jimlgx.codeagile.generate.model.SourceFolder;
import org.jimlgx.codeagile.parse.ParseUtils;
import org.jimlgx.codeagile.parse.ProjectParse;

/**
 * <code>XmlProjectParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-23
 */

public class XmlProjectParse extends AbstractParse implements ProjectParse {
//	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */

	public XmlProjectParse() {
		super();
	}

	/**
	 * @param element
	 */
	public XmlProjectParse(Element element) {
		super(element);
	}

	/**
	 * <code>parse</code>
	 * 
	 * @return
	 * @since 2013-7-23 wangjunming
	 */
	public List<MavenProject> parse() {

		if (getElement() != null) {

			@SuppressWarnings("unchecked")
			List<Element> itr = getElement().selectNodes("//projects//project");
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

		ParseUtils.parseAttributeValue(projectElement, project, "name",
				"artifactId", "groupId", "code", "basedir", "version");

		// sourceFolders
		Map<String, SourceFolder> sourceFolders = SourceFolder
				.mapMavenSourceFolders(project.getPath());

		project.setSourceFolders(sourceFolders);

		Map<String, Folder> folders = Folder.mapDocFolder();
		project.setFolders(folders);

		Map<String, FileModel> fileModels = FileModel.mapMavneFile(project
				.getPath());

		project.setFileModels(fileModels);

		try {
			XmlModuleParse moduleParse = new XmlModuleParse(projectElement);
			project.setSourceFolders(SourceFolder.mapMavenSourceFolders(project
					.getPath()));

			List<MVCModule> modules = moduleParse.parse();

			project.setModules(modules);

		} catch (RuntimeException e) {
			// e.printStackTrace();
			logger.warn("parseModule error");
			logger.warn(e.getMessage(), e);
		}
		return project;
	}
}
