/**
 * 
 */
package ec.gob.seps.query.criteria.entity.attribute.basic;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;

/**
 * @author gortiz
 *
 */
public class AttributeOneValue extends AbstractAttribute{
	
	private final Object value;

	public AttributeOneValue(String nombreCampo, Object value) {
		super(nombreCampo);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public final Object getValue() {
		return value;
	}

}
