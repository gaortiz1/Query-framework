/**
 * 
 */
package ec.gob.seps.query.criteria.operador.condicion.factory.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeMultipleValue;
import ec.gob.seps.query.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.gob.seps.query.criteria.operador.condicion.Condicionable;
import ec.gob.seps.query.criteria.operador.condicion.decorator.impl.NotDecorator;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.InterseccionEnum;
import ec.gob.seps.query.criteria.operador.condicion.factory.FactoryFieldValue;
import ec.gob.seps.query.criteria.operador.condicion.impl.In;
import ec.gob.seps.query.criteria.operador.condicion.impl.NullOpeador;
import ec.gob.seps.query.criteria.operador.condicion.proxy.ProxyAttributeMultipleValue;

/**
 * @author gortiz
 *
 */
public final class OperadorMultipleValueFactory extends AbstractTemplateCriteria implements FactoryFieldValue<AttributeMultipleValue, InterseccionEnum> {

	private OperadorMultipleValueFactory(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField) {
		super(criteriaBuilderWhere, pathField);
	}

	/**
	 * @return the instance
	 */
	public static FactoryFieldValue<AttributeMultipleValue, InterseccionEnum> getInstance(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField) {
		return new OperadorMultipleValueFactory(criteriaBuilderWhere, pathField);
	}

	@Override
	public Condicionable<AttributeMultipleValue> newInstance(InterseccionEnum condicion) {
		
		Condicionable<AttributeMultipleValue> condicionable = null;

		switch (condicion) {

		case IN:
			condicionable = In.inPredicate(pathField);
			break;
			
		case NOT_IN:
			condicionable = NotDecorator.notPredicate(criteriaBuilderWhere, In.inPredicate(pathField));
			break;

		default:
			condicionable = NullOpeador.noExistOperador();
			break;
		}

		return new ProxyAttributeMultipleValue(condicionable);
	}

}
