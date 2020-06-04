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
import sunwell.stonefire.core.entity.Tenant;

/**
 *
 * @author Benny
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TenantsListDTO extends StandardDTO
{
    private List<TenantDTO> tenantsList ;
    
    
    public TenantsListDTO() {
        
    }
    
    public TenantsListDTO(List<Tenant> _tenants) {
        setData (_tenants);
    }
    
    public void setData(List<Tenant> _tenants) {
        if(_tenants != null && _tenants.size () > 0) {
            tenantsList = new LinkedList<>();
            for (Tenant _t : _tenants) {
                tenantsList.add (new TenantDTO (_t));
            }
        }
    }

    /**
     * @return the masterMenuList
     */
    public List<TenantDTO> getTenantsList ()
    {
        return tenantsList;
    }

    /**
     * @param masterMenuList the masterMenuList to set
     */
    public void setTenantsList (List<TenantDTO> _tenantsList)
    {
        this.tenantsList = _tenantsList;
    }
}
