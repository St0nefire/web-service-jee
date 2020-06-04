package sunwell.stonefire.core.entity;

///**
// * MasterTagScheduledPackage.java
// *
// * Created on Jul 17, 2017, 2:57:41 PM
// */
//package sunwell.stonefire.entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
///**
// *
// * @author Benny
// */
//@Entity 
//@Table(name = "mastertagscheduledpackage")
//@NamedQueries({
//    @NamedQuery(name = "MasterTagScheduledPackage.findAll", query = "SELECT m FROM MasterTagScheduledPackage m")
//    , @NamedQuery(name = "MasterTagScheduledPackage.findById", query = "SELECT m FROM MasterTagScheduledPackage m WHERE m.id = :id")
//    , @NamedQuery(name = "MasterTagScheduledPackage.findByCreatedAt", query = "SELECT m FROM MasterTagScheduledPackage m WHERE m.createdAt = :createdAt")
//    , @NamedQuery(name = "MasterTagScheduledPackage.findByUpdatedAt", query = "SELECT m FROM MasterTagScheduledPackage m WHERE m.updatedAt = :updatedAt")
//})
//public class MasterTagScheduledPackage implements Serializable 
//{
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
//    
//    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//    
//    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt;
//    
//    @JoinColumn(name = "master_tag_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private MasterTag masterTagId;
//    
//    @JoinColumn(name = "scheduled_package_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private ScheduledPackage scheduledPackageId;
//
//    public MasterTagScheduledPackage ()
//    {
//    }
//
//    public MasterTagScheduledPackage (Integer id)
//    {
//        this.id = id;
//    }
//
//    public Integer getId ()
//    {
//        return id;
//    }
//
//    public void setId (Integer id)
//    {
//        this.id = id;
//    }
//
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
//    public MasterTag getMasterTagId ()
//    {
//        return masterTagId;
//    }
//
//    public void setMasterTagId (MasterTag masterTagId)
//    {
//        this.masterTagId = masterTagId;
//    }
//
//    public ScheduledPackage getScheduledPackageId ()
//    {
//        return scheduledPackageId;
//    }
//
//    public void setScheduledPackageId (ScheduledPackage scheduledPackageId)
//    {
//        this.scheduledPackageId = scheduledPackageId;
//    }
//
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += (id != null ? id.hashCode () : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof MasterTagScheduledPackage)) {
//            return false;
//        }
//        MasterTagScheduledPackage other = (MasterTagScheduledPackage) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
//            return false;
//        return true;
//    }
//
//    @Override
//    public String toString ()
//    {
//        return "sunwell.stonefire.entity.MasterTagScheduledPackage[ id=" + id + " ]";
//    }
//
//}
