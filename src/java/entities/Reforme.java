/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "reforme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reforme.findAll", query = "SELECT r FROM Reforme r"),
    @NamedQuery(name = "Reforme.findByIdReforme", query = "SELECT r FROM Reforme r WHERE r.idReforme = :idReforme"),
    @NamedQuery(name = "Reforme.findByDatemisereforme", query = "SELECT r FROM Reforme r WHERE r.datemisereforme = :datemisereforme"),
    @NamedQuery(name = "Reforme.findByDatevente", query = "SELECT r FROM Reforme r WHERE r.datevente = :datevente"),
    @NamedQuery(name = "Reforme.findByMontantvente", query = "SELECT r FROM Reforme r WHERE r.montantvente = :montantvente"),
    @NamedQuery(name = "Reforme.findByVendu", query = "SELECT r FROM Reforme r WHERE r.vendu = :vendu")})
public class Reforme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reforme")
    private Integer idReforme;
    @Size(max = 50)
    @Column(name = "datemisereforme")
    private String datemisereforme;
    @Size(max = 50)
    @Column(name = "datevente")
    private String datevente;
    @Column(name = "montantvente")
    private BigInteger montantvente;
    @Column(name = "vendu")
    private Boolean vendu;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule")
    @ManyToOne
    private Vehicule idVehicule;

    public Reforme() {
    }

    public Reforme(Integer idReforme) {
        this.idReforme = idReforme;
    }

    public Integer getIdReforme() {
        return idReforme;
    }

    public void setIdReforme(Integer idReforme) {
        this.idReforme = idReforme;
    }

    public String getDatemisereforme() {
        return datemisereforme;
    }

    public void setDatemisereforme(String datemisereforme) {
        this.datemisereforme = datemisereforme;
    }

    public String getDatevente() {
        return datevente;
    }

    public void setDatevente(String datevente) {
        this.datevente = datevente;
    }

    public BigInteger getMontantvente() {
        return montantvente;
    }

    public void setMontantvente(BigInteger montantvente) {
        this.montantvente = montantvente;
    }

    public Boolean getVendu() {
        return vendu;
    }

    public void setVendu(Boolean vendu) {
        this.vendu = vendu;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReforme != null ? idReforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reforme)) {
            return false;
        }
        Reforme other = (Reforme) object;
        if ((this.idReforme == null && other.idReforme != null) || (this.idReforme != null && !this.idReforme.equals(other.idReforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reforme[ idArrondissement=" + idReforme + " ]";
    }
    
}
