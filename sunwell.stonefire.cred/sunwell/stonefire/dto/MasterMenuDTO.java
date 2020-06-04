/**
 * MasterMenus.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */
package sunwell.stonefire.dto;

import sunwell.stonefire.core.entity.MasterMenu;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterMenuDTO extends StandardDTO
{
    
   
    private Integer id;
    
    
    private String name;
    
    
    private String konten;
    
   
    private String memo;
    
    
    private Boolean active;
    
    
    private String image;
    
    private String tenantId;
    
    
    private Date createdAt;
    
    
    private Date updatedAt;
    
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private UserCred userId;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterMenuId")
//    private List<MasterMenuScheduledPackage> masterMenuScheduledPackageList;

    public MasterMenuDTO ()
    {
    }
    
    public MasterMenuDTO (MasterMenu _mm)
    {
        setData (_mm);
    }

    public void setData (MasterMenu _mm)
    {
        this.id = _mm.getId ();
        this.name = _mm.getName ();
        this.konten = _mm.getKonten ();
        this.memo = _mm.getMemo ();
        this.image = _mm.getImage ();
        this.tenantId = _mm.getTenant ().getId ();
        this.active = _mm.isActive ();
        this.createdAt = _mm.getCreatedAt ();
        this.updatedAt = _mm.getUpdatedAt ();
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

    public Boolean isActive ()
    {
        return active;
    }

    public void setActive (Boolean active)
    {
        this.active = active;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
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
        if (!(object instanceof MasterMenuDTO)) {
            return false;
        }
        MasterMenuDTO other = (MasterMenuDTO) object;
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
