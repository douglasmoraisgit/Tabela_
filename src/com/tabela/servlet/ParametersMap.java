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

import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 * Servlet implementation class ParametersMap
 */
@WebServlet("/ParametersMap")
public class ParametersMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StringBuilder      Sql = new StringBuilder();
    StringBuilder material = new StringBuilder();
    StringBuilder tratamento = new StringBuilder();
    StringBuilder fotossensivel= new StringBuilder();
    StringBuilder indice = new StringBuilder();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParametersMap() {
        super();
        // TODO Auto-generated constructor stub
    }
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
 
                
                
                
                    if(value.length>1){    
                        for (int i = 0; i < value.length; i++) {
                        	if (key.startsWith("material")){ 
                        	material.append(key+ "=" + "'"+value[i].toString()+ "' or ");
                        	} 
                        	if (key.startsWith("tratamento")){ 
                            tratamento.append(key+ " = " + value[i].toString()+ " or ");
                            }
                        	if (key.startsWith("fotossensivel")){ 
                            fotossensivel.append(key+ " = " + value[i].toString()+ " or ");
                            }
                        	if (key.startsWith("ir")){ 
                            indice.append(key+ " = " + value[i].toString()+ " or ");
                            }
                        }
                    }else { System.out.println("nenhuma selecao");}
                  }
                        
            	material.insert(0,"(");
            	material.substring(0, material.length()-1);   
            	System.out.println("1 "+material.toString());
            	tratamento.insert(0,"(");
                fotossensivel.insert(0,"(");
                indice.insert(0,"(");
            
                
             //   System.out.println(Sqlstring(material, tratamento, fotossensivel, indice));
          
             //   System.out.println(material.toString()+"  "+material.length());
             //   System.out.println(tratamento.length());
             //   System.out.println(fotossensivel.length());
             //   System.out.println(indice.length());
                
              
                
            //   String mat =  material.toString().substring(0, (material.toString().length()-4)).concat(") AND ");
            //   String tra =  tratamento.toString().substring(0, (tratamento.toString().length()-4)).concat(") AND ");
            //   String fot =  fotossensivel.toString().substring(0, (fotossensivel.toString().length()-4)).concat(") AND ");
            //   String ind =  indice.toString().substring(0, (indice.toString().length()-4)).concat(") AND ");
               
            //  System.out.println(Sqlstring(mat, tra, fot, ind));
                
                
	    // System.out.println(material.toString().substring(0, (material.toString().length()-4)).concat(") AND"));
        //  System.out.println(tratamento.toString().substring(0, (tratamento.toString().length()-4)).concat(")")); 
        //  System.out.println(fotossensivel.toString().substring(0, (fotossensivel.toString().length()-4)).concat(")")); 
        //  System.out.println(indice.toString().substring(0, (indice.toString().length()-4)).concat(")")); 
			//System.out.println(Sql.toString().substring(0, (Sql.toString().length()-4)).concat(" )"));
			
            
    }
    
    public String Sqlstring( StringBuilder material, StringBuilder tratamento, StringBuilder fotossensivel, StringBuilder indice  ) {
  	  if (material.length() > 1){
  		  material.toString().concat(") AND ");
  		  //material.toString().substring(0, (material.toString().length()-2)).concat(") AND ");
  		int letras = material.length();
  		System.out.println("Letras " +letras+" "+material);
  		
  		  Sql.append(material);
  	
  	  }
  	  if (tratamento.length()>1) {
  		tratamento.substring(0, tratamento.toString().length()-2).concat(") AND ");
  		 // tratamento.toString().substring(0, (tratamento.toString().length()-2)).concat(") AND ");
  		int letras = tratamento.length();
  		System.out.println("Letras " +letras+" "+tratamento);
  		  Sql.append(tratamento);
   	  }
  	  if (fotossensivel.length()>1) {
  		fotossensivel.substring(0, fotossensivel.toString().length()-2).concat(") AND ");
  		  //  fotossensivel.toString().substring(0, (fotossensivel.toString().length()-2)).concat(") AND ");
  		int letras = fotossensivel.length();
  		System.out.println("Letras " + letras+" "+fotossensivel);
  		  Sql.append(fotossensivel);
  	  }
  	  if (indice.length()>1){
  		indice.substring(0, indice.toString().length()-2).concat(") AND ");
  		// indice.toString().substring(0, (indice.toString().length()-2)).concat(") AND ");
  		int letras = indice.length();
  		System.out.println("Letras "+letras+" "+indice);
  		  Sql.append(indice);
  	  }
  	  System.out.println("SQL "+ Sql.length());
  	  String retorno = Sql.substring(0,Sql.length()-3).concat(")");
  	//  return Sql.toString().substring(0, (Sql.toString().length()-3)).concat(")");
  	  return retorno;
    } 
	
}
