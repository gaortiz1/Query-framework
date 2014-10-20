/**
 * 
 */
package ec.gob.seps.query.criteria.operador.logico.impl;

import javax.persistence.criteria.CriteriaBuilder;

import ec.gob.seps.query.criteria.WrapperPredicable;
import ec.gob.seps.query.criteria.operador.logico.AbstractTemplateOperadorLogico;

/**
 * @author gortiz
 *
 */
public final class And extends AbstractTemplateOperadorLogico {

	private And(CriteriaBuilder criteriaBuilderWhere) {
		super(criteriaBuilderWhere.conjunction());
	}
	
	public static WrapperPredicable andPredicate(final CriteriaBuilder criteriaBuilderWhere) {
        return new And(criteriaBuilderWhere);
    }
	
}
