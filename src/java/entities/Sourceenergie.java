/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "sourceenergie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sourceenergie.findAll", query = "SELECT s FROM Sourceenergie s"),
    @NamedQuery(name = "Sourceenergie.findByIdSourceenergie", query = "SELECT s FROM Sourceenergie s WHERE s.idSourceenergie = :idSourceenergie"),
    @NamedQuery(name = "Sourceenergie.findByNom", query = "SELECT s FROM Sourceenergie s WHERE s.nom = :nom")})
public class Sourceenergie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sourceenergie")
    private Integer idSourceenergie;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idSourceenergie")
    private Collection<Vehicule> vehiculeCollection;

    public Sourceenergie() {
    }

    public Sourceenergie(Integer idSourceenergie) {
        this.idSourceenergie = idSourceenergie;
    }

    public Integer getIdSourceenergie() {
        return idSourceenergie;
    }

    public void setIdSourceenergie(Integer idSourceenergie) {
        this.idSourceenergie = idSourceenergie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Vehicule> getVehiculeCollection() {
        return vehiculeCollection;
    }

    public void setVehiculeCollection(Collection<Vehicule> vehiculeCollection) {
        this.vehiculeCollection = vehiculeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSourceenergie != null ? idSourceenergie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sourceenergie)) {
            return false;
        }
        Sourceenergie other = (Sourceenergie) object;
        if ((this.idSourceenergie == null && other.idSourceenergie != null) || (this.idSourceenergie != null && !this.idSourceenergie.equals(other.idSourceenergie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sourceenergie[ idSourceenergie=" + idSourceenergie + " ]";
    }
    
}
