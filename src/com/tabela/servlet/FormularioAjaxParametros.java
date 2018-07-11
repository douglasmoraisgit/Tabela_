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
 * Servlet implementation class FormularioAjaxParametros
 */
@WebServlet("/FormularioAjaxParametros")
public class FormularioAjaxParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        
        res.setContentType("text/html");
 
        Map m=req.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();
        StringBuilder sql = new StringBuilder("select * from visao_simples where  ");  
            while(it.hasNext()){
 
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
 
                String   coluna  = entry.getKey();
                String[] valor   = entry.getValue();
                
               
                
                if(valor.length>1){    
                                   for (int i = 0; i < valor.length; i++) {                        	
                        	        sql.append(coluna).append("=").append("'"+valor[i]+"'").append(" or ");      
                        	        System.out.println(sql);
                                          }                      
                                   }
                                   else {              	
                        	 
                        	            Double odesf = Double.parseDouble(valor[0]);
                        	            //System.out.println("Olho direito : Esferico :"+odesf+ "  Cilindrico :");
                        	
                                     	sql.append((coluna+" = "+ Double.parseDouble(valor[0])+" and "));
                                     	 System.out.println(sql);
                        	            } 
                }   
            pw.println(sql.toString().substring(0, (sql.toString().length()-4)).concat(" ;"));   
    }
}