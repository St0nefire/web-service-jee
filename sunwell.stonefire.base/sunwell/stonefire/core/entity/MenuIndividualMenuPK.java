/*
 * AccessRightsPK.java
 *
 * Created on Feb 6, 2015, 1:05:55 PM
 */
package sunwell.stonefire.core.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author irfin
 */
public class MenuIndividualMenuPK implements Serializable
{
    private Integer masterMenu;
    private Integer menuIndividual;

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode (this.masterMenu);
        hash = 89 * hash + Objects.hashCode (this.menuIndividual);
        return hash;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;
        if (getClass () != obj.getClass ())
            return false;
        
        final MenuIndividualMenuPK that = (MenuIndividualMenuPK) obj;
        if (!Objects.equals (this.masterMenu, that.masterMenu))
            return false;
        if (!Objects.equals (this.menuIndividual, that.menuIndividual))
            return false;
       
        return true;
    }
}
