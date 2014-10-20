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
public interface FromCriteria<T extends AbstractAttribute> {
	
	From<?, ?> getFrom(T field);

}
