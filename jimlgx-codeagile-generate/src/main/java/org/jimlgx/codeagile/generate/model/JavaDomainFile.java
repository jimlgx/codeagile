/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file JavaDomainFile.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-7-14
 */
package org.jimlgx.codeagile.generate.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * <code>JavaDomainFile</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-14
 */
public class JavaDomainFile extends JavaFile {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private static final long serialVersionUID = -1758005973976383665L;
	/**
	 * DomainModel domain :
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private DomainModel domain;

	/**
	 * MVCModule module :
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private MVCModule module;

	/**
	 * @return the module
	 */
	public MVCModule getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the mvcModule to set
	 */
	public void setModule(MVCModule module) {
		this.module = module;
	}

	/**
	 * List<ModelField> fields :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private List<ModelField> fields;

	/**
	 * @return the fields
	 */
	public List<ModelField> getFields() {
		if (CollectionUtils.isEmpty(fields)) {
			return this.getDomain().getFields();
		}
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<ModelField> fields) {
		this.fields = fields;
	}

	/**
	 * String paramID :主键类型
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String paramID = "Long";
	/**
	 * String paramT : model
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String paramT;
	/**
	 * String paramD : dao
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String paramD;
	/**
	 * String paramM : manager
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String paramM;
	/**
	 * String paramS : service
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String paramS;

	/**
	 * String modulePackage :
	 * 
	 * @since 2013-8-10 wangjunming
	 */
	private String modulePackage;

	// /**
	// * String tableName :对应表名称
	// *
	// * @since 2013-7-14 wangjunming
	// */
	// private String tableName;

	// /**
	// * @return the tableName
	// */
	// public String getTableName() {
	// return tableName;
	// }
	//
	// /**
	// * @param tableName
	// * the tableName to set
	// */
	// public void setTableName(String tableName) {
	// this.tableName = tableName;
	// }

	/**
	 * @return the paramID
	 */
	public String getParamID() {
		return paramID;
	}

	/**
	 * @param paramID
	 *            the paramID to set
	 */
	public void setParamID(String paramID) {
		this.paramID = paramID;
	}

	/**
	 * @return the modulePackage
	 */
	public String getModulePackage() {
		return modulePackage;
	}

	/**
	 * @param modulePackage
	 *            the modulePackage to set
	 */
	public void setModulePackage(String modulePackage) {
		this.modulePackage = modulePackage;
	}

	/**
	 * 
	 */
	public JavaDomainFile() {
		super();
	}

	/**
	 * @param domainModel
	 */
	public JavaDomainFile(DomainModel domainModel) {
		super();
		this.domain = domainModel;
	}

	/**
	 * @return the domain
	 */
	public DomainModel getDomain() {
		return domain;
	}

	/**
	 * <code>getExtendsClass</code>
	 * 
	 * @return
	 * @since 2013-8-10 wangjunming
	 */
	@Override
	public String getExtendsClass() {
		if (StringUtils.isEmpty(super.getExtendsClass())) {
			return this.getDomain().getExtendsClass();
		}
		return super.getExtendsClass();
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(DomainModel domain) {
		this.domain = domain;
	}

	/**
	 * @return the paramT
	 */
	public String getParamT() {
		return paramT;
	}

	/**
	 * @param paramT
	 *            the paramT to set
	 */
	public void setParamT(String paramT) {
		this.paramT = paramT;
	}

	/**
	 * @return the paramD
	 */
	public String getParamD() {
		return paramD;
	}

	/**
	 * @param paramD
	 *            the paramD to set
	 */
	public void setParamD(String paramD) {
		this.paramD = paramD;
	}

	/**
	 * @return the paramM
	 */
	public String getParamM() {
		return paramM;
	}

	/**
	 * @param paramM
	 *            the paramM to set
	 */
	public void setParamM(String paramM) {
		this.paramM = paramM;
	}

	/**
	 * @return the paramS
	 */
	public String getParamS() {
		return paramS;
	}

	/**
	 * @param paramS
	 *            the paramS to set
	 */
	public void setParamS(String paramS) {
		this.paramS = paramS;
	}

}
