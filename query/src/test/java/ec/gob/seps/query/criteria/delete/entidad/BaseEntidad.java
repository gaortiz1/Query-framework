/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.gob.seps.query.criteria.delete.entidad.enums.EstadoRegistroEnum;

/**
 * @author eron
 *
 */
@MappedSuperclass
public class BaseEntidad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 1, max = 10)
    @Column(name = "STS_ESTADO")
    private String estado;
    
	@Column(name = "FEC_FECHA_CRC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
	@Size(max = 50)
    @Column(name = "NOM_USUARIO_CRC")
    private String usuarioCreacion;
    
	@Column(name = "FEC_FECHA_ACT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualiza;
    
	@Size(max = 50)
    @Column(name = "NOM_USUARIO_ACT")
    private String usuarioActualiza;
    
	@Size(max = 100)
    @Column(name = "NOM_APL")
    private String aplicacion;
    
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	
	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	/**
	 * @return the fechaActualiza
	 */
	public Date getFechaActualiza() {
		return fechaActualiza;
	}
	
	/**
	 * @param fechaActualiza the fechaActualiza to set
	 */
	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	
	/**
	 * @return the usuarioActualiza
	 */
	public String getUsuarioActualiza() {
		return usuarioActualiza;
	}
	
	/**
	 * @param usuarioActualiza the usuarioActualiza to set
	 */
	public void setUsuarioActualiza(String usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}
	
	/**
	 * @return the aplicacion
	 */
	public String getAplicacion() {
		return aplicacion;
	}
	
	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	@PrePersist
	public void setFechaCreacion(){
		this.fechaCreacion = Calendar.getInstance().getTime();
	}
	
	@PreUpdate
	public void setFechaActualizacion(){
		this.fechaActualiza = Calendar.getInstance().getTime();
	}

}
