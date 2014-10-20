/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "HAL_SEGUIMIENTO_ESTRAT_HIST")
@NamedQueries({
    @NamedQuery(name = "SeguimientoEstrategHistorico.findAll", query = "SELECT h FROM SeguimientoEstrategHistorico h")})
public class SeguimientoEstrategHistorico extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_SEGUIM_ESTRAT")
    @SequenceGenerator(name="HAL_SEQ_SEGUIM_ESTRAT", schema="HAL", sequenceName="HAL_SEQ_SEGUIM_ESTRAT", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SEGUIM_ESTRAT_HIST")
    private BigDecimal codSeguimEstratHist;
    
    @NotNull
    @Column(name = "NUM_PORCT_AVANCE_ANTERIOR")
    private BigDecimal numPorctAvanceAnterior;
    
    @NotNull
    @Column(name = "NUM_PORCT_AVANCE_NUEVO")
    private BigDecimal numPorctAvanceNuevo;
    
    @NotNull
    @Column(name = "FEC_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecActualizacion;
    
    @JoinColumn(name = "COD_ESTRATEGIA", referencedColumnName = "COD_ESTRATEGIA")
    @ManyToOne
    private Estrategia codHallazgoEstrategia;

    public SeguimientoEstrategHistorico() {
    }

    public SeguimientoEstrategHistorico(BigDecimal codSeguimEstratHist) {
        this.codSeguimEstratHist = codSeguimEstratHist;
    }

    public BigDecimal getCodSeguimEstratHist() {
        return codSeguimEstratHist;
    }

    public void setCodSeguimEstratHist(BigDecimal codSeguimEstratHist) {
        this.codSeguimEstratHist = codSeguimEstratHist;
    }

    public BigDecimal getNumPorctAvanceAnterior() {
        return numPorctAvanceAnterior;
    }

    public void setNumPorctAvanceAnterior(BigDecimal numPorctAvanceAnterior) {
        this.numPorctAvanceAnterior = numPorctAvanceAnterior;
    }

    public BigDecimal getNumPorctAvanceNuevo() {
        return numPorctAvanceNuevo;
    }

    public void setNumPorctAvanceNuevo(BigDecimal numPorctAvanceNuevo) {
        this.numPorctAvanceNuevo = numPorctAvanceNuevo;
    }

    public Date getFecActualizacion() {
        return fecActualizacion;
    }

    public void setFecActualizacion(Date fecActualizacion) {
        this.fecActualizacion = fecActualizacion;
    }

    public Estrategia getCodHallazgoEstrategia() {
        return codHallazgoEstrategia;
    }

    public void setCodHallazgoEstrategia(Estrategia codHallazgoEstrategia) {
        this.codHallazgoEstrategia = codHallazgoEstrategia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSeguimEstratHist != null ? codSeguimEstratHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SeguimientoEstrategHistorico)) {
            return false;
        }
        SeguimientoEstrategHistorico other = (SeguimientoEstrategHistorico) object;
        if ((this.codSeguimEstratHist == null && other.codSeguimEstratHist != null) || (this.codSeguimEstratHist != null && !this.codSeguimEstratHist.equals(other.codSeguimEstratHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalSeguimientoEstratHist[ codSeguimEstratHist=" + codSeguimEstratHist + " ]";
    }
    
}
