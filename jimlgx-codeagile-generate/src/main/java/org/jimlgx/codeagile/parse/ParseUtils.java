/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse
 * @file ParseUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jimlgx.common.util.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * <code>ParseUtils</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-23
 */
public class ParseUtils {
	protected static Logger logger = LoggerFactory.getLogger(ParseUtils.class);

	/**
	 * <code>parseAttributeValue</code>
	 * 
	 * 解析 element 中指定的属性元素 赋值到 model 对象的相应属性上
	 * 
	 * @param element
	 * @param modle
	 * @param strings
	 * @since 2013-7-23 wangjunming
	 */
 
	public static void parseAttributeValue(Element element, Object modle,
			String... strings) {
 
		Assert.notNull(element);
		Assert.notNull(modle);
		for (String attributeName : strings) {
			String value = element.attributeValue(attributeName);
			if (StringUtils.isNotBlank(value)) {
				try {
					String setter = PropertyUtils.parseSetter(attributeName);
 
					logger.debug("setter = {}", setter);

					Method method = findMethod(modle, setter, value.getClass());

					if (method != null) {
						ReflectionUtils.invokeMethod(method, modle, value);
					} else {
						logger.warn("the class :{},not found method :{}",
								modle.getClass(), setter);
					}
				} catch (RuntimeException e) {
					// e.printStackTrace();
					logger.warn(e.getMessage(), e);
				}
			}
		}

	}
 

	/**
	 * <code>findMethod</code>
	 * 
	 * @param modle
	 * @param name
	 * @return
	 * @since 2013-7-25 wangjunming
	 */
	protected static Method findMethod(Object modle, String name,
			Class<?>... paramTypes) {
		Method method = ReflectionUtils.findMethod(modle.getClass(), name,
				paramTypes);
		return method;
	}

	/**
	 * <code>loadAsDocument</code>
	 * 
	 * 加载文件为 dom4j Document
	 * 
	 * @param xmlFile
	 * @return
	 * @since 2013-7-26 wangjunming
	 */
	public static Document loadAsDocument(File xmlFile) {
		SAXReader sr = new SAXReader();
		try {
			Document document = sr.read(xmlFile);
			return document;
		} catch (DocumentException e) {
			logger.warn(e.getMessage(), e);
			throw new IllegalArgumentException(e);
		}
	}

 
}
