/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.pdm
 * @file PdmDomainParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-11
 */
package org.jimlgx.codeagile.parse.pdm;

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
 * <code>PdmDomainParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-11
 */
public class PdmDomainParse  implements DomainParse {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Document document;

	/**
	 * 
	 */
	public PdmDomainParse(File file) {
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
	 * <code>parseDomains</code>
	 * 
	 * 解析Domains
	 * 
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	public List<DomainModel> parse() {
		if (document != null) {

			@SuppressWarnings("unchecked")
			List<Element> itr = document.selectNodes("//c:Tables//o:Table");
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
	 * <code>parseColumns</code>
	 * 
	 * @param tableElement
	 *            Table节点
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	protected List<ModelField> parseFields(Element tableElement) {
		Element columnsElement = tableElement.element("Columns");
		if (columnsElement != null) {
			@SuppressWarnings("unchecked")
			List<Element> itr = columnsElement.elements("Column");

			List<ModelField> fields = new ArrayList<ModelField>(itr.size());
			for (Element columnElement : itr) {
				ModelField field = parseField(columnElement);
				fields.add(field);
			}

			return fields;
		}
		return null;
	}

	/**
	 * <code>parseField</code>
	 * 
	 * @param columnElement
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	protected ModelField parseField(Element columnElement) {
		String pkID = columnElement.attributeValue("Id");
		ModelField filed = new ModelField();

		filed.setDefaultValue(columnElement.elementTextTrim("DefaultValue"));
		filed.setName(columnElement.elementTextTrim("Name"));
		String dataType = parseDataType(columnElement);

		filed.setDataType(dataType);
		filed.setLength(columnElement.elementTextTrim("Length") == null ? null
				: Integer.parseInt(columnElement.elementTextTrim("Length")));

		filed.setCode(columnElement.elementTextTrim("Code"));
		filed.setUniqueSign(pkID);
		return filed;
	}

	/**
	 * <code>parseDataType</code>
	 * 
	 * 解析数据类型
	 * 
	 * @param columnElement
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	protected String parseDataType(Element columnElement) {
		String dataType = columnElement.elementTextTrim("DataType");
		if (columnElement.elementTextTrim("DataType").indexOf("(") > 0) {
			dataType = dataType.substring(0, dataType.indexOf("("));
		}
		return dataType;
	}

	/**
	 * <code>parseDomain</code>
	 * 
	 * @param tableElement
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	protected DomainModel parseDomain(Element tableElement) {
		DomainModel domain = new DomainModel();
		domain.setComment(tableElement.elementTextTrim("Comment"));
		domain.setName(tableElement.elementTextTrim("Name"));
		domain.setUniqueSign(tableElement.elementTextTrim("Code"));
		domain.setCode(tableElement.elementTextTrim("Code"));

		List<ModelField> fields = parseFields(tableElement);

		domain.setFields(fields);

		parsePrimaryKey(domain, tableElement);

		return domain;
	}

	/**
	 * <code>parsePrimaryKey</code>
	 * 
	 * 解析主键
	 * 
	 * @param domain
	 * @param tableElement
	 * @since 2013-7-11 wangjunming
	 */
	protected void parsePrimaryKey(DomainModel domain, Element tableElement) {

		if (tableElement.element("PrimaryKey") != null) {

			String keys_primarykey_ref_id = tableElement.element("PrimaryKey")
					.element("Key").attributeValue("Ref");
			logger.debug("keys_primarykey_ref_id = {}", keys_primarykey_ref_id);
			// logger.debug("tableElement = {}", tableElement.asXML());
			@SuppressWarnings("unchecked")
			List<Element> list = tableElement
					.selectNodes("//c:Keys//o:Key[@Id='"
							+ keys_primarykey_ref_id + "']");

			logger.info("list.size = {}", list.size());

			if (list != null && list.size() > 0) {
				Element element = list.get(0);
				String keys_column_ref = element.element("Key.Columns")
						.element("Column").attributeValue("Ref");
				logger.debug("keys_column_ref = {}", keys_column_ref);

				List<ModelField> fields = domain.getFields();
				if (fields == null || fields.isEmpty()) {
					throw new IllegalArgumentException(
							"the domain.fields is not empty");
				}

				for (ModelField modelField : fields) {
					if (keys_column_ref.equals(modelField.getUniqueSign())) {

						modelField.setPrimaryKey(true);
						domain.setPrimaryKey(modelField.getCode());
						break;
					}
				}
			}
		}

	}

}
