/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.proxy;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public abstract class AbstractProxyField<T extends AbstractAttribute> implements Condicionable<T> {
	
	protected final Condicionable<T> condicion;

	protected AbstractProxyField(Condicionable<T> condicion) {
		this.condicion = condicion;
	}

}
