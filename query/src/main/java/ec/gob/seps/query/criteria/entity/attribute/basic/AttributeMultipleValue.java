/**
 * 
 */
package ec.gob.seps.query.criteria.entity.attribute.basic;

import ec.gob.seps.query.criteria.entity.attribute.AbstractAttribute;


/**
 * @author gortiz
 *
 */
public class AttributeMultipleValue extends AbstractAttribute{
	
	private final Object[] values;

	public AttributeMultipleValue(String nombreCampo, Object... values) {
		super(nombreCampo);
		this.values = values;
	}

	/**
	 * @return the values
	 */
	public final Object[] getValues() {
		return values.clone();
	}

}
