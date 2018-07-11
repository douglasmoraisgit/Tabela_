package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OngetParameterNames
 */
@WebServlet("/OngetParameterNames")
public class OngetParameterNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*Explanation
	Line number 21,  we are getting input parameter values by using getParameterMap() method, which always returns Map object
	So we have all input parameter names and its values in the form of key-value pairs in the Map object, then how to iterate them ?
	We don’t have iterator() method in the Map interface so how ? In the Map interface we have entrySet() method which always returns Set object, 
	so first get that Set object [ that’s what we did at line number 22 ]
	Now iterate that Set object [ line number 23 ]
	line number 27, we are converting the Set generated value into Map.Entry<String,String[]>, means assume one row(Entry) 
	contains key = value ( little imagination will be needed here ;) )
	Finally i am printing the values, hope you can understand that logic (check the output screen too)*/
	
	
	
	
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        pw.println("SERVLET - OngetParameterNames<br/>");
        res.setContentType("text/html");
 
        Map m=req.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();
 
            while(it.hasNext()){
 
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
 
                String key             = entry.getKey();
                String[] value         = entry.getValue();
 
                pw.println("Key is "+key+"<br>");
 
                    if(value.length>1){    
                        for (int i = 0; i < value.length; i++) {
                            pw.println("<li>" + value[i].toString() + "</li><br>");
                        }
                    }else
                            pw.println("Value is "+value[0].toString()+"<br>");
 
                    pw.println("-------------------<br>");
            }
 
        pw.close();    
    }
}