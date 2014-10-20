package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIT_CATALOGO")
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo extends BaseEntidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_CATALOGO")
	private Long codigo;

	@Column(name="NOM_CATALOGO")
	private String nombre;

	@Column(name="NOM_NEMONICO")
	private String nemonico;

	@Column(name="NUM_NIVEL")
	private BigDecimal nivel;

	@Column(name="NUM_ORDEN")
	private BigDecimal orden;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="COD_CATALOGO_PADRE")
	private Catalogo catalogoPadre;

	//bi-directional many-to-one association to GrupoCatalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COD_GRP_CATALOGO")
	private GrupoCatalogo grupoCatalogo;

	public Catalogo() {
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the nivel
	 */
	public BigDecimal getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the orden
	 */
	public BigDecimal getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	/**
	 * @return the catalogoPadre
	 */
	public Catalogo getCatalogoPadre() {
		return catalogoPadre;
	}

	/**
	 * @param catalogoPadre the catalogoPadre to set
	 */
	public void setCatalogoPadre(Catalogo catalogoPadre) {
		this.catalogoPadre = catalogoPadre;
	}

	/**
	 * @return the grupoCatalogo
	 */
	public GrupoCatalogo getGrupoCatalogo() {
		return grupoCatalogo;
	}

	/**
	 * @param grupoCatalogo the grupoCatalogo to set
	 */
	public void setGrupoCatalogo(GrupoCatalogo grupoCatalogo) {
		this.grupoCatalogo = grupoCatalogo;
	}

}
