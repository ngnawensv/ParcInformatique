/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngnawen
 */
@Entity
@Table(name = "norme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Norme.findAll", query = "SELECT n FROM Norme n"),
    @NamedQuery(name = "Norme.findByIdMarque", query = "SELECT n FROM Norme n WHERE n.idMarque = :idMarque"),
    @NamedQuery(name = "Norme.findByMin", query = "SELECT n FROM Norme n WHERE n.min = :min"),
    @NamedQuery(name = "Norme.findByMax", query = "SELECT n FROM Norme n WHERE n.max = :max")})
public class Norme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_marque")
    private Integer idMarque;
    @Size(max = 255)
    @Column(name = "min")
    private String min;
    @Size(max = 255)
    @Column(name = "max")
    private String max;
    @JoinColumn(name = "id_typestructure", referencedColumnName = "id_typestructure")
    @ManyToOne
    private Typestructure idTypestructure;
    @JoinColumn(name = "id_categorievehicule", referencedColumnName = "id_categorievehicule")
    @ManyToOne
    private Categorievehicule idCategorievehicule;

    public Norme() {
    }

    public Norme(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public Typestructure getIdTypestructure() {
        return idTypestructure;
    }

    public void setIdTypestructure(Typestructure idTypestructure) {
        this.idTypestructure = idTypestructure;
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
        hash += (idMarque != null ? idMarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Norme)) {
            return false;
        }
        Norme other = (Norme) object;
        if ((this.idMarque == null && other.idMarque != null) || (this.idMarque != null && !this.idMarque.equals(other.idMarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Norme[ idMarque=" + idMarque + " ]";
    }
    
}
