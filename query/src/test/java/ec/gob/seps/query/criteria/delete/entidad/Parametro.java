package ec.gob.seps.query.criteria.delete.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the TXINT_PARAMETRO database table.
 * 
 */
@Entity
@Table(name="TIT_PARAMETRO")
public class Parametro extends BaseEntidad {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(schema="TIT", allocationSize=1, name="TIT_SEQ_PARAMETRO", sequenceName="TIT_SEQ_PARAMETRO")
	@GeneratedValue(generator="TIT_SEQ_PARAMETRO", strategy = GenerationType.SEQUENCE)
	@Column(name="COD_PARAMETRO")
	private long codigo;

	@Column(name="NOM_NEMONICO")
	private String nemonico;

	@Column(name="NOM_VALOR")
	private String valor;

	@Column(name="TXT_DESCRIPCION")
	private String descripcion;

	public Parametro() {
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNemonico() {
		return nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}