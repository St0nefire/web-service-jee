/**
 * MasterMenus.java
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
import javax.persistence.Lob;
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
@Table(name = "mastermenu")
@NamedQueries({
    @NamedQuery(name = "MasterMenu.findAll", query = "SELECT m FROM MasterMenu m")
    , @NamedQuery(name = "MasterMenu.findById", query = "SELECT m FROM MasterMenu m WHERE m.id = :id")
    , @NamedQuery(name = "MasterMenu.findByName", query = "SELECT m FROM MasterMenu m WHERE m.name = :name")
    , @NamedQuery(name = "MasterMenu.findByActive", query = "SELECT m FROM MasterMenu m WHERE m.active = :active")
    , @NamedQuery(name = "MasterMenu.findByImage", query = "SELECT m FROM MasterMenu m WHERE m.image = :image")
    , @NamedQuery(name = "MasterMenu.findByTenant", query = "SELECT m FROM MasterMenu m WHERE m.tenant = :tenant")
    , @NamedQuery(name = "MasterMenu.findByCreatedAt", query = "SELECT m FROM MasterMenu m WHERE m.createdAt = :createdAt")
    , @NamedQuery(name = "MasterMenu.findByUpdatedAt", query = "SELECT m FROM MasterMenu m WHERE m.updatedAt = :updatedAt")})
public class MasterMenu implements Serializable 
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
    @Column(name = "is_active")
    private boolean active;
    
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private UserCred user;
    
    @JoinColumn(name = "tenant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tenant tenant;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterMenuId")
//    private List<MasterMenuScheduledPackage> masterMenuScheduledPackageList;

    public MasterMenu ()
    {
    }

    public MasterMenu (Integer id)
    {
        this.id = id;
    }

    public MasterMenu (Tenant _t, Integer id, String name, String konten, boolean isActive, String image)
    {
        this.tenant = _t;
        this.id = id;
        this.name = name;
        this.konten = konten;
        this.active = isActive;
        this.image = image;
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

    public boolean isActive ()
    {
        return active;
    }

    public void setActive (boolean isActive)
    {
        this.active = isActive;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
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

//    public UserCred getUser ()
//    {
//        return user;
//    }
//
//    public void setUser (UserCred userId)
//    {
//        this.user = userId;
//    }
    
    /**
     * @return the tenant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param tebant the tenant to set
     */
    public void setTenant (Tenant _t)
    {
        this.tenant = _t;
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
        if (!(object instanceof MasterMenu)) {
            return false;
        }
        MasterMenu other = (MasterMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MasterMenus[ id=" + id + " ]";
    }

}
