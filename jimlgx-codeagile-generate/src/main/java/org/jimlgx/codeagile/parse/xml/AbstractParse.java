/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.parse.xml
 * @file AbstractParse.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-26
 */
package org.jimlgx.codeagile.parse.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>AbstractParse</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-26
 */
public abstract class AbstractParse {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	// private Document document;
	/**
	 * Element element :
	 * 
	 * @since 2013-7-26 wangjunming
	 */
	private Element element;

	/**
	 * @param element
	 */
	public AbstractParse(Element element) {
		super();
		this.element = element;
	}

	/**
	 * 
	 */
	public AbstractParse() {
		super();
	}

	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}

}
