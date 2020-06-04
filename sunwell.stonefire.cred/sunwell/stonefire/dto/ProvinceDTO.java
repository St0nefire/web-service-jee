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

import java.util.LinkedList;
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
public class ProvinceDTO extends StandardDTO
{
    private Integer id;
    private String name;
    private List<RegencyDTO> regencies;
    
    public ProvinceDTO() {
        
    }
    
    public ProvinceDTO(Province _p) {
        setData (_p);
    }
    
    public void setData(Province _p) {
        id = _p.getId ();
        name = _p.getProvinceName ();
        if(_p.getKotasList () != null && _p.getKotasList ().size () > 0) {
            regencies = new LinkedList<>();
            for (Regency regency : _p.getKotasList ()) {
                regencies.add (new RegencyDTO (regency));
            }
        }
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
    
    /**
     * @return the regencies
     */
    public List<RegencyDTO> getRegencies ()
    {
        return regencies;
    }

    /**
     * @param regencies the regencies to set
     */
    public void setRegencies (List<RegencyDTO> regencies)
    {
        this.regencies = regencies;
    }
}
