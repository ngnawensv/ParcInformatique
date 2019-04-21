/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "annee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annee.findAll", query = "SELECT a FROM Annee a"),
    @NamedQuery(name = "Annee.findByIdAnnee", query = "SELECT a FROM Annee a WHERE a.idAnnee = :idAnnee"),
    @NamedQuery(name = "Annee.findByNom", query = "SELECT a FROM Annee a WHERE a.nom = :nom")})
public class Annee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_annee")
    private Integer idAnnee;
    @Size(max = 25)
    @Column(name = "nom")
    private String nom;

    public Annee() {
    }

    public Annee(Integer idAnnee) {
        this.idAnnee = idAnnee;
    }

    public Integer getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Integer idAnnee) {
        this.idAnnee = idAnnee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnnee != null ? idAnnee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annee)) {
            return false;
        }
        Annee other = (Annee) object;
        if ((this.idAnnee == null && other.idAnnee != null) || (this.idAnnee != null && !this.idAnnee.equals(other.idAnnee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Annee[ idAnnee=" + idAnnee + " ]";
    }
    
}
