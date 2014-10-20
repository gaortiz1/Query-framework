/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.decorator;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public abstract class AbstractCondicionDecorator<T extends AbstractAttribute> implements Condicionable<T> {
	
	protected final Condicionable<T> condicion;

	protected AbstractCondicionDecorator(Condicionable<T> condicion) {
		this.condicion = condicion;
	}

}
