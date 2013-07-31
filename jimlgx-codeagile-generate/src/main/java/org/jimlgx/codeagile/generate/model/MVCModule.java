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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.template.DefaultTemplate;

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
	 * String MVC_MODEL : model
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	public static final String MVC_MODEL = "model";
	/**
	 * String MVC_DAO : dao
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	public static final String MVC_DAO = "dao";
	/**
	 * String MVC_SERVICE : service
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	public static final String MVC_SERVICE = "service";
	/**
	 * String MVC_MANAGER :manager
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	public static final String MVC_MANAGER = "manager";
	/**
	 * String MVC_WEB : web
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	public static final String MVC_WEB = "web";
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
		// buildFolders();
		// generateMVCDomains();

	}

	/**
	 * <code>parseDomains</code>
	 * 
	 * @since 2013-7-31 wangjunming
	 */
	private void parseDomains() {

		List<DomainModel> domains = getDomains();

		for (DomainModel domainModel : domains) {

			Map<String, SourceFolder> sourceFolders = getProject()
					.getSourceFolders();

			for (Map.Entry<String, SourceFolder> sfEntry : sourceFolders
					.entrySet()) {
				if (SourceFolder.MAIN_JAVA.equals(sfEntry.getKey())) {
					SourceFolder sourceFolder = sfEntry.getValue();
					buildMainJavaFile(domainModel, sourceFolder);
				} else if (SourceFolder.TEST_JAVA.equals(sfEntry.getKey())) {
					SourceFolder sourceFolder = sfEntry.getValue();
					buildTestJavaFile(domainModel, sourceFolder);
				} else if (SourceFolder.MAIN_WEBAPP.equals(sfEntry.getKey())) {
					SourceFolder sourceFolder = sfEntry.getValue();
					buildMainWebappFile(domainModel, sourceFolder);
				}
			}
		}
	}

	/**
	 * <code>buildMainWebappFile</code>
	 * 
	 * 构建web页面
	 * 
	 * @param domainModel
	 * @param sourceFolder
	 * @since 2013-7-31 wangjunming
	 */
	private void buildMainWebappFile(DomainModel domainModel,
			SourceFolder sourceFolder) {

	}

	/**
	 * <code>buildMainJavaFile</code>
	 * 
	 * @param domainModel
	 * @param sourceFolder
	 * @since 2013-7-31 wangjunming
	 */
	protected void buildMainJavaFile(DomainModel domainModel,
			SourceFolder sourceFolder) {
		Map<String, PackageFolder> packages = buildPackages();
		sourceFolder.setPackages(packages);
		// sFolder.getValue()
		for (Map.Entry<String, PackageFolder> pfEntry : packages.entrySet()) {
			String key = pfEntry.getKey();
			PackageFolder pFolder = pfEntry.getValue();

			if (MVC_MODEL.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Dao",
						DefaultTemplate.MVC.Dao, domainModel, pFolder);

				PropertiesFile propertiesFile = buildPropertiesByDomain(domainModel);
				// 建立双向关联
				pFolder.getFileModels().add(propertiesFile);
				propertiesFile.setPackageFolder(pFolder);
			} else if (MVC_DAO.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Dao",
						DefaultTemplate.MVC.Dao, domainModel, pFolder);
			} else if (MVC_SERVICE.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Service",
						DefaultTemplate.MVC.Service, domainModel, pFolder);
			} else if (MVC_WEB.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Action",
						DefaultTemplate.MVC.Action, domainModel, pFolder);
			} else if (MVC_MANAGER.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Manager",
						DefaultTemplate.MVC.Manager, domainModel, pFolder);
			}

		}
	}

	/**
	 * <code>buildTestJavaFile</code>
	 * 
	 * 构建测试类结构
	 * 
	 * @param domainModel
	 * @param sourceFolder
	 * @since 2013-7-31 wangjunming
	 */
	protected void buildTestJavaFile(DomainModel domainModel,
			SourceFolder sourceFolder) {
		Map<String, PackageFolder> packages = buildPackages();
		sourceFolder.setPackages(packages);
		// sFolder.getValue()
		for (Map.Entry<String, PackageFolder> pfEntry : packages.entrySet()) {
			String key = pfEntry.getKey();
			PackageFolder pFolder = pfEntry.getValue();

			if (MVC_MODEL.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Test",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);

				PropertiesFile propertiesFile = buildPropertiesByDomain(domainModel);
				// 建立双向关联
				pFolder.getFileModels().add(propertiesFile);
				propertiesFile.setPackageFolder(pFolder);
			} else if (MVC_DAO.equals(key)) {
				buildJavaFile(domainModel.getCode() + "DaoTest",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);
			} else if (MVC_SERVICE.equals(key)) {
				buildJavaFile(domainModel.getCode() + "ServiceTest",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);
			} else if (MVC_WEB.equals(key)) {
				buildJavaFile(domainModel.getCode() + "ActionTest",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);
			} else if (MVC_MANAGER.equals(key)) {
				buildJavaFile(domainModel.getCode() + "ManagerTest",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);
			}

		}
	}

	/**
	 * <code>buildJavaFile</code>
	 * 
	 * @param domainModel
	 * @param pFolder
	 * @since 2013-7-31 wangjunming
	 */
	protected void buildJavaFile(String code, String template,
			DomainModel domainModel, PackageFolder pFolder) {
		JavaDomainFile javaDomainFile = new JavaDomainFile(domainModel);
		javaDomainFile.setCode(code);

		// 设置模板
		javaDomainFile.setTemplate(template);

		// 建立双向关系
		javaDomainFile.setPackageFolder(pFolder);
		pFolder.getJavaFiles().add(javaDomainFile);
	}

	/**
	 * <code>buildPropertiesByDomain</code>
	 * 
	 * @param domainModel
	 * @return
	 * @since 2013-7-31 wangjunming
	 */
	public static PropertiesFile buildPropertiesByDomain(DomainModel domainModel) {

		String code = domainModel.getCode() + "_zh_CN.properties";

		PropertiesFile file = new PropertiesFile(code,
				DefaultTemplate.PROPERTIES.field);

		List<ModelField> fields = domainModel.getFields();
		for (ModelField modelField : fields) {
			file.getProperties()
					.put(modelField.getCode(), modelField.getName());
		}
		return file;
	}

	/**
	 * <code>buildFolders</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private Map<String, PackageFolder> buildPackages() {

		PackageFolder folder = buildPackage(getProject(), this);
		Map<String, PackageFolder> packages = buildMVCPackages(folder);
		return packages;
	}

	/**
	 * <code>buildMVCPackages</code>
	 * 
	 * @param folder
	 * @return
	 * @since 2013-7-31 wangjunming
	 */
	protected static Map<String, PackageFolder> buildMVCPackages(
			PackageFolder folder) {
		Map<String, PackageFolder> mvcPackages = new HashMap<String, PackageFolder>(
				4);
		buildPackage(mvcPackages, folder, MVC_MODEL);
		buildPackage(mvcPackages, folder, MVC_DAO);
		buildPackage(mvcPackages, folder, MVC_SERVICE);
		buildPackage(mvcPackages, folder, MVC_WEB);
		return mvcPackages;
	}

	/**
	 * <code>buildPackageFolder</code>
	 * 
	 * @param map
	 * @param folder
	 * @param mvcModel
	 * @since 2013-7-31 wangjunming
	 */
	protected static void buildPackage(Map<String, PackageFolder> map,
			PackageFolder folder, String mvcModel) {
		map.put(mvcModel, new PackageFolder(folder, mvcModel));
	}

	/**
	 * <code>buildPackage</code>
	 * 
	 * @param project
	 * @param mvcModule
	 * @return
	 * @since 2013-7-31 wangjunming
	 */
	public static PackageFolder buildPackage(MavenProject project,
			MVCModule mvcModule) {
		String groupId = project.getGroupId();
		String pCode = project.getCode();
		String mCode = mvcModule.getCode();
		String pfCode = groupId + "." + pCode + "." + mCode;
		PackageFolder packageFolder = new PackageFolder(pfCode);

		return packageFolder;
	}

}
