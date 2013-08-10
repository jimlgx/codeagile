/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlModuleParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-26
 */
package org.jimlgx.codeagile.parse.xml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.dom4j.Element;
import org.jimlgx.codeagile.generate.model.DomainGenerate;
import org.jimlgx.codeagile.generate.model.DomainGenerateMVC;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.jimlgx.codeagile.generate.model.MVCModule;
import org.jimlgx.codeagile.generate.model.ModuleUtils;
import org.jimlgx.codeagile.parse.ParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * <code>XmlModuleParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-26
 */
public class XmlModuleParse extends AbstractParse {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public XmlModuleParse() {
		super();
	}

	/**
	 * @param element
	 */
	public XmlModuleParse(Element element) {
		super(element);
	}

	/**
	 * <code>parse</code>
	 * 
	 * @return
	 * @since 2013-7-23 wangjunming
	 */
	public List<MVCModule> parse() {

		if (getElement() != null) {

			@SuppressWarnings("unchecked")
			List<Element> itr = getElement().selectNodes("//modules//module");
			List<MVCModule> modules = new ArrayList<MVCModule>(itr.size());

			for (Element moduleElement : itr) {
				MVCModule module = parseMVCModule(moduleElement);

				modules.add(module);
			}
			return modules;
		}
		return null;
	}

	/**
	 * <code>parseMavenModule</code>
	 * 
	 * @param moduleElement
	 * @return
	 * @since 2013-7-26 wangjunming
	 */
	protected MVCModule parseMVCModule(Element moduleElement) {
		MVCModule module = new MVCModule();
		ParseUtils.parseAttributeValue(moduleElement, module, "name",
				"parseType", "pdm", "code", "version");

		parseDomainModels(moduleElement, module);
		parseGenerates(moduleElement, module);

		return module;
	}

	/**
	 * <code>parseGenerates</code>
	 * 
	 * @param moduleElement
	 * @param module
	 * @since 2013-8-2 wangjunming
	 */
	private void parseGenerates(Element moduleElement, MVCModule module) {

		List<Element> itr = getElement().selectNodes("//generates//bean");
		if (CollectionUtils.isEmpty(itr)) {
			// 添加默认的 生成器
			module.setDomainGenerates(Arrays.asList(new DomainGenerateMVC(
					module)));

		} else {
			// 解析配置好的生成器
			List<DomainGenerate> generates = new ArrayList<DomainGenerate>(
					itr.size());
			for (Element element : itr) {
				String generate = element.attributeValue("name");
				if ("mvc".equalsIgnoreCase(generate)) {
					generates.add(new DomainGenerateMVC(module));
				} else {
					DomainGenerate generate2 = ModuleUtils
							.reflectionNewInstance(module, generate);
					if (generate2 != null) {
						generates.add(generate2);
					}
				}
			}

			if (!CollectionUtils.isEmpty(generates)) {
				module.setDomainGenerates(generates);
			} else {
				logger.warn("config generate is error");
			}
		}

	}

	/**
	 * <code>parseDomainModels</code>
	 * 
	 * @param moduleElement
	 * @param module
	 * @since 2013-7-29 wangjunming
	 */
	protected void parseDomainModels(Element moduleElement, MVCModule module) {
		try {
			XmlDomainParse domainParse = new XmlDomainParse(moduleElement);
			List<DomainModel> domains = domainParse.parse();
			module.setDomains(domains);
		} catch (RuntimeException e) {
			// e.printStackTrace();
			logger.warn("parseModule error");
			logger.warn(e.getMessage(), e);
		}
	}
}
