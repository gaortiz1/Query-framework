/**
 * 
 */
package ec.gob.seps.query.criteria.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.gob.seps.query.criteria.impl.CriteriaJPA;

/**
 * @author gortiz
 *
 */
@Stateless
public class QueryImpl extends CriteriaJPA{
	
	@PersistenceContext(unitName = "arquillianPU")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
}
