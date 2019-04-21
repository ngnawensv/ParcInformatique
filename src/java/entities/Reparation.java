/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "reparation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparation.findAll", query = "SELECT r FROM Reparation r"),
    @NamedQuery(name = "Reparation.findByIdReparation", query = "SELECT r FROM Reparation r WHERE r.idReparation = :idReparation"),
    @NamedQuery(name = "Reparation.findByDatereparation", query = "SELECT r FROM Reparation r WHERE r.datereparation = :datereparation"),
    @NamedQuery(name = "Reparation.findByCoutreparation", query = "SELECT r FROM Reparation r WHERE r.coutreparation = :coutreparation"),
    @NamedQuery(name = "Reparation.findByImmobilisation", query = "SELECT r FROM Reparation r WHERE r.immobilisation = :immobilisation"),
    @NamedQuery(name = "Reparation.findByDatedebut", query = "SELECT r FROM Reparation r WHERE r.datedebut = :datedebut"),
    @NamedQuery(name = "Reparation.findByDatefin", query = "SELECT r FROM Reparation r WHERE r.datefin = :datefin"),
    @NamedQuery(name = "Reparation.findByCommentaire", query = "SELECT r FROM Reparation r WHERE r.commentaire = :commentaire")})
public class Reparation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reparation")
    private Integer idReparation;
    @Column(name = "datereparation")
    @Temporal(TemporalType.DATE)
    private Date datereparation;
    @Column(name = "coutreparation")
    private Integer coutreparation;
    @Size(max = 255)
    @Column(name = "immobilisation")
    private String immobilisation;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Size(max = 255)
    @Column(name = "commentaire")
    private String commentaire;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_typereparation", referencedColumnName = "id_typereparation")
    @ManyToOne
    private Typereparation idTypereparation;
    @JoinColumn(name = "id_garage", referencedColumnName = "id_garage")
    @ManyToOne
    private Garage idGarage;

    public Reparation() {
    }

    public Reparation(Integer idReparation) {
        this.idReparation = idReparation;
    }

    public Integer getIdReparation() {
        return idReparation;
    }

    public void setIdReparation(Integer idReparation) {
        this.idReparation = idReparation;
    }

    public Date getDatereparation() {
        return datereparation;
    }

    public void setDatereparation(Date datereparation) {
        this.datereparation = datereparation;
    }

    public Integer getCoutreparation() {
        return coutreparation;
    }

    public void setCoutreparation(Integer coutreparation) {
        this.coutreparation = coutreparation;
    }

    public String getImmobilisation() {
        return immobilisation;
    }

    public void setImmobilisation(String immobilisation) {
        this.immobilisation = immobilisation;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Typereparation getIdTypereparation() {
        return idTypereparation;
    }

    public void setIdTypereparation(Typereparation idTypereparation) {
        this.idTypereparation = idTypereparation;
    }

    public Garage getIdGarage() {
        return idGarage;
    }

    public void setIdGarage(Garage idGarage) {
        this.idGarage = idGarage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparation != null ? idReparation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparation)) {
            return false;
        }
        Reparation other = (Reparation) object;
        if ((this.idReparation == null && other.idReparation != null) || (this.idReparation != null && !this.idReparation.equals(other.idReparation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reparation[ idReparation=" + idReparation + " ]";
    }
    
}
