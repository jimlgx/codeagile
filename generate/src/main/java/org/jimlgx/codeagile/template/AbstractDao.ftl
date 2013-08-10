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


/**
 * <code>AbstractDao</code>
 * 抽象Dao
 * @version ${version}
 * @author  ${author}
 * @param <T> T
 * @since 	${version}  ${date}
 */
public abstract class AbstractDao<T extends Entity<?>> extends
		BaseEntityDaoSupport<T> {
//	/**
//	 * <code>setHibernateTemplate</code>
//	 *
//	 * @param hibernateTemplate
//	 * @since   ${date}    ${author}
//	 */
//	@Override
//	@Autowired
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		super.setHibernateTemplate(hibernateTemplate);
//	}

}
