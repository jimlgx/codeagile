/*
 * @project ${projectName}
 * @package ${packages}
 * @file ${fileName}
 * @version  ${version}
 * @author  ${author}
 * @time  ${dateTime}
 * CopyRight:${copyRight}
 */
package ${packages};

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * <code>${simpleName}</code>  
 * 
 * //TODO 对${simpleName}的描述注释信息
 *  ${description}
 * @version  ${version}
 * @author   ${author}
 * @since    ${version} ${date}
 */
@Entity
@Table(name = "t_${moduleNameTable}_${simpleName}")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
${modifiers} class ${simpleName} extends ${extendsClass}  {
	private static final long serialVersionUID = 1L;
	//TODO 添加${simpleName}该模型的属性和方法或者覆盖父类的方法
	
	//	
	<#list fileds as filed>
	/**
	 * ${filed.name} 标志  值="${filed.value}" 
	 * 
	 * @since ${date} ${author}
	 */
	public static final String ${filed.valueUpperCase} = "${filed.value}";
	</#list>
	
	<#list fileds as filed>
	/**
	 * ${filed.type} ${filed.value} : ${filed.name}
	 * ${filed.description}
	 * @since ${date} ${author}
	 */
	private ${filed.type} ${filed.value};
	
	</#list>
	
	/**
	 * 
	 */
	public ${simpleName}() {
		super();
	}

	/**
	 * @param id
	 */
	public ${simpleName}(Serializable id) {
		super(id);
	}
	
	<#list fileds as filed>
	/**
	 * <code>get${filed.valueHump}</code>  ${filed.name}
	 * ${filed.description}
	 * @return ${filed.type}
	 * @since ${date} ${author}
	 */
	public ${filed.type} get${filed.valueHump}() {
		return this.${filed.value};
	}

	/**
	 * <code>set${filed.valueHump}</code>
	 * ${filed.name}  ${filed.description}
	 * @param ${filed.value}
	 * @since ${date} ${author}
	 */
	public void set${filed.valueHump}(${filed.type} ${filed.value}) {
		this.${filed.value} = ${filed.value};
	}

	</#list>
	
}
