/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlModuleParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-26
 */
package org.jimlgx.codeagile.parse.xml;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.jimlgx.codeagile.generate.model.MVCModule;
import org.jimlgx.codeagile.generate.model.MavenModule;
import org.jimlgx.codeagile.parse.ParseUtils;

/**
 * <code>XmlModuleParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-26
 */
public class XmlModuleParse extends AbstractParse {

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
			List<MVCModule> module = new ArrayList<MVCModule>(itr.size());

			for (Element moduleElement : itr) {
				MVCModule project = parseMavenModule(moduleElement);

				module.add(project);
			}
			return module;
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
	protected MVCModule parseMavenModule(Element moduleElement) {
		MVCModule module = new MVCModule();
		ParseUtils.parseAttributeValue(moduleElement, module, "name",
				"parseType", "pdm", "code", "version");

		parseDomainModels(moduleElement, module);
		return module;
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
