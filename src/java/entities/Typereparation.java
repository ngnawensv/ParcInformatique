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
@Table(name = "typereparation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typereparation.findAll", query = "SELECT t FROM Typereparation t"),
    @NamedQuery(name = "Typereparation.findByIdTypereparation", query = "SELECT t FROM Typereparation t WHERE t.idTypereparation = :idTypereparation"),
    @NamedQuery(name = "Typereparation.findByNom", query = "SELECT t FROM Typereparation t WHERE t.nom = :nom")})
public class Typereparation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typereparation")
    private Integer idTypereparation;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idTypereparation")
    private Collection<Reparation> reparationCollection;

    public Typereparation() {
    }

    public Typereparation(Integer idTypereparation) {
        this.idTypereparation = idTypereparation;
    }

    public Integer getIdTypereparation() {
        return idTypereparation;
    }

    public void setIdTypereparation(Integer idTypereparation) {
        this.idTypereparation = idTypereparation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Reparation> getReparationCollection() {
        return reparationCollection;
    }

    public void setReparationCollection(Collection<Reparation> reparationCollection) {
        this.reparationCollection = reparationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypereparation != null ? idTypereparation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typereparation)) {
            return false;
        }
        Typereparation other = (Typereparation) object;
        if ((this.idTypereparation == null && other.idTypereparation != null) || (this.idTypereparation != null && !this.idTypereparation.equals(other.idTypereparation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typereparation[ idTypereparation=" + idTypereparation + " ]";
    }
    
}
