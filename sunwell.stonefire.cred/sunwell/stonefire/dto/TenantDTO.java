/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Users.java
 *
 * Created on Jul 17, 2017, 10:44:06 AM
 */

package sunwell.stonefire.dto;

import sunwell.stonefire.core.entity.Tenant;
import aegwyn.core.web.util.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TenantDTO extends StandardDTO 
{
    private String id;
    private String name;
    private String email;
    private String address;
    private String city;
    private String province;
    private String country;
    private String description;
    private String phoneNumber;
    private String memo;
    private String news;
    private String logo;
    private String profilePicture;
    
    public TenantDTO ()
    {
    }

    public TenantDTO (Tenant _t)
    {
        setData (_t);
    }

    public void setData(Tenant _t) {
        this.id = _t.getId ();
        this.name = _t.getName ();
        this.email = _t.getEmail ();
        this.address = _t.getAddress ();
        this.city = _t.getCity ();
        this.province = _t.getProvince ();
        this.country = _t.getCountry ();
        this.description = _t.getDescription ();
        this.phoneNumber = _t.getPhoneNumber ();
        this.memo = _t.getMemo ();
        this.news = _t.getNews ();
        this.profilePicture = _t.getProfilePicture ();
        this.logo = _t.getLogo ();
    }
  

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
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

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture ()
    {
        return profilePicture;
    }

    public void setProfilePicture (String profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    /**
     * @return the memo
     */
    public String getMemo ()
    {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo (String memo)
    {
        this.memo = memo;
    }

    /**
     * @return the news
     */
    public String getNews ()
    {
        return news;
    }

    /**
     * @param news the news to set
     */
    public void setNews (String news)
    {
        this.news = news;
    }

    /**
     * @return the logo
     */
    public String getLogo ()
    {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo (String logo)
    {
        this.logo = logo;
    }

    /**
     * @return the address
     */
    public String getAddress ()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress (String address)
    {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity ()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity (String city)
    {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince ()
    {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince (String province)
    {
        this.province = province;
    }

    /**
     * @return the country
     */
    public String getCountry ()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry (String country)
    {
        this.country = country;
    }

    /**
     * @return the description
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription (String description)
    {
        this.description = description;
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
        if (!(object instanceof TenantDTO)) {
            return false;
        }
        TenantDTO other = (TenantDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

}
