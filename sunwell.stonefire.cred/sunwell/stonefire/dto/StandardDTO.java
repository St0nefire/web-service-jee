/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * StandardDTO.java
 *
 * Created on Jul 20, 2017, 11:11:14 AM
 */

package sunwell.stonefire.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StandardDTO 
{
    private String sessionString;
    private String errorMessage;
    private String companyName;
    
    /**
     * @return the session
     */
    public String getSessionString ()
    {
        return sessionString;
    }

    /**
     * @param session the session to set
     */
    public void setSessionString (String session)
    {
        this.sessionString = session;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage ()
    {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage (String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    
    /**
     * @return the companyName
     */
    public String getCompanyName ()
    {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName (String companyName)
    {
        this.companyName = companyName;
    }
    
   
}
