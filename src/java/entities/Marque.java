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
@Table(name = "marque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m"),
    @NamedQuery(name = "Marque.findByIdMarque", query = "SELECT m FROM Marque m WHERE m.idMarque = :idMarque"),
    @NamedQuery(name = "Marque.findByNom", query = "SELECT m FROM Marque m WHERE m.nom = :nom")})
public class Marque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_marque")
    private Integer idMarque;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idMarque")
    private Collection<Modele> modeleCollection;

    public Marque() {
    }

    public Marque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Modele> getModeleCollection() {
        return modeleCollection;
    }

    public void setModeleCollection(Collection<Modele> modeleCollection) {
        this.modeleCollection = modeleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarque != null ? idMarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.idMarque == null && other.idMarque != null) || (this.idMarque != null && !this.idMarque.equals(other.idMarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Marque[ idMarque=" + idMarque + " ]";
    }
    
}
