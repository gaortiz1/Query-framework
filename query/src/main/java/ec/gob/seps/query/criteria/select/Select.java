/**
 * 
 */
package ec.gob.seps.query.criteria.select;

import java.io.Serializable;

import javax.persistence.criteria.From;
import javax.persistence.metamodel.EntityType;

import ec.gob.seps.query.criteria.WrapperPredicable;

/**
 * @author gortiz
 *
 */
public interface Select {
	
	<T extends Serializable> WrapperPredicable getWhere(T entity, From<?, ?> from, EntityType<?> entityType);
	
}
