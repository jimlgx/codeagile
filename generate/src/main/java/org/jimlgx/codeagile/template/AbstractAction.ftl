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

import com.zrtech.core.model.Entity;
import com.zrtech.base.module.entity.service.BaseEntityManager;
import com.zrtech.base.module.web.webapp.BaseWebActionSupport;

/**
 * <code>AbstractAction</code>
 * 
  *    抽象Action
 * @version ${version}
 * @author  ${author}
 * @param <T> 
 * @param <M> 
 * @since 	${version}  ${date}
 */
public abstract class AbstractAction<T extends Entity<?>, M extends BaseEntityManager<T, ?>>
		extends BaseWebActionSupport<T, M> {
	private static final long serialVersionUID = 2428777535869157423L;

	/**
	 * <code>setManager</code>
	 * 自动注入Manager
	 * @param manager
	 * @since    ${date} ${author}
	 */
	@Override
	@Autowired
	public void setManager(M manager) {
		super.setManager(manager);
	}

}
