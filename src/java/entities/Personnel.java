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
@Table(name = "personnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByIdPersonnel", query = "SELECT p FROM Personnel p WHERE p.idPersonnel = :idPersonnel"),
    @NamedQuery(name = "Personnel.findByNomPrenom", query = "SELECT p FROM Personnel p WHERE p.nomPrenom = :nomPrenom"),
    @NamedQuery(name = "Personnel.findByMatricule", query = "SELECT p FROM Personnel p WHERE p.matricule = :matricule"),
    @NamedQuery(name = "Personnel.findByCni", query = "SELECT p FROM Personnel p WHERE p.cni = :cni"),
    @NamedQuery(name = "Personnel.findBySexe", query = "SELECT p FROM Personnel p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personnel.findByDateNaissance", query = "SELECT p FROM Personnel p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Personnel.findByLieuNaissance", query = "SELECT p FROM Personnel p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Personnel.findByNationalite", query = "SELECT p FROM Personnel p WHERE p.nationalite = :nationalite"),
    @NamedQuery(name = "Personnel.findByDateRecrutement", query = "SELECT p FROM Personnel p WHERE p.dateRecrutement = :dateRecrutement"),
    @NamedQuery(name = "Personnel.findByPhoto", query = "SELECT p FROM Personnel p WHERE p.photo = :photo")})
public class Personnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personnel")
    private Integer idPersonnel;
    @Size(max = 100)
    @Column(name = "nom_prenom")
    private String nomPrenom;
    @Size(max = 20)
    @Column(name = "matricule")
    private String matricule;
    @Size(max = 255)
    @Column(name = "cni")
    private String cni;
    @Size(max = 255)
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 100)
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    @Size(max = 20)
    @Column(name = "nationalite")
    private String nationalite;
    @Column(name = "date_recrutement")
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    @Size(max = 50)
    @Column(name = "photo")
    private String photo;
    @OneToMany(mappedBy = "idPersonnel")
    private Collection<Adresse> adresseCollection;
    @OneToMany(mappedBy = "idPersonnel")
    private Collection<Restitution> restitutionCollection;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @ManyToOne
    private Service idService;
    @JoinColumn(name = "id_fonction", referencedColumnName = "id_fonction")
    @ManyToOne
    private Fonction idFonction;
    @OneToMany(mappedBy = "idPersonnel")
    private Collection<Attribution> attributionCollection;

    public Personnel() {
    }

    public Personnel(Integer idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public Integer getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Integer idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }

    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @XmlTransient
    public Collection<Restitution> getRestitutionCollection() {
        return restitutionCollection;
    }

    public void setRestitutionCollection(Collection<Restitution> restitutionCollection) {
        this.restitutionCollection = restitutionCollection;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public Fonction getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(Fonction idFonction) {
        this.idFonction = idFonction;
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
        hash += (idPersonnel != null ? idPersonnel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idPersonnel == null && other.idPersonnel != null) || (this.idPersonnel != null && !this.idPersonnel.equals(other.idPersonnel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Personnel[ idPersonnel=" + idPersonnel + " ]";
    }
    
}
