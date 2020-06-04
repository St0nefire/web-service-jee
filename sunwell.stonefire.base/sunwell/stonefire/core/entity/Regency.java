/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Kotas.java
 *
 * Created on Jul 17, 2017, 10:44:06 AM
 */

package sunwell.stonefire.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benny
 */
@Entity 
@Table(name = "regency")
@NamedQueries({
    @NamedQuery(name = "Regency.findAll", query = "SELECT k FROM Regency k")
    , @NamedQuery(name = "Regency.findById", query = "SELECT k FROM Regency k WHERE k.id = :id")
    , @NamedQuery(name = "Regency.findByNamaKota", query = "SELECT k FROM Regency k WHERE k.namaKota = :namaKota")
    , @NamedQuery(name = "Regency.findByCreatedAt", query = "SELECT k FROM Regency k WHERE k.createdAt = :createdAt")
    , @NamedQuery(name = "Regency.findByUpdatedAt", query = "SELECT k FROM Regency k WHERE k.updatedAt = :updatedAt")})
@XmlRootElement
public class Regency implements Serializable 
{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "nama_kota")
    private String namaKota;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaId")
    private List<Address> addressesList;
    
    @JoinColumn(name = "provinsi_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Province provinsiId;

    public Regency ()
    {
    }

    public Regency (Integer id)
    {
        this.id = id;
    }

    public Regency (Integer id, String namaKota)
    {
        this.id = id;
        this.namaKota = namaKota;
    }

    public Integer getId ()
    {
        return id;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getNamaKota ()
    {
        return namaKota;
    }

    public void setNamaKota (String namaKota)
    {
        this.namaKota = namaKota;
    }

    public Date getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<Address> getAddressesList ()
    {
        return addressesList;
    }

    public void setAddressesList (List<Address> addressesList)
    {
        this.addressesList = addressesList;
    }

    public Province getProvinsiId ()
    {
        return provinsiId;
    }

    public void setProvinsiId (Province provinsiId)
    {
        this.provinsiId = provinsiId;
    }

    @Override
    public int hashCode ()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode () : 0);
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regency)) {
            return false;
        }
        Regency other = (Regency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Kotas[ id=" + id + " ]";
    }

}
