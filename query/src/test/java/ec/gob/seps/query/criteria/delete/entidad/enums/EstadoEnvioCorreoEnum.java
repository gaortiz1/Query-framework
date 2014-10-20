package ec.gob.seps.query.criteria.delete.entidad.enums;

public enum EstadoEnvioCorreoEnum {
	POR_ENVIAR("POR_ENVIAR"),
	ENVIADO("ENVIADO");
	
	private String estado;
	
	private EstadoEnvioCorreoEnum(String estado){
		this.estado = estado;
	}
	
	public String getEstado(){
		return this.estado;
	}
}
