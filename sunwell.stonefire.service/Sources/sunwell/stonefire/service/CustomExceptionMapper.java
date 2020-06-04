/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * CustomExceptionMapper.java
 *
 * Created on Jul 17, 2017, 11:23:49 AM
 */

package sunwell.stonefire.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import sunwell.stonefire.dto.StandardDTO;

/**
 *
 * @author Benny
 */
@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        StandardDTO retval = new StandardDTO();
        System.out.println ("CE CALLED");
        System.out.println (e.getMessage ());
        e.printStackTrace();
        return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .header ("Access-Control-Allow-Origin", "*")
//                    .entity(e.getCause())
                    .entity (retval)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
    }
}

// why does the code above return this response ?
//<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
//<html xmlns="http://www.w3.org/1999/xhtml">
//    <head>
//        <title>GlassFish Server Open Source Edition  4.1  - Error report</title>
//        <style type="text/css">
//        <!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} 
//            H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} 
//            H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} 
//            BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} 
//            B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} 
//            P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}HR {color : #525D76;}-->
//        </style> </head>
//    <body> 
//        <h1>HTTP Status 500 - Internal Server Error</h1><hr/>
//            <p>
//                <b>type</b> 
//                Status report
//            </p>
//            <p>
//                <b>message</b>
//                Internal Server Error
//            </p>
//            <p>
//                <b>description</b>
//                The server encountered an internal error that prevented it from fulfilling this request.
//            </p>
//            <hr/>
//            <h3>GlassFish Server Open Source Edition  4.1 </h3>
//    </body>
//</html>