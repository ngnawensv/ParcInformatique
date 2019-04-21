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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "arrondissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrondissement.findAll", query = "SELECT a FROM Arrondissement a"),
    @NamedQuery(name = "Arrondissement.findByIdArrondissement", query = "SELECT a FROM Arrondissement a WHERE a.idArrondissement = :idArrondissement"),
    @NamedQuery(name = "Arrondissement.findByNom", query = "SELECT a FROM Arrondissement a WHERE a.nom = :nom")})
public class Arrondissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_arrondissement")
    private Integer idArrondissement;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "id_departement", referencedColumnName = "id_departement")
    @ManyToOne
    private Departement idDepartement;
    @OneToMany(mappedBy = "idArrondissement")
    private Collection<Structure> structureCollection;

    public Arrondissement() {
    }

    public Arrondissement(Integer idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public Integer getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(Integer idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Departement getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
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
        hash += (idArrondissement != null ? idArrondissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arrondissement)) {
            return false;
        }
        Arrondissement other = (Arrondissement) object;
        if ((this.idArrondissement == null && other.idArrondissement != null) || (this.idArrondissement != null && !this.idArrondissement.equals(other.idArrondissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Arrondissement[ idArrondissement=" + idArrondissement + " ]";
    }
    
}
