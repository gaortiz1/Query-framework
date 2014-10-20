/**
 * 
 */
package ec.gob.seps.query.criteria;

import java.util.Date;

import javax.validation.constraints.AssertFalse;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import ec.gob.seps.query.criteria.delete.entidad.Catalogo;
import ec.gob.seps.query.criteria.delete.entidad.Componente;
import ec.gob.seps.query.criteria.delete.entidad.Hallazgo;

/**
 * @author gortiz
 *
 */
@RunWith(Arquillian.class)
public class TestEqual extends AbstractTestCriteria{
	
	
	@Test
	@AssertFalse
	public void testMetodoFindLIKE() {
		
		Componente entity = new Componente();
		entity.setAplicacion("a");
		entity.setCodHallazgoComponente(1l);
		entity.setNomNombre("a");
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
	}
	
	@Test
	@AssertFalse
	public void testMetodoFindAllLIKE() {
		
		
		Componente entity = new Componente();
		entity.setAplicacion("a");
		entity.setCodHallazgoComponente(1l);
		entity.setNomNombre("a");
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
	}
	
	@Test
	@AssertFalse
	public void testMetodoFindEqual() {
		Catalogo entity = new Catalogo();
		entity.setFechaActualiza(new Date());
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
	}
	
	@Test
	@AssertFalse
	public void testMetodoFindAllEqual() {
		Catalogo entity = new Catalogo();
		entity.setFechaActualiza(new Date());
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
	}
	
	@Test
	@AssertFalse
	public void testMetodoFindAllWithOutParameter() {
		assert this.queryImpl.find(new Catalogo()) == null;
		assert this.queryImpl.findAll(new Hallazgo()) == null;
	}

}
