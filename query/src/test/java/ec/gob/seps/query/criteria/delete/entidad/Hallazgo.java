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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "HAL_FORMULARIO_AUDITOR", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "Hallazgo.findAll", query = "SELECT h FROM Hallazgo h"),
    @NamedQuery(name = "Hallazgo.buscarPorRuc", query = "select h from Hallazgo h where h.rucOrganizacion = :ruc")})
public class Hallazgo extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_HALLAZGOS")
    @SequenceGenerator(name="HAL_SEQ_HALLAZGOS", schema="HAL", sequenceName="HAL_SEQ_HALLAZGOS", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FORMULARIO_AUDITOR")
    private Long codHallazgo;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "NUM_RUC_ORGANIZACION")
    private String rucOrganizacion;
    
    @NotNull
    @Size(max = 13)
    @Column(name = "NUM_DNI")
    private String numDni;
        
    @Column(name = "FEC_ENVIO_HALLAZGO_CAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaEnvioHallazgoCab;
    
    @NotNull
    @Column(name = "STS_PERMANENTE")
    private String stsPermanente;
            
    @JoinColumn(name = "COD_CAT_TIPO_AUDITOR", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codCatTipoAuditor;
    
    @OneToMany(mappedBy = "codHallazgo")
    private List<InformeHallazgo> halInformesHallazgoList;
    
    @JoinColumn(name = "COD_LOG_CARGA", referencedColumnName = "COD_LOG_CARGA")
    @ManyToOne(cascade=CascadeType.PERSIST)
    private LogCargaEstructura logCargaEstructura;
    
    public Hallazgo() {
    }

    /**
     * 
     * @param codHallazgo
     */
    public Hallazgo(Long codHallazgo) {
        this.codHallazgo = codHallazgo;
    }

    /**
     * 
     * @return
     */
    public Long getCodHallazgo() {
        return codHallazgo;
    }

    /**
     * 
     * @param codHallazgo
     */
    public void setCodHallazgo(Long codHallazgo) {
        this.codHallazgo = codHallazgo;
    }

    /**
	 * @return the rucOrganizacion
	 */
	public String getRucOrganizacion() {
		return rucOrganizacion;
	}

	/**
	 * @param rucOrganizacion the rucOrganizacion to set
	 */
	public void setRucOrganizacion(String rucOrganizacion) {
		this.rucOrganizacion = rucOrganizacion;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFecFechaEnvioHallazgoCab() {
        return fecFechaEnvioHallazgoCab;
    }

	/**
	 * 
	 * @param fecFechaEnvioHallazgoCab
	 */
    public void setFecFechaEnvioHallazgoCab(Date fecFechaEnvioHallazgoCab) {
        this.fecFechaEnvioHallazgoCab = fecFechaEnvioHallazgoCab;
    }

    /**
     * 
     * @return
     */
    public List<InformeHallazgo> getHalInformesHallazgoList() {
		return halInformesHallazgoList;
	}

    /**
     * 
     * @param halInformesHallazgoList
     */
	public void setHalInformesHallazgoList(
			List<InformeHallazgo> halInformesHallazgoList) {
		this.halInformesHallazgoList = halInformesHallazgoList;
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
	 * @return the numDni
	 */
	public String getNumDni() {
		return numDni;
	}

	/**
	 * @param numDni the numDni to set
	 */
	public void setNumDni(String numDni) {
		this.numDni = numDni;
	}

	/**
	 * @return the codCatTipoAuditor
	 */
	public Catalogo getCodCatTipoAuditor() {
		return codCatTipoAuditor;
	}

	/**
	 * @param codCatTipoAuditor the codCatTipoAuditor to set
	 */
	public void setCodCatTipoAuditor(Catalogo codCatTipoAuditor) {
		this.codCatTipoAuditor = codCatTipoAuditor;
	}

	public LogCargaEstructura getLogCargaEstructura() {
		return logCargaEstructura;
	}

	public void setLogCargaEstructura(LogCargaEstructura logCargaEstructura) {
		this.logCargaEstructura = logCargaEstructura;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codHallazgo != null ? codHallazgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Hallazgo)) {
            return false;
        }
        Hallazgo other = (Hallazgo) object;
        if ((this.codHallazgo == null && other.codHallazgo != null) || (this.codHallazgo != null && !this.codHallazgo.equals(other.codHallazgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalHallazgos[ codHallazgo=" + codHallazgo + " ]";
    }
    
}
