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
public class ScheduledPackageMenuPK implements Serializable
{
    private Integer masterMenu;
    private Integer scheduledPackage;
    private Integer date;

    @Override
    public int hashCode ()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode (this.masterMenu);
        hash = 89 * hash + Objects.hashCode (this.scheduledPackage);
        hash = 89 * hash + Objects.hashCode (this.date);
        return hash;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;
        if (getClass () != obj.getClass ())
            return false;
        
        final ScheduledPackageMenuPK that = (ScheduledPackageMenuPK) obj;
        if (!Objects.equals (this.masterMenu, that.masterMenu))
            return false;
        if (!Objects.equals (this.scheduledPackage, that.scheduledPackage))
            return false;
        if (!Objects.equals (this.date, that.date))
            return false;
        
        return true;
    }
}
