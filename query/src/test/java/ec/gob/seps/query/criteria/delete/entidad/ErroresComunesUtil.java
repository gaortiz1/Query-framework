package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ErroresComunesUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="tipoTransaccion")
	private String tipoTransaccion;
	
	@Column(name="numeroTransaccion")
	private String numeroTransaccion;
	
	@Column(name="motivoEconomicoTransaccion")
	private String motivoEconomicoTransaccion;

	/**
	 * @return the tipoTransaccion
	 */
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * @return the numeroTransaccion
	 */
	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	/**
	 * @param numeroTransaccion the numeroTransaccion to set
	 */
	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	/**
	 * @return the motivoEconomicoTransaccion
	 */
	public String getMotivoEconomicoTransaccion() {
		return motivoEconomicoTransaccion;
	}

	/**
	 * @param motivoEconomicoTransaccion the motivoEconomicoTransaccion to set
	 */
	public void setMotivoEconomicoTransaccion(String motivoEconomicoTransaccion) {
		this.motivoEconomicoTransaccion = motivoEconomicoTransaccion;
	}
		
}
