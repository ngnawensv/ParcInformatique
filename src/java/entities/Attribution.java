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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "attribution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribution.findAll", query = "SELECT a FROM Attribution a"),
    @NamedQuery(name = "Attribution.findByIdAttribution", query = "SELECT a FROM Attribution a WHERE a.idAttribution = :idAttribution"),
    @NamedQuery(name = "Attribution.findByDateattribution", query = "SELECT a FROM Attribution a WHERE a.dateattribution = :dateattribution"),
    @NamedQuery(name = "Attribution.findByDaterestitution", query = "SELECT a FROM Attribution a WHERE a.daterestitution = :daterestitution"),
    @NamedQuery(name = "Attribution.findByDatesyst", query = "SELECT a FROM Attribution a WHERE a.datesyst = :datesyst")})
public class Attribution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_attribution")
    private Integer idAttribution;
    @Column(name = "dateattribution")
    @Temporal(TemporalType.DATE)
    private Date dateattribution;
    @Column(name = "daterestitution")
    @Temporal(TemporalType.DATE)
    private Date daterestitution;
    @Column(name = "datesyst")
    @Temporal(TemporalType.DATE)
    private Date datesyst;
    @OneToMany(mappedBy = "idAttribution")
    private Collection<Restitution> restitutionCollection;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_personnel", referencedColumnName = "id_personnel")
    @ManyToOne
    private Personnel idPersonnel;

    public Attribution() {
    }

    public Attribution(Integer idAttribution) {
        this.idAttribution = idAttribution;
    }

    public Integer getIdAttribution() {
        return idAttribution;
    }

    public void setIdAttribution(Integer idAttribution) {
        this.idAttribution = idAttribution;
    }

    public Date getDateattribution() {
        return dateattribution;
    }

    public void setDateattribution(Date dateattribution) {
        this.dateattribution = dateattribution;
    }

    public Date getDaterestitution() {
        return daterestitution;
    }

    public void setDaterestitution(Date daterestitution) {
        this.daterestitution = daterestitution;
    }

    public Date getDatesyst() {
        return datesyst;
    }

    public void setDatesyst(Date datesyst) {
        this.datesyst = datesyst;
    }

    @XmlTransient
    public Collection<Restitution> getRestitutionCollection() {
        return restitutionCollection;
    }

    public void setRestitutionCollection(Collection<Restitution> restitutionCollection) {
        this.restitutionCollection = restitutionCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttribution != null ? idAttribution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attribution)) {
            return false;
        }
        Attribution other = (Attribution) object;
        if ((this.idAttribution == null && other.idAttribution != null) || (this.idAttribution != null && !this.idAttribution.equals(other.idAttribution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Attribution[ idAttribution=" + idAttribution + " ]";
    }
    
}
