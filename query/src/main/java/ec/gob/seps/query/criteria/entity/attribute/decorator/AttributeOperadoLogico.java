/**
 * 
 */
package ec.gob.seps.query.criteria.entity.attribute.decorator;

import ec.gob.seps.query.criteria.WrapperPredicable;
import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.EnumCondicion;

/**
 * @author gortiz
 *
 */
public class AttributeOperadoLogico<T extends AbstractAttribute, E extends EnumCondicion> extends AbstractAttributeDecorator<T> {
	
	private final WrapperPredicable operadorLogico;
	private final E comparacionEnum;

	public AttributeOperadoLogico(T field, WrapperPredicable operadorLogico, E comparacionEnum) {
		super(field);
		this.operadorLogico = operadorLogico;
		this.comparacionEnum = comparacionEnum;
	}

	/**
	 * @return the operadorLogico
	 */
	public WrapperPredicable getOperadorLogico() {
		return operadorLogico;
	}

	/**
	 * @return the comparacionEnum
	 */
	public E getComparacionEnum() {
		return comparacionEnum;
	}

}
