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
public final class Or extends AbstractTemplateOperadorLogico{

	private Or(CriteriaBuilder criteriaBuilder) {
		super(criteriaBuilder.disjunction());
	}
	
	public static WrapperPredicable orPredicate(final CriteriaBuilder criteriaBuilder) {
        return new Or(criteriaBuilder);
    }
}
