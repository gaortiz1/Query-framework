/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "HAL_ESTRATEGIA", schema = "HAL")
@NamedQuery(name = "Estrategia.findAll", query = "SELECT h FROM Estrategia h")
public class Estrategia extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAL_SEQ_ESTRATEGIAS")
    @SequenceGenerator(name="HAL_SEQ_ESTRATEGIAS", schema="HAL", sequenceName="HAL_SEQ_ESTRATEGIAS", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTRATEGIA")
    private Integer codHallazgoEstrategia;
    
    @NotNull
    @Column(name = "NUM_ESTRATEGIA")
    private Integer numEstrategia;
    
    @Size(max = 1000)
    @NotNull
    @Column(name = "TXT_DESCRIPCION")
    private String txtDescripcion;
    
    @NotNull
    @Column(name = "FEC_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaInicio;
    
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaFin;
    
    @Column(name = "FEC_FIN_PROPUESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFechaFinPropuesta;
    
    @Size(max = 500)
    @NotNull
    @Column(name = "TXT_ENTREGABLE")
    private String txtEntregable;
    
    @Column(name = "NUM_PORCENTAJE_AVANCE")
    @NotNull
    private BigDecimal numPorcentajeAvance;
    
    @Size(max = 10)
    @Column(name = "STS_APROBACION_REESTRUCTURA")
    private String stsAprobacionReestructura;
    
    @NotNull
    @Column(name = "STS_PERMANENTE")
    private String stsPermanente;
    
    @NotNull
    @Column(name = "STS_APROBACION")
    private String stsAprobacion;
   
    @Column(name = "TXT_COMENTARIO_REEST")
    private String txtComentarioReest;
    
    @Column(name = "TXT_COMENTARIO_APROB")
    private String txtComentarioAprob;
    
    @OneToMany(mappedBy = "codEstrategiaReemplaza")
    private List<Estrategia> halHallazgosEstrategiaList;    

  	@OneToMany(mappedBy="estrategia", cascade=CascadeType.MERGE)
  	private List<RecomendacionEstrategia> listaRecomendacionEstrategias;     

  	@JoinColumn(name = "COD_ESTRATEGIA_REEMPLAZA", referencedColumnName = "COD_ESTRATEGIA")
    @ManyToOne
    private Estrategia codEstrategiaReemplaza;
    
  	@JoinColumn(name = "COD_CAT_CUMPLIMIENTO", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codEstadoCumplimiento;
    
  	@JoinColumn(name = "COD_CAT_RESPONSABLE", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codResponsableEstrategia;
    
  	@JoinColumn(name = "COD_CAT_TIPO_REESTRUCTURA", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codEstadoReestructura;
    
  	@OneToMany(mappedBy = "codHallazgoEstrategia")
    private List<SeguimientoEstrategHistorico> seguimientoEstratHistList;
    
  	@OneToMany(mappedBy = "codHallazgoEstrategia")
    private List<ReestructuracionesHistorico> reestEtratHistList;

    public Estrategia() {
    }
    
    public Estrategia(Integer codHallazgoEstrategia, Integer numEstrategia,
			String txtDescripcion, Date fecFechaInicio, String txtEntregable,
			BigDecimal numPorcentajeAvance, Catalogo codEstadoCumplimiento,
			Catalogo codResponsableEstrategia) {
		super();
		this.codHallazgoEstrategia = codHallazgoEstrategia;
		this.numEstrategia = numEstrategia;
		this.txtDescripcion = txtDescripcion;
		this.fecFechaInicio = fecFechaInicio;
		this.txtEntregable = txtEntregable;
		this.numPorcentajeAvance = numPorcentajeAvance;
		this.codEstadoCumplimiento = codEstadoCumplimiento;
		this.codResponsableEstrategia = codResponsableEstrategia;
	}

	public Estrategia(Integer codHallazgoEstrategia) {
        this.codHallazgoEstrategia = codHallazgoEstrategia;
    }

    public Integer getCodHallazgoEstrategia() {
        return codHallazgoEstrategia;
    }

    public void setCodHallazgoEstrategia(Integer codHallazgoEstrategia) {
        this.codHallazgoEstrategia = codHallazgoEstrategia;
    }

    public Integer getNumEstrategia() {
        return numEstrategia;
    }

    public void setNumEstrategia(Integer numEstrategia) {
        this.numEstrategia = numEstrategia;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public Date getFecFechaInicio() {
        return fecFechaInicio;
    }

    public void setFecFechaInicio(Date fecFechaInicio) {
        this.fecFechaInicio = fecFechaInicio;
    }

    public Date getFecFechaFinPropuesta() {
        return fecFechaFinPropuesta;
    }

    public void setFecFechaFinPropuesta(Date fecFechaFinPropuesta) {
        this.fecFechaFinPropuesta = fecFechaFinPropuesta;
    }

    public String getTxtEntregable() {
        return txtEntregable;
    }

    public void setTxtEntregable(String txtEntregable) {
        this.txtEntregable = txtEntregable;
    }

    public BigDecimal getNumPorcentajeAvance() {
        return numPorcentajeAvance;
    }

    public void setNumPorcentajeAvance(BigDecimal numPorcentajeAvance) {
        this.numPorcentajeAvance = numPorcentajeAvance;
    }

    public String getStsAprobacionReestructura() {
        return stsAprobacionReestructura;
    }

    public void setStsAprobacionReestructura(String stsAprobacionReestructura) {
        this.stsAprobacionReestructura = stsAprobacionReestructura;
    }

    
    public List<Estrategia> getHalHallazgosEstrategiaList() {
        return halHallazgosEstrategiaList;
    }

    public void setHalHallazgosEstrategiaList(List<Estrategia> halHallazgosEstrategiaList) {
        this.halHallazgosEstrategiaList = halHallazgosEstrategiaList;
    }

    public Estrategia getCodEstrategiaReemplaza() {
        return codEstrategiaReemplaza;
    }

    public void setCodEstrategiaReemplaza(Estrategia codEstrategiaReemplaza) {
        this.codEstrategiaReemplaza = codEstrategiaReemplaza;
    }

    public Catalogo getCodEstadoCumplimiento() {
        return codEstadoCumplimiento;
    }

    public void setCodEstadoCumplimiento(Catalogo codEstadoCumplimiento) {
        this.codEstadoCumplimiento = codEstadoCumplimiento;
    }

    public Catalogo getCodResponsableEstrategia() {
        return codResponsableEstrategia;
    }

    public void setCodResponsableEstrategia(Catalogo codResponsableEstrategia) {
        this.codResponsableEstrategia = codResponsableEstrategia;
    }

    public Catalogo getCodEstadoReestructura() {
        return codEstadoReestructura;
    }

    public void setCodEstadoReestructura(Catalogo codEstadoReestructura) {
        this.codEstadoReestructura = codEstadoReestructura;
    }    

    public List<RecomendacionEstrategia> getListaRecomendacionEstrategias() {
		return listaRecomendacionEstrategias;
	}

	public void setListaRecomendacionEstrategias(
			List<RecomendacionEstrategia> listaRecomendacionEstrategias) {
		this.listaRecomendacionEstrategias = listaRecomendacionEstrategias;
	}
		
	/**
	 * @return the fecFechaFin
	 */
	public Date getFecFechaFin() {
		return fecFechaFin;
	}

	/**
	 * @param fecFechaFin the fecFechaFin to set
	 */
	public void setFecFechaFin(Date fecFechaFin) {
		this.fecFechaFin = fecFechaFin;
	}

	/**
	 * @return the seguimientoEstratHistList
	 */
	public List<SeguimientoEstrategHistorico> getSeguimientoEstratHistList() {
		return seguimientoEstratHistList;
	}

	/**
	 * @param seguimientoEstratHistList the seguimientoEstratHistList to set
	 */
	public void setSeguimientoEstratHistList(
			List<SeguimientoEstrategHistorico> seguimientoEstratHistList) {
		this.seguimientoEstratHistList = seguimientoEstratHistList;
	}

	/**
	 * @return the reestEtratHistList
	 */
	public List<ReestructuracionesHistorico> getReestEtratHistList() {
		return reestEtratHistList;
	}

	/**
	 * @param reestEtratHistList the reestEtratHistList to set
	 */
	public void setReestEtratHistList(
			List<ReestructuracionesHistorico> reestEtratHistList) {
		this.reestEtratHistList = reestEtratHistList;
	}
	
	/**
	 * @return the txtComentarioReest
	 */
	public String getTxtComentarioReest() {
		return txtComentarioReest;
	}

	/**
	 * @param txtComentarioReest the txtComentarioReest to set
	 */
	public void setTxtComentarioReest(String txtComentarioReest) {
		this.txtComentarioReest = txtComentarioReest;
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
	 * @return the stsAprobacion
	 */
	public String getStsAprobacion() {
		return stsAprobacion;
	}

	/**
	 * @param stsAprobacion the stsAprobacion to set
	 */
	public void setStsAprobacion(String stsAprobacion) {
		this.stsAprobacion = stsAprobacion;
	}

	/**
	 * @return the txtComentarioAprob
	 */
	public String getTxtComentarioAprob() {
		return txtComentarioAprob;
	}

	/**
	 * @param txtComentarioAprob the txtComentarioAprob to set
	 */
	public void setTxtComentarioAprob(String txtComentarioAprob) {
		this.txtComentarioAprob = txtComentarioAprob;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codHallazgoEstrategia != null ? codHallazgoEstrategia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Estrategia)) {
            return false;
        }
        Estrategia other = (Estrategia) object;
        if ((this.codHallazgoEstrategia == null && other.codHallazgoEstrategia != null) || (this.codHallazgoEstrategia != null && !this.codHallazgoEstrategia.equals(other.codHallazgoEstrategia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getCodHallazgoEstrategia().toString().concat("-").concat(getTxtDescripcion());
    }
    
}
