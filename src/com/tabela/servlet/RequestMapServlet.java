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
 * Servlet implementation class RequestMapServlet
 */
@WebServlet("/RequestMapServlet")
public class RequestMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/*Request parameters are extra information sent with the request. For HTTP servlets, parameters are 
	  sent as a query string or posted form data depending upon the method set in the JSP or Servlet
	  (get or post). All the field names and values in the jsp are sent as a parameters.
      We can access all the parameter names and values sent with request can be accessed using getParameterMap() in 
      the object of the class ServletRequest or HttpServletRequest . request.getParameterMap() 
      returns java.util.Map containing parameter names as keys and parameter values as map values. 
      The keys are of type String. The values are of type String array.
      The following code describes how to access the parameter names, parameter values using getParameterMap() .
      The following code is applicable wherever ServletRequest or HttpServletRequest class is passed. */
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        response.setContentType("text/html;charset=UTF-8"); 
 
        response.setHeader("Cache-Control", "no-cache"); 
 
        PrintWriter out = response.getWriter();
                try {
 
            Map<String,String[]> inputParams = null;
            inputParams = request.getParameterMap(); //// request is object of above mentioned class . in jsp it is an implict object
 
             if (inputParams != null) {
                 System.out.println("Total number of parameters: " + inputParams.size());
             Iterator<String> iter = inputParams.keySet().iterator();
              while (iter.hasNext())
                 {
              String key = (String) iter.next();  // gets the parameter  name
              String[] values = (String[]) inputParams.get(key);   // returns the value of a parameter name
 
              for (int i = 0; i < values.length; i++) {
                  System.out.println("Parameter Name="+ key + " Value=" + values[i]);
 
//...... Processing Parameters
//.......
                  out.print("Parameter Name="+ key + ", Value=" + values[i]+"</br>");
                 }
              }
             } 
 
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.close();
        }
 
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
 
}
	
	
	

