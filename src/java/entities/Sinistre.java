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
@Table(name = "sinistre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinistre.findAll", query = "SELECT s FROM Sinistre s"),
    @NamedQuery(name = "Sinistre.findByIdSinistre", query = "SELECT s FROM Sinistre s WHERE s.idSinistre = :idSinistre"),
    @NamedQuery(name = "Sinistre.findByDatesinistre", query = "SELECT s FROM Sinistre s WHERE s.datesinistre = :datesinistre"),
    @NamedQuery(name = "Sinistre.findByLieusinistre", query = "SELECT s FROM Sinistre s WHERE s.lieusinistre = :lieusinistre"),
    @NamedQuery(name = "Sinistre.findByMontant", query = "SELECT s FROM Sinistre s WHERE s.montant = :montant"),
    @NamedQuery(name = "Sinistre.findByImmobilisation", query = "SELECT s FROM Sinistre s WHERE s.immobilisation = :immobilisation"),
    @NamedQuery(name = "Sinistre.findByDatedebut", query = "SELECT s FROM Sinistre s WHERE s.datedebut = :datedebut"),
    @NamedQuery(name = "Sinistre.findByDatefin", query = "SELECT s FROM Sinistre s WHERE s.datefin = :datefin"),
    @NamedQuery(name = "Sinistre.findByCommentaire", query = "SELECT s FROM Sinistre s WHERE s.commentaire = :commentaire"),
    @NamedQuery(name = "Sinistre.findByPhoto", query = "SELECT s FROM Sinistre s WHERE s.photo = :photo")})
public class Sinistre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sinistre")
    private Integer idSinistre;
    @Column(name = "datesinistre")
    @Temporal(TemporalType.DATE)
    private Date datesinistre;
    @Size(max = 255)
    @Column(name = "lieusinistre")
    private String lieusinistre;
    @Column(name = "montant")
    private Integer montant;
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
    @Size(max = 255)
    @Column(name = "photo")
    private String photo;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_typesinistre", referencedColumnName = "id_typesinistre")
    @ManyToOne
    private Typesinistre idTypesinistre;
    @JoinColumn(name = "id_garage", referencedColumnName = "id_garage")
    @ManyToOne
    private Garage idGarage;

    public Sinistre() {
    }

    public Sinistre(Integer idSinistre) {
        this.idSinistre = idSinistre;
    }

    public Integer getIdSinistre() {
        return idSinistre;
    }

    public void setIdSinistre(Integer idSinistre) {
        this.idSinistre = idSinistre;
    }

    public Date getDatesinistre() {
        return datesinistre;
    }

    public void setDatesinistre(Date datesinistre) {
        this.datesinistre = datesinistre;
    }

    public String getLieusinistre() {
        return lieusinistre;
    }

    public void setLieusinistre(String lieusinistre) {
        this.lieusinistre = lieusinistre;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Typesinistre getIdTypesinistre() {
        return idTypesinistre;
    }

    public void setIdTypesinistre(Typesinistre idTypesinistre) {
        this.idTypesinistre = idTypesinistre;
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
        hash += (idSinistre != null ? idSinistre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinistre)) {
            return false;
        }
        Sinistre other = (Sinistre) object;
        if ((this.idSinistre == null && other.idSinistre != null) || (this.idSinistre != null && !this.idSinistre.equals(other.idSinistre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sinistre[ idSinistre=" + idSinistre + " ]";
    }
    
}
