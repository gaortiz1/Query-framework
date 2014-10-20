package ec.gob.seps.query.criteria.operador.condicion;

import javax.persistence.criteria.Predicate;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;

/**
 * 
 * @author gortiz
 *
 */
public interface Condicionable<T extends AbstractAttribute> {
	
	Predicate getPredicate(T row);

}
