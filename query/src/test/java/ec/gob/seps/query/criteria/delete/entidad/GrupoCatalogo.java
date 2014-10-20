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
@Table(name = "HAL_GRUPO_CATALOGO", schema = "HAL")
@NamedQueries({
    @NamedQuery(name = "GrupoCatalogo.findAll", query = "SELECT h FROM GrupoCatalogo h"),
    @NamedQuery(name = "GrupoCatalogo.buscarPorNemonico", query = "select o from GrupoCatalogo o where o.nomNemonico = :nemonico")})
public class GrupoCatalogo extends BaseEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_GRUPO_CATALOGO")
    private Long codGrupoCatalogo;
    
    @NotNull
    @Size(max = 100)
    @Column(name = "NOM_GRUPO_CATALOGO")
    private String nomGrupoCatalogo;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "TXT_DESCRIPCION")
    private String txtDescripcion;
    
    @NotNull
    @Size(max = 10)
    @Column(name = "NOM_NEMONICO")
    private String nomNemonico;
        
    @OneToMany(mappedBy = "codGrupoCatalogo")
    private List<Catalogo> halCatalogosHallazgoList;

    public GrupoCatalogo() {
    }

    public GrupoCatalogo(Long codGrupoCatalogo) {
        this.codGrupoCatalogo = codGrupoCatalogo;
    }

    public Long getCodGrupoCatalogo() {
        return codGrupoCatalogo;
    }

    public void setCodGrupoCatalogo(Long codGrupoCatalogo) {
        this.codGrupoCatalogo = codGrupoCatalogo;
    }

    public String getNomGrupoCatalogo() {
        return nomGrupoCatalogo;
    }

    public void setNomGrupoCatalogo(String nomGrupoCatalogo) {
        this.nomGrupoCatalogo = nomGrupoCatalogo;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getNomNemonico() {
        return nomNemonico;
    }

    public void setNomNemonico(String nomNemonico) {
        this.nomNemonico = nomNemonico;
    }

    public List<Catalogo> getHalCatalogosHallazgoList() {
        return halCatalogosHallazgoList;
    }

    public void setHalCatalogosHallazgoList(List<Catalogo> halCatalogosHallazgoList) {
        this.halCatalogosHallazgoList = halCatalogosHallazgoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoCatalogo != null ? codGrupoCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GrupoCatalogo)) {
            return false;
        }
        GrupoCatalogo other = (GrupoCatalogo) object;
        if ((this.codGrupoCatalogo == null && other.codGrupoCatalogo != null) || (this.codGrupoCatalogo != null && !this.codGrupoCatalogo.equals(other.codGrupoCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.model.HalGrupoCatalogo[ codGrupoCatalogo=" + codGrupoCatalogo + " ]";
    }
    
}
