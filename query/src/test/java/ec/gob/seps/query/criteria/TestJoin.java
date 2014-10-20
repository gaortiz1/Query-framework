/**
 * 
 */
package ec.gob.seps.query.criteria;

import java.util.Collection;
import java.util.HashSet;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import ec.gob.seps.query.criteria.delete.entidad.Catalogo;
import ec.gob.seps.query.criteria.delete.entidad.Componente;
import ec.gob.seps.query.criteria.delete.entidad.InformeHallazgoDetalle;
import ec.gob.seps.query.criteria.delete.entidad.Recomendacion;
import ec.gob.seps.query.criteria.delete.entidad.RecomendacionEstrategia;
import ec.gob.seps.query.criteria.delete.entidad.Subcomponente;

/**
 * @author gortiz
 *
 */
@RunWith(Arquillian.class)
public class TestJoin extends AbstractTestCriteria{
	
	@Test
	public void testJoinSinWhere() {
		
		Componente entity = new Componente();
		entity.setHalHallazgosSubcomponenteList(new HashSet<Subcomponente>());
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
		
	}
	
	@Test
	public void testJoinConWhere() {
		
		Componente entity = new Componente();
		entity.setAplicacion("a");
		entity.setHalHallazgosSubcomponenteList(new HashSet<Subcomponente>());
		
		Subcomponente subcomponente = new Subcomponente();
		subcomponente.setAplicacion("a");
		
		entity.getHalHallazgosSubcomponenteList().add(subcomponente);
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
		
	}
	
	@Test
	public void testJoinConWhereCompleto() {
		
		Componente entity = new Componente();
		entity.setAplicacion("b");
		entity.setNomNombre("a");
		
		entity.setHalHallazgosSubcomponenteList(new HashSet<Subcomponente>());
		
		Subcomponente subcomponente = new Subcomponente();
		subcomponente.setAplicacion("a");
		
		entity.getHalHallazgosSubcomponenteList().add(subcomponente);

		subcomponente.setHalInformesHallazgoDetalleList(new HashSet<InformeHallazgoDetalle>());
		
		InformeHallazgoDetalle informeHallazgoDetalle = new InformeHallazgoDetalle();
		informeHallazgoDetalle.setCodInformeHallazgoDetalle(1l);
		informeHallazgoDetalle.setCodArea(new Catalogo());
		informeHallazgoDetalle.getCodArea().setNomCatalogo("a");
		
		subcomponente.getHalInformesHallazgoDetalleList().add(informeHallazgoDetalle);
		
		informeHallazgoDetalle.setHalHallazgosRecomendacionList(new HashSet<Recomendacion>());		
		
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setTxtDescripcion("a");
		recomendacion.setListaRecomendacionEstrategias(new HashSet<RecomendacionEstrategia>());
		informeHallazgoDetalle.getHalHallazgosRecomendacionList().add(recomendacion);
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
		
	}

}
