package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReglasNegocio extends BaseEntidad implements Serializable{
	
	private static final long serialVersionUID = 5567508176211120193L;

	@Id
	@Column(name="COD_REGLA_NEGOCIO")
	private Long codigo;
	
	@Column(name="NOM_ESTRUCTURA")
	private String estructura;
	
	@Column(name="NOM_NEMONICO")
	private String nemonico;
	
	@Column(name="NOM_DESCRIPCION")
	private String descripcion;
	
	@Column(name="NOM_SEGMENTO1")
	private String segmento1;
	
	@Column(name="NOM_SEGMENTO2")
	private String segmento2;
	
	@Column(name="NOM_SEGMENTO3")
	private String segmento3;
	
	@Column(name="NOM_SEGMENTO4")
	private String segmento4;
	
	public ReglasNegocio(){
		super();
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
	 * @return the estructura
	 */
	public String getEstructura() {
		return estructura;
	}

	/**
	 * @param estructura the estructura to set
	 */
	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}

	/**
	 * @return the nemonico
	 */
	public String getNemonico() {
		return nemonico;
	}

	/**
	 * @param nemonico the nemonico to set
	 */
	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the segmento1
	 */
	public String getSegmento1() {
		return segmento1;
	}

	/**
	 * @param segmento1 the segmento1 to set
	 */
	public void setSegmento1(String segmento1) {
		this.segmento1 = segmento1;
	}

	/**
	 * @return the segmento2
	 */
	public String getSegmento2() {
		return segmento2;
	}

	/**
	 * @param segmento2 the segmento2 to set
	 */
	public void setSegmento2(String segmento2) {
		this.segmento2 = segmento2;
	}

	/**
	 * @return the segmento3
	 */
	public String getSegmento3() {
		return segmento3;
	}

	/**
	 * @param segmento3 the segmento3 to set
	 */
	public void setSegmento3(String segmento3) {
		this.segmento3 = segmento3;
	}

	/**
	 * @return the segmento4
	 */
	public String getSegmento4() {
		return segmento4;
	}

	/**
	 * @param segmento4 the segmento4 to set
	 */
	public void setSegmento4(String segmento4) {
		this.segmento4 = segmento4;
	}
}
