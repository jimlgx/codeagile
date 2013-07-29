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

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ${modulePackage}.model.${paramT};
import ${modulePackage}.service.${paramM};
/**
 * <code>${simpleName}</code>  
 * //TODO 对${simpleName}的描述注释信息
 *  ${description}
 * @version  ${version}
 * @author   ${author}
 * @since    ${version} ${date}
 */
@Controller("${packages}.${simpleName}")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
${modifiers}  class ${simpleName}  extends AbstractAction<${paramT},${paramM}>  {
	private static final long serialVersionUID = 1L;
	//TODO 添加${simpleName}该模型的属性和方法或者覆盖父类的方法
}
