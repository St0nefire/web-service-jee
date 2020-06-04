/**
 * MenuIndividuals.java
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
@Table(name = "menuindividual")
@NamedQueries({
    @NamedQuery(name = "MenuIndividual.findAll", query = "SELECT m FROM MenuIndividual m")
    , @NamedQuery(name = "MenuIndividual.findById", query = "SELECT m FROM MenuIndividual m WHERE m.id = :id")
    , @NamedQuery(name = "MenuIndividual.findByName", query = "SELECT m FROM MenuIndividual m WHERE m.name = :name")
    , @NamedQuery(name = "MenuIndividual.findByAvailable", query = "SELECT m FROM MenuIndividual m WHERE m.available = :available")
    , @NamedQuery(name = "MenuIndividual.findByPrice", query = "SELECT m FROM MenuIndividual m WHERE m.price = :price")
    , @NamedQuery(name = "MenuIndividual.findByImage", query = "SELECT m FROM MenuIndividual m WHERE m.image = :image")
    , @NamedQuery(name = "MenuIndividual.findByTenant", query = "SELECT m FROM MenuIndividual m WHERE m.tenant = :tenant")
    , @NamedQuery(name = "MenuIndividual.findByCreatedAt", query = "SELECT m FROM MenuIndividual m WHERE m.createdAt = :createdAt")
    , @NamedQuery(name = "MenuIndividual.findByUpdatedAt", query = "SELECT m FROM MenuIndividual m WHERE m.updatedAt = :updatedAt")
})
public class MenuIndividual implements Serializable 
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
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private UserCred user;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuIndividual")
    private List<MenuIndividualMenu> menus;
    
    @JoinColumn(name = "tenant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tenant tenant;
    
    @ManyToMany
    @JoinTable(name="menuindividualtag",
        joinColumns=
            @JoinColumn(name="menu_individual_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="master_tag_id", referencedColumnName="id")
    )
    private List<MasterTag> tags;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuIndividualId")
//    private List<MasterTagMenuIndividual> masterTagMenuIndividualList;

    public MenuIndividual ()
    {
    }

    public MenuIndividual (Integer id)
    {
        this.id = id;
    }

    public MenuIndividual (Tenant _t, String name, String konten, String memo, Double price, String image)
    {
        this.tenant = _t;
        this.id = id;
        this.name = name;
        this.konten = konten;
        this.price = price;
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

//    public List<MasterTagMenuIndividual> getMasterTagMenuIndividualList ()
//    {
//        return masterTagMenuIndividualList;
//    }
//
//    public void setMasterTagMenuIndividualList (List<MasterTagMenuIndividual> masterTagMenuIndividualList)
//    {
//        this.masterTagMenuIndividualList = masterTagMenuIndividualList;
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
        if (!(object instanceof MenuIndividual)) {
            return false;
        }
        MenuIndividual other = (MenuIndividual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MenuIndividuals[ id=" + id + " ]";
    }

    /**
     * @return the tags
     */
    public List<MasterTag> getTags ()
    {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags (List<MasterTag> tags)
    {
        this.tags = tags;
    }
    
    /**
     * @return the menus
     */
    public List<MenuIndividualMenu> getMenus ()
    {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus (List<MenuIndividualMenu> menus)
    {
        this.menus = menus;
    }

    /**
     * @return the tebant
     */
    public Tenant getTenant ()
    {
        return tenant;
    }

    /**
     * @param tebant the tebant to set
     */
    public void setTenant (Tenant _t)
    {
        this.tenant = _t;
    }

}
