/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 *
 * @author eron
 */
@Entity
@Table(name = "HAL_REAJUSTE", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "HallazgoReajuste.findAll", query = "SELECT h FROM HallazgoReajuste h")})
public class HallazgoReajuste extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_REAJUSTE_HALLAZGO")
    @SequenceGenerator(name="HAL_SEQ_REAJUSTE_HALLAZGO", schema="HAL", sequenceName="HAL_SEQ_REAJUSTE_HALLAZGO", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_REAJUSTE")
    private Long codHallazgoReajuste;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_AJUSTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaAjuste;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_IMPACTO_AJUSTADO")
    private short numImpactoAjustado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PROBABILIDAD_AJUSTADO")
    private short numProbabilidadAjustado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RIESGO_AJUSTADO")
    private short numRiesgoAjustado;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_IMPACTO_ANTERIOR")
    private short numImpactoAnterior;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PROBABILIDAD_ANTERIOR")
    private short numProbabilidadAnterior;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RIESGO_ANTERIOR")
    private short numRiesgoAnterior;
    
    @Column(name = "TXT_HECHO_SUBSECUENTE")
    private String txtHechoSubsecuente;
    
    @JoinColumn(name = "COD_HALLAZGO", referencedColumnName = "COD_HALLAZGO")
    @ManyToOne
    private InformeHallazgoDetalle codInformeHallazgoDetalle;
    
    @JoinColumn(name = "COD_CAT_RESPONSABLE", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codResponsableAjuste;

    public HallazgoReajuste() {
    }

    public HallazgoReajuste(Long codHallazgoReajuste) {
        this.codHallazgoReajuste = codHallazgoReajuste;
    }

    public HallazgoReajuste(Long codHallazgoReajuste, Date fecFechaAjuste, short numImpactoAjustado, short numProbabilidadAjustado, short numRiesgoAjustado) {
        this.codHallazgoReajuste = codHallazgoReajuste;
        this.fecFechaAjuste = fecFechaAjuste;
        this.numImpactoAjustado = numImpactoAjustado;
        this.numProbabilidadAjustado = numProbabilidadAjustado;
        this.numRiesgoAjustado = numRiesgoAjustado;
    }

    public Long getCodHallazgoReajuste() {
        return codHallazgoReajuste;
    }

    public void setCodHallazgoReajuste(Long codHallazgoReajuste) {
        this.codHallazgoReajuste = codHallazgoReajuste;
    }

    public Date getFecFechaAjuste() {
        return fecFechaAjuste;
    }

    public void setFecFechaAjuste(Date fecFechaAjuste) {
        this.fecFechaAjuste = fecFechaAjuste;
    }

    public short getNumImpactoAjustado() {
        return numImpactoAjustado;
    }

    public void setNumImpactoAjustado(short numImpactoAjustado) {
        this.numImpactoAjustado = numImpactoAjustado;
    }

    public short getNumProbabilidadAjustado() {
        return numProbabilidadAjustado;
    }

    public void setNumProbabilidadAjustado(short numProbabilidadAjustado) {
        this.numProbabilidadAjustado = numProbabilidadAjustado;
    }

    public short getNumRiesgoAjustado() {
        return numRiesgoAjustado;
    }

    public void setNumRiesgoAjustado(short numRiesgoAjustado) {
        this.numRiesgoAjustado = numRiesgoAjustado;
    }

    public InformeHallazgoDetalle getCodInformeHallazgoDetalle() {
        return codInformeHallazgoDetalle;
    }

    public void setCodInformeHallazgoDetalle(InformeHallazgoDetalle codInformeHallazgoDetalle) {
        this.codInformeHallazgoDetalle = codInformeHallazgoDetalle;
    }

    public Catalogo getCodResponsableAjuste() {
        return codResponsableAjuste;
    }

    public void setCodResponsableAjuste(Catalogo codResponsableAjuste) {
        this.codResponsableAjuste = codResponsableAjuste;
    }

    /**
	 * @return the txtHechoSubsecuente
	 */
	public String getTxtHechoSubsecuente() {
		return txtHechoSubsecuente;
	}

	/**
	 * @param txtHechoSubsecuente the txtHechoSubsecuente to set
	 */
	public void setTxtHechoSubsecuente(String txtHechoSubsecuente) {
		this.txtHechoSubsecuente = txtHechoSubsecuente;
	}

	/**
	 * @return the numImpactoAnterior
	 */
	public short getNumImpactoAnterior() {
		return numImpactoAnterior;
	}

	/**
	 * @param numImpactoAnterior the numImpactoAnterior to set
	 */
	public void setNumImpactoAnterior(short numImpactoAnterior) {
		this.numImpactoAnterior = numImpactoAnterior;
	}

	/**
	 * @return the numProbabilidadAnterior
	 */
	public short getNumProbabilidadAnterior() {
		return numProbabilidadAnterior;
	}

	/**
	 * @param numProbabilidadAnterior the numProbabilidadAnterior to set
	 */
	public void setNumProbabilidadAnterior(short numProbabilidadAnterior) {
		this.numProbabilidadAnterior = numProbabilidadAnterior;
	}

	/**
	 * @return the numRiesgoAnterior
	 */
	public short getNumRiesgoAnterior() {
		return numRiesgoAnterior;
	}

	/**
	 * @param numRiesgoAnterior the numRiesgoAnterior to set
	 */
	public void setNumRiesgoAnterior(short numRiesgoAnterior) {
		this.numRiesgoAnterior = numRiesgoAnterior;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codHallazgoReajuste != null ? codHallazgoReajuste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HallazgoReajuste)) {
            return false;
        }
        HallazgoReajuste other = (HallazgoReajuste) object;
        if ((this.codHallazgoReajuste == null && other.codHallazgoReajuste != null) || (this.codHallazgoReajuste != null && !this.codHallazgoReajuste.equals(other.codHallazgoReajuste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalHallazgosReajuste[ codHallazgoReajuste=" + codHallazgoReajuste + " ]";
    }
    
}
