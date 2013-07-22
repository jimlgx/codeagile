/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file XmlDomainParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-19
 */
package org.jimlgx.codeagile.parse.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jimlgx.codeagile.generate.model.DomainModel;
import org.jimlgx.codeagile.generate.model.ModelField;
import org.jimlgx.codeagile.parse.DomainParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>XmlDomainParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-19
 */
public class XmlDomainParse implements DomainParse {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Document document;

	/**
	 * 
	 */
	public XmlDomainParse(File file) {
		super();
		SAXReader sr = new SAXReader();
		try {
			document = sr.read(file);
		} catch (DocumentException e) {
			throw new IllegalArgumentException("the " + file.getPath()
					+ " not pdm file", e);
		}
	}

	/**
	 * 
	 */
	public XmlDomainParse() {
		super();
	}

	/**
	 * <code>parseDomains</code>
	 * 
	 * @return
	 * @since 2013-7-19 wangjunming
	 */
	public List<DomainModel> parseDomains() {
		if (document != null) {

			@SuppressWarnings("unchecked")
			List<Element> itr = document.selectNodes("//models//model");
			List<DomainModel> domains = new ArrayList<DomainModel>(itr.size());

			for (Element tableElement : itr) {
				DomainModel domain = parseDomain(tableElement);

				domains.add(domain);
			}
			return domains;
		}
		return null;
	}

	/**
	 * <code>parseDomain</code>
	 * 
	 * @param tableElement
	 * @return
	 * @since 2013-7-22 wangjunming
	 */
	protected DomainModel parseDomain(Element tableElement) {
		DomainModel domain = new DomainModel();
		String name = tableElement.attributeValue("name");
		String description = tableElement.attributeValue("description");
		String code = tableElement.attributeValue("code");
		domain.setName(name);
		domain.setDescription(description);
		domain.setCode(code);
		List<ModelField> fieldList = parseFields(tableElement);
		domain.setFields(fieldList);
		return domain;
		// return null;
	}

	/**
	 * <code>parseFields</code>
	 * 
	 * @param tableElement
	 * @return
	 * @since 2013-7-22 wangjunming
	 */
	protected List<ModelField> parseFields(Element tableElement) {
		List<Element> itr = tableElement.selectNodes("//models//model");
		List<ModelField> fields = new ArrayList<ModelField>(itr.size());

		for (Element fieldElement : itr) {
			ModelField field = parseField(fieldElement);
			fields.add(field);
		}
		return fields;
	}

	/**
	 * <code>parseField</code>
	 * 
	 * @param fieldElement
	 * @return
	 * @since 2013-7-22 wangjunming
	 */
	private ModelField parseField(Element fieldElement) {
		ModelField field = new ModelField();
		String name = fieldElement.attributeValue("name");
		String description = fieldElement.attributeValue("description");
		String code = fieldElement.attributeValue("code");

		String javaType = fieldElement.attributeValue("type");

		field.setName(name);
		field.setDescription(description);
		field.setCode(code);
		field.setJavaType(javaType);
		return field;
	}

}
