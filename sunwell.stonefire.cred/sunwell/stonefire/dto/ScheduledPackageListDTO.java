/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * MasterMenuListDTO.java
 *
 * Created on Jul 21, 2017, 1:36:30 PM
 */

package sunwell.stonefire.dto;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.ScheduledPackage;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduledPackageListDTO extends StandardDTO
{
    private List<ScheduledPackageDTO> scheduledPackageList ;
    
    
    public ScheduledPackageListDTO() {
        
    }
    
    public ScheduledPackageListDTO(List<ScheduledPackage> _list) {
        setData (_list);
    }
    
    public void setData(List<ScheduledPackage> _list) {
        if(_list != null && _list.size () > 0) {
            scheduledPackageList = new LinkedList<>();
            for (ScheduledPackage _sp : _list) {
                scheduledPackageList.add (new ScheduledPackageDTO (_sp));
            }
        }
    }

    /**
     * @return the masterMenuList
     */
    public List<ScheduledPackageDTO> getScheduledPackageList ()
    {
        return scheduledPackageList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setScheduledPackageList (List<ScheduledPackageDTO> masterMenuList)
    {
        this.scheduledPackageList = masterMenuList;
    }
}
