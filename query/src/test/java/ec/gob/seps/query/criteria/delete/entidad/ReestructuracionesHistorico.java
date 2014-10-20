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
import javax.validation.constraints.Size;

/**
 *
 * @author eron
 */
@Entity
@Table(name = "HAL_REESTRUCT_ESTRAT_HIST")
@NamedQueries({
    @NamedQuery(name = "ReestructuracionesHistorico.findAll", query = "SELECT h FROM ReestructuracionesHistorico h")})
public class ReestructuracionesHistorico extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_REESTRUCTURACION")
    @SequenceGenerator(name="HAL_SEQ_REESTRUCTURACION", schema="HAL", sequenceName="HAL_SEQ_REESTRUCTURACION", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_REEST_ESTRAT_HIST")
    private BigDecimal codReestEstratHist;
    
    @Column(name = "FEC_APROBACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaAprobacion;
    
    @Size(max = 100)
    @Column(name = "NOM_USUARIO_APRUEBA")
    private String nomUsuarioAprueba;
   
    @Column(name = "STS_APROBACION_REESTRUCTURA")
    private String estadoReestructuracion;
    
    @Column(name = "TXT_COMENTARIO")
    private String txtComentario;
    
    @JoinColumn(name = "COD_ESTRATEGIA", referencedColumnName = "COD_ESTRATEGIA")
    @ManyToOne
    private Estrategia codHallazgoEstrategia;
    
    @JoinColumn(name = "COD_CAT_TIP_REESTRUCT", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codCatalogoTipReestruct;

    public ReestructuracionesHistorico() {
    }

    public ReestructuracionesHistorico(BigDecimal codReestEstratHist) {
        this.codReestEstratHist = codReestEstratHist;
    }

    public BigDecimal getCodReestEstratHist() {
        return codReestEstratHist;
    }

    public void setCodReestEstratHist(BigDecimal codReestEstratHist) {
        this.codReestEstratHist = codReestEstratHist;
    }

    public Date getFecFechaAprobacion() {
        return fecFechaAprobacion;
    }

    public void setFecFechaAprobacion(Date fecFechaAprobacion) {
        this.fecFechaAprobacion = fecFechaAprobacion;
    }

    public String getNomUsuarioAprueba() {
        return nomUsuarioAprueba;
    }

    public void setNomUsuarioAprueba(String nomUsuarioAprueba) {
        this.nomUsuarioAprueba = nomUsuarioAprueba;
    }

    public Estrategia getCodHallazgoEstrategia() {
        return codHallazgoEstrategia;
    }

    public void setCodHallazgoEstrategia(Estrategia codHallazgoEstrategia) {
        this.codHallazgoEstrategia = codHallazgoEstrategia;
    }

    public Catalogo getCodCatalogoTipReestruct() {
        return codCatalogoTipReestruct;
    }

    public void setCodCatalogoTipReestruct(Catalogo codCatalogoTipReestruct) {
        this.codCatalogoTipReestruct = codCatalogoTipReestruct;
    }
    

    /**
	 * @return the estadoReestructuracion
	 */
	public String getEstadoReestructuracion() {
		return estadoReestructuracion;
	}

	/**
	 * @param estadoReestructuracion the estadoReestructuracion to set
	 */
	public void setEstadoReestructuracion(String estadoReestructuracion) {
		this.estadoReestructuracion = estadoReestructuracion;
	}

	/**
	 * @return the txtComentario
	 */
	public String getTxtComentario() {
		return txtComentario;
	}

	/**
	 * @param txtComentario the txtComentario to set
	 */
	public void setTxtComentario(String txtComentario) {
		this.txtComentario = txtComentario;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codReestEstratHist != null ? codReestEstratHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ReestructuracionesHistorico)) {
            return false;
        }
        ReestructuracionesHistorico other = (ReestructuracionesHistorico) object;
        if ((this.codReestEstratHist == null && other.codReestEstratHist != null) || (this.codReestEstratHist != null && !this.codReestEstratHist.equals(other.codReestEstratHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalReestructEstratHist[ codReestEstratHist=" + codReestEstratHist + " ]";
    }
    
}
