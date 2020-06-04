/**
 * MasterMenus.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */
package sunwell.stonefire.dto;

import sunwell.stonefire.core.entity.ScheduledPackageMenu;
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
public class ScheduledPackageMenuDTO extends StandardDTO
{   
    private Integer masterMenuId;
//    private Integer scheduledPackageId;
    private Integer date;

    public ScheduledPackageMenuDTO ()
    {
    }
    
    public ScheduledPackageMenuDTO (ScheduledPackageMenu _sp)
    {
        setData (_sp);
    }

    public void setData (ScheduledPackageMenu _sp)
    {
        this.setMasterMenuId (_sp.getMasterMenu ().getId ());
//        this.setScheduledPackageId (_sp.getScheduledPackage ().getId ());
        this.setDate ((Integer) _sp.getDate ());
    }
    
     /**
     * @return the masterMenuId
     */
    public Integer getMasterMenuId ()
    {
        return masterMenuId;
    }

    /**
     * @param masterMenuId the masterMenuId to set
     */
    public void setMasterMenuId (Integer masterMenuId)
    {
        this.masterMenuId = masterMenuId;
    }

    /**
     * @return the scheduledPackageId
     */
//    public Integer getScheduledPackageId ()
//    {
//        return scheduledPackageId;
//    }
//
//    /**
//     * @param scheduledPackageId the scheduledPackageId to set
//     */
//    public void setScheduledPackageId (Integer scheduledPackageId)
//    {
//        this.scheduledPackageId = scheduledPackageId;
//    }

    /**
     * @return the date
     */
    public Integer getDate ()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate (Integer date)
    {
        this.date = date;
    }

}
