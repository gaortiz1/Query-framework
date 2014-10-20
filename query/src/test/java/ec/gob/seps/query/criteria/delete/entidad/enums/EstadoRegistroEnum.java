package ec.gob.seps.query.criteria.delete.entidad.enums;

public enum EstadoRegistroEnum {

	/**
     * Estados para eliminacion logica de registros.
     */
	ESTADO_ACTIVO("ACT"),
    ESTADO_INACTIVO("INA");
    
    private String estado;

    /**
     * Constructor.
     * @param codigo - codigo.
     */
    private EstadoRegistroEnum(String estado) {
        this.estado = estado;
    }

    /**
     * Getter codigo.
     * @return codigo
     */
    public String getEstado() {
        return estado;
    }
}
