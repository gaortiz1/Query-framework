/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad que almacena la carga de los archivos
 * @author eron
 *
 */
@Entity
@Table(name="HAL_LOG_CARGA", schema="HAL")
public class LogCargaEstructura extends BaseEntidad implements Serializable{
	
	private static final long serialVersionUID = 2350308746494942565L;

	@Id
	@SequenceGenerator(schema="HAL", sequenceName="HAL_SEQ_LOG_CARGA", name="HAL_SEQ_LOG_CARGA", allocationSize=1)
	@GeneratedValue(generator="HAL_SEQ_LOG_CARGA", strategy=GenerationType.SEQUENCE)
	@Column(name="COD_LOG_CARGA")
	private Long codigo;
	
	@Column(name="NUM_RUC_ORGANIZACION")
	private String rucOrganizacion;
	
	@Column(name="FEC_CARGA")
	@Temporal(TemporalType.DATE)
	private Date fechaCarga;
	
	@Column(name="TXT_OBSERVACION_CARGA")
	private String observacion;
	
	@Lob
	@Column(name="BNR_ESTRUCTURA")
	private byte[] estructuraBlob;
	
	@Column(name="NOM_ESTRUCTURA")
	private String nombreArchivoEstruc;
	
	@Column(name="NUM_TAMANIO")
	private Long tamanioArchivo;
	
	
	public LogCargaEstructura(Long codigo){
		this.codigo = codigo;
	}
	
	public LogCargaEstructura(){
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the rucOrganizacion
	 */
	public String getRucOrganizacion() {
		return rucOrganizacion;
	}

	/**
	 * @param rucOrganizacion the rucOrganizacion to set
	 */
	public void setRucOrganizacion(String rucOrganizacion) {
		this.rucOrganizacion = rucOrganizacion;
	}

	/**
	 * @return the fechaCarga
	 */
	public Date getFechaCarga() {
		return fechaCarga;
	}

	/**
	 * @param fechaCarga the fechaCarga to set
	 */
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the estructuraBlob
	 */
	public byte[] getEstructuraBlob() {
		return estructuraBlob;
	}

	/**
	 * @param estructuraBlob the estructuraBlob to set
	 */
	public void setEstructuraBlob(byte[] estructuraBlob) {
		this.estructuraBlob = estructuraBlob;
	}

	/**
	 * @return the nombreArchivoEstruc
	 */
	public String getNombreArchivoEstruc() {
		return nombreArchivoEstruc;
	}

	/**
	 * @param nombreArchivoEstruc the nombreArchivoEstruc to set
	 */
	public void setNombreArchivoEstruc(String nombreArchivoEstruc) {
		this.nombreArchivoEstruc = nombreArchivoEstruc;
	}

	/**
	 * @return the tamanioArchivo
	 */
	public Long getTamanioArchivo() {
		return tamanioArchivo;
	}

	/**
	 * @param tamanioArchivo the tamanioArchivo to set
	 */
	public void setTamanioArchivo(Long tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}
}
