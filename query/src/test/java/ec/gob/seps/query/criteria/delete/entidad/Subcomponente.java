/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eron
 */
@Entity
@Table(name = "HAL_SUBCOMPONENTE", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "Subcomponente.buscarTodos", query = "SELECT h FROM Subcomponente h"),
    @NamedQuery(name = "Subcomponente.buscarPorComponente", query = "select o from Subcomponente o where o.codHallazgoComponente.codHallazgoComponente = :codigoComponente"),
    @NamedQuery(name = "Subcomponente.buscarPorSubcomponente", query = "select o from Subcomponente o where o.codHallazgoSubcomponente = :codigoSubcomponente")})
public class Subcomponente extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SUBCOMPONENTE")
    private Long codHallazgoSubcomponente;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NOM_DESCRIPCION")
    private String nomNombre;
    
    @NotNull
    @Column(name = "NOM_NEMONICO")
    private String nomNemonico;
    
    @JoinColumn(name = "COD_COMPONENTE", referencedColumnName = "COD_COMPONENTE")
    @ManyToOne
    private Componente codHallazgoComponente;
    
    @OneToMany(mappedBy = "codHallazgoSubcomponente", fetch=FetchType.LAZY)
    private Set<InformeHallazgoDetalle> halInformesHallazgoDetalleList;

    public Subcomponente() {
    }

    public Subcomponente(Long codHallazgoSubcomponente) {
        this.codHallazgoSubcomponente = codHallazgoSubcomponente;
    }
    
    public Subcomponente(Long codHallazgoSubcomponente, String nomNombre) {
        this.codHallazgoSubcomponente = codHallazgoSubcomponente;
        this.nomNombre = nomNombre;
    }

    public Long getCodHallazgoSubcomponente() {
        return codHallazgoSubcomponente;
    }

    public void setCodHallazgoSubcomponente(Long codHallazgoSubcomponente) {
        this.codHallazgoSubcomponente = codHallazgoSubcomponente;
    }

    public String getNomNombre() {
        return nomNombre;
    }

    public void setNomNombre(String nomNombre) {
        this.nomNombre = nomNombre;
    }

    public Componente getCodHallazgoComponente() {
        return codHallazgoComponente;
    }

    public void setCodHallazgoComponente(Componente codHallazgoComponente) {
        this.codHallazgoComponente = codHallazgoComponente;
    }

    /**
	 * @return the halInformesHallazgoDetalleList
	 */
	public final Set<InformeHallazgoDetalle> getHalInformesHallazgoDetalleList() {
		return halInformesHallazgoDetalleList;
	}

	/**
	 * @param halInformesHallazgoDetalleList the halInformesHallazgoDetalleList to set
	 */
	public final void setHalInformesHallazgoDetalleList(
			Set<InformeHallazgoDetalle> halInformesHallazgoDetalleList) {
		this.halInformesHallazgoDetalleList = halInformesHallazgoDetalleList;
	}

	public String getNomNemonico() {
		return nomNemonico;
	}

	public void setNomNemonico(String nomNemonico) {
		this.nomNemonico = nomNemonico;
	}
}
