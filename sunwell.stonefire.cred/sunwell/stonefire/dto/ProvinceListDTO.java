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
import sunwell.stonefire.core.entity.Province;
import sunwell.stonefire.core.entity.ScheduledPackage;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProvinceListDTO extends StandardDTO
{
    private List<ProvinceDTO> provincesList ;
    
    
    public ProvinceListDTO() {
        
    }
    
    public ProvinceListDTO(List<Province> _provinces) {
        setData (_provinces);
    }
    
    public void setData(List<Province> _provinces) {
        if(_provinces != null && _provinces.size () > 0) {
            provincesList = new LinkedList<>();
            for (Province _p : _provinces) {
                provincesList.add (new ProvinceDTO (_p));
            }
        }
    }

    /**
     * @return the masterMenuList
     */
    public List<ProvinceDTO> getProvincesList ()
    {
        return provincesList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setProvincesList (List<ProvinceDTO> _provinceList)
    {
        this.provincesList = _provinceList;
    }
}
