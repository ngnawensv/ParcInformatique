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
@Table(name = "demande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d"),
    @NamedQuery(name = "Demande.findByIdDemande", query = "SELECT d FROM Demande d WHERE d.idDemande = :idDemande"),
    @NamedQuery(name = "Demande.findByIntitule", query = "SELECT d FROM Demande d WHERE d.intitule = :intitule"),
    @NamedQuery(name = "Demande.findByAnneedemande", query = "SELECT d FROM Demande d WHERE d.anneedemande = :anneedemande"),
    @NamedQuery(name = "Demande.findByQtedemande", query = "SELECT d FROM Demande d WHERE d.qtedemande = :qtedemande"),
    @NamedQuery(name = "Demande.findByAnneeaccord", query = "SELECT d FROM Demande d WHERE d.anneeaccord = :anneeaccord"),
    @NamedQuery(name = "Demande.findByQteaccord", query = "SELECT d FROM Demande d WHERE d.qteaccord = :qteaccord"),
    @NamedQuery(name = "Demande.findByValidation", query = "SELECT d FROM Demande d WHERE d.validation = :validation")})
public class Demande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_demande")
    private Integer idDemande;
    @Size(max = 255)
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "anneedemande")
    @Temporal(TemporalType.DATE)
    private Date anneedemande;
    @Column(name = "qtedemande")
    private Integer qtedemande;
    @Size(max = 255)
    @Column(name = "anneeaccord")
    private String anneeaccord;
    @Column(name = "qteaccord")
    private Integer qteaccord;
    @Column(name = "validation")
    private Short validation;
    @JoinColumn(name = "id_structure", referencedColumnName = "id_structure")
    @ManyToOne
    private Structure idStructure;
    @JoinColumn(name = "id_modele", referencedColumnName = "id_modele")
    @ManyToOne
    private Modele idModele;
    @JoinColumn(name = "id_categorievehicule", referencedColumnName = "id_categorievehicule")
    @ManyToOne
    private Categorievehicule idCategorievehicule;

    public Demande() {
    }

    public Demande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getAnneedemande() {
        return anneedemande;
    }

    public void setAnneedemande(Date anneedemande) {
        this.anneedemande = anneedemande;
    }

    public Integer getQtedemande() {
        return qtedemande;
    }

    public void setQtedemande(Integer qtedemande) {
        this.qtedemande = qtedemande;
    }

    public String getAnneeaccord() {
        return anneeaccord;
    }

    public void setAnneeaccord(String anneeaccord) {
        this.anneeaccord = anneeaccord;
    }

    public Integer getQteaccord() {
        return qteaccord;
    }

    public void setQteaccord(Integer qteaccord) {
        this.qteaccord = qteaccord;
    }

    public Short getValidation() {
        return validation;
    }

    public void setValidation(Short validation) {
        this.validation = validation;
    }

    public Structure getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(Structure idStructure) {
        this.idStructure = idStructure;
    }

    public Modele getIdModele() {
        return idModele;
    }

    public void setIdModele(Modele idModele) {
        this.idModele = idModele;
    }

    public Categorievehicule getIdCategorievehicule() {
        return idCategorievehicule;
    }

    public void setIdCategorievehicule(Categorievehicule idCategorievehicule) {
        this.idCategorievehicule = idCategorievehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Demande[ idDemande=" + idDemande + " ]";
    }
    
}
