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
@Table(name = "typesinistre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typesinistre.findAll", query = "SELECT t FROM Typesinistre t"),
    @NamedQuery(name = "Typesinistre.findByIdTypesinistre", query = "SELECT t FROM Typesinistre t WHERE t.idTypesinistre = :idTypesinistre"),
    @NamedQuery(name = "Typesinistre.findByNom", query = "SELECT t FROM Typesinistre t WHERE t.nom = :nom")})
public class Typesinistre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typesinistre")
    private Integer idTypesinistre;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idTypesinistre")
    private Collection<Sinistre> sinistreCollection;

    public Typesinistre() {
    }

    public Typesinistre(Integer idTypesinistre) {
        this.idTypesinistre = idTypesinistre;
    }

    public Integer getIdTypesinistre() {
        return idTypesinistre;
    }

    public void setIdTypesinistre(Integer idTypesinistre) {
        this.idTypesinistre = idTypesinistre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Sinistre> getSinistreCollection() {
        return sinistreCollection;
    }

    public void setSinistreCollection(Collection<Sinistre> sinistreCollection) {
        this.sinistreCollection = sinistreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypesinistre != null ? idTypesinistre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typesinistre)) {
            return false;
        }
        Typesinistre other = (Typesinistre) object;
        if ((this.idTypesinistre == null && other.idTypesinistre != null) || (this.idTypesinistre != null && !this.idTypesinistre.equals(other.idTypesinistre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typesinistre[ idTypesinistre=" + idTypesinistre + " ]";
    }
    
}
