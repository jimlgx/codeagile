/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file AbstractModel.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-11
 */
package org.jimlgx.codeagile.generate.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * <code>AbstractModel</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-11
 */
public class AbstractModel implements Serializable {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	private static final long serialVersionUID = -6529236160284596075L;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * String name : 名称
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String name;
	/**
	 * String uniqueSign :唯一标志
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String uniqueSign;
	/**
	 * String code :代码标志
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private String code;

	/**
	 * String description :描述
	 * 
	 * @since 2013-4-14 wangjunming
	 */
	private String description;
	/**
	 * String comment :注释
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private String comment;

	/**
	 * String creator :创建者
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private String creator;
	/**
	 * Date createTime :创建时间
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	private Date createTime = new Date();

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * <code>getDate</code>
	 * 
	 * 获得日期
	 * 
	 * @return
	 * @since 2013-7-30 wangjunming
	 */
	public String getDate() {
		return DateFormatUtils.format(getCreateTime(), "yyyy-MM-dd");
	}

	public String getDateTime() {
		return DateFormatUtils.format(getCreateTime(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the uniqueSign
	 */
	public String getUniqueSign() {
		return uniqueSign;
	}

	/**
	 * @param uniqueSign
	 *            the uniqueSign to set
	 */
	public void setUniqueSign(String uniqueSign) {
		this.uniqueSign = uniqueSign;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		Assert.notNull(code, "code not null");
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		Assert.notNull(code, "code not null");
		this.code = code;
	}

	/**
	 * <code>toString</code>
	 * 
	 * @return
	 * @since 2013-7-11 wangjunming
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
