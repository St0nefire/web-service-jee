/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * StonefireWebService.java
 *
 * Created on Jul 17, 2017, 10:59:20 AM
 */

package sunwell.stonefire.service;


//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;
import aegwyn.core.web.model.UserSession;
import aegwyn.core.web.model.UserSessionContainer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import sunwell.stonefire.bus.GenericFacade;
import sunwell.stonefire.bus.MasterMenuFacade;
import sunwell.stonefire.bus.MenuIndividualFacade;
import sunwell.stonefire.bus.ScheduledPackageFacade;
import sunwell.stonefire.bus.UserCredFacade;
import sunwell.stonefire.dto.MasterMenuDTO;
import sunwell.stonefire.dto.MenuIndividualDTO;
import sunwell.stonefire.dto.MasterMenuListDTO;
import sunwell.stonefire.dto.MasterTagDTO;
import sunwell.stonefire.dto.MasterTagListDTO;
import sunwell.stonefire.dto.MenuIndividualListDTO;
import sunwell.stonefire.dto.ScheduledPackageDTO;
import sunwell.stonefire.dto.ScheduledPackageListDTO;
import sunwell.stonefire.dto.StandardDTO;
import sunwell.stonefire.dto.UserCredDTO;
import sunwell.stonefire.core.entity.MasterMenu;
import sunwell.stonefire.core.entity.MasterTag;
import sunwell.stonefire.core.entity.MenuIndividual;
import sunwell.stonefire.core.entity.MenuIndividualMenu;
import sunwell.stonefire.core.entity.ScheduledPackage;
import sunwell.stonefire.core.entity.ScheduledPackageMenu;
import sunwell.stonefire.core.entity.Tenant;
import sunwell.stonefire.core.entity.UserCred;

/**
 *
 * @author Benny
 */
@Stateless
@Path("")
public class MenuWebService 
{
    @EJB
    UserCredFacade userFacade;
    
//    @EJB
//    UsersFacadeREST usersFacade;
    
    @EJB
    MasterMenuFacade masterMenufacade;
    
    @EJB
    MenuIndividualFacade miFacade;
    
    @EJB
    ScheduledPackageFacade spFacade;
    
    @EJB
    GenericFacade genericFacade;
    
    @Inject
    UserSessionContainer usc;
            
//    @GET
//    @Path("/mastermenu")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getMasterMenus(@QueryParam("sessionString")String _sessionString) throws Exception
//    {
//        boolean res = validateLogin(_sessionString);
//        MasterMenuListDTO retval = new MasterMenuListDTO();
//        if(!res) {
//            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS CURRENTLY ACTIVE");
//        }
//        else {
//            List<MasterMenu> listMasterMenu = masterMenufacade.findAll ();
//            if(listMasterMenu != null) {
//                retval.setData (listMasterMenu);
//            }
//        }
//        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
//    }
    
