/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * UserType.java
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
@Table(name = "usertype")
@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u")
    , @NamedQuery(name = "UserType.findById", query = "SELECT u FROM UserType u WHERE u.id = :id")
    , @NamedQuery(name = "UserType.findByTypeName", query = "SELECT u FROM UserType u WHERE u.typeName = :typeName")
    , @NamedQuery(name = "UserType.findByCreatedAt", query = "SELECT u FROM UserType u WHERE u.createdAt = :createdAt")
    , @NamedQuery(name = "UserType.findByUpdatedAt", query = "SELECT u FROM UserType u WHERE u.updatedAt = :updatedAt")})
@XmlRootElement
public class UserType implements Serializable 
{
    
    public static final Integer USER_TYPE_ADMIN = 1;
    public static final Integer USER_TYPE_TENANT = 2;
    public static final Integer USER_TYPE_USER = 3;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "type_name")
    private String typeName;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTypeId")
//    private List<UserCred> usersList;

    public UserType ()
    {
    }

    public UserType (Integer id)
    {
        this.id = id;
    }

    public UserType (Integer id, String typeName)
    {
        this.id = id;
        this.typeName = typeName;
    }

    public Integer getId ()
    {
        return id;
    }

    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getTypeName ()
    {
        return typeName;
    }

    public void setTypeName (String typeName)
    {
        this.typeName = typeName;
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

//    @XmlTransient
//    public List<UserCred> getUsersList ()
//    {
//        return usersList;
//    }
//
//    public void setUsersList (List<UserCred> usersList)
//    {
//        this.usersList = usersList;
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
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.cred.model.entity.UserType[ id=" + id + " ]";
    }

}
