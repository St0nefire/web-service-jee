/**
 * MasterMenuScheduledPackage.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */
package sunwell.stonefire.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Benny
 */
@IdClass(ScheduledPackageMenuPK.class)
@Entity 
@Table(name = "scheduledpackagemenu")
@NamedQueries({
    @NamedQuery(name = "ScheduledPackageMenu.findAll", query = "SELECT m FROM ScheduledPackageMenu m")
//    , @NamedQuery(name = "ScheduledPackageMenu.findById", query = "SELECT m FROM ScheduledPackageMenu m WHERE m.id = :id")
    , @NamedQuery(name = "ScheduledPackageMenu.findByDate", query = "SELECT m FROM ScheduledPackageMenu m WHERE m.date = :date")
    , @NamedQuery(name = "ScheduledPackageMenu.findByCreatedAt", query = "SELECT m FROM ScheduledPackageMenu m WHERE m.createdAt = :createdAt")
    , @NamedQuery(name = "ScheduledPackageMenu.findByUpdatedAt", query = "SELECT m FROM ScheduledPackageMenu m WHERE m.updatedAt = :updatedAt")
})
public class ScheduledPackageMenu implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @JoinColumn(name = "master_menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MasterMenu masterMenu;
    
    @Id
    @JoinColumn(name = "scheduled_package_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ScheduledPackage scheduledPackage;
    
    @Id
    @Basic(optional = false)
    @Column(name = "date")
    private int date;
    
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public ScheduledPackageMenu ()
    {
    }

    public int getDate ()
    {
        return date;
    }

    public void setDate (int date)
    {
        this.date = date;
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

    public MasterMenu getMasterMenu ()
    {
        return masterMenu;
    }

    public void setMasterMenu (MasterMenu masterMenuId)
    {
        this.masterMenu = masterMenuId;
    }

    public ScheduledPackage getScheduledPackage ()
    {
        return scheduledPackage;
    }

    public void setScheduledPackage (ScheduledPackage scheduledPackageId)
    {
        this.scheduledPackage = scheduledPackageId;
    }

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
//        if (!(object instanceof ScheduledPackageMenu)) {
//            return false;
//        }
//        ScheduledPackageMenu other = (ScheduledPackageMenu) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals (other.id)))
//            return false;
//        return true;
//    }
//
//    @Override
//    public String toString ()
//    {
//        return "sunwell.stonefire.entity.MasterMenuScheduledPackage[ id=" + id + " ]";
//    }

}
