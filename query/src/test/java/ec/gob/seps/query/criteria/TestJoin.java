/**
 * 
 */
package ec.gob.seps.query.criteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import ec.gob.seps.query.criteria.delete.entidad.Archivo;
import ec.gob.seps.query.criteria.delete.entidad.Catalogo;
import ec.gob.seps.query.criteria.delete.entidad.Componente;
import ec.gob.seps.query.criteria.delete.entidad.EstructuraArchivo;
import ec.gob.seps.query.criteria.delete.entidad.InformeHallazgoDetalle;
import ec.gob.seps.query.criteria.delete.entidad.ObservacionEstructuraArchivo;
import ec.gob.seps.query.criteria.delete.entidad.Recomendacion;
import ec.gob.seps.query.criteria.delete.entidad.RecomendacionEstrategia;
import ec.gob.seps.query.criteria.delete.entidad.Subcomponente;
import ec.gob.seps.query.criteria.delete.entidad.enums.EstadoEnvioCorreoEnum;
import ec.gob.seps.query.criteria.delete.entidad.enums.EstadoProcesamientoEnum;

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
//		informeHallazgoDetalle.getCodArea().setNomCatalogo("a");
		
		subcomponente.getHalInformesHallazgoDetalleList().add(informeHallazgoDetalle);
		
		informeHallazgoDetalle.setHalHallazgosRecomendacionList(new HashSet<Recomendacion>());		
		
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setTxtDescripcion("a");
		recomendacion.setListaRecomendacionEstrategias(new HashSet<RecomendacionEstrategia>());
		informeHallazgoDetalle.getHalHallazgosRecomendacionList().add(recomendacion);
		
		assert this.queryImpl.find(entity) == null;
		assert this.queryImpl.findAll(entity) == null;
		
	}
	
	@Test
	public void testJoinConWhereManyToOne() {
		
		final ObservacionEstructuraArchivo observacionEstructuraArchivo = new ObservacionEstructuraArchivo();
		observacionEstructuraArchivo.setEstado(null);
		observacionEstructuraArchivo.setEstadoEnvioMail(EstadoEnvioCorreoEnum.POR_ENVIAR.getEstado());
		observacionEstructuraArchivo.setEstructuraArchivoDTO(new EstructuraArchivo());
		observacionEstructuraArchivo.getEstructuraArchivoDTO().setValidez(EstadoProcesamientoEnum.PROCESADO_ERRORES.getEstadoProceso());
		observacionEstructuraArchivo.getEstructuraArchivoDTO().setEstado(null);
		
		observacionEstructuraArchivo.getEstructuraArchivoDTO().setArchivoDTO(new Archivo());
		observacionEstructuraArchivo.getEstructuraArchivoDTO().getArchivoDTO().setAplicacion("aaaa");
		
		assert this.queryImpl.find(observacionEstructuraArchivo) == null;
		assert this.queryImpl.findAll(observacionEstructuraArchivo) == null;
		
	}
	
	@Test
	public void testJoinConWhereOneToMany() {
		
		EstructuraArchivo estructuraArchivo = new EstructuraArchivo();
		
		ObservacionEstructuraArchivo observacionEstructuraArchivo = new ObservacionEstructuraArchivo();
		observacionEstructuraArchivo.setAplicacion("Aaa");
		observacionEstructuraArchivo.setArchivoData("aaaa");
		
		estructuraArchivo.setObservaciones(new ArrayList<ObservacionEstructuraArchivo>());
		estructuraArchivo.getObservaciones().add(observacionEstructuraArchivo);
		
		
		assert this.queryImpl.find(estructuraArchivo) == null;
		assert this.queryImpl.findAll(estructuraArchivo) == null;
		
	}

}
