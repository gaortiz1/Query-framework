package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the TXINT_CARGA_ESTRUCTURA database table.
 * 
 */
@Entity
@Table(name="TIT_ESTRUCTURA_ARCHIVO")
public class EstructuraArchivo extends BaseEntidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_ESTRUCTURA_ARCH")
	@SequenceGenerator(schema="TIT", allocationSize=1, name="TIT_SEQ_ESTRUCTURA_ARCHIVO", sequenceName="TIT_SEQ_ESTRUCTURA_ARCHIVO")
	@GeneratedValue(generator="TIT_SEQ_ESTRUCTURA_ARCHIVO", strategy = GenerationType.SEQUENCE)
	private Long codigoEstructuraArchivo;
	
	@Column(name="COD_ARCHIVO")
	private Long codigoArchivo;
	
	@Column(name="COD_ESTRUCTURA")
	private Long codigoEstructura;

	@Column(name="NUM_RUC")
	private String rucOrganizacion;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name="FEC_CORTE_DATOS")
	private Date fechaCorte;

	@Column(name="NUM_REGISTROS_CARGA")
	private Long numeroRegistro;
	
	@Column(name="STS_VALIDA_INDIVIDUAL")
	private String validacionIndividual;

	@Column(name="STS_VALIDA_CRUZADA")
	private String validacionCruzada;
	
	@Column(name="STS_VALIDA_BALANCE")
	private String validacionBalance;	

	@Column(name="STS_VALIDEZ")
	private String validez;
	
	@Column(name="STS_MAIL_ACEPTADO")
	private String envioAceptado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_ESTRUCTURA", insertable=false, updatable=false)
	private Estructura estructuraArchivoDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_ARCHIVO", insertable=false, updatable=false)
	private Archivo archivoDTO;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="estructuraArchivoDTO")
	private Collection<ObservacionEstructuraArchivo> observaciones;

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
	 * @return the codigoArchivo
	 */
	public Long getCodigoArchivo() {
		return codigoArchivo;
	}

	/**
	 * @param codigoArchivo the codigoArchivo to set
	 */
	public void setCodigoArchivo(Long codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}

	/**
	 * @return the codigoEstructura
	 */
	public Long getCodigoEstructura() {
		return codigoEstructura;
	}

	/**
	 * @param codigoEstructura the codigoEstructura to set
	 */
	public void setCodigoEstructura(Long codigoEstructura) {
		this.codigoEstructura = codigoEstructura;
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
	 * @return the fechaCorte
	 */
	public Date getFechaCorte() {
		return fechaCorte;
	}

	/**
	 * @param fechaCorte the fechaCorte to set
	 */
	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	/**
	 * @return the numeroRegistro
	 */
	public Long getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	/**
	 * @return the validacionIndividual
	 */
	public String getValidacionIndividual() {
		return validacionIndividual;
	}

	/**
	 * @param validacionIndividual the validacionIndividual to set
	 */
	public void setValidacionIndividual(String validacionIndividual) {
		this.validacionIndividual = validacionIndividual;
	}

	/**
	 * @return the validacionCruzada
	 */
	public String getValidacionCruzada() {
		return validacionCruzada;
	}

	/**
	 * @param validacionCruzada the validacionCruzada to set
	 */
	public void setValidacionCruzada(String validacionCruzada) {
		this.validacionCruzada = validacionCruzada;
	}

	/**
	 * @return the validacionBalance
	 */
	public String getValidacionBalance() {
		return validacionBalance;
	}

	/**
	 * @param validacionBalance the validacionBalance to set
	 */
	public void setValidacionBalance(String validacionBalance) {
		this.validacionBalance = validacionBalance;
	}

	/**
	 * @return the validez
	 */
	public String getValidez() {
		return validez;
	}

	/**
	 * @param validez the validez to set
	 */
	public void setValidez(String validez) {
		this.validez = validez;
	}

	/**
	 * @return the envioAceptado
	 */
	public String getEnvioAceptado() {
		return envioAceptado;
	}

	/**
	 * @param envioAceptado the envioAceptado to set
	 */
	public void setEnvioAceptado(String envioAceptado) {
		this.envioAceptado = envioAceptado;
	}

	/**
	 * @return the estructuraArchivoDTO
	 */
	public Estructura getEstructuraArchivoDTO() {
		return estructuraArchivoDTO;
	}

	/**
	 * @param estructuraArchivoDTO the estructuraArchivoDTO to set
	 */
	public void setEstructuraArchivoDTO(Estructura estructuraArchivoDTO) {
		this.estructuraArchivoDTO = estructuraArchivoDTO;
	}

	/**
	 * @return the archivoDTO
	 */
	public Archivo getArchivoDTO() {
		return archivoDTO;
	}

	/**
	 * @param archivoDTO the archivoDTO to set
	 */
	public void setArchivoDTO(Archivo archivoDTO) {
		this.archivoDTO = archivoDTO;
	}

	/**
	 * @return the observaciones
	 */
	public Collection<ObservacionEstructuraArchivo> getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(
			Collection<ObservacionEstructuraArchivo> observaciones) {
		this.observaciones = observaciones;
	}
}