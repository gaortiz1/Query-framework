/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.factory.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeNoneValue;
import ec.gob.seps.query.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;
import ec.gob.seps.query.criteria.operador.condicion.decorator.impl.NotDecorator;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.InterseccionEnum;
import ec.gob.seps.query.criteria.operador.condicion.factory.FactoryFieldValue;
import ec.gob.seps.query.criteria.operador.condicion.impl.IsNull;
import ec.gob.seps.query.criteria.operador.condicion.impl.NullOpeador;
import ec.gob.seps.query.criteria.operador.condicion.proxy.ProxyAttributeNoneValue;

/**
 * @author gortiz
 * 
 */
public final class OperadorNoneValueFactory extends AbstractTemplateCriteria implements FactoryFieldValue<AttributeNoneValue, InterseccionEnum> {
	
	private OperadorNoneValueFactory(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField) {
		super(criteriaBuilderWhere, pathField);
	}

	/**
	 * @return the instance
	 */
	public static FactoryFieldValue<AttributeNoneValue, InterseccionEnum> getInstance(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField) {
		return new OperadorNoneValueFactory(criteriaBuilderWhere, pathField);
	}

	public Condicionable<AttributeNoneValue> newInstance(final InterseccionEnum condicion) {

		Condicionable<AttributeNoneValue> condicionable = null;

		switch (condicion) {

		case IS_NULL:
			condicionable = IsNull.isNullPredicate(pathField);
			break;

		case IS_NOT_NULL:
			condicionable = NotDecorator.notPredicate(criteriaBuilderWhere, IsNull.isNullPredicate(pathField));
			break;
		default:
			condicionable = NullOpeador.noExistOperador();
			break;
		}

		return new ProxyAttributeNoneValue(condicionable);
	}

}
