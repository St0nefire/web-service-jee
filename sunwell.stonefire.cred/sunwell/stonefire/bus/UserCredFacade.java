/**
 * UserCredFacade.java
 *
 * Created on Jul 17, 2017, 4:24:35 PM
 */

package sunwell.stonefire.bus;

import aegwyn.core.web.util.Util;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import sunwell.stonefire.dao.UserCredDAO;
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;
import sunwell.stonefire.core.entity.UserType;

/**
 *
 * @author Benny
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserCredFacade 
{
    /**
     * <pre>
     * Mengembalikan nilai integer sbb:
     * 0 = login gagal (wrong username and/or passwd)
     * 1 = login berhasil
     * 2 = account suspended
     * </pre>
     * 
     * @param _username
     * @param _passwd
     * @return 
     */
    
    @Inject
    UserCredDAO userCredDAO;
        
    public UserCred validate (String _email, String _password) throws Exception
    {
        try {
            UserCred usr = userCredDAO.findByEmail (_email);

            if (usr != null) {
                // Hitung MD5 dari password masukan user.
                String passDariUser = Util.generateMD5 (_password);

                System.out.println ("$$$$$$$$$$$$$$$$$$$$$$ hasil MD5 oleh java = " + passDariUser);
                System.out.println ("$$$$$$$$$$$$$$$$$$$$$$ passwd di DB = " + usr.getPassword ());

                // Periksa password
                if (!passDariUser.equals (usr.getPassword ())) 
                    usr = null;
            }
            return usr;
        }
        catch (NoResultException ex) {
            ex.printStackTrace ();
            return null;
        }
    }
    
    public List<UserCred> findByTenant(Tenant _t) {
        return userCredDAO.findByTenant (_t);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(UserCred _usr, UserType _ut) {
        userCredDAO.create (_usr, _ut);
    }
}
