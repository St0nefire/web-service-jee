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

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuIndividualListDTO extends StandardDTO
{
    private List<MenuIndividualDTO> menuIndividualList ;
    
    
    public MenuIndividualListDTO() {
        
    }
    
    public MenuIndividualListDTO(List<MenuIndividual> _list) {
        setData (_list);
    }
    
   
    
    public void setData(List<MenuIndividual> _list) {
        if(_list != null && _list.size () > 0) {
            menuIndividualList = new LinkedList<>();
            for (MenuIndividual _mi : _list) {
                menuIndividualList.add (new MenuIndividualDTO (_mi));
            }
        }
    }
   

    /**
     * @return the masterMenuList
     */
    public List<MenuIndividualDTO> getMenuIndividualList ()
    {
        return menuIndividualList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setMenuIndividualList (List<MenuIndividualDTO> menuIndividualList)
    {
        this.menuIndividualList = menuIndividualList;
    }
}
