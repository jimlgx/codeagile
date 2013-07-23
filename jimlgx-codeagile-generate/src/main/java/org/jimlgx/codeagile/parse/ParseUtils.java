/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse
 * @file ParseUtils.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-23
 */
package org.jimlgx.codeagile.parse;

import java.lang.reflect.Method;

import org.apache.maven.model.Model;
import org.codehaus.plexus.util.StringUtils;
import org.dom4j.Element;
import org.jimlgx.common.util.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.google.common.reflect.Reflection;

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
	 * <code>parse</code>
	 * 
	 * 统一解析对象
	 * 
	 * @param element
	 * @param modle
	 * @param strings
	 * @since 2013-7-23 wangjunming
	 */
	public static void parse(Element element, Object modle, String... strings) {
		Assert.notNull(element);
		Assert.notNull(modle);
		for (String attributeName : strings) {
			String value = element.attributeValue(attributeName);
			if (StringUtils.isNotBlank(value)) {
				try {
					String setter = PropertyUtils.parseSetter(attributeName);
					Method method = ReflectionUtils.findMethod(
							modle.getClass(), setter);
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
}
