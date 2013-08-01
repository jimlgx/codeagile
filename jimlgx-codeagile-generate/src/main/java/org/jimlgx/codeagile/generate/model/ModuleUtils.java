/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file ModelUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jimlgx.codeagile.generate.MvcConstants;
import org.jimlgx.codeagile.template.DefaultTemplate;

/**
 * <code>ModelUtils</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-8-1
 */
public class ModuleUtils implements MvcConstants {
	/**
	 * <code>createMVCPackages</code>
	 * 
	 * <pre>
	 * org.jimlgx.demo
	 * org.jimlgx.demo.web
	 * org.jimlgx.demo.service
	 * org.jimlgx.demo.dao
	 * org.jimlgx.demo.model
	 * </pre>
	 * 
	 * @param folder
	 * @return
	 * @since 2013-7-31 wangjunming
	 */
	public static Map<String, PackageFolder> createMVCPackages(
			PackageFolder folder) {
		Map<String, PackageFolder> mvcPackages = new HashMap<String, PackageFolder>(
				4);
		mvcPackages.put(MODULE_ROOT, folder);
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
	private static void buildPackage(Map<String, PackageFolder> map,
			PackageFolder folder, String mvcModel) {
		map.put(mvcModel, new PackageFolder(folder, mvcModel));
	}

	/**
	 * <code>createPackage</code>
	 * 
	 * @param project
	 * @param mvcModule
	 * @return
	 * @since 2013-7-31 wangjunming
	 */
	public static PackageFolder createPackage(MavenProject project,
			MVCModule mvcModule) {
		String groupId = project.getGroupId();
		String pCode = project.getCode();
		String mCode = mvcModule.getCode();
		String pfCode = groupId + "." + pCode + "." + mCode;
		PackageFolder packageFolder = new PackageFolder(pfCode);

		return packageFolder;
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

}
