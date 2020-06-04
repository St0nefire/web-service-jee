/**
 * MasterMenus.java
 *
 * Created on Jul 17, 2017, 2:57:41 PM
 */
package sunwell.stonefire.dto;

import sunwell.stonefire.core.entity.MenuIndividualMenu;
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
public class MenuIndividualMenuDTO extends StandardDTO
{   
    private Integer masterMenuId;

    public MenuIndividualMenuDTO ()
    {
    }
    
    public MenuIndividualMenuDTO (MenuIndividualMenu _mim)
    {
        setData (_mim);
    }

    public void setData (MenuIndividualMenu _mim)
    {
        this.setMasterMenuId (_mim.getMasterMenu ().getId ());
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
}
