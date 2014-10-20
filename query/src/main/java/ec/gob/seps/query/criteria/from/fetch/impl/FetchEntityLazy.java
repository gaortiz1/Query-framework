/**
 * 
 */
package ec.gob.seps.query.criteria.from.fetch.impl;

import javax.persistence.criteria.From;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeOneValue;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeJoin;
import ec.gob.seps.query.criteria.from.AbstractTemplateFrom;
import ec.gob.seps.query.criteria.from.FromCriteria;

/**
 * @author gortiz
 *
 */
public final class FetchEntityLazy extends AbstractTemplateFrom<AttributeJoin<AttributeOneValue>> {

	private FetchEntityLazy(From<?, ?> from) {
		super(from);
	}
	
	public static FromCriteria<AttributeJoin<AttributeOneValue>> join(final From<?, ?> from){
		return new FetchEntityLazy(from);
	}

	@Override
	public From<?, ?> getFrom(AttributeJoin<AttributeOneValue> field) {
		return (From<?, ?>) from.fetch(field.getNombreCampo(), field.getJoinTypeCriteria().getJoinType());
	}

}
