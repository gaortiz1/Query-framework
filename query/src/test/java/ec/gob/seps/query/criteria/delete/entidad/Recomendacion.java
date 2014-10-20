/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eron
 */
@Entity
@Table(name = "HAL_RECOMENDACION", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "Recomendacion.findAll", query = "SELECT h FROM Recomendacion h"),
    @NamedQuery(name = "Recomendacion.buscarPorHallazgo", query = "select o from Recomendacion o where o.codInformeHallazgoDetalle.codInformeHallazgoDetalle =  :codigoHallazgo")})
public class Recomendacion extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_RECOMENDACION")
    @SequenceGenerator(name="HAL_SEQ_RECOMENDACION", schema="HAL", sequenceName="HAL_SEQ_RECOMENDACION", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RECOMENDACION")
    private Long codHallazgoRecomendacion;
    
    @NotNull
    @Column(name = "NUM_RECOMENDACION")
    private Integer numRecomendacion;
    
    @NotNull
    @Size(max = 1500)
    @Column(name = "TXT_DESCRIPCION")
    private String txtDescripcion;
        
    @NotNull
    @Column(name = "STS_PERMANENTE")
    private String stsPermanente;
       
    @JoinColumn(name = "COD_HALLAZGO", referencedColumnName = "COD_HALLAZGO")
    @ManyToOne
    private InformeHallazgoDetalle codInformeHallazgoDetalle;
  	
    @OneToMany(mappedBy="recomendacion", fetch=FetchType.EAGER)
  	private Set<RecomendacionEstrategia> listaRecomendacionEstrategias;

    public Recomendacion(Integer numRecomendacion, String txtDescripcion) {
    	this.numRecomendacion = numRecomendacion;
    	this.txtDescripcion = txtDescripcion;
    }

    public Recomendacion(Long codHallazgoRecomendacion) {
        this.codHallazgoRecomendacion = codHallazgoRecomendacion;
    }
    
    public Recomendacion() {
       
    }

    public Long getCodHallazgoRecomendacion() {
        return codHallazgoRecomendacion;
    }

    public void setCodHallazgoRecomendacion(Long codHallazgoRecomendacion) {
        this.codHallazgoRecomendacion = codHallazgoRecomendacion;
    }

    public Integer getNumRecomendacion() {
        return numRecomendacion;
    }

    public void setNumRecomendacion(Integer numRecomendacion) {
        this.numRecomendacion = numRecomendacion;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InformeHallazgoDetalle getCodInformeHallazgoDetalle() {
        return codInformeHallazgoDetalle;
    }

    public void setCodInformeHallazgoDetall(InformeHallazgoDetalle codInformeHallazgoDetalle) {
        this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
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

	/**
	 * @return the listaRecomendacionEstrategias
	 */
	public final Set<RecomendacionEstrategia> getListaRecomendacionEstrategias() {
		return listaRecomendacionEstrategias;
	}

	/**
	 * @param listaRecomendacionEstrategias the listaRecomendacionEstrategias to set
	 */
	public final void setListaRecomendacionEstrategias(
			Set<RecomendacionEstrategia> listaRecomendacionEstrategias) {
		this.listaRecomendacionEstrategias = listaRecomendacionEstrategias;
	}

	/**
	 * @param codInformeHallazgoDetalle the codInformeHallazgoDetalle to set
	 */
	public final void setCodInformeHallazgoDetalle(
			InformeHallazgoDetalle codInformeHallazgoDetalle) {
		this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
	}

	
}