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
@Table(name = "mois")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mois.findAll", query = "SELECT m FROM Mois m"),
    @NamedQuery(name = "Mois.findByIdAnnee", query = "SELECT m FROM Mois m WHERE m.idAnnee = :idAnnee"),
    @NamedQuery(name = "Mois.findByNom", query = "SELECT m FROM Mois m WHERE m.nom = :nom")})
public class Mois implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_annee")
    private Integer idAnnee;
    @Size(max = 25)
    @Column(name = "nom")
    private String nom;

    public Mois() {
    }

    public Mois(Integer idAnnee) {
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
        if (!(object instanceof Mois)) {
            return false;
        }
        Mois other = (Mois) object;
        if ((this.idAnnee == null && other.idAnnee != null) || (this.idAnnee != null && !this.idAnnee.equals(other.idAnnee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mois[ idAnnee=" + idAnnee + " ]";
    }
    
}
