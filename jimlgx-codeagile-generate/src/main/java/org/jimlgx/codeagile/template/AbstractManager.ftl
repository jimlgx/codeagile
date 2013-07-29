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

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <code>AbstractManager</code>
 * 
 * 抽象Manager
 * @version ${version}
 * @author  ${author}
 * @param <T> T
 * @param <D> D
 * @since 	${version}  ${date}
 */
public abstract class AbstractManager<T extends Entity<?>, D extends BaseEntityDao<T>>
		extends BaseEntityManagerSupport<T, D> {
	/**
	 * <code>setDao</code>
	 * 自动注入Dao
	 * @param dao
	 * @since   ${date}    wangjunming
	 */
	@Override
	@Autowired
	public void setDao(D dao) {
		super.setDao(dao);
	}


}
