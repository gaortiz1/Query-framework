/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author gortiz
 *
 */
@Entity
@Table(schema="ACP", name="ACP_ESTRUCTURA")
public class Estructura extends BaseEntidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_ESTRUCTURA")
	@SequenceGenerator(schema="ACP", allocationSize=1, name="ACP_SEQ_ESTRUCTURA", sequenceName="ACP_SEQ_ESTRUCTURA")
	@GeneratedValue(generator="ACP_SEQ_ESTRUCTURA", strategy=GenerationType.SEQUENCE)
	private Long codigoEstructura;
	
	@Column(name="NOMBRE_ARCHIVO")
	private Long codigoTema;
	
	@Column(name="NOM_ESTRUCTURA")
	private String nombreEstructura;
	
	@Column(name="NOM_NEMONICO")
	private String nombreNemonico;
	
	@Column(name="STS_PERIOCIDAD")
	private String periocidad;
	
	@Column(name="NUM_DIAS_PLAZO")
	private Integer numeroDiaPlazo;
	
	@Column(name="STS_VALIDACION")
	private String validacion;
	
	@Column(name="STS_REPROCESO")
	private String reproceso;
	
	@Column(name="NUM_REPRC_DIAS")
	private Integer numeroReprcDia;
	
	@Column(name="STS_FERIADO")
	private String feriado;
	
	@Column(name="NOM_ESQUEMA")
	private String esquema;
	
	@Column(name="STS_PRECEDENCIA")
	private String precedencia;
	
	@Column(name="STS_VIGENCIA")
	private String vigencia;

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
	 * @return the codigoTema
	 */
	public Long getCodigoTema() {
		return codigoTema;
	}

	/**
	 * @param codigoTema the codigoTema to set
	 */
	public void setCodigoTema(Long codigoTema) {
		this.codigoTema = codigoTema;
	}

	/**
	 * @return the nombreEstructura
	 */
	public String getNombreEstructura() {
		return nombreEstructura;
	}

	/**
	 * @param nombreEstructura the nombreEstructura to set
	 */
	public void setNombreEstructura(String nombreEstructura) {
		this.nombreEstructura = nombreEstructura;
	}

	/**
	 * @return the nombreNemonico
	 */
	public String getNombreNemonico() {
		return nombreNemonico;
	}

	/**
	 * @param nombreNemonico the nombreNemonico to set
	 */
	public void setNombreNemonico(String nombreNemonico) {
		this.nombreNemonico = nombreNemonico;
	}

	/**
	 * @return the periocidad
	 */
	public String getPeriocidad() {
		return periocidad;
	}

	/**
	 * @param periocidad the periocidad to set
	 */
	public void setPeriocidad(String periocidad) {
		this.periocidad = periocidad;
	}

	/**
	 * @return the numeroDiaPlazo
	 */
	public Integer getNumeroDiaPlazo() {
		return numeroDiaPlazo;
	}

	/**
	 * @param numeroDiaPlazo the numeroDiaPlazo to set
	 */
	public void setNumeroDiaPlazo(Integer numeroDiaPlazo) {
		this.numeroDiaPlazo = numeroDiaPlazo;
	}

	/**
	 * @return the validacion
	 */
	public String getValidacion() {
		return validacion;
	}

	/**
	 * @param validacion the validacion to set
	 */
	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	/**
	 * @return the reproceso
	 */
	public String getReproceso() {
		return reproceso;
	}

	/**
	 * @param reproceso the reproceso to set
	 */
	public void setReproceso(String reproceso) {
		this.reproceso = reproceso;
	}

	/**
	 * @return the numeroReprcDia
	 */
	public Integer getNumeroReprcDia() {
		return numeroReprcDia;
	}

	/**
	 * @param numeroReprcDia the numeroReprcDia to set
	 */
	public void setNumeroReprcDia(Integer numeroReprcDia) {
		this.numeroReprcDia = numeroReprcDia;
	}

	/**
	 * @return the feriado
	 */
	public String getFeriado() {
		return feriado;
	}

	/**
	 * @param feriado the feriado to set
	 */
	public void setFeriado(String feriado) {
		this.feriado = feriado;
	}

	/**
	 * @return the esquema
	 */
	public String getEsquema() {
		return esquema;
	}

	/**
	 * @param esquema the esquema to set
	 */
	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	/**
	 * @return the precedencia
	 */
	public String getPrecedencia() {
		return precedencia;
	}

	/**
	 * @param precedencia the precedencia to set
	 */
	public void setPrecedencia(String precedencia) {
		this.precedencia = precedencia;
	}

	/**
	 * @return the vigencia
	 */
	public String getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	
}
