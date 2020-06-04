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
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MasterMenuFacade 
{
    @Inject
    MasterMenuDAO mmDAO;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public MasterMenu create(Tenant _t, String _name, String _detail, String _memo, String _imageURL) {
        MasterMenu mm = new MasterMenu ();
        mm.setName (_name);
        mm.setKonten (_detail);
        mm.setMemo (_memo);
        mm.setImage (_imageURL);
        mm.setActive (true);
        mm.setCreatedAt (new Date());
        mm.setTenant (_t);
        mmDAO.create (mm);
        return mm;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public MasterMenu create(MasterMenu _mm) {
        mmDAO.create (_mm);
        return _mm;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public MasterMenu edit(Tenant _t, Integer _id, String _name, String _detail, String _memo, String _imageURL) {
        MasterMenu mm = mmDAO.findById (_id);
        mm.setName (_name);
        mm.setKonten (_detail);
        mm.setMemo (_memo);
        mm.setImage (_imageURL);
        mm.setUpdatedAt (new Date());
        mm.setTenant (_t);
        mmDAO.edit (mm);
        return mm;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public MasterMenu edit(MasterMenu _mm) {
        mmDAO.edit (_mm);
        return _mm;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public MasterMenu delete(Integer _id) {
        MasterMenu mm = mmDAO.findById (_id);
        mmDAO.delete (mm);
        return mm;
    }
    
    public MasterMenu findById(int _id) {
        return mmDAO.findById (_id);
    }
    
    public List<MasterMenu> findAll() {
        return mmDAO.findAll ();
    }
    
    public List<MasterMenu> findByTenant(Tenant _t) {
        return mmDAO.findByTenant (_t);
    }
}
