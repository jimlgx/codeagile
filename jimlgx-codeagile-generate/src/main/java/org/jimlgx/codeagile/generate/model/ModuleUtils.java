/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file ModelUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-8-1
 */
package org.jimlgx.codeagile.generate.model;

import hidden.org.codehaus.plexus.interpolation.util.StringUtils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;
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

	/**
	 * <code>buildFolderCode</code>
	 * 
	 * @param code
	 * @return
	 * @since 2013-8-2 wangjunming
	 */
	public static String buildFolderCode(String code) {
		String folderCode = StringUtils.replace(code, ".", File.separator);
		return folderCode;
	}

	/**
	 * <code>reflectionNewInstance</code>
	 * 
	 * @param module
	 * @param generate
	 * @since 2013-8-2 wangjunming
	 */
	public static DomainGenerate reflectionNewInstance(MVCModule module,
			String generate) {
		DomainGenerate generate2 = null;
		try {
			Class<? extends DomainGenerate> genClass = (Class<? extends DomainGenerate>) ClassUtils
					.getClass(generate);
			Constructor<? extends DomainGenerate> constructor = genClass
					.getConstructor(MVCModule.class);
			generate2 = constructor.newInstance(module);

			return generate2;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}
}
