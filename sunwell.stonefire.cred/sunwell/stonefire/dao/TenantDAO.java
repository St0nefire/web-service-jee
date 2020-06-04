/**
 * UserCredDAO.java
 *
 * Created on Jul 17, 2017, 2:02:16 PM
 */

package sunwell.stonefire.dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class TenantDAO implements Serializable
{
    @PersistenceContext
    EntityManager em;
        
    public List<Tenant> findByProvinceAndCity(String _province, String _city) {
        TypedQuery<Tenant> query ;
        
        if(_province != null && _city != null) {
           query = em.createNamedQuery ("Tenant.findByProvinceAndCity", Tenant.class);
           query.setParameter ("province", _province);
           query.setParameter ("city", _city);
        }
        else if(_province != null) {
           query = em.createNamedQuery ("Tenant.findByProvince", Tenant.class);
           query.setParameter ("province", _province);
        }
        else if(_city != null) {
           query = em.createNamedQuery ("Tenant.findByCity", Tenant.class);
           query.setParameter ("city", _city);
        }
        else {
           query = em.createNamedQuery ("Tenant.findAll", Tenant.class);
        }
        
        
        List<Tenant> resultList = query.getResultList ();
        return resultList;
    }
    
    public Tenant edit(Tenant _t) {
        em.merge (_t);
        em.flush ();
        return _t;
    }
}
