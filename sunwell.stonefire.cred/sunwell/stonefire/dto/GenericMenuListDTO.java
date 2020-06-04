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
import sunwell.stonefire.core.entity.MenuIndividual;
import sunwell.stonefire.core.entity.ScheduledPackage;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericMenuListDTO extends StandardDTO
{
    private List<GenericMenuDTO> menuList = new LinkedList<>();
    
    
    public GenericMenuListDTO() {
        
    }
    
    public GenericMenuListDTO(List<Object> _list) {
        setData (_list);
    }
    
    public void setData(List<Object> _list) {
        if(_list != null) {            
            for (Object _obj : _list) {
                if(_list.get (0) instanceof MasterMenu) {
                    
                }
                else if(_list.get (0) instanceof MenuIndividual) {

                }
                else if(_list.get (0) instanceof ScheduledPackage) {

                }
            }
        }
    }

    /**
     * @return the masterMenuList
     */
    public List<GenericMenuDTO> getMasterMenuList ()
    {
        return menuList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setMasterMenuList (List<GenericMenuDTO> masterMenuList)
    {
        this.menuList = masterMenuList;
    }
}
