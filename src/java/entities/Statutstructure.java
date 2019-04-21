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
@Table(name = "statutstructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statutstructure.findAll", query = "SELECT s FROM Statutstructure s"),
    @NamedQuery(name = "Statutstructure.findByIdStatutstructure", query = "SELECT s FROM Statutstructure s WHERE s.idStatutstructure = :idStatutstructure"),
    @NamedQuery(name = "Statutstructure.findByNom", query = "SELECT s FROM Statutstructure s WHERE s.nom = :nom")})
public class Statutstructure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_statutstructure")
    private Short idStatutstructure;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idStatutstructure")
    private Collection<Structure> structureCollection;

    public Statutstructure() {
    }

    public Statutstructure(Short idStatutstructure) {
        this.idStatutstructure = idStatutstructure;
    }

    public Short getIdStatutstructure() {
        return idStatutstructure;
    }

    public void setIdStatutstructure(Short idStatutstructure) {
        this.idStatutstructure = idStatutstructure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Structure> getStructureCollection() {
        return structureCollection;
    }

    public void setStructureCollection(Collection<Structure> structureCollection) {
        this.structureCollection = structureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatutstructure != null ? idStatutstructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statutstructure)) {
            return false;
        }
        Statutstructure other = (Statutstructure) object;
        if ((this.idStatutstructure == null && other.idStatutstructure != null) || (this.idStatutstructure != null && !this.idStatutstructure.equals(other.idStatutstructure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statutstructure[ idStatutstructure=" + idStatutstructure + " ]";
    }
    
}
