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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * <code>AbstractModel</code>
 * 
 * @version ${version}
 * @author  ${author}
 * @since 	${version}  ${date}
 *
 */
@MappedSuperclass
${modifiers} abstract class AbstractModel extends EntityIntegerImpl {
	/** 
	 * long serialVersionUID :       
	 * @since  ${date} ${author}
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AbstractModel() {
		super();
	}

	/**
	 * @param id
	 */
	public AbstractModel(Serializable id) {
		super(id);
	}


	/**
	 * @return the id 实体的唯一性标志
	 */
	@Override
	@Id
	//@GenericGenerator(name = "generator", strategy = BaseEntityConstants.GENERIC_GENERATOR_STATEGY_ASSIGNED_AND_HILO)
	@GeneratedValue(generator = "generator")
	@Column(name = ConstantsModel.ID)
	public Integer getId() {
		return this.id;
	}

}
