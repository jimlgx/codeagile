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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <code>${simpleName}</code> ${simpleName} 
 * //TODO 记得写注释啊！
 * @version  ${version}
 * @author   ${author}
 * @since    ${version} ${date}
 */
${modifiers}  class ${simpleName} extends AbstractTransactionalJUnit4SpringContextTests {
	//测试的类
	//@Autowired
	//${testClassField};
	
    /**
     * <code>test1</code>
     *
	 * @since ${date} ${author}
     */
    @Test
    public void test1(){
    	//
    }
    
    
    /**
     * <code>main</code>
     *
     * @param args 命令参数
	 * @since ${date} ${author}
     */
    public static void main(String[] args) {
    	//
    }
}
