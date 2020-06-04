/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * ProvinceDTO.java
 *
 * Created on Aug 25, 2017, 2:10:40 PM
 */

package sunwell.stonefire.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sunwell.stonefire.core.entity.Province;
import sunwell.stonefire.core.entity.Regency;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegencyDTO 
{    
    private Integer id;
    private String name;
    
    public RegencyDTO() {
        
    }
    
    public RegencyDTO(Regency _r) {
        setData (_r);
    }
    
    public void setData(Regency _r) {
        id = _r.getId ();
        name = _r.getNamaKota ();
    }

    /**
     * @return the id
     */
    public Integer getId ()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId (Integer id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName ()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName (String name)
    {
        this.name = name;
    }    
}
