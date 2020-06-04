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
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Dependent
public class UserCredDAO implements Serializable
{
    @PersistenceContext
    EntityManager em;
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void create (UserCred _uc, UserType _ut)
    {
        _uc.setUserType (_ut);
        em.persist (_uc);
    }
        
    public UserCred findByEmail(String _email) {
        TypedQuery<UserCred> query = em.createNamedQuery ("UserCred.findByEmail", UserCred.class);
        query.setParameter ("email", _email);
        List<UserCred> resultList = query.getResultList ();
        if(resultList != null && resultList.size () > 0) 
            return resultList.get (0);
        
        return null;
    }
    
    public List<UserCred> findByTenant(Tenant _t) {
        TypedQuery<UserCred> query = em.createNamedQuery ("UserCred.findByTenant", UserCred.class);
        query.setParameter ("tenant", _t);
        List<UserCred> resultList = query.getResultList ();
        return resultList;
    }
}
