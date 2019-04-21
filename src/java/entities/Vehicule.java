/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v"),
    @NamedQuery(name = "Vehicule.findByIdVehicule", query = "SELECT v FROM Vehicule v WHERE v.idVehicule = :idVehicule"),
    @NamedQuery(name = "Vehicule.findByImmatriculation", query = "SELECT v FROM Vehicule v WHERE v.immatriculation = :immatriculation"),
    @NamedQuery(name = "Vehicule.findByNumchassis", query = "SELECT v FROM Vehicule v WHERE v.numchassis = :numchassis"),
    @NamedQuery(name = "Vehicule.findByCartegrise", query = "SELECT v FROM Vehicule v WHERE v.cartegrise = :cartegrise"),
    @NamedQuery(name = "Vehicule.findByDatemiseenservice", query = "SELECT v FROM Vehicule v WHERE v.datemiseenservice = :datemiseenservice"),
    @NamedQuery(name = "Vehicule.findByNbredeplace", query = "SELECT v FROM Vehicule v WHERE v.nbredeplace = :nbredeplace"),
    @NamedQuery(name = "Vehicule.findByDateacquisition", query = "SELECT v FROM Vehicule v WHERE v.dateacquisition = :dateacquisition"),
    @NamedQuery(name = "Vehicule.findByNumserie", query = "SELECT v FROM Vehicule v WHERE v.numserie = :numserie"),
    @NamedQuery(name = "Vehicule.findByPuissance", query = "SELECT v FROM Vehicule v WHERE v.puissance = :puissance"),
    @NamedQuery(name = "Vehicule.findByCoutachatttc", query = "SELECT v FROM Vehicule v WHERE v.coutachatttc = :coutachatttc"),
    @NamedQuery(name = "Vehicule.findByDescription", query = "SELECT v FROM Vehicule v WHERE v.description = :description"),
    @NamedQuery(name = "Vehicule.findByDocument", query = "SELECT v FROM Vehicule v WHERE v.document = :document"),
    @NamedQuery(name = "Vehicule.findByNbresinistre", query = "SELECT v FROM Vehicule v WHERE v.nbresinistre = :nbresinistre"),
    @NamedQuery(name = "Vehicule.findByNbrereparation", query = "SELECT v FROM Vehicule v WHERE v.nbrereparation = :nbrereparation"),
    @NamedQuery(name = "Vehicule.findByNbrerevision", query = "SELECT v FROM Vehicule v WHERE v.nbrerevision = :nbrerevision"),
    @NamedQuery(name = "Vehicule.findByPhoto", query = "SELECT v FROM Vehicule v WHERE v.photo = :photo"),
    @NamedQuery(name = "Vehicule.findByEtat", query = "SELECT v FROM Vehicule v WHERE v.etat = :etat")})
