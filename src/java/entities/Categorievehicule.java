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
@Table(name = "categorievehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorievehicule.findAll", query = "SELECT c FROM Categorievehicule c"),
    @NamedQuery(name = "Categorievehicule.findByIdCategorievehicule", query = "SELECT c FROM Categorievehicule c WHERE c.idCategorievehicule = :idCategorievehicule"),
    @NamedQuery(name = "Categorievehicule.findByNom", query = "SELECT c FROM Categorievehicule c WHERE c.nom = :nom")})
public class Categorievehicule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categorievehicule")
    private Integer idCategorievehicule;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idCategorievehicule")
    private Collection<Vehicule> vehiculeCollection;
    @OneToMany(mappedBy = "idCategorievehicule")
    private Collection<Norme> normeCollection;
    @OneToMany(mappedBy = "idCategorievehicule")
    private Collection<Demande> demandeCollection;

    public Categorievehicule() {
    }

    public Categorievehicule(Integer idCategorievehicule) {
        this.idCategorievehicule = idCategorievehicule;
    }

    public Integer getIdCategorievehicule() {
        return idCategorievehicule;
    }

    public void setIdCategorievehicule(Integer idCategorievehicule) {
        this.idCategorievehicule = idCategorievehicule;
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

    @XmlTransient
    public Collection<Norme> getNormeCollection() {
        return normeCollection;
    }

    public void setNormeCollection(Collection<Norme> normeCollection) {
        this.normeCollection = normeCollection;
    }

    @XmlTransient
    public Collection<Demande> getDemandeCollection() {
        return demandeCollection;
    }

    public void setDemandeCollection(Collection<Demande> demandeCollection) {
        this.demandeCollection = demandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorievehicule != null ? idCategorievehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorievehicule)) {
            return false;
        }
        Categorievehicule other = (Categorievehicule) object;
        if ((this.idCategorievehicule == null && other.idCategorievehicule != null) || (this.idCategorievehicule != null && !this.idCategorievehicule.equals(other.idCategorievehicule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorievehicule[ idCategorievehicule=" + idCategorievehicule + " ]";
    }
    
}
