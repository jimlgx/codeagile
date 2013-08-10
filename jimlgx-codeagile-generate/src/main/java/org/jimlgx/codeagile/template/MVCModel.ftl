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
@Table(name = "t_${module.code}_${simpleName}")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
${modifiers} class ${simpleName} extends ${extendsClass}  {
	private static final long serialVersionUID = 1L;
	//TODO 添加${simpleName}该模型的属性和方法或者覆盖父类的方法
	
	//	
	<#list fields as field>
	/**
	 * ${field.name} 标志  值="${field.code}" 
	 * 
	 * @since ${date} ${author}
	 */
	public static final String ${field.codeUpperCase} = "${field.code}";
	</#list>
	
	<#list fields as field>
	/**
	 * ${field.javaType} ${field.code} : ${field.name}
	 * ${field.description}
	 * @since ${date} ${author}
	 */
	private ${field.javaType} ${field.code};
	
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
	public ${simpleName}(Long id) {
		super(id);
	}
	
	<#list fields as field>
	/**
	 * <code>get${field.codeHump}</code>  ${field.name}
	 * ${field.description}
	 * @return ${field.javaType}
	 * @since ${date} ${author}
	 */
	public ${field.javaType} get${field.codeHump}() {
		return this.${field.code};
	}

	/**
	 * <code>set${field.codeHump}</code>
	 * ${field.name}  ${field.description}
	 * @param ${field.code}
	 * @since ${date} ${author}
	 */
	public void set${field.codeHump}(${field.javaType} ${field.code}) {
		this.${field.code} = ${field.code};
	}

	</#list>
	
}
