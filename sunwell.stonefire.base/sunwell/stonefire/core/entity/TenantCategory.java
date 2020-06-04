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
@Entity 
@Table(name = "tenantcategory")
@NamedQueries({
    @NamedQuery(name = "TenantCategory.findAll", query = "SELECT t FROM TenantCategory t")
    , @NamedQuery(name = "TenantCategory.findById", query = "SELECT t FROM TenantCategory t WHERE t.id = :id")
    , @NamedQuery(name = "TenantCategory.findByName", query = "SELECT t FROM TenantCategory t WHERE t.name = :name")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TenantCategory implements Serializable 
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
    

    public TenantCategory ()
    {
    }

    public TenantCategory (String id)
    {
        this.id = id;
    }

    public TenantCategory (String id, String name, String email)
    {
        this.id = id;
        this.name = name;
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
}
