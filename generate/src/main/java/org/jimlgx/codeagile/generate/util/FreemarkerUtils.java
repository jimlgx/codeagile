/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.util
 * @file FreemarkerUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-29
 */
package org.jimlgx.codeagile.generate.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.jimlgx.codeagile.template.DefaultTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * <code>FreemarkerUtils</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-29
 */
public class FreemarkerUtils {
	private static volatile Configuration cfg = null;
	protected static Logger logger = LoggerFactory
			.getLogger(FreemarkerUtils.class);

	/**
	 * <code>createFile</code> 使用freemarker创建文件， 如果要创建的文件存在则直接忽略
	 * 
	 * @param templateName
	 *            模板名称
	 * @param outFile
	 *            输出文件
	 * @param rootMap
	 *            键值集合
	 * @throws IOException
	 * @throws TemplateException
	 * @since 2013-7-29 wangjunming
	 */
	public static void createFile(String templateName, File outFile,
			Object rootMap) throws IOException, TemplateException {
		if (outFile.exists()) {
			logger.info("exists File :\"{}\" ignore it", outFile.getPath());
			return;
		}
		logger.info("create File :\"{}", outFile.getPath());
		Configuration cfg = getConfiguration();
		// 定义Template对象
		Template template = cfg.getTemplate(templateName);
		// 定义输出
		PrintWriter out = null;
		try {
			out = new PrintWriter(outFile);
		} catch (FileNotFoundException e) {
			GenerateUtils.createNewFile(outFile);
			out = new PrintWriter(outFile);
		}

		template.process(rootMap, out);
	}

	/**
	 * <code>getConfiguration</code>
	 * 
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	protected static Configuration getConfiguration() {
		if (cfg == null) {
			synchronized (FreemarkerUtils.class) {
				if (cfg == null) {
					Configuration cfg = new Configuration();
					// 从什么地方加载freemarker模板文件
					// cfg.setDirectoryForTemplateLoading(FileUtil
					// .getFile(ConstantsCoder.TEMPLATE_DIRECTORY));

					// cfg.setClassForTemplateLoading(
					// FreemarkerTemplatePath.class, "");

					cfg.setClassForTemplateLoading(DefaultTemplate.class, "");

					// 设置对象包装器
					cfg.setObjectWrapper(new DefaultObjectWrapper());
					// 设置异常处理器
					cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
					FreemarkerUtils.cfg = cfg;
				}
			}
		}
		return cfg;
	}

}
