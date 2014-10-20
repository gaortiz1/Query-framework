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
import javax.persistence.Id;
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
@Table(name = "HAL_COMPONENTE", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "Componente.buscarTodos", query = "SELECT h FROM Componente h")})
public class Componente extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_COMPONENTE")
    private Long codHallazgoComponente;
    
    @Size(max = 100)
    @NotNull
    @Column(name = "NOM_DESCRIPCION")
    private String nomNombre;
    
    @OneToMany(mappedBy = "codHallazgoComponente", fetch=FetchType.LAZY)
    private Set<Subcomponente> halHallazgosSubcomponenteList;

    public Componente() {
    }
    
    public Componente(Long codHallazgoComponente) {
        this.codHallazgoComponente = codHallazgoComponente;
    }

    public Long getCodHallazgoComponente() {
        return codHallazgoComponente;
    }

    public void setCodHallazgoComponente(Long codHallazgoComponente) {
        this.codHallazgoComponente = codHallazgoComponente;
    }

    public String getNomNombre() {
        return nomNombre;
    }

    public void setNomNombre(String nomNombre) {
        this.nomNombre = nomNombre;
    }

	/**
	 * @return the halHallazgosSubcomponenteList
	 */
	public final Set<Subcomponente> getHalHallazgosSubcomponenteList() {
		return halHallazgosSubcomponenteList;
	}

	/**
	 * @param halHallazgosSubcomponenteList the halHallazgosSubcomponenteList to set
	 */
	public final void setHalHallazgosSubcomponenteList(
			Set<Subcomponente> halHallazgosSubcomponenteList) {
		this.halHallazgosSubcomponenteList = halHallazgosSubcomponenteList;
	}
}
