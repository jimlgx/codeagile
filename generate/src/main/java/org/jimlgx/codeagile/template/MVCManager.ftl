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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${modulePackage}.model.${paramT};
import ${modulePackage}.dao.${paramD};
/**
 * <code>${simpleName}</code>  
 * //TODO 对${simpleName}的描述注释信息
 *  ${description}
 * @version  ${version}
 * @author   ${author}
 * @since    ${version} ${date}
 */
@Transactional
@Service("${packages}.${simpleName}")
${modifiers}  class ${simpleName}  extends ${extendsClass}<${paramT},${paramID},${paramD}>  {
	//TODO 添加${simpleName}该模型的属性和方法或者覆盖父类的方法
}
