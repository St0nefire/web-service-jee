/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * MasterMenuFacade.java
 *
 * Created on Jul 21, 2017, 1:20:04 PM
 */

package sunwell.stonefire.bus;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import sunwell.stonefire.dao.MasterMenuDAO;
import sunwell.stonefire.dao.MenuIndividualDAO;
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.MenuIndividual;
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MenuIndividualFacade 
{
    @Inject
    MenuIndividualDAO miDAO;
        
    public List<MenuIndividual> findByTenant(Tenant _t) {
        return miDAO.findByTenant (_t);
    }
}
