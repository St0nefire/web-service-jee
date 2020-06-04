/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * MasterTagDTO.java
 *
 * Created on Aug 1, 2017, 11:41:15 AM
 */

package sunwell.stonefire.dto;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class MasterTagDTO extends StandardDTO
{   
    private Integer id;
    
    private String name;
    
    private String tagPicture;
    
    public MasterTagDTO() {
    
    }  
    
    public MasterTagDTO(MasterTag _mt) {
        setData (_mt);
    }
    
    public void setData(MasterTag _mt) {
        id = _mt.getId ();
        name = _mt.getName ();
        tagPicture = _mt.getTagPicture ();
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
     * @param tagName the name to set
     */
    public void setName (String tagName)
    {
        this.name = tagName;
    }

    /**
     * @return the tagPicture
     */
    public String getTagPicture ()
    {
        return tagPicture;
    }

    /**
     * @param tagPicture the tagPicture to set
     */
    public void setTagPicture (String tagPicture)
    {
        this.tagPicture = tagPicture;
    }
   
}
