/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.util
 * @file GenerateUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

/**
 * <code>GenerateUtils</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class GenerateUtils {
	public static final String PROJECT_HOME = System.getProperty("user.dir");

	protected static Logger logger = LoggerFactory
			.getLogger(GenerateUtils.class);

	/**
	 * <code>createFileDirectory</code> 创建文件夹路径
	 * 
	 * @param file
	 *            File
	 * @since 2013-7-14 wangjunming
	 */
	public static void createFileDirectory(File file) {

		if (file == null) {
			logger.info("the File is null");
			return;
		}
		boolean exists = file.exists();
		if (exists) {
			logger.info("exists File :\"{}\" ignore it", file.getAbsolutePath());
		} else {
			file.mkdirs();
			logger.info("create File :\"{}\"", file.getAbsolutePath());
		}
	}

	/**
	 * <code>createNewFile</code>
	 * 
	 * 创建新的文件
	 * 
	 * 该方法不常用，文件一般使用模板创建 例如：freemarker
	 * 
	 * @param file
	 * @since 2013-7-29 wangjunming
	 */
	public static void createNewFile(File file) {

		if (file == null) {
			logger.info("the File is null");
			return;
		}
		boolean exists = file.exists();
		if (exists) {
			logger.info("exists File :\"{}\" ignore it", file.getAbsolutePath());
		} else {

			File parent = file.getParentFile();
			if (!parent.exists()) {
				createFileDirectory(parent);
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				logger.warn(e.getMessage(), e);
			}
			logger.info("create File :\"{}\"", file.getAbsolutePath());
		}
	}

	/**
	 * <code>getUserDir</code> 获得默认的工作空间
	 * 
	 * @return 工作空间目录 如："D:\WORKSPACE\Eclipse\"
	 * @since 2013-7-14 wangjunming
	 */
	public static String getUserDir() {

		return (new File(System.getProperty("user.dir"))).getParentFile()
				.getAbsolutePath() + "\\";
	}

	/**
	 * <code>isAbsoluteFile</code>
	 * 
	 * 判断路径是否是绝对文件路径
	 * 
	 * @param filePath
	 * @return
	 * @since 2013-7-14 wangjunming
	 */
	public static boolean isAbsoluteFile(String filePath) {
		try {
			File file = ResourceUtils.getFile(filePath);
			return file.isAbsolute();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * <code>buildBasedir</code>
	 * 
	 * 构建绝对的 basedir路径
	 * 
	 * @param basedir
	 * @return
	 * @since 2013-7-14 wangjunming
	 */
	public static String buildBasedir(String basedir) {
		String filePath = null;
		if (isAbsoluteFile(basedir)) {
			filePath = basedir;
		} else {

			filePath = getUserDir() + basedir;
		}

		if (StringUtils.endsWith(filePath, "\\")
				|| StringUtils.endsWith(filePath, "/")) {
			logger.debug("basedir = {}", basedir);

		} else {
			filePath = filePath + "\\";
		}
		return filePath;
	}
}
