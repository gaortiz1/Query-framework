/**
 * 
 */
package ec.gob.seps.query.criteria.read.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;

import org.apache.commons.collections.CollectionUtils;

import ec.gob.seps.query.criteria.WrapperPredicable;
import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeOneValue;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeJoin;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeOperadoLogico;
import ec.gob.seps.query.criteria.entity.wrapper.EntityReflectWrapper;
import ec.gob.seps.query.criteria.from.fetch.enumeration.FetchTypeWrapper;
import ec.gob.seps.query.criteria.from.join.enumeration.JoinTypeWrapper;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.ComparacionEnum;
import ec.gob.seps.query.criteria.operador.logico.impl.And;

/**
 * @author gortiz
 * @param <T>
 *
 */
public final class ReadEntity<T extends Serializable> implements ReadableEntity {
	
	private final EntityType<?> entityType;
	private final T entity;
	private final CriteriaBuilder criteriaBuilderWhere;
	
	private Set<AttributeOperadoLogico<?, ?>> basicFields = new HashSet<AttributeOperadoLogico<?, ?>>();
	private Set<AttributeJoin<?>> beanFields = new HashSet<AttributeJoin<?>>();
	
	public static <T extends Serializable> ReadableEntity read(EntityType<?> entityType, T entity, CriteriaBuilder criteriaBuilderWhere) {
		return new ReadEntity<T>(entityType, entity, criteriaBuilderWhere);
	}
	
	private ReadEntity(EntityType<?> entityType, T entity, CriteriaBuilder criteriaBuilderWhere) {
		this.entityType = entityType;
		this.entity = entity;
		this.criteriaBuilderWhere = criteriaBuilderWhere;
		buildField();
	}
	
	
	private void buildField(){
		
		if (this.entityType != null && this.entity != null){
			
			final Set<?> attributes = entityType.getAttributes();
			
			if (CollectionUtils.isNotEmpty(attributes)){
				
				for (Object objectAttribute : attributes){
					
					Attribute<?, ?> attribute = (Attribute<?, ?>) objectAttribute;
					
					final Object valueAttribute = EntityReflectWrapper.getProperty(this.entity, attribute.getName());
					
					if (valueAttribute != null){
						
						switch (attribute.getPersistentAttributeType()) {
						
						case BASIC:
							
							final AttributeOperadoLogico<AttributeOneValue, ComparacionEnum> fieldFieldOneValue = this.buildFieldWithOneValue(attribute.getName(), valueAttribute, And.andPredicate(criteriaBuilderWhere), valueAttribute instanceof CharSequence ? ComparacionEnum.LIKE : ComparacionEnum.EQUAL);
							this.basicFields.add(fieldFieldOneValue);
							
							break;
						
						case EMBEDDED:
							break;
							
						case MANY_TO_MANY : case ONE_TO_MANY : case MANY_TO_ONE:
							final AttributeJoin<AttributeOneValue> fieldBean = this.buildFieldWithObject(attribute.getName(), valueAttribute, JoinTypeWrapper.INNER, FetchTypeWrapper.EAGER);
							this.beanFields.add(fieldBean);
							
							break;

						default:
							break;
						}
						
					}
				}
				
			}
		}
		
	}
	
	private AttributeOperadoLogico<AttributeOneValue, ComparacionEnum> buildFieldWithOneValue(String nameAttribute, Object valueAttribute, WrapperPredicable operadorLogico, ComparacionEnum condicion){
		return new AttributeOperadoLogico<AttributeOneValue, ComparacionEnum>(new AttributeOneValue(nameAttribute, valueAttribute), operadorLogico, condicion);
		
	}
	
	private AttributeJoin<AttributeOneValue> buildFieldWithObject(final String nameAttribute, final Object valueAttribute, final JoinTypeWrapper joinTypeCriteria, final FetchTypeWrapper fetchTypeCriteria) {
		return new AttributeJoin<AttributeOneValue>(new AttributeOneValue(nameAttribute, valueAttribute), joinTypeCriteria, fetchTypeCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<AttributeOperadoLogico<?, ?>> getBasicFields() {
		return CollectionUtils.isNotEmpty(basicFields) ? basicFields : Collections.EMPTY_SET;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<AttributeJoin<?>> getBeanFields() {
		return CollectionUtils.isNotEmpty(beanFields) ? beanFields : Collections.EMPTY_SET;
	}

}