/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.gob.seps.query.criteria.delete.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "HAL_CATALOGO", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT h FROM Catalogo h"),
    @NamedQuery(name = "Catalogo.buscarPorGrupoCatalogo", query = "select o from Catalogo o where o.codGrupoCatalogo.codGrupoCatalogo = :codigoGrupoCatalogo")})
public class Catalogo extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CATALOGO")
    private Long codCatalogoHallazgo;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NOM_CATALOGO")
    private String nomCatalogo;
    
    @NotNull
    @Size(max = 10)
    @Column(name = "NOM_NEMONICO")
    private String nomNemonico;
    
    @JoinColumn(name = "COD_GRUPO_CATALOGO", referencedColumnName = "COD_GRUPO_CATALOGO")
    @ManyToOne
    private GrupoCatalogo codGrupoCatalogo;
    
    @OneToMany(mappedBy = "codPadreCatalogo")
    private List<Catalogo> catalogoPadreList;
    
    @JoinColumn(name = "COD_PADRE_CATALOGO", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private Catalogo codPadreCatalogo;

    public Catalogo() {
    }

    public Catalogo(Long codCatalogoHallazgo) {
        this.codCatalogoHallazgo = codCatalogoHallazgo;
    }
    
    public Catalogo(Long codCatalogoHallazgo, String nomCatalogo) {
        this.codCatalogoHallazgo = codCatalogoHallazgo;
        this.nomCatalogo = nomCatalogo;
    }

    public Long getCodCatalogoHallazgo() {
		return codCatalogoHallazgo;
	}

	public void setCodCatalogoHallazgo(Long codCatalogoHallazgo) {
		this.codCatalogoHallazgo = codCatalogoHallazgo;
	}

	public String getNomCatalogo() {
		return nomCatalogo;
	}

	public void setNomCatalogo(String nomCatalogo) {
		this.nomCatalogo = nomCatalogo;
	}

	public String getNomNemonico() {
		return nomNemonico;
	}

	public void setNomNemonico(String nomNemonico) {
		this.nomNemonico = nomNemonico;
	}

	public GrupoCatalogo getCodGrupoCatalogo() {
		return codGrupoCatalogo;
	}

	public void setCodGrupoCatalogo(GrupoCatalogo codGrupoCatalogo) {
		this.codGrupoCatalogo = codGrupoCatalogo;
	}

	public List<Catalogo> getCatalogoPadreList() {
		return catalogoPadreList;
	}

	public void setCatalogoPadreList(List<Catalogo> catalogoPadreList) {
		this.catalogoPadreList = catalogoPadreList;
	}

	public Catalogo getCodPadreCatalogo() {
		return codPadreCatalogo;
	}

	public void setCodPadreCatalogo(Catalogo codPadreCatalogo) {
		this.codPadreCatalogo = codPadreCatalogo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codCatalogoHallazgo != null ? codCatalogoHallazgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.codCatalogoHallazgo == null && other.codCatalogoHallazgo != null) || (this.codCatalogoHallazgo != null && !this.codCatalogoHallazgo.equals(other.codCatalogoHallazgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.Catalogo[ codCatalogoHallazgo=" + codCatalogoHallazgo + " ]";
    }
    
}
