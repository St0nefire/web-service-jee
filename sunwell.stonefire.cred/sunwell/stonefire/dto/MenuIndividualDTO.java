/**
 * MasterMenus.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */
package sunwell.stonefire.dto;

import sunwell.stonefire.core.entity.MenuIndividual;
import sunwell.stonefire.core.entity.MenuIndividualMenu;
import sunwell.stonefire.core.entity.MasterTag;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuIndividualDTO extends StandardDTO
{
   
    private Integer id;
    
    
    private String name;
    
    
    private String konten;
    
   
    private String memo;
    
    
    private Double price;
    
    
    private String image;
    
    private String tenantId;
    
    
    private Date createdAt;
    
    
    private Date updatedAt;
    
//    private Integer minOrder;
    
    private Boolean available;
    
    private List<MasterTagDTO> tags ;
    
    private List<MenuIndividualMenuDTO> menus;

    public MenuIndividualDTO ()
    {
    }
    
    public MenuIndividualDTO (MenuIndividual _mi)
    {
        setData (_mi);
    }

    public void setData (MenuIndividual _mi)
    {
        this.id = _mi.getId ();
        this.name = _mi.getName ();
        this.konten = _mi.getKonten ();
        this.memo = _mi.getMemo ();
        this.image = _mi.getImage ();
        this.price = _mi.getPrice ();
        this.available = _mi.isAvailable ();
        this.tenantId = _mi.getTenant ().getId ();
        this.createdAt = _mi.getCreatedAt ();
        this.updatedAt = _mi.getUpdatedAt ();
        if(_mi.getTags () != null && _mi.getTags ().size () > 0) {
            tags = new LinkedList<> ();
            for (MasterTag tag : _mi.getTags ()) {
                tags.add (new MasterTagDTO (tag));
            }
        }
        
        if(_mi.getMenus () != null && _mi.getMenus ().size () > 0) {
            menus = new LinkedList<>();
            for (MenuIndividualMenu mim : _mi.getMenus ()) {
                menus.add (new MenuIndividualMenuDTO (mim));
            }
        }
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

    public Double getPrice ()
    {
        return price;
    }

    public void setPrice (Double price)
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
        if (!(object instanceof MenuIndividualDTO)) {
            return false;
        }
        MenuIndividualDTO other = (MenuIndividualDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    /**
     * @return the available
     */
    public Boolean isAvailable ()
    {
        return available;
    }

    /**
     * @param isAvalaible the available to set
     */
    public void setAvailable (Boolean isAvalaible)
    {
        this.available = isAvalaible;
    }
    
     /**
     * @return the tags
     */
    public List<MasterTagDTO> getTags ()
    {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags (List<MasterTagDTO> tags)
    {
        this.tags = tags;
    }
    
    /**
     * @return the menus
     */
    public List<MenuIndividualMenuDTO> getMenus ()
    {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus (List<MenuIndividualMenuDTO> menus)
    {
        this.menus = menus;
    }

    /**
     * @return the tenantId
     */
    public String getTenantId ()
    {
        return tenantId;
    }

    /**
     * @param tenantId the tenantId to set
     */
    public void setTenantId (String tenantId)
    {
        this.tenantId = tenantId;
    }

}
