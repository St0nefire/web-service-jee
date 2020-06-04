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
import sunwell.stonefire.dao.GenericDAO;
import sunwell.stonefire.dao.MasterMenuDAO;
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GenericFacade 
{
    @Inject
    GenericDAO genericDAO;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T> T create(T _entity) {
        genericDAO.create (_entity);
        return _entity;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T> T edit(T _entity) {
        genericDAO.edit (_entity);
        return _entity;
    }
        
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T> T delete(Object _id, Class<T> _type) {
        T entity = genericDAO.findById (_id, _type);
        genericDAO.delete (entity);
        return entity;
    }
    
    public <T> T findById(Object _id, Class<T> _type) {
        return genericDAO.findById (_id, _type);
    }
    
    public <T> List<T> findAll(Class<T> _type) {
        return genericDAO.findAll (_type);
    }
    
    public void flush() {
        genericDAO.flush ();
    }
    
    public void refresh(Object _ent) {
        genericDAO.refresh(_ent);
    }
}
