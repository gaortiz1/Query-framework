package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * 
 * @author eron
 */
@Entity
@Table(name="HAL_RECOMENDACION_ESTRATEGIA", schema = "HAL")
public class RecomendacionEstrategia extends BaseEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_REC_ESTRATEGIA")
	@SequenceGenerator(name="HAL_SEQ_REC_ESTRATEGIA", schema="HAL", sequenceName="HAL_SEQ_REC_ESTRATEGIA", allocationSize=1)
	@Basic(optional = false)
    @NotNull
	@Column(name="COD_RECOMENDACION_ESTRATEGIA")
	private Long codigo;

	@Column(name = "STS_PERMANENTE")
    private String stsPermanente;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="COD_ESTRATEGIA", referencedColumnName="COD_ESTRATEGIA")
	private Estrategia estrategia;

	@ManyToOne
	@JoinColumn(name="COD_RECOMENDACION", referencedColumnName="COD_RECOMENDACION")
	private Recomendacion recomendacion;

	public RecomendacionEstrategia() {
	}
	
	public RecomendacionEstrategia(Estrategia estrategia, Recomendacion recomendacion){
		this.estrategia = estrategia;
		this.recomendacion = recomendacion;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Estrategia getEstrategia() {
		return this.estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public Recomendacion getRecomendacion() {
		return this.recomendacion;
	}

	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}

	/**
	 * @return the stsPermanente
	 */
	public String getStsPermanente() {
		return stsPermanente;
	}

	/**
	 * @param stsPermanente the stsPermanente to set
	 */
	public void setStsPermanente(String stsPermanente) {
		this.stsPermanente = stsPermanente;
	}
}