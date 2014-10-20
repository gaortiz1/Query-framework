/**
 * 
 */
package ec.gob.seps.query.criteria.entity.attribute.decorator;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;

/**
 * @author gortiz
 * @param <T>
 *
 */
public abstract class AbstractAttributeDecorator<T extends AbstractAttribute> extends AbstractAttribute {
	
	protected final T attribute;

	protected AbstractAttributeDecorator(T attribute) {
		super(attribute.getNombreCampo());
		this.attribute = attribute;
	}

	/**
	 * @return the field
	 */
	public final T getAttribute() {
		return attribute;
	}
}
