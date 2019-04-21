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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "restitution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restitution.findAll", query = "SELECT r FROM Restitution r"),
    @NamedQuery(name = "Restitution.findByIdAffectation", query = "SELECT r FROM Restitution r WHERE r.idAffectation = :idAffectation"),
    @NamedQuery(name = "Restitution.findByDatePriseService", query = "SELECT r FROM Restitution r WHERE r.datePriseService = :datePriseService"),
    @NamedQuery(name = "Restitution.findByDateAffectation", query = "SELECT r FROM Restitution r WHERE r.dateAffectation = :dateAffectation"),
    @NamedQuery(name = "Restitution.findByIdnvelleatribution", query = "SELECT r FROM Restitution r WHERE r.idnvelleatribution = :idnvelleatribution")})
public class Restitution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_affectation")
    private Integer idAffectation;
    @Column(name = "date_prise_service")
    @Temporal(TemporalType.DATE)
    private Date datePriseService;
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    @Column(name = "idnvelleatribution")
    private Integer idnvelleatribution;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_personnel", referencedColumnName = "id_personnel")
    @ManyToOne
    private Personnel idPersonnel;
    @JoinColumn(name = "id_attribution", referencedColumnName = "id_attribution")
    @ManyToOne
    private Attribution idAttribution;

    public Restitution() {
    }

    public Restitution(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public Integer getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public Date getDatePriseService() {
        return datePriseService;
    }

    public void setDatePriseService(Date datePriseService) {
        this.datePriseService = datePriseService;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public Integer getIdnvelleatribution() {
        return idnvelleatribution;
    }

    public void setIdnvelleatribution(Integer idnvelleatribution) {
        this.idnvelleatribution = idnvelleatribution;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Personnel getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Personnel idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public Attribution getIdAttribution() {
        return idAttribution;
    }

    public void setIdAttribution(Attribution idAttribution) {
        this.idAttribution = idAttribution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAffectation != null ? idAffectation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restitution)) {
            return false;
        }
        Restitution other = (Restitution) object;
        if ((this.idAffectation == null && other.idAffectation != null) || (this.idAffectation != null && !this.idAffectation.equals(other.idAffectation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Restitution[ idAffectation=" + idAffectation + " ]";
    }
    
}
