/**
 * 
 */
package ec.gob.seps.query.criteria.from.fetch.impl;

import javax.persistence.criteria.From;

import org.hibernate.jpa.criteria.FromImplementor;

import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeOneValue;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeJoin;
import ec.gob.seps.query.criteria.from.AbstractTemplateFrom;
import ec.gob.seps.query.criteria.from.FromCriteria;

/**
 * @author gortiz
 *
 */
public final class FetchEntityEager extends AbstractTemplateFrom<AttributeJoin<AttributeOneValue>> {

	private FetchEntityEager(From<?, ?> from) {
		super(from);
	}
	
	public static FromCriteria<AttributeJoin<AttributeOneValue>> join(final From<?, ?> from){
		return new FetchEntityEager(from);
	}

	@Override
	public From<?, ?> getFrom(AttributeJoin<AttributeOneValue> field) {
		return (FromImplementor<?, ?>) from.fetch(field.getNombreCampo(), field.getJoinTypeCriteria().getJoinType());
	}

}
