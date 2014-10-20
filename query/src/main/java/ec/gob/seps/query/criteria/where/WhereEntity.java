/**
 * 
 */
package ec.gob.seps.query.criteria.where;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.apache.commons.collections.CollectionUtils;

import ec.gob.seps.query.criteria.WrapperPredicable;
import ec.gob.seps.query.criteria.build.BuilderWrapperPredicable;
import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeMultipleValue;
import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeNoneValue;
import ec.gob.seps.query.criteria.entity.attribute.basic.AttributeOneValue;
import ec.gob.seps.query.criteria.entity.attribute.decorator.AttributeOperadoLogico;
import ec.gob.seps.query.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.ComparacionEnum;
import ec.gob.seps.query.criteria.operador.condicion.enumeration.InterseccionEnum;
import ec.gob.seps.query.criteria.operador.condicion.factory.impl.OperadorMultipleValueFactory;
import ec.gob.seps.query.criteria.operador.condicion.factory.impl.OperadorNoneValueFactory;
import ec.gob.seps.query.criteria.operador.condicion.factory.impl.OperadorOneValueFactory;
import ec.gob.seps.query.criteria.operador.logico.impl.And;
import ec.gob.seps.query.criteria.read.entity.ReadableEntity;

/**
 * @author gortiz
 *
 */
public final class WhereEntity<T extends Serializable> extends AbstractTemplateCriteria implements WrapperPredicable {
	
	private final ReadableEntity readEntity;
	
	private WhereEntity(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField, ReadableEntity readEntity) {
		super(criteriaBuilderWhere, pathField);
		this.readEntity = readEntity;
	}

	public static <T extends Serializable> WrapperPredicable where(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField, final ReadableEntity readEntity) {
		return new WhereEntity<T>(criteriaBuilderWhere, pathField, readEntity);
	}

	public Predicate getPredicate() {
		
		BuilderWrapperPredicable builderOperadorLogico = null;
		
		if (CollectionUtils.isNotEmpty(readEntity.getBasicFields())){
			
			Predicate predicateField = null;
			
			builderOperadorLogico = new BuilderWrapperPredicable(And.andPredicate(criteriaBuilderWhere));
			
			for (final AttributeOperadoLogico<?, ?> attributeOperadoLogico : readEntity.getBasicFields()) {
				
				if (attributeOperadoLogico.getAttribute() instanceof AttributeOneValue) {
					
					predicateField = OperadorOneValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((ComparacionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeOneValue) attributeOperadoLogico.getAttribute());
					
				} else if (attributeOperadoLogico.getAttribute() instanceof AttributeMultipleValue) {
					
					predicateField = OperadorMultipleValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((InterseccionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeMultipleValue) attributeOperadoLogico.getAttribute());
					
				} else if (attributeOperadoLogico.getAttribute() instanceof AttributeNoneValue) {
					
					predicateField = OperadorNoneValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((InterseccionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeNoneValue) attributeOperadoLogico.getAttribute());
				}
				
				builderOperadorLogico.addCondicion(predicateField);
			}
		}
		
		return builderOperadorLogico != null ? builderOperadorLogico.getPredicate() : null;
	}
	
}
