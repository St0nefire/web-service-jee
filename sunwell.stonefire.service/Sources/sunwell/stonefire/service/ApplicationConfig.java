/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * ApplicationConfig.java
 *
 * Created on Jul 17, 2017, 10:54:59 AM
 */

package sunwell.stonefire.service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author Benny
 */
@javax.ws.rs.ApplicationPath("resource") 
public class ApplicationConfig extends Application 
{

    @Override
    public Set<Class<?>> getClasses ()
    {
        Set<Class<?>> resources = new java.util.HashSet<> ();
        addRestResourceClasses (resources);
        resources.add (MultiPartFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses (Set<Class<?>> resources)
    {
        resources.add (sunwell.stonefire.service.CrossOriginResourceSharingFilter.class);
        resources.add (sunwell.stonefire.service.CustomExceptionMapper.class);
        resources.add (sunwell.stonefire.service.MenuWebService.class);
        resources.add (sunwell.stonefire.service.StonefireWebService.class);
    }
}

//resources.add (MultiPartFeature.class);
//resources.add (LoggingFilter.class);
