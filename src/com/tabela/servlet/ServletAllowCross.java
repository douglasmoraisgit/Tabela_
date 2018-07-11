package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class ServletAllowCross
 */
@WebServlet("/ServletAllowCross")
public class ServletAllowCross extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/*
	 Java Servlet to solve Origin not allowed by Access-Control-Allow-Origin issue
Issue: XMLHttpRequest cannot load http://localhost:8080/AjaxTest/Login?userId=abc&password=abc. 
Origin null is not allowed by Access-Control-Allow-Origin.

Browsers restrict client JavaScript from directly communicate with a remote server from a
different domain. So if you try to make an AJAX request from your web page that is 
hosted on say www.domainA.com to a Service that is hosted on www.domainB.com then you will get this error. 
You can use JSON With Padding (JSONP)to get around but the best way to solve this is using CORS. 

W3C had introduced Cross-Origin Resource Sharing (CORS) as a standard solution to provide a safe, 
flexible and a recommended standard way to solve this issue. CORS is a contract between client 
AJAX call from domain A and a page hosted on domain B. 

User agents commonly apply same-origin restrictions to network requests. 
These restrictions prevent a client-side Web application running from one origin from obtaining data 
retrieved from another origin, and also limit unsafe HTTP requests that can be automatically launched 
toward destinations that differ from the running application's origin.

According to CORS specification 
A response can include an Access-Control-Allow-Origin header, with the origin of where the request originated from as the value, to allow access to the resource's contents. The user agent validates that the value and origin of where the request originated match.
User agents can discover via a preflight request whether a cross-origin resource is prepared to accept requests, using a non-simple method, from a given origin. This is again validated by the user agent.
Server-side applications are enabled to discover that an HTTP request was deemed a cross-origin request by the user agent, through the Origin header. This extension enables server-side applications to enforce limitations (e.g. returning nothing) on the cross-origin requests that they are willing to service. 
 */
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAllowCross() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //List of allowed origins
        List<String> incomingURLs = Arrays.asList(getServletContext().getInitParameter("incomingURLs").trim().split(","));

       
        // Get client's origin
        String clientOrigin = request.getHeader("origin");
       
        // Get client's IP address
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }  
       
        String userId = request.getParameter("userId").trim();
        String password = request.getParameter("password").trim();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
       
        int myIndex = incomingURLs.indexOf(clientOrigin);
        //if the client origin is found in our list then give access
        //if you don't want to check for origin and want to allow access 
        //to all incoming request then change the line to this
        //response.setHeader("Access-Control-Allow-Origin", "*");
        if(myIndex != -1){
            response.setHeader("Access-Control-Allow-Origin", clientOrigin);
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");
        }

        //just a fake login - if userId is same as password allow access
        if(userId.equalsIgnoreCase(password)){

            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", true);
            out.println(myObj.toString());

        }
        else {
           
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            out.println(myObj.toString());

        }

        out.close();

    }

}