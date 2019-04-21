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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "modele")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modele.findAll", query = "SELECT m FROM Modele m"),
    @NamedQuery(name = "Modele.findByIdModele", query = "SELECT m FROM Modele m WHERE m.idModele = :idModele"),
    @NamedQuery(name = "Modele.findByNom", query = "SELECT m FROM Modele m WHERE m.nom = :nom")})
public class Modele implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modele")
    private Integer idModele;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque")
    @ManyToOne
    private Marque idMarque;
    @OneToMany(mappedBy = "idModele")
    private Collection<Vehicule> vehiculeCollection;
    @OneToMany(mappedBy = "idModele")
    private Collection<Demande> demandeCollection;

    public Modele() {
    }

    public Modele(Integer idModele) {
        this.idModele = idModele;
    }

    public Integer getIdModele() {
        return idModele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Marque idMarque) {
        this.idMarque = idMarque;
    }

    @XmlTransient
    public Collection<Vehicule> getVehiculeCollection() {
        return vehiculeCollection;
    }

    public void setVehiculeCollection(Collection<Vehicule> vehiculeCollection) {
        this.vehiculeCollection = vehiculeCollection;
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
        hash += (idModele != null ? idModele.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modele)) {
            return false;
        }
        Modele other = (Modele) object;
        if ((this.idModele == null && other.idModele != null) || (this.idModele != null && !this.idModele.equals(other.idModele))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Modele[ idModele=" + idModele + " ]";
    }
    
}
