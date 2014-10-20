/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author gortiz
 *
 */
@Entity
@Table(name="TIT_OBSERVACION_ESTRUCTURA")
public class ObservacionEstructuraArchivo extends BaseEntidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_OBSERVACION")
	@SequenceGenerator(allocationSize=1, name="TIT_SEQ_OBS_ESTR_ARCH", sequenceName="TIT_SEQ_OBS_ESTR_ARCH")
	@GeneratedValue(generator="TIT_SEQ_OBS_ESTR_ARCH", strategy=GenerationType.SEQUENCE)
	private Long codigoObservacion;
	
	@Column(name="COD_CATAL_VALI")
	private Long codigoCatalogoValidacion;
	
	@Column(name="COD_ESTRUCTURA_ARCH")
	private Long codigoEstructuraArchivo;
	
	@Lob
	@Column(name="TXT_DATA")
	private String archivoData;
	
	@Column(name="STS_ENVIO_MAIL")
	private String estadoEnvioMail;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_CATAL_VALI", referencedColumnName="COD_CATALOGO", insertable=false, updatable=false)
	private Catalogo catalogoDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_ESTRUCTURA_ARCH", referencedColumnName="COD_ESTRUCTURA_ARCH", insertable=false, updatable=false)
	private EstructuraArchivo estructuraArchivoDTO;

	/**
	 * @return the codigoObservacion
	 */
	public Long getCodigoObservacion() {
		return codigoObservacion;
	}

	/**
	 * @param codigoObservacion the codigoObservacion to set
	 */
	public void setCodigoObservacion(Long codigoObservacion) {
		this.codigoObservacion = codigoObservacion;
	}

	/**
	 * @return the codigoCatalogoValidacion
	 */
	public Long getCodigoCatalogoValidacion() {
		return codigoCatalogoValidacion;
	}

	/**
	 * @param codigoCatalogoValidacion the codigoCatalogoValidacion to set
	 */
	public void setCodigoCatalogoValidacion(Long codigoCatalogoValidacion) {
		this.codigoCatalogoValidacion = codigoCatalogoValidacion;
	}

	/**
	 * @return the codigoEstructuraArchivo
	 */
	public Long getCodigoEstructuraArchivo() {
		return codigoEstructuraArchivo;
	}

	/**
	 * @param codigoEstructuraArchivo the codigoEstructuraArchivo to set
	 */
	public void setCodigoEstructuraArchivo(Long codigoEstructuraArchivo) {
		this.codigoEstructuraArchivo = codigoEstructuraArchivo;
	}

	/**
	 * @return the archivoData
	 */
	public String getArchivoData() {
		return archivoData;
	}

	/**
	 * @param archivoData the archivoData to set
	 */
	public void setArchivoData(String archivoData) {
		this.archivoData = archivoData;
	}

	/**
	 * @return the estadoEnvioMail
	 */
	public String getEstadoEnvioMail() {
		return estadoEnvioMail;
	}

	/**
	 * @param estadoEnvioMail the estadoEnvioMail to set
	 */
	public void setEstadoEnvioMail(String estadoEnvioMail) {
		this.estadoEnvioMail = estadoEnvioMail;
	}

	/**
	 * @return the catalogoDTO
	 */
	public Catalogo getCatalogoDTO() {
		return catalogoDTO;
	}

	/**
	 * @param catalogoDTO the catalogoDTO to set
	 */
	public void setCatalogoDTO(Catalogo catalogoDTO) {
		this.catalogoDTO = catalogoDTO;
	}

	/**
	 * @return the estructuraArchivoDTO
	 */
	public EstructuraArchivo getEstructuraArchivoDTO() {
		return estructuraArchivoDTO;
	}

	/**
	 * @param estructuraArchivoDTO the estructuraArchivoDTO to set
	 */
	public void setEstructuraArchivoDTO(EstructuraArchivo estructuraArchivoDTO) {
		this.estructuraArchivoDTO = estructuraArchivoDTO;
	}
}
