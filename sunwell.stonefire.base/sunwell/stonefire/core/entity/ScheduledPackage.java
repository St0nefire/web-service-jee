/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * ScheduledPackages.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Benny
 */
@Entity 
@Table(name = "scheduledpackage")
@NamedQueries({
    @NamedQuery(name = "ScheduledPackage.findAll", query = "SELECT s FROM ScheduledPackage s")
    , @NamedQuery(name = "ScheduledPackage.findById", query = "SELECT s FROM ScheduledPackage s WHERE s.id = :id")
    , @NamedQuery(name = "ScheduledPackage.findByName", query = "SELECT s FROM ScheduledPackage s WHERE s.name = :name")
    , @NamedQuery(name = "ScheduledPackage.findByAvalaible", query = "SELECT s FROM ScheduledPackage s WHERE s.available = :available")
    , @NamedQuery(name = "ScheduledPackage.findByPrice", query = "SELECT s FROM ScheduledPackage s WHERE s.price = :price")
    , @NamedQuery(name = "ScheduledPackage.findByImage", query = "SELECT s FROM ScheduledPackage s WHERE s.image = :image")
    , @NamedQuery(name = "ScheduledPackage.findByTenant", query = "SELECT m FROM ScheduledPackage m WHERE m.tenant = :tenant")
    , @NamedQuery(name = "ScheduledPackage.findByMinOrder", query = "SELECT s FROM ScheduledPackage s WHERE s.minOrder = :minOrder")
    , @NamedQuery(name = "ScheduledPackage.findByCreatedAt", query = "SELECT s FROM ScheduledPackage s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "ScheduledPackage.findByUpdatedAt", query = "SELECT s FROM ScheduledPackage s WHERE s.updatedAt = :updatedAt")})
public class ScheduledPackage implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "konten")
    private String konten;
    
    @Lob
    @Column(name = "memo")
    private String memo;
    
    @Basic(optional = false)
    @Column(name = "is_avalaible")
    private boolean available;
    
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)
    @Column(name = "min_order")
    private Integer minOrder;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduledPackage")
    private List<ScheduledPackageMenu> menus;
    
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private UserCred user;
    
    @JoinColumn(name = "tenant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tenant tenant;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduledPackageId")
    @ManyToMany
    @JoinTable(name="scheduledpackagetag",
        joinColumns=
            @JoinColumn(name="scheduled_package_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="master_tag_id", referencedColumnName="id")
    )
    private List<MasterTag> tags;

    public ScheduledPackage ()
    {
    }

    public ScheduledPackage (Integer id)
    {
        this.id = id;
    }

    public ScheduledPackage (Tenant _t, String name, String konten, String _memo, double price, int minOrder, boolean isAvalaible, String image)
    {
        this.tenant = _t;
        this.name = name;
        this.konten = konten;
        this.available = isAvalaible;
        this.price = price;
        this.image = image;
        this.minOrder = minOrder;
    }

    public Integer getId ()
    {
        return id;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getKonten ()
    {
        return konten;
    }

    public void setKonten (String konten)
    {
        this.konten = konten;
    }

    public String getMemo ()
    {
        return memo;
    }

    public void setMemo (String memo)
    {
        this.memo = memo;
    }

    public boolean isAvailable ()
    {
        return available;
    }

    public void setAvailable (boolean isAvalaible)
    {
        this.available = isAvalaible;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double price)
    {
        this.price = price;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public Integer getMinOrder ()
    {
        return minOrder;
    }

    public void setMinOrder (Integer minOrder)
    {
        this.minOrder = minOrder;
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

//    public List<MasterMenuScheduledPackage> getMasterMenuScheduledPackageList ()
//    {
//        return masterMenuScheduledPackageList;
//    }
//
//    public void setMasterMenuScheduledPackageList (List<MasterMenuScheduledPackage> masterMenuScheduledPackageList)
//    {
//        this.masterMenuScheduledPackageList = masterMenuScheduledPackageList;
//    }

//    public UserCred getUser ()
//    {
//        return user;
//    }
//
//    public void setUser (UserCred userId)
//    {
//        this.user = userId;
//    }

    public List<MasterTag> getTags ()
    {
        return tags;
    }

    public void setTags (List<MasterTag> masterTagScheduledPackageList)
    {
        this.tags = masterTagScheduledPackageList;
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
        if (!(object instanceof ScheduledPackage)) {
            return false;
        }
        ScheduledPackage other = (ScheduledPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.ScheduledPackages[ id=" + id + " ]";
    }

    /**
     * @return the menus
     */
    public List<ScheduledPackageMenu> getMenus ()
    {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus (List<ScheduledPackageMenu> menus)
    {
        if(menus == null)
            return;
        
        for (ScheduledPackageMenu menu : menus) {
            menu.setScheduledPackage (this);
        }
        this.menus = menus;
    }

    /**
     * @return the tenant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param tenant the tenant to set
     */
    public void setTenant (Tenant tenant)
    {
        this.tenant = tenant;
    }

}
