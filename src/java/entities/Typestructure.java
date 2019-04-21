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
@Table(name = "typestructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typestructure.findAll", query = "SELECT t FROM Typestructure t"),
    @NamedQuery(name = "Typestructure.findByIdTypestructure", query = "SELECT t FROM Typestructure t WHERE t.idTypestructure = :idTypestructure"),
    @NamedQuery(name = "Typestructure.findByCodeFr", query = "SELECT t FROM Typestructure t WHERE t.codeFr = :codeFr"),
    @NamedQuery(name = "Typestructure.findByNomFr", query = "SELECT t FROM Typestructure t WHERE t.nomFr = :nomFr")})
public class Typestructure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typestructure")
    private Integer idTypestructure;
    @Size(max = 30)
    @Column(name = "code_fr")
    private String codeFr;
    @Size(max = 255)
    @Column(name = "nom_fr")
    private String nomFr;
    @OneToMany(mappedBy = "idTypestructure")
    private Collection<Structure> structureCollection;
    @OneToMany(mappedBy = "idTypestructure")
    private Collection<Norme> normeCollection;

    public Typestructure() {
    }

    public Typestructure(Integer idTypestructure) {
        this.idTypestructure = idTypestructure;
    }

    public Integer getIdTypestructure() {
        return idTypestructure;
    }

    public void setIdTypestructure(Integer idTypestructure) {
        this.idTypestructure = idTypestructure;
    }

    public String getCodeFr() {
        return codeFr;
    }

    public void setCodeFr(String codeFr) {
        this.codeFr = codeFr;
    }

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    @XmlTransient
    public Collection<Structure> getStructureCollection() {
        return structureCollection;
    }

    public void setStructureCollection(Collection<Structure> structureCollection) {
        this.structureCollection = structureCollection;
    }

    @XmlTransient
    public Collection<Norme> getNormeCollection() {
        return normeCollection;
    }

    public void setNormeCollection(Collection<Norme> normeCollection) {
        this.normeCollection = normeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypestructure != null ? idTypestructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typestructure)) {
            return false;
        }
        Typestructure other = (Typestructure) object;
        if ((this.idTypestructure == null && other.idTypestructure != null) || (this.idTypestructure != null && !this.idTypestructure.equals(other.idTypestructure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typestructure[ idTypestructure=" + idTypestructure + " ]";
    }
    
}
