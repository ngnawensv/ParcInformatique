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
@Table(name = "sourcefinancement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sourcefinancement.findAll", query = "SELECT s FROM Sourcefinancement s"),
    @NamedQuery(name = "Sourcefinancement.findByIdSourcefinancement", query = "SELECT s FROM Sourcefinancement s WHERE s.idSourcefinancement = :idSourcefinancement"),
    @NamedQuery(name = "Sourcefinancement.findByNom", query = "SELECT s FROM Sourcefinancement s WHERE s.nom = :nom")})
public class Sourcefinancement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sourcefinancement")
    private Integer idSourcefinancement;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idSourcefinancement")
    private Collection<Vehicule> vehiculeCollection;

    public Sourcefinancement() {
    }

    public Sourcefinancement(Integer idSourcefinancement) {
        this.idSourcefinancement = idSourcefinancement;
    }

    public Integer getIdSourcefinancement() {
        return idSourcefinancement;
    }

    public void setIdSourcefinancement(Integer idSourcefinancement) {
        this.idSourcefinancement = idSourcefinancement;
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
        hash += (idSourcefinancement != null ? idSourcefinancement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sourcefinancement)) {
            return false;
        }
        Sourcefinancement other = (Sourcefinancement) object;
        if ((this.idSourcefinancement == null && other.idSourcefinancement != null) || (this.idSourcefinancement != null && !this.idSourcefinancement.equals(other.idSourcefinancement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sourcefinancement[ idSourcefinancement=" + idSourcefinancement + " ]";
    }
    
}
