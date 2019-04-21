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
@Table(name = "fonction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fonction.findAll", query = "SELECT f FROM Fonction f"),
    @NamedQuery(name = "Fonction.findByIdFonction", query = "SELECT f FROM Fonction f WHERE f.idFonction = :idFonction"),
    @NamedQuery(name = "Fonction.findByNom", query = "SELECT f FROM Fonction f WHERE f.nom = :nom")})
public class Fonction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fonction")
    private Integer idFonction;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idFonction")
    private Collection<Personnel> personnelCollection;

    public Fonction() {
    }

    public Fonction(Integer idFonction) {
        this.idFonction = idFonction;
    }

    public Integer getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(Integer idFonction) {
        this.idFonction = idFonction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Personnel> getPersonnelCollection() {
        return personnelCollection;
    }

    public void setPersonnelCollection(Collection<Personnel> personnelCollection) {
        this.personnelCollection = personnelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFonction != null ? idFonction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fonction)) {
            return false;
        }
        Fonction other = (Fonction) object;
        if ((this.idFonction == null && other.idFonction != null) || (this.idFonction != null && !this.idFonction.equals(other.idFonction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fonction[ idFonction=" + idFonction + " ]";
    }
    
}
