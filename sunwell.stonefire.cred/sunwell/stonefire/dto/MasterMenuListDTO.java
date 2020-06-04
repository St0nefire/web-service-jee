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

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterMenuListDTO extends StandardDTO
{
    private List<MasterMenuDTO> masterMenuList ;
    
    
    public MasterMenuListDTO() {
        
    }
    
    public MasterMenuListDTO(List<MasterMenu> _list) {
        setData (_list);
    }
    
    public void setData(List<MasterMenu> _list) {
        if(_list != null && _list.size () > 0) {
            masterMenuList = new LinkedList<>();
            for (MasterMenu masterMenu : _list) {
                masterMenuList.add (new MasterMenuDTO (masterMenu));
            }
        }
    }

    /**
     * @return the masterMenuList
     */
    public List<MasterMenuDTO> getMasterMenuList ()
    {
        return masterMenuList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setMasterMenuList (List<MasterMenuDTO> masterMenuList)
    {
        this.masterMenuList = masterMenuList;
    }
}
