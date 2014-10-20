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
@Table(name = "HAL_HALLAZGO", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "InformeHallazgoDetalle.findAll", query = "SELECT h FROM InformeHallazgoDetalle h"),               
    @NamedQuery(name = "InformeHallazgoDetalle.buscarPorInforme", query = "select o from InformeHallazgoDetalle o where o.codInformeHallazgo.codInformeHallazgo = :codigoInforme")})
public class InformeHallazgoDetalle extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_INFORMES_HALL_DET")
    @SequenceGenerator(name="HAL_SEQ_INFORMES_HALL_DET", schema="HAL", sequenceName="HAL_SEQ_INFORMES_HALL_DET", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_HALLAZGO")
    private Long codInformeHallazgoDetalle;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_HALLAZGO")
    private Short numHallazgo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "TXT_DESCRIPCION")
    private String txtDescripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_IMPACTO_ACTUAL")
    private Short numImpactoActual;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PROBABILIDAD_ACTUAL")
    private Short numProbabilidadActual;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RIESGO_ACTUAL")
    private Short numRiesgoActual;
    
    @Column(name = "STS_PERMANENTE")
    private String stsPermanente;
        
    @OneToMany(mappedBy = "codInformeHallazgoDetalle")
    private Set<HallazgoReajuste> halHallazgosReajusteList;
    
    @OneToMany(mappedBy = "codInformeHallazgoDetalle", fetch=FetchType.LAZY)
    private Set<Recomendacion> halHallazgosRecomendacionList;
    
    @JoinColumn(name = "COD_INFORME", referencedColumnName = "COD_INFORME")
    @ManyToOne
    private InformeHallazgo codInformeHallazgo;
    
    @JoinColumn(name = "COD_SUBCOMPONENTE", referencedColumnName = "COD_SUBCOMPONENTE")
    @ManyToOne
    private Subcomponente codHallazgoSubcomponente;
    
    @JoinColumn(name = "COD_CAT_TIPO_PROCESO", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codTipoProceso;
    
    @JoinColumn(name = "COD_CAT_AREA", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codArea;

    public InformeHallazgoDetalle() {
    }

    public InformeHallazgoDetalle(Long codInformeHallazgoDetalle) {
        this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
    }

    public InformeHallazgoDetalle(Long codInformeHallazgoDetalle, short numHallazgo, String txtDescripcion, short numImpactoActual, short numProbabilidadActual, short numRiesgoActual) {
        this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
        this.numHallazgo = numHallazgo;
        this.txtDescripcion = txtDescripcion;
        this.numImpactoActual = numImpactoActual;
        this.numProbabilidadActual = numProbabilidadActual;
        this.numRiesgoActual = numRiesgoActual;
    }
    
    public InformeHallazgoDetalle(short numHallazgo, String txtDescripcion, short numImpactoActual, short numProbabilidadActual, short numRiesgoActual,
    		Catalogo codTipoProceso, Catalogo codArea, Subcomponente codHallazgoSubcomponente) {
        this.numHallazgo = numHallazgo;
        this.txtDescripcion = txtDescripcion;
        this.numImpactoActual = numImpactoActual;
        this.numProbabilidadActual = numProbabilidadActual;
        this.numRiesgoActual = numRiesgoActual;
        this.codTipoProceso = codTipoProceso;
        this.codArea = codArea;
        this.codHallazgoSubcomponente = codHallazgoSubcomponente; 
    }

    public Long getCodInformeHallazgoDetalle() {
        return codInformeHallazgoDetalle;
    }

    public void setCodInformeHallazgoDetalle(Long codInformeHallazgoDetalle) {
        this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
    }

    public Short getNumHallazgo() {
        return numHallazgo;
    }

    public void setNumHallazgo(Short numHallazgo) {
        this.numHallazgo = numHallazgo;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public Short getNumImpactoActual() {
        return numImpactoActual;
    }

    public void setNumImpactoActual(Short numImpactoActual) {
        this.numImpactoActual = numImpactoActual;
    }

    public Short getNumProbabilidadActual() {
        return numProbabilidadActual;
    }

    public void setNumProbabilidadActual(Short numProbabilidadActual) {
        this.numProbabilidadActual = numProbabilidadActual;
    }

    public Short getNumRiesgoActual() {
        return numRiesgoActual;
    }

    public void setNumRiesgoActual(Short numRiesgoActual) {
        this.numRiesgoActual = numRiesgoActual;
    }

    /**
	 * @return the halHallazgosReajusteList
	 */
	public final Set<HallazgoReajuste> getHalHallazgosReajusteList() {
		return halHallazgosReajusteList;
	}

	/**
	 * @param halHallazgosReajusteList the halHallazgosReajusteList to set
	 */
	public final void setHalHallazgosReajusteList(
			Set<HallazgoReajuste> halHallazgosReajusteList) {
		this.halHallazgosReajusteList = halHallazgosReajusteList;
	}

	/**
	 * @return the halHallazgosRecomendacionList
	 */
	public final Set<Recomendacion> getHalHallazgosRecomendacionList() {
		return halHallazgosRecomendacionList;
	}

	/**
	 * @param halHallazgosRecomendacionList the halHallazgosRecomendacionList to set
	 */
	public final void setHalHallazgosRecomendacionList(
			Set<Recomendacion> halHallazgosRecomendacionList) {
		this.halHallazgosRecomendacionList = halHallazgosRecomendacionList;
	}

	public InformeHallazgo getCodInformeHallazgo() {
        return codInformeHallazgo;
    }

    public void setCodInformeHallazgo(InformeHallazgo codInformeHallazgo) {
        this.codInformeHallazgo = codInformeHallazgo;
    }

    public Subcomponente getCodHallazgoSubcomponente() {
        return codHallazgoSubcomponente;
    }

    public void setCodHallazgoSubcomponente(Subcomponente codHallazgoSubcomponente) {
        this.codHallazgoSubcomponente = codHallazgoSubcomponente;
    }

    public Catalogo getCodTipoProceso() {
        return codTipoProceso;
    }

    public void setCodTipoProceso(Catalogo codTipoProceso) {
        this.codTipoProceso = codTipoProceso;
    }

    public Catalogo getCodArea() {
        return codArea;
    }

    public void setCodArea(Catalogo codArea) {
        this.codArea = codArea;
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
