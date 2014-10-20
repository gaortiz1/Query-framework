package ec.gob.seps.query.criteria.operador.condicion.impl;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeNoneValue;
import ec.gob.seps.query.criteria.operador.condicion.AbstractTemplatePath;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;

/**
 * 
 * @author gortiz
 *
 */
public final class IsNull extends AbstractTemplatePath implements Condicionable<AttributeNoneValue> {
	
	private IsNull(final Path<?> pathField){
		super(pathField);
	}
	
	public static IsNull isNullPredicate(final Path<?> pathField) {
        return new IsNull(pathField);
    }

	@Override
	public Predicate getPredicate(final AttributeNoneValue field) {
		return this.pathField.get(field.getNombreCampo()).isNull();
	}

}
