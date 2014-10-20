/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad.enums;

/**
 * @author eron
 *
 */
public enum TipoIdentificacionEnum {
	
	CEDULA("CEDULA"),
	RUC("RUC"),
	PASAPORTE("PASAPORTE"),
	MENOR_EDAD("MENOR_EDAD"),
	OTRO("OTROS");
	
	private String tipoIdentificacion;
	
	private TipoIdentificacionEnum(String tipo){
		this.tipoIdentificacion = tipo;
	}

	/**
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

}
