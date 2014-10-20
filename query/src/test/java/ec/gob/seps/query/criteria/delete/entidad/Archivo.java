/**
 * 
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author gortiz
 *
 */
@Entity
@Table(name="TIT_ARCHIVO", schema="TIT")
public class Archivo extends BaseEntidad {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_ARCHIVO")
	@SequenceGenerator(schema="TIT", allocationSize=1, name="TIT_SEQ_ARCHIVO", sequenceName="TIT_SEQ_ARCHIVO")
	@GeneratedValue(generator="TIT_SEQ_ARCHIVO", strategy=GenerationType.SEQUENCE)
	private Long codigoArchivo;
	
	@Column(name="NOM_ARCHIVO")
	private String nombreArchivo;
	
	@Lob()
	@Column(name="TXT_DATA_XML")
	private String dataXML;
	
	@Column(name="NUM_ARCHIVO_TAMANIO")
	private Long sizeArchivo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="archivoDTO")
	private Collection<EstructuraArchivo> estructuraArchivos;

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
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return the dataXML
	 */
	public String getDataXML() {
		return dataXML;
	}

	/**
	 * @param dataXML the dataXML to set
	 */
	public void setDataXML(String dataXML) {
		this.dataXML = dataXML;
	}

	/**
	 * @return the sizeArchivo
	 */
	public Long getSizeArchivo() {
		return sizeArchivo;
	}

	/**
	 * @param sizeArchivo the sizeArchivo to set
	 */
	public void setSizeArchivo(Long sizeArchivo) {
		this.sizeArchivo = sizeArchivo;
	}

	/**
	 * @return the estructuraArchivos
	 */
	public Collection<EstructuraArchivo> getEstructuraArchivos() {
		return estructuraArchivos;
	}

	/**
	 * @param estructuraArchivos the estructuraArchivos to set
	 */
	public void setEstructuraArchivos(Collection<EstructuraArchivo> estructuraArchivos) {
		this.estructuraArchivos = estructuraArchivos;
	}
}
