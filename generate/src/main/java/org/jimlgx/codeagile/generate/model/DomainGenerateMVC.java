/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file DomainMVCGenerate.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import java.util.Map;

import org.jimlgx.codeagile.generate.MvcConstants;
import org.jimlgx.codeagile.template.DefaultTemplate;

/**
 * <code>DomainGenerateMVC</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-1
 */
public class DomainGenerateMVC extends DomainGenerateSupport implements
		MvcConstants {
	/**
	 * MVCModule mvcModule :
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	private MVCModule mvcModule;

	/**
	 * 
	 */
	public DomainGenerateMVC() {
		super();
	}

	/**
	 * @param mvcModule
	 */
	public DomainGenerateMVC(MVCModule mvcModule) {
		super();
		this.mvcModule = mvcModule;
	}

	/**
	 * @return the mvcModule
	 */
	public MVCModule getMvcModule() {
		return mvcModule;
	}

	/**
	 * @param mvcModule
	 *            the mvcModule to set
	 */
	public void setMvcModule(MVCModule mvcModule) {
		this.mvcModule = mvcModule;
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
	protected void buildMainWebappFile(DomainModel domainModel,
			SourceFolder sourceFolder) {

		// Folder folder = new Folder();
		// folder
		FileModel fileModel = new FileModel("WEB-INF/web.xml",
				DefaultTemplate.XML.web);
		Map<String, FileModel> fileModels = sourceFolder.getFileModels();
		fileModels.put(fileModel.getCode(), fileModel);
		sourceFolder.setFileModels(fileModels);
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
		Map<String, PackageFolder> packages = this.getMvcModule()
				.buildPackages();
		sourceFolder.setPackages(packages);
		// sFolder.getValue()
		for (Map.Entry<String, PackageFolder> pfEntry : packages.entrySet()) {
			String key = pfEntry.getKey();
			PackageFolder pFolder = pfEntry.getValue();

			if (MVC_MODEL.equals(key)) {
				JavaDomainFile javaDomainFile = buildJavaFile(
						domainModel.getCode(), DefaultTemplate.MVC.Model,
						domainModel, pFolder);

				PropertiesFile propertiesFile = ModuleUtils
						.buildPropertiesByDomain(domainModel);
				// 建立双向关联
				pFolder.getFileModels().put(propertiesFile.getCode(),
						propertiesFile);
				propertiesFile.setPackageFolder(pFolder);

				setExtendsClassifNull(javaDomainFile, "EntityLongImpl");

			} else if (MVC_DAO.equals(key)) {
				JavaDomainFile javaDomainFile = buildJavaFile(
						domainModel.getCode() + "Dao", DefaultTemplate.MVC.Dao,
						domainModel, pFolder);
				setExtendsClassifNull(javaDomainFile, "EntityDaoSupport");

			} else if (MVC_SERVICE.equals(key)) {
				JavaDomainFile javaDomainFile = buildJavaFile(
						domainModel.getCode() + "Service",
						DefaultTemplate.MVC.Service, domainModel, pFolder);
				setExtendsClassifNull(javaDomainFile, "EntityManagerSupport");
			} else if (MVC_WEB.equals(key)) {
				JavaDomainFile javaDomainFile = buildJavaFile(
						domainModel.getCode() + "Action",
						DefaultTemplate.MVC.Action, domainModel, pFolder);
				setExtendsClassifNull(javaDomainFile, "JsonEntityActionSupport");
			} else if (MVC_MANAGER.equals(key)) {

				JavaDomainFile javaDomainFile = buildJavaFile(
						domainModel.getCode() + "Manager",
						DefaultTemplate.MVC.Manager, domainModel, pFolder);
				setExtendsClassifNull(javaDomainFile, "EntityManagerSupport");
			}

		}
	}

	/**
	 * <code>setExtendsClassifNull</code>
	 * 
	 * @param javaDomainFile
	 * @param string
	 * @since 2013-8-10 wangjunming
	 */
	private void setExtendsClassifNull(JavaDomainFile javaDomainFile,
			String string) {
		javaDomainFile.setExtendsClass(string);
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
		Map<String, PackageFolder> packages = this.getMvcModule()
				.buildPackages();
		sourceFolder.setPackages(packages);
		// sFolder.getValue()
		for (Map.Entry<String, PackageFolder> pfEntry : packages.entrySet()) {
			String key = pfEntry.getKey();
			PackageFolder pFolder = pfEntry.getValue();

			if (MVC_MODEL.equals(key)) {
				buildJavaFile(domainModel.getCode() + "Test",
						DefaultTemplate.TESTCASE.TemplateSpringTest,
						domainModel, pFolder);

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
	protected JavaDomainFile buildJavaFile(String code, String template,
			DomainModel domainModel, PackageFolder pFolder) {
		JavaDomainFile javaDomainFile = new JavaDomainFile(domainModel);
		javaDomainFile.setModule(mvcModule);

		javaDomainFile.setCode(code);

		// 设置模板
		javaDomainFile.setTemplate(template);
		javaDomainFile.setExtension(".java");

		// 添加泛型类型名称
		javaDomainFile.setParamT(domainModel.getCode());
		javaDomainFile.setParamD(domainModel.getCode() + "Dao");
		javaDomainFile.setParamM(domainModel.getCode() + "Manager");
		javaDomainFile.setParamS(domainModel.getCode() + "Service");
		javaDomainFile.setModulePackage(this.mvcModule.getPackageFolder()
				.getCode());

		// 建立双向关系
		javaDomainFile.setPackageFolder(pFolder);
		pFolder.getJavaFiles().add(javaDomainFile);

		return javaDomainFile;
	}

	/**
	 * <code>generate</code>
	 * 
	 * @param domainModel
	 * @since 2013-8-1 wangjunming
	 */
	public void generate(DomainModel domainModel) {

		Map<String, SourceFolder> sourceFolders = this.getMvcModule()
				.getProject().getSourceFolders();

		for (Map.Entry<String, SourceFolder> sfEntry : sourceFolders.entrySet()) {
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

		// 生成
		for (SourceFolder folder : sourceFolders.values()) {
			folder.generate();
		}

	}

}
