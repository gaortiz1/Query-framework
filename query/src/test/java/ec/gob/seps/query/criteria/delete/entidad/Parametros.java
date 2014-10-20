package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Parametros
 *
 */
@Entity
@Table(name="HAL_PARAMETRO", schema = "HAL")
public class Parametros extends BaseEntidad implements Serializable {

	private static final long serialVersionUID = -6865432340941655835L;
	@Id
	@NotNull
	@Column(name = "COD_PARAMETRO")
	private Long codigo;
	
	@NotNull
	@Column(name = "NOM_DESCRIPCION")
	private String nombre;
	
	@Column(name = "TXT_VALOR")
	private String valor;
	

	public Parametros() {
	}   
	
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
   
}
