/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * UserCredDTO.java
 *
 * Created on Jul 20, 2017, 11:02:26 AM
 */

package sunwell.stonefire.dto;

import aegwyn.core.web.util.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import sunwell.stonefire.core.entity.Address;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCredDTO extends StandardDTO implements Serializable 
{

    
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String providerName;
    private String providerId;
    private String about;
    private String profilePicture;
    private String rememberToken;
    private String tenantId;
    private TenantDTO tenant;
//    private Date createdAt;
//    private Date updatedAt;
//    private List<Address> addressesList;
//    private String userTypeId;
//    private String userTypeName;
    
//    @XmlTransient
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
//    private List<MasterMenu> masterMenusList;
//    
//    @XmlTransient
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
//    private List<MenuIndividual> menuIndividualsList;
//    
//    @XmlTransient
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
//    private List<ScheduledPackage> scheduledPackagesList;

    public UserCredDTO ()
    {
    }

    public UserCredDTO (UserCred _usr)
    {
        setData (_usr);
    }
    
    public void setData(UserCred _usr) {
        id = _usr.getId ();
        name = _usr.getName ();
        email = _usr.getEmail ();
        password = _usr.getPassword ();
        phoneNumber = _usr.getPhoneNumber ();
        providerName = _usr.getProviderName ();
        providerId = _usr.getProviderId ();
        about = _usr.getAbout ();
        profilePicture = _usr.getProfilePicture ();
        rememberToken = _usr.getRememberToken ();
        tenantId = _usr.getTenant ().getId ();
        tenant = new TenantDTO(_usr.getTenant ());
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

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = Util.getChecksumOf (password);
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getProviderName ()
    {
        return providerName;
    }

    public void setProviderName (String providerName)
    {
        this.providerName = providerName;
    }

    public String getProviderId ()
    {
        return providerId;
    }

    public void setProviderId (String providerId)
    {
        this.providerId = providerId;
    }

    public String getAbout ()
    {
        return about;
    }

    public void setAbout (String about)
    {
        this.about = about;
    }

    public String getProfilePicture ()
    {
        return profilePicture;
    }

    public void setProfilePicture (String profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    public String getRememberToken ()
    {
        return rememberToken;
    }

    public void setRememberToken (String rememberToken)
    {
        this.rememberToken = rememberToken;
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
    
    /**
     * @return the tenant
     */
    public TenantDTO getTenant ()
    {
        return tenant;
    }

    /**
     * @param tenant the tenant to set
     */
    public void setTenant (TenantDTO tenant)
    {
        this.tenant = tenant;
    }

//    public Date getCreatedAt ()
//    {
//        return createdAt;
//    }
//
//    public void setCreatedAt (Date createdAt)
//    {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt ()
//    {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt (Date updatedAt)
//    {
//        this.updatedAt = updatedAt;
//    }
//
//    @XmlTransient
//    public List<Address> getAddressesList ()
//    {
//        return addressesList;
//    }
//
//    public void setAddressesList (List<Address> addressesList)
//    {
//        this.addressesList = addressesList;
//    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Users[ id=" + id + " ]";
    }

    /**
     * @return the userTypeName
     */
//    public String getUserTypeName ()
//    {
//        return userTypeName;
//    }
//
//    /**
//     * @param userTypeName the userTypeName to set
//     */
//    public void setUserTypeName (String userTypeName)
//    {
//        this.userTypeName = userTypeName;
//    }
//
//    /**
//     * @return the userTypeId
//     */
//    public String getUserTypeId ()
//    {
//        return userTypeId;
//    }
//
//    /**
//     * @param userTypeId the userTypeId to set
//     */
//    public void setUserTypeId (String userTypeId)
//    {
//        this.userTypeId = userTypeId;
//    }
}
