package ec.gob.seps.query.criteria.delete.entidad.enums;

/**
 * Enumerador que indica los estados de procesamiento de las 
 * estructuras cargadas y validadas en batch
 * @author eron
 *
 */
public enum EstadoProcesamientoEnum {
	
	POR_PROCESAR("PP"),
	PROCESADO_CORRECTO("PC"),
	PROCESADO_ERRORES("PE"),
	POR_GUARDAR("PG");
	
	private String estadoProceso;
	
	private EstadoProcesamientoEnum(String estado){
		this.estadoProceso = estado;
	}
	
	public String getEstadoProceso(){
		return this.estadoProceso;
	}
}
