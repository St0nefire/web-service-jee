/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * MasterTagDTOList.java
 *
 * Created on Aug 1, 2017, 11:43:09 AM
 */

package sunwell.stonefire.dto;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sunwell.stonefire.core.entity.MasterTag;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterTagListDTO extends StandardDTO
{
    private List<MasterTagDTO> masterTagsList ;
    
    public MasterTagListDTO() {
        
    }
    
    public MasterTagListDTO(List<MasterTag> _list) {
        setData (_list);
    }
    
    public void setData(List<MasterTag> _list) {
        if(_list != null && _list.size () > 0) {
            masterTagsList = new LinkedList<>();
            for (MasterTag mt : _list) {
                masterTagsList.add (new MasterTagDTO (mt));
            }
        }
    }

    /**
     * @return the masterTagsList
     */
    public List<MasterTagDTO> getMasterTagsList ()
    {
        return masterTagsList;
    }

    /**
     * @param masterTagsList the masterTagsList to set
     */
    public void setMasterTagsList (List<MasterTagDTO> masterTagsList)
    {
        this.masterTagsList = masterTagsList;
    }
}
