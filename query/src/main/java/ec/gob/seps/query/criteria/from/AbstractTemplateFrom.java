/**
 * 
 */
package ec.gob.seps.query.criteria.from;

import javax.persistence.criteria.From;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTemplateFrom<T extends AbstractAttribute> implements FromCriteria<T> {
	
	protected final From<?, ?> from;

	protected AbstractTemplateFrom(From<?, ?> from) {
		this.from = from;
	}

}