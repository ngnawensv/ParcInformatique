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
@Table(name = "pays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.nextId", query = "SELECT MAX(p.idPays) FROM Pays p"),
    @NamedQuery(name = "Pays.findByIdPays", query = "SELECT p FROM Pays p WHERE p.idPays = :idPays"),
    @NamedQuery(name = "Pays.findByNom", query = "SELECT p FROM Pays p WHERE UPPER(p.nom)= UPPER(:nom)")})
public class Pays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pays")
    private Integer idPays;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idPays")
    private Collection<Region> regionCollection;

    public Pays() {
    }

    public Pays(Integer idPays) {
        this.idPays = idPays;
    }

    public Integer getIdPays() {
        return idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Region> getRegionCollection() {
        return regionCollection;
    }

    public void setRegionCollection(Collection<Region> regionCollection) {
        this.regionCollection = regionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPays != null ? idPays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.idPays == null && other.idPays != null) || (this.idPays != null && !this.idPays.equals(other.idPays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pays{" + "idPays=" + idPays + ", nom=" + nom + '}';
    }

    
    
}
