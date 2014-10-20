/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.proxy;

import javax.persistence.criteria.Predicate;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeNoneValue;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public class ProxyAttributeNoneValue extends AbstractProxyField<AttributeNoneValue> {

	public ProxyAttributeNoneValue(Condicionable<AttributeNoneValue> condicion) {
		super(condicion);
	}

	@Override
	public Predicate getPredicate(AttributeNoneValue row) {
		if ( row != null && row.getNombreCampo() != null){
			return this.condicion.getPredicate(row);
		}
		return null;
	}

}
