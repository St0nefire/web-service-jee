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

package sunwell.stonefire.core.entity;

//import aegwyn.core.web.util.Util;
import java.io.BufferedInputStream;
import java.io.Serializable;
import java.security.MessageDigest;
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
@Entity 
@Table(name = "usercred")
@UuidGenerator(name="UUID")
@NamedQueries({
    @NamedQuery(name = "UserCred.findAll", query = "SELECT u FROM UserCred u")
    , @NamedQuery(name = "UserCred.findById", query = "SELECT u FROM UserCred u WHERE u.id = :id")
    , @NamedQuery(name = "UserCred.findByTenant", query = "SELECT u FROM UserCred u WHERE u.tenant = :tenant")
    , @NamedQuery(name = "UserCred.findByName", query = "SELECT u FROM UserCred u WHERE u.name = :name")
    , @NamedQuery(name = "UserCred.findByEmail", query = "SELECT u FROM UserCred u WHERE u.email = :email")
    , @NamedQuery(name = "UserCred.findByPassword", query = "SELECT u FROM UserCred u WHERE u.password = :password")
    , @NamedQuery(name = "UserCred.findByPhoneNumber", query = "SELECT u FROM UserCred u WHERE u.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "UserCred.findByProviderName", query = "SELECT u FROM UserCred u WHERE u.providerName = :providerName")
    , @NamedQuery(name = "UserCred.findByProviderId", query = "SELECT u FROM UserCred u WHERE u.providerId = :providerId")
    , @NamedQuery(name = "UserCred.findByAbout", query = "SELECT u FROM UserCred u WHERE u.about = :about")
    , @NamedQuery(name = "UserCred.findByProfilePicture", query = "SELECT u FROM UserCred u WHERE u.profilePicture = :profilePicture")
    , @NamedQuery(name = "UserCred.findByRememberToken", query = "SELECT u FROM UserCred u WHERE u.rememberToken = :rememberToken")
    , @NamedQuery(name = "UserCred.findByCreatedAt", query = "SELECT u FROM UserCred u WHERE u.createdAt = :createdAt")
    , @NamedQuery(name = "UserCred.findByUpdatedAt", query = "SELECT u FROM UserCred u WHERE u.updatedAt = :updatedAt")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCred implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="UUID")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "provider_name")
    private String providerName;
    
    @Column(name = "provider_id")
    private String providerId;
    
    @Column(name = "about")
    private String about;
    
    @Column(name = "profile_picture")
    private String profilePicture;
    
    @Column(name = "remember_token")
    private String rememberToken;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Address> addressesList;
    
    @JoinColumn(name = "tenant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tenant tenant;
    
    @XmlTransient
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserType userType;
    
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

    public UserCred ()
    {
    }

    public UserCred (String id)
    {
        this.id = id;
    }

    public UserCred (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
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
        this.password = getChecksumOf (password);
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

    public UserType getUserType ()
    {
        return userType;
    }

    public void setUserType (UserType userTypeId)
    {
        this.userType = userTypeId;
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
        if (!(object instanceof UserCred)) {
            return false;
        }
        UserCred other = (UserCred) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.Users[ id=" + id + " ]";
    }

//    public List<MasterMenu> getMasterMenusList ()
//    {
//        return masterMenusList;
//    }
//
//    public void setMasterMenusList (List<MasterMenu> masterMenusList)
//    {
//        this.masterMenusList = masterMenusList;
//    }
//
//    public List<MenuIndividual> getMenuIndividualsList ()
//    {
//        return menuIndividualsList;
//    }
//
//    public void setMenuIndividualsList (List<MenuIndividual> menuIndividualsList)
//    {
//        this.menuIndividualsList = menuIndividualsList;
//    }
//
//    public List<ScheduledPackage> getScheduledPackagesList ()
//    {
//        return scheduledPackagesList;
//    }
//
//    public void setScheduledPackagesList (List<ScheduledPackage> scheduledPackagesList)
//    {
//        this.scheduledPackagesList = scheduledPackagesList;
//    }
    
    public String getChecksumOf(String _strToCheck) 
    {        
        try {
            StringBuffer buf = new StringBuffer();
            byte[] digestBuffer = new byte[8];
            byte[] digest = null;
            BufferedInputStream bis;
            MessageDigest md5;
            int i;
            md5 = MessageDigest.getInstance("MD5");
            md5.update(_strToCheck.getBytes());
            digest = md5.digest();
            int len = digest.length;
            for (int j = 0; j < len; j++) {
                byte2hex(digest[j], buf);
            }
            
            return buf.toString().toLowerCase ();
        } 
        catch (Exception e) {
            e.printStackTrace (System.out);
        }
        return null;
    }
    
    private void byte2hex(byte b, StringBuffer buf) 
    {
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int high = (b & 0xf0) >> 4;
        int low = b & 0x0f;
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

}
