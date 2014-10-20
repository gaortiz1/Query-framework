/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.factory;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.EnumCondicion;

/**
 * @author gortiz
 *
 */
public interface FactoryFieldValue<F extends AbstractAttribute, E extends EnumCondicion> {
	
	Condicionable<F> newInstance(final E condicion);

}
