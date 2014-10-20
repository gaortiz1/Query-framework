package ec.gob.seps.query.criteria.delete.entidad.enums;

/**
 * Enumerador que lista el tipo de validacion
 * 	VALIDO
 *  INVALIDO
 *  PENDIENTE
 * @author eron
 *
 */
public enum EstadoValidacionEnum {
	
	VALIDO("VALIDO"),
	INVALIDO("INVALIDO"),
	PENDIENTE("PENDIENTE");
	
	private String estado;
	
	private EstadoValidacionEnum(String estado){
		this.estado = estado;
	}
	
	public String getEstado(){
		return this.estado;
	}

}
