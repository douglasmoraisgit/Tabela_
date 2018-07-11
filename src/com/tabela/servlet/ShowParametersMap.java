package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersMap
 */
@WebServlet("/ShowParametersMap")
public class ShowParametersMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	  {
		
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("ShowParametersMap<br/>");
	    Map  map  = request.getParameterMap();
	    //entrySet returns Set interface.
	    Iterator iter = map.entrySet().iterator();
	      while ( iter.hasNext() ) 
	      {
	        Map.Entry entry  = (Map.Entry)iter.next() ;
	        String    name   = (String)entry.getKey() ;
	        String[]  values = (String[])entry.getValue();
	        out.println("Name:   "+name+"<br/>");
	        for ( int i = 0 ; i < values.length ; ++i )
	        {
	             out.println("Values["+i+"]:"+values[i]+"<br/>");
	        }
	        out.println("<br/>");
	      }
	     }
	
	
}