public class Vehicule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vehicule")
    private Integer idVehicule;
    @Size(max = 255)
    @Column(name = "immatriculation")
    private String immatriculation;
    @Size(max = 255)
    @Column(name = "numchassis")
    private String numchassis;
    @Size(max = 255)
    @Column(name = "cartegrise")
    private String cartegrise;
    @Column(name = "datemiseenservice")
    @Temporal(TemporalType.DATE)
    private Date datemiseenservice;
    @Column(name = "nbredeplace")
    private Integer nbredeplace;
    @Column(name = "dateacquisition")
    @Temporal(TemporalType.DATE)
    private Date dateacquisition;
    @Size(max = 255)
    @Column(name = "numserie")
    private String numserie;
    @Size(max = 255)
    @Column(name = "puissance")
    private String puissance;
    @Column(name = "coutachatttc")
    private Integer coutachatttc;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "document")
    private String document;
    @Column(name = "nbresinistre")
    private Integer nbresinistre;
    @Column(name = "nbrereparation")
    private Integer nbrereparation;
    @Column(name = "nbrerevision")
    private Integer nbrerevision;
    @Size(max = 255)
    @Column(name = "photo")
    private String photo;
    @Size(max = 255)
    @Column(name = "etat")
    private String etat;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Reparation> reparationCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Restitution> restitutionCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Sinistre> sinistreCollection;
    @JoinColumn(name = "id_sourcefinancement", referencedColumnName = "id_sourcefinancement")
    @ManyToOne
    private Sourcefinancement idSourcefinancement;
    @JoinColumn(name = "id_sourceenergie", referencedColumnName = "id_sourceenergie")
    @ManyToOne
    private Sourceenergie idSourceenergie;
    @JoinColumn(name = "id_modele", referencedColumnName = "id_modele")
    @ManyToOne
    private Modele idModele;
    @JoinColumn(name = "id_modeacquisition", referencedColumnName = "id_modeacquisition")
    @ManyToOne
    private Modeacquisition idModeacquisition;
    @JoinColumn(name = "id_categorievehicule", referencedColumnName = "id_categorievehicule")
    @ManyToOne
    private Categorievehicule idCategorievehicule;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Reforme> reformeCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Attribution> attributionCollection;

    public Vehicule() {
    }

    public Vehicule(Integer idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Integer getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Integer idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNumchassis() {
        return numchassis;
    }

    public void setNumchassis(String numchassis) {
        this.numchassis = numchassis;
    }

    public String getCartegrise() {
        return cartegrise;
    }

    public void setCartegrise(String cartegrise) {
        this.cartegrise = cartegrise;
    }

    public Date getDatemiseenservice() {
        return datemiseenservice;
    }

    public void setDatemiseenservice(Date datemiseenservice) {
        this.datemiseenservice = datemiseenservice;
    }

    public Integer getNbredeplace() {
        return nbredeplace;
    }

    public void setNbredeplace(Integer nbredeplace) {
        this.nbredeplace = nbredeplace;
    }

    public Date getDateacquisition() {
        return dateacquisition;
    }

    public void setDateacquisition(Date dateacquisition) {
        this.dateacquisition = dateacquisition;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public Integer getCoutachatttc() {
        return coutachatttc;
    }

    public void setCoutachatttc(Integer coutachatttc) {
        this.coutachatttc = coutachatttc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getNbresinistre() {
        return nbresinistre;
    }

    public void setNbresinistre(Integer nbresinistre) {
        this.nbresinistre = nbresinistre;
    }

    public Integer getNbrereparation() {
        return nbrereparation;
    }

    public void setNbrereparation(Integer nbrereparation) {
        this.nbrereparation = nbrereparation;
    }

    public Integer getNbrerevision() {
        return nbrerevision;
    }

    public void setNbrerevision(Integer nbrerevision) {
        this.nbrerevision = nbrerevision;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public Collection<Reparation> getReparationCollection() {
        return reparationCollection;
    }

    public void setReparationCollection(Collection<Reparation> reparationCollection) {
        this.reparationCollection = reparationCollection;
    }

    @XmlTransient
    public Collection<Restitution> getRestitutionCollection() {
        return restitutionCollection;
    }

    public void setRestitutionCollection(Collection<Restitution> restitutionCollection) {
        this.restitutionCollection = restitutionCollection;
    }

    @XmlTransient
    public Collection<Sinistre> getSinistreCollection() {
        return sinistreCollection;
    }

    public void setSinistreCollection(Collection<Sinistre> sinistreCollection) {
        this.sinistreCollection = sinistreCollection;
    }

    public Sourcefinancement getIdSourcefinancement() {
        return idSourcefinancement;
    }

    public void setIdSourcefinancement(Sourcefinancement idSourcefinancement) {
        this.idSourcefinancement = idSourcefinancement;
    }

    public Sourceenergie getIdSourceenergie() {
        return idSourceenergie;
    }

    public void setIdSourceenergie(Sourceenergie idSourceenergie) {
        this.idSourceenergie = idSourceenergie;
    }

    public Modele getIdModele() {
        return idModele;
    }

    public void setIdModele(Modele idModele) {
        this.idModele = idModele;
    }

    public Modeacquisition getIdModeacquisition() {
        return idModeacquisition;
    }

    public void setIdModeacquisition(Modeacquisition idModeacquisition) {
        this.idModeacquisition = idModeacquisition;
    }

    public Categorievehicule getIdCategorievehicule() {
        return idCategorievehicule;
    }

    public void setIdCategorievehicule(Categorievehicule idCategorievehicule) {
        this.idCategorievehicule = idCategorievehicule;
    }

    @XmlTransient
    public Collection<Reforme> getReformeCollection() {
        return reformeCollection;
    }

    public void setReformeCollection(Collection<Reforme> reformeCollection) {
        this.reformeCollection = reformeCollection;
    }

    @XmlTransient
    public Collection<Attribution> getAttributionCollection() {
        return attributionCollection;
    }

    public void setAttributionCollection(Collection<Attribution> attributionCollection) {
        this.attributionCollection = attributionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicule != null ? idVehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.idVehicule == null && other.idVehicule != null) || (this.idVehicule != null && !this.idVehicule.equals(other.idVehicule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vehicule[ idVehicule=" + idVehicule + " ]";
    }
    
}
