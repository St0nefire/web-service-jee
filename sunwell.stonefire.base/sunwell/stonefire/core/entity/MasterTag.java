/**
 * MasterTags.java
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
@Table(name = "mastertag")
@NamedQueries({
    @NamedQuery(name = "MasterTag.findAll", query = "SELECT m FROM MasterTag m")
    , @NamedQuery(name = "MasterTag.findById", query = "SELECT m FROM MasterTag m WHERE m.id = :id")
    , @NamedQuery(name = "MasterTag.findByTagName", query = "SELECT m FROM MasterTag m WHERE m.name = :name")
    , @NamedQuery(name = "MasterTag.findByTagPicture", query = "SELECT m FROM MasterTag m WHERE m.tagPicture = :tagPicture")
    , @NamedQuery(name = "MasterTag.findByCreatedAt", query = "SELECT m FROM MasterTag m WHERE m.createdAt = :createdAt")
    , @NamedQuery(name = "MasterTag.findByUpdatedAt", query = "SELECT m FROM MasterTag m WHERE m.updatedAt = :updatedAt")
})
public class MasterTag implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tag_name")
    private String name;
    
    @Column(name = "tag_picture")
    private String tagPicture;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterTagId")
//    private List<MasterTagScheduledPackage> masterTagScheduledPackageList;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterTagId")
//    private List<MasterTagMenuIndividual> masterTagMenuIndividualList;

    public MasterTag ()
    {
    }

    public MasterTag (Integer id)
    {
        this.id = id;
    }

    public MasterTag (Integer id, String tagName)
    {
        this.id = id;
        this.name = tagName;
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

    public void setName (String tagName)
    {
        this.name = tagName;
    }

    public String getTagPicture ()
    {
        return tagPicture;
    }

    public void setTagPicture (String tagPicture)
    {
        this.tagPicture = tagPicture;
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

//    public List<MasterTagScheduledPackage> getMasterTagScheduledPackageList ()
//    {
//        return masterTagScheduledPackageList;
//    }
//
//    public void setMasterTagScheduledPackageList (List<MasterTagScheduledPackage> masterTagScheduledPackageList)
//    {
//        this.masterTagScheduledPackageList = masterTagScheduledPackageList;
//    }
//
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
        if (!(object instanceof MasterTag)) {
            return false;
        }
        MasterTag other = (MasterTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "sunwell.stonefire.entity.MasterTags[ id=" + id + " ]";
    }

}
