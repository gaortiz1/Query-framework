/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "HAL_INFORME", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "InformeHallazgo.findAll", query = "SELECT h FROM InformeHallazgo h"),
    @NamedQuery(name = "InformeHallazgo.buscarPorHallazgo", query = "select h from InformeHallazgo h where h.codHallazgo.codHallazgo = :codigoHallazgo")})
public class InformeHallazgo extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_INFORMES")
    @SequenceGenerator(name="HAL_SEQ_INFORMES", schema="HAL", sequenceName="HAL_SEQ_INFORMES", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_INFORME")
    private Integer codInformeHallazgo;
    
    @Column(name = "NUM_INFORME")
    private String numInformeHallazgo;
    
    @Column(name = "FEC_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaEmision;
        
    @Column(name = "STS_PERMANENTE")
    private String stsPermanente;
    
    @Lob
	@Column(name="BNR_ADJUNTO")
	private byte[] bnrInformeAdjunto;
    
    @JoinColumn(name = "COD_CAT_TIPO_INFORME", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codTipoInforme;
    
    @JoinColumn(name = "COD_CAT_RESPONSABLE_EMISION", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codResponsableEmision;
    
    @JoinColumn(name = "COD_CAT_PERIODCIDAD", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codPeriodcidad;
    
    @JoinColumn(name = "COD_FORMULARIO_AUDITOR", referencedColumnName = "COD_FORMULARIO_AUDITOR")
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Hallazgo codHallazgo;
    
    @OneToMany(mappedBy = "codInformeHallazgo")
    private List<InformeHallazgoDetalle> halInformesHallazgoDetalleList;

    public InformeHallazgo() {
    }

    public InformeHallazgo(Integer codInformeHallazgo) {
        this.codInformeHallazgo = codInformeHallazgo;
    }

    public Integer getCodInformeHallazgo() {
        return codInformeHallazgo;
    }

    public void setCodInformeHallazgo(Integer codInformeHallazgo) {
        this.codInformeHallazgo = codInformeHallazgo;
    }

    public String getNumInformeHallazgo() {
        return numInformeHallazgo;
    }

    public void setNumInformeHallazgo(String numInformeHallazgo) {
        this.numInformeHallazgo = numInformeHallazgo;
    }

    public Date getFecFechaEmision() {
        return fecFechaEmision;
    }

    public void setFecFechaEmision(Date fecFechaEmision) {
        this.fecFechaEmision = fecFechaEmision;
    }

    public Catalogo getCodTipoInforme() {
        return codTipoInforme;
    }

    public void setCodTipoInforme(Catalogo codTipoInforme) {
        this.codTipoInforme = codTipoInforme;
    }

    public Catalogo getCodResponsableEmision() {
        return codResponsableEmision;
    }

    public void setCodResponsableEmision(Catalogo codResponsableEmision) {
        this.codResponsableEmision = codResponsableEmision;
    }

    public Catalogo getCodPeriodcidad() {
        return codPeriodcidad;
    }

    public void setCodPeriodcidad(Catalogo codPeriodcidad) {
        this.codPeriodcidad = codPeriodcidad;
    }

    public Hallazgo getCodHallazgo() {
		return codHallazgo;
	}

	public void setCodHallazgo(Hallazgo codHallazgo) {
		this.codHallazgo = codHallazgo;
	}

	public List<InformeHallazgoDetalle> getHalInformesHallazgoDetalleList() {
        return halInformesHallazgoDetalleList;
    }

    public void setHalInformesHallazgoDetalleList(List<InformeHallazgoDetalle> halInformesHallazgoDetalleList) {
        this.halInformesHallazgoDetalleList = halInformesHallazgoDetalleList;
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
	 * @return the bnrInformeAdjunto
	 */
	public byte[] getBnrInformeAdjunto() {
		return bnrInformeAdjunto;
	}

	/**
	 * @param bnrInformeAdjunto the bnrInformeAdjunto to set
	 */
	public void setBnrInformeAdjunto(byte[] bnrInformeAdjunto) {
		this.bnrInformeAdjunto = bnrInformeAdjunto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codInformeHallazgo != null ? codInformeHallazgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InformeHallazgo)) {
            return false;
        }
        InformeHallazgo other = (InformeHallazgo) object;
        if ((this.codInformeHallazgo == null && other.codInformeHallazgo != null) || (this.codInformeHallazgo != null && !this.codInformeHallazgo.equals(other.codInformeHallazgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalInformesHallazgo[ codInformeHallazgo=" + codInformeHallazgo + " ]";
    }
    
}