    @GET
    @Path("/mastermenu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMasterMenus(@QueryParam("sessionString")String _sessionString,
                                   @QueryParam("tenantId")String _tenantId) throws Exception
    {
        Tenant tenant = null;
        MasterMenuListDTO retval = new MasterMenuListDTO();
        if(_tenantId != null) {
            tenant = genericFacade.findById (_tenantId, Tenant.class);
        }
        else {
            tenant = getTenant (_sessionString);
        }
        if(tenant == null) {
            retval.setErrorMessage ("ERROR, NO TENANT FOR THIS REQUEST");
        }
        else {
            List<MasterMenu> listMasterMenu = masterMenufacade.findByTenant (tenant);
            if(listMasterMenu != null) {
                retval.setData (listMasterMenu);
            }
        }
        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @POST
    @Path("/mastermenu")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response addMasterMenu(
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo, 
        @FormDataParam("sessionString") String _sessionString ) {
        
        MasterMenuDTO retval = new MasterMenuDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
            Tenant tenant = user.getTenant ();
            if(uploadedInputStream != null) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + fileDetail.getFileName();
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            MasterMenu mm = masterMenufacade.create (tenant, _name, _konten, _memo, fileDetail!= null ? fileDetail.getFileName (): null);
            retval.setData (mm);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    
    @PUT
    @Path("/mastermenu")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response editMasterMenu(
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("id") Integer _id,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo,
        @FormDataParam("active") Boolean _active,
        @FormDataParam("sessionString") String _sessionString ) {
        
        MasterMenuDTO retval = new MasterMenuDTO();
        UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
        Tenant tenant = user.getTenant ();
        if(user == null) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            if(uploadedInputStream != null ) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + fileDetail.getFileName();
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            MasterMenu mm = masterMenufacade.findById (_id);
            mm.setImage (fileDetail!= null ? fileDetail.getFileName (): mm.getImage ());
            mm.setName (_name != null ? _name : mm.getName ());
            mm.setKonten (_konten != null ? _konten : mm.getKonten ());
            mm.setMemo (_memo != null ? _memo : mm.getMemo ());
            mm.setActive (_active != null ? _active : mm.isActive ());
            mm = masterMenufacade.edit (mm);
            retval.setData (mm);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @PUT
    @Path("/mastermenu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response editMasterMenuWithJSon(MasterMenuDTO _dto ) {
        System.out.println ("EDIT WITh JSON CALLED, ACTIVE: " + _dto.isActive ());
        MasterMenuDTO retval = new MasterMenuDTO();
        if(!validateLogin (_dto.getSessionString ())) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            MasterMenu mm = masterMenufacade.findById (_dto.getId ());
            mm.setName (_dto.getName () != null ? _dto.getName () : mm.getName ());
            mm.setKonten (_dto.getKonten () != null ? _dto.getKonten () : mm.getKonten ());
            mm.setMemo (_dto.getMemo () != null ? _dto.getMemo () : mm.getMemo ());
            mm.setActive (_dto.isActive () != null ? _dto.isActive () : mm.isActive ());
            mm = masterMenufacade.edit (mm);
            retval.setData (mm);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @DELETE
    @Path("/mastermenu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response deleteMasterMenu(@QueryParam("id") Integer _id, @QueryParam("sessionString") String _sessionString) {
        
        System.out.println ("called");
        StandardDTO retval = new StandardDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            masterMenufacade.delete (_id);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
//    @GET
//    @Path("/scheduledpackage")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getScheduledPackages(@QueryParam("sessionString")String _sessionString) throws Exception
//    {
//        boolean res = validateLogin(_sessionString);
//        ScheduledPackageListDTO retval = new ScheduledPackageListDTO();
//        if(!res) {
//            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS CURRENTLY ACTIVE");
//        }
//        else {
//            List<ScheduledPackage> listScheduledPackage = genericFacade.findAll (ScheduledPackage.class);
//            if(listScheduledPackage != null) {
//                retval.setData (listScheduledPackage);
//            }
//        }
//        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
//    }
    
    @GET
    @Path("/scheduledpackage")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScheduledPackages(@QueryParam("sessionString")String _sessionString,
                                         @QueryParam("tenantId")String _tenantId) throws Exception
    {
        Tenant tenant = null;
        ScheduledPackageListDTO retval = new ScheduledPackageListDTO();
        if(_tenantId != null) {
            tenant = genericFacade.findById (_tenantId, Tenant.class);
        }
        else if(_sessionString != null) {
            tenant = getTenant (_sessionString);
        }
        
        if(tenant == null) {
            retval.setErrorMessage ("ERROR, NO TENANT FOUND FOR CURRENT REQUEST");
        }
        else {
            List<ScheduledPackage> listScheduledPackage = spFacade.findByTenant (tenant);
            if(listScheduledPackage != null) {
                retval.setData (listScheduledPackage);
            }
        }
        ResponseBuilder rp;
        if(retval.getErrorMessage () == null)
            rp = Response.ok();
        else
            rp = Response.serverError();
        
        return rp.entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
        
    @POST
    @Path("/scheduledpackage")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response addScheduledPackage(
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo,
        @FormDataParam("price") Double _price,
        @FormDataParam("minOrder") Integer _minOrder,
        @FormDataParam("tags") String _tags,
        @FormDataParam("menus") String _menus,
        @FormDataParam("sessionString") String _sessionString ) {
                
        ScheduledPackageDTO retval = new ScheduledPackageDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
            Tenant tenant = user.getTenant ();
            String imageName = fileDetail != null ? fileDetail.getFileName() : null;
            if(uploadedInputStream != null) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + fileDetail.getFileName();
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            ScheduledPackage sp = new ScheduledPackage (tenant, _name, _konten, _memo, _price, _minOrder, true, imageName != null ? imageName : "");
            if(_tags != null && _tags.length () > 0) {
                String[] tagNames = _tags.split (";");
                List<MasterTag> listMasterTags = genericFacade.findAll (MasterTag.class);
                List<MasterTag> listScheduledPackageTags = new LinkedList<>();
                if(listMasterTags != null) {
                    for (String tagName : Arrays.asList (tagNames)) {
                        for (MasterTag mt : listMasterTags) {
                            if(tagName.trim ().toLowerCase ().equals (mt.getName ().trim ().toLowerCase ())) {
                                listScheduledPackageTags.add (mt);
                            }
                        }
                    }
                    sp.setTags (listScheduledPackageTags);
                }
            }
            
            if(_menus != null && _menus.length () > 0) {
                List<ScheduledPackageMenu> menus = new LinkedList<>();
                String[] stringMenus = _menus.split (";");
                for (String stringMenu : stringMenus) {
                    ScheduledPackageMenu menu = new ScheduledPackageMenu ();
                    String[] menuInfo = stringMenu.split ("_");
                    MasterMenu mm = genericFacade.findById (Integer.valueOf (menuInfo[0]), MasterMenu.class);
                    menu.setMasterMenu (mm);
                    menu.setDate (Integer.valueOf (menuInfo[1]));
                    menu.setCreatedAt (new Date ());
                    menu.setScheduledPackage (sp);
                    menus.add (menu);
                }
                sp.setMenus (menus);
            }
            
            sp = genericFacade.create (sp);
            retval.setData (sp);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @PUT
    @Path("/scheduledpackage")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response editScheduledPackage(
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("id") Integer _id,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo,
        @FormDataParam("price") Double _price,
        @FormDataParam("minOrder") Integer _minOrder,
        @FormDataParam("available") Boolean available,
        @FormDataParam("tags") String _tags,
        @FormDataParam("menus") String _menus,
        @FormDataParam("sessionString") String _sessionString ) {
                
        ScheduledPackageDTO retval = new ScheduledPackageDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
            Tenant tenant = user.getTenant ();
            if(uploadedInputStream != null ) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + fileDetail.getFileName();
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            ScheduledPackage sp = genericFacade.findById (_id, ScheduledPackage.class);
            sp.setImage (fileDetail!= null ? fileDetail.getFileName (): sp.getImage ());
            sp.setName (_name != null ? _name : sp.getName ());
            sp.setKonten (_konten != null ? _konten : sp.getKonten ());
            sp.setMemo (_memo != null ? _memo : sp.getMemo ());
            sp.setPrice (_price != null ? _price : sp.getPrice ());
            sp.setMinOrder (_minOrder != null ? _minOrder : sp.getMinOrder ());
            sp.setAvailable (available != null ? available : sp.isAvailable ());
            if(_tags != null && _tags.length () > 0) {
                String[] tagNames = _tags.split (";");
                List<MasterTag> listMasterTags = genericFacade.findAll (MasterTag.class);
                List<MasterTag> listScheduledPackageTags = new LinkedList<>();
                if(listMasterTags != null) {
                    for (String tagName : Arrays.asList (tagNames)) {
                        for (MasterTag mt : listMasterTags) {
                            if(tagName.trim ().toLowerCase ().equals (mt.getName ().trim ().toLowerCase ())) {
                                listScheduledPackageTags.add (mt);
                            }
                        }
                    }
                    sp.setTags (listScheduledPackageTags);
                }
            }
            
            sp.setMenus (null);
            genericFacade.flush ();
            
            if(_menus != null && _menus.length () > 0) {
                List<ScheduledPackageMenu> menus = new LinkedList<>();
                String[] stringMenus = _menus.split (";");
                for (String stringMenu : stringMenus) {
                    ScheduledPackageMenu menu = new ScheduledPackageMenu ();
                    String[] menuInfo = stringMenu.split ("_");
                    MasterMenu mm = genericFacade.findById (Integer.valueOf (menuInfo[0]), MasterMenu.class);
                    menu.setMasterMenu (mm);
                    menu.setDate (Integer.valueOf (menuInfo[1]));
                    menu.setCreatedAt (new Date ());
                    menu.setScheduledPackage (sp);
                    menus.add (menu);
                }
                sp.setMenus (menus);
            }
            
            sp = genericFacade.edit (sp);
            retval.setData (sp);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @DELETE
    @Path("/scheduledpackage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response deleteScheduledPackage(@QueryParam("id") Integer _id, @QueryParam("sessionString") String _sessionString) {
        StandardDTO retval = new StandardDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            genericFacade.delete (_id, ScheduledPackage.class);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
//    @GET
//    @Path("/menuindividual")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getMenuIndividual(@QueryParam("sessionString")String _sessionString) throws Exception
//    {
//        boolean res = validateLogin(_sessionString);
//        MenuIndividualListDTO retval = new MenuIndividualListDTO();
//        if(!res) {
//            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS CURRENTLY ACTIVE");
//        }
//        else {
//            List<MenuIndividual> listMenuIndividual = genericFacade.findAll (MenuIndividual.class);
//            if(listMenuIndividual != null) {
//                retval.setData (listMenuIndividual);
//            }
//        }
//        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
//    }
    
    @GET
    @Path("/menuindividual")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuIndividual(@QueryParam("sessionString")String _sessionString,
                                      @QueryParam("tenantId")String _tenantId) throws Exception
    {
        Tenant tenant = null;
        MenuIndividualListDTO retval = new MenuIndividualListDTO();
        
        if(_tenantId != null) {
            tenant = genericFacade.findById (_tenantId, Tenant.class);
        }
        else if(_sessionString != null) {
            tenant = getTenant (_sessionString);
        }
        if(tenant == null) {
            retval.setErrorMessage ("ERROR, NO TENANT FOUND FOR CURRENT REQUEST");
        }
        else {
            List<MenuIndividual> listMenuIndividual = miFacade.findByTenant (tenant);
            if(listMenuIndividual != null) {
                retval.setData (listMenuIndividual);
            }
        }
        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
        
    @POST
    @Path("/menuindividual")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response addMenuIndividual(
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo,
        @FormDataParam("price") Double _price,
        @FormDataParam("tags") String _tags,
        @FormDataParam("menus") String _menus,
        @FormDataParam("sessionString") String _sessionString ) {
                
        MenuIndividualDTO retval = new MenuIndividualDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
            Tenant tenant = user.getTenant ();
            String imageName = fileDetail != null ? fileDetail.getFileName() : null;
            if(uploadedInputStream != null) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + imageName;
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            MenuIndividual mi = new MenuIndividual (tenant, _name, _konten, _memo, _price, imageName);
            if(_tags != null && _tags.length () > 0) {
                String[] tagNames = _tags.split (";");
                List<MasterTag> listMasterTags = genericFacade.findAll (MasterTag.class);
                List<MasterTag> listMenuIndividualTags = new LinkedList<>();
                if(listMasterTags != null) {
                    for (String tagName : Arrays.asList (tagNames)) {
                        for (MasterTag mt : listMasterTags) {
                            if(tagName.trim ().toLowerCase ().equals (mt.getName ().trim ().toLowerCase ())) {
                                listMenuIndividualTags.add (mt);
                            }
                        }
                    }
                    mi.setTags (listMenuIndividualTags);
                }
            }
            
            if(_menus != null && _menus.length () > 0) {
                List<MenuIndividualMenu> menus = new LinkedList<>();
                String[] stringMenus = _menus.split (";");
                for (String stringMenu : stringMenus) {
                    MenuIndividualMenu menu = new MenuIndividualMenu ();
                    MasterMenu mm = genericFacade.findById (Integer.valueOf (stringMenu), MasterMenu.class);
                    menu.setMasterMenu (mm);
                    menu.setCreatedAt (new Date ());
                    menu.setMenuIndividual (mi);
                    menus.add (menu);
                }
                mi.setMenus (menus);
            }
            
            mi = genericFacade.create (mi);
            retval.setData (mi);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @PUT
    @Path("/menuindividual")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response editMenuIndividual( 
        @FormDataParam("uploadFile") InputStream uploadedInputStream,
        @FormDataParam("uploadFile") FormDataContentDisposition fileDetail,
        @FormDataParam("id") Integer _id,
        @FormDataParam("name") String _name,
        @FormDataParam("konten") String _konten,
        @FormDataParam("memo") String _memo,
        @FormDataParam("price") Double _price,
        @FormDataParam("available") Boolean available,
        @FormDataParam("tags") String _tags,
        @FormDataParam("menus") String _menus,
        @FormDataParam("sessionString") String _sessionString ) {
                
        MenuIndividualDTO retval = new MenuIndividualDTO();
        UserCred user = getUser (_sessionString);
        Tenant tenant = user.getTenant ();
        if(user == null) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
//            UserCred user = (UserCred)usc.getSession (_sessionString, false).getObject ("user");
            if(uploadedInputStream != null ) {
                String uploadedFileLocation = "/Users/sunwell/Documents/upload-example/" + tenant.getId () + "/" + fileDetail.getFileName();
                File dir = new File("/Users/sunwell/Documents/upload-example/" + tenant.getId ());
                if(!dir.exists ()) {
                    dir.mkdir ();
                }
                writeToFile(uploadedInputStream, uploadedFileLocation);
            }
            MenuIndividual mi = genericFacade.findById (_id, MenuIndividual.class);
            mi.setImage (fileDetail!= null ? fileDetail.getFileName (): mi.getImage ());
            mi.setName (_name != null ? _name : mi.getName ());
            mi.setKonten (_konten != null ? _konten : mi.getKonten ());
            mi.setMemo (_memo != null ? _memo : mi.getMemo ());
            mi.setPrice (_price != null ? _price : mi.getPrice ());
            mi.setAvailable (available != null ? available : mi.isAvailable ());
            if(_tags != null && _tags.length () > 0) {
                String[] tagNames = _tags.split (";");
                List<MasterTag> listMasterTags = genericFacade.findAll (MasterTag.class);
                List<MasterTag> listMenuIndividualTags = new LinkedList<>();
                if(listMasterTags != null) {
                    for (String tagName : Arrays.asList (tagNames)) {
                        for (MasterTag mt : listMasterTags) {
                            if(tagName.trim ().toLowerCase ().equals (mt.getName ().trim ().toLowerCase ())) {
                                listMenuIndividualTags.add (mt);
                            }
                        }
                    }
                    mi.setTags (listMenuIndividualTags);
                }
            }
            
            mi.setMenus (null);
            this.genericFacade.flush ();
            
            if(_menus != null && _menus.length () > 0) {
                List<MenuIndividualMenu> menus = new LinkedList<>();
                String[] stringMenus = _menus.split (";");
                for (String stringMenu : stringMenus) {
                    MenuIndividualMenu menu = new MenuIndividualMenu ();
                    MasterMenu mm = genericFacade.findById (Integer.valueOf (stringMenu), MasterMenu.class);
                    menu.setMasterMenu (mm);
                    menu.setCreatedAt (new Date ());
                    menu.setMenuIndividual (mi);
                    menus.add (menu);
                }
                mi.setMenus (menus);
            }
            
            mi = genericFacade.edit (mi);
            retval.setData (mi);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
    
    @DELETE
    @Path("/menuindividual")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response deleteMenuIndividual(@QueryParam("id") Integer _id, @QueryParam("sessionString") String _sessionString) {
                
        StandardDTO retval = new StandardDTO();
        if(!validateLogin (_sessionString)) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS ACTIVE");
        }
        else {
            genericFacade.delete (_id, MenuIndividual.class);
        }

        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
        
    
    
    @GET
    @Path("/tags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTags(@QueryParam("sessionString")String _sessionString) throws Exception
    {
        System.out.println ("GET TAGS CALLED");
        boolean res = validateLogin(_sessionString);
        MasterTagListDTO retval = new MasterTagListDTO();
        if(!res) {
            retval.setErrorMessage ("ERROR, NO LOGIN SESSION IS CURRENTLY ACTIVE");
        }
        else {
            List<MasterTag> listT = genericFacade.findAll (MasterTag.class);
            System.out.println ("LIST LENGTH: " + listT.size ());
            if(listT != null) {
                retval.setData (listT);
            }
        }
        return Response.ok ().entity (retval).type (MediaType.APPLICATION_JSON).build ();
    }
 
    private void writeToFile(InputStream uploadedInputStream,
        String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(
                            uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private boolean validateLogin(String _sessionString) {
        return getUser (_sessionString) != null ? true : false;
    }
    
    private UserCred getUser(String _sessionString) {
        UserSession session = usc.getSession (_sessionString, false);
        if(session == null)
            return null;
        
        UserCred usr = (UserCred)session.getObject ("user");
        return usr;
    }
    
    private Tenant getTenant(String _sessionString) {
        UserCred user = getUser (_sessionString);
        if(user == null)
            return null;
        
        return user.getTenant ();
    }
}
