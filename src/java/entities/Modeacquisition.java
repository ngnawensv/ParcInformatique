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
@Table(name = "modeacquisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modeacquisition.findAll", query = "SELECT m FROM Modeacquisition m"),
    @NamedQuery(name = "Modeacquisition.findByIdModeacquisition", query = "SELECT m FROM Modeacquisition m WHERE m.idModeacquisition = :idModeacquisition"),
    @NamedQuery(name = "Modeacquisition.findByNom", query = "SELECT m FROM Modeacquisition m WHERE m.nom = :nom")})
public class Modeacquisition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modeacquisition")
    private Integer idModeacquisition;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idModeacquisition")
    private Collection<Vehicule> vehiculeCollection;

    public Modeacquisition() {
    }

    public Modeacquisition(Integer idModeacquisition) {
        this.idModeacquisition = idModeacquisition;
    }

    public Integer getIdModeacquisition() {
        return idModeacquisition;
    }

    public void setIdModeacquisition(Integer idModeacquisition) {
        this.idModeacquisition = idModeacquisition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Vehicule> getVehiculeCollection() {
        return vehiculeCollection;
    }

    public void setVehiculeCollection(Collection<Vehicule> vehiculeCollection) {
        this.vehiculeCollection = vehiculeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModeacquisition != null ? idModeacquisition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modeacquisition)) {
            return false;
        }
        Modeacquisition other = (Modeacquisition) object;
        if ((this.idModeacquisition == null && other.idModeacquisition != null) || (this.idModeacquisition != null && !this.idModeacquisition.equals(other.idModeacquisition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Modeacquisition[ idModeacquisition=" + idModeacquisition + " ]";
    }
    
}
