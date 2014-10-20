package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TIT_GRUPO_CATALOGO")
@NamedQuery(name="GrupoCatalogo.findAll", query="SELECT g FROM GrupoCatalogo g")
public class GrupoCatalogo extends BaseEntidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_GRP_CATALOGO")
	private Long codigo;
	
	@Column(name="NOM_NEMONICO")
	private String nemonico;

	@Column(name="NOM_NOMBRE")
	private String nombre;

	@Column(name="TXT_DESCRIPCION")
	private String descripcion;

	//bi-directional many-to-one association to Catalogo
	@OneToMany(mappedBy="grupoCatalogo")
	private List<Catalogo> catalogos;

	public GrupoCatalogo() {
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
	 * @return the catalogos
	 */
	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	/**
	 * @param catalogos the catalogos to set
	 */
	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}
	
}
