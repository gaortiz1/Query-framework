/**
 * 
 */
package ec.gob.seps.query.criteria.from.join.impl;

import javax.persistence.criteria.From;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeOneValue;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeJoin;
import ec.gob.seps.query.criteria.from.AbstractTemplateFrom;
import ec.gob.seps.query.criteria.from.FromCriteria;

/**
 * @author gortiz
 *
 */
public final class JoinEntity extends AbstractTemplateFrom<AttributeJoin<AttributeOneValue>> {
	
	private JoinEntity(From<?, ?> from) {
		super(from);
	}

	public static FromCriteria<AttributeJoin<AttributeOneValue>> join(final From<?, ?> from){
		return new JoinEntity(from);
	}

	@Override
	public From<?, ?> getFrom(final AttributeJoin<AttributeOneValue> field) {
		return from.join(field.getNombreCampo(), field.getJoinTypeCriteria().getJoinType());
	}

}
