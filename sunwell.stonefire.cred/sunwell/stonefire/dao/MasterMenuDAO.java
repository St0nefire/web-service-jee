/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * MasterMenuDAO.java
 *
 * Created on Jul 21, 2017, 1:16:44 PM
 */

package sunwell.stonefire.dao;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Dependent
public class MasterMenuDAO 
{
    @PersistenceContext
    EntityManager em;
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void create (MasterMenu _mm)
    {
        em.persist (_mm);
        em.flush ();
        em.refresh (_mm);
        System.out.println ("ID MM: " + _mm.getId ());
    }
    
    public MasterMenu findById(Integer _id) {
        return em.find (MasterMenu.class, _id);
    }
    
    public MasterMenu edit(MasterMenu _mm) {
        em.merge (_mm);
        em.flush ();
        return _mm;
    }
    
    public MasterMenu delete(MasterMenu _mm) {
        em.merge (_mm);
        em.remove (_mm);
        em.flush ();
        return _mm;
    }
        
    public List<MasterMenu> findAll() {
        TypedQuery<MasterMenu> query = em.createNamedQuery ("MasterMenu.findAll", MasterMenu.class);
        List<MasterMenu> resultList = query.getResultList ();
        if(resultList.size () > 0)
            return resultList;
        else
            return null;
    }
    
    public List<MasterMenu> findByTenant(Tenant _t) {
        TypedQuery<MasterMenu> query = em.createNamedQuery ("MasterMenu.findByTenant", MasterMenu.class).setParameter ("tenant", _t);
        List<MasterMenu> resultList = query.getResultList ();
        if(resultList.size () > 0)
            return resultList;
        else
            return null;
    }
}
