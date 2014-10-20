/**
 * 
 */
package ec.gob.seps.query.criteria;

import javax.persistence.criteria.Predicate;

/**
 * @author gortiz
 *
 */
public interface WrapperPredicable {
	
	Predicate getPredicate();

}
