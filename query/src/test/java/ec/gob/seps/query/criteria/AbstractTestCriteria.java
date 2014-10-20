/**
 * 
 */
package ec.gob.seps.query.criteria;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import ec.gob.seps.query.criteria.ejb.QueryImpl;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTestCriteria {
	
	/**
	 * @return
	 */
	@Deployment
	public static Archive<?> createDeployment() {
		
		return ShrinkWrap.create(WebArchive.class, "test-demo.war")
				.addPackages(true, "ec.gob.seps.query.criteria")
				.addPackages(true, "org.apache.commons")
				.addAsWebInfResource("jbossas-ds.xml")
				.addPackages(true, "org.hibernate.criteria")
				.addPackages(true, " org.hibernate.jpa.criteria.FromImplementor")
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@EJB(beanName="QueryImpl")
	protected QueryImpl queryImpl;

}
