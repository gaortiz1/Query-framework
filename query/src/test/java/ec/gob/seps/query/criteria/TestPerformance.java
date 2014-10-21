/**
 * 
 */
package ec.gob.seps.query.criteria;

import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Ignore;
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
//@RunWith(Arquillian.class)
public class TestPerformance extends AbstractTestCriteria{
	
	
	@Ignore
//	@Test
	public void test() {
		
		for (int i = 0; i < 10000 ; i++) {
			
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
			informeHallazgoDetalle.getCodArea().setNombre("a");
			subcomponente.getHalInformesHallazgoDetalleList().add(informeHallazgoDetalle);
			
			informeHallazgoDetalle.setHalHallazgosRecomendacionList(new HashSet<Recomendacion>());		
			
			Recomendacion recomendacion = new Recomendacion();
			recomendacion.setTxtDescripcion("a");
			recomendacion.setListaRecomendacionEstrategias(new HashSet<RecomendacionEstrategia>());
			informeHallazgoDetalle.getHalHallazgosRecomendacionList().add(recomendacion);
			System.out.println(this.queryImpl.find(entity));
			System.out.println(this.queryImpl.findAll(entity));
			
		}
	}
	

}
