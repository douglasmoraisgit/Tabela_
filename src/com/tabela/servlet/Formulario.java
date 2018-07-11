package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tabela.auxiliares.AuxiliarFormulario;
import com.tabela.auxiliares.ChaveAux;
import com.tabela.auxiliares.NovaChave;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

@WebServlet("/Formulario")
public class Formulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter print = response.getWriter();
		AuxiliarFormulario auxiliar = new AuxiliarFormulario();	 
	    Enumeration paramNames = request.getParameterNames();
	    List<String> listas = auxiliar.listaColunas(paramNames);
		print.println("<br/>");
		print.println(listas);
		print.println("<br/>");
	    String	esf_d= request.getParameter("odesf");
	    String	cil_d= request.getParameter("odcil");
	    String	esf_e= request.getParameter("oeesf");
	    String	cil_e= request.getParameter("oecil");
	    Double odesf = Double.parseDouble(esf_d);
	    Double odcil = Double.parseDouble(cil_d);
	    Double oeesf = Double.parseDouble(esf_e);
	    Double oecil = Double.parseDouble(cil_e);
	    print.println("ESFERICO   D: "+odesf);
		print.println("CILINDRICO D:"+odcil);
		print.println("<br/>");
		print.println("ESFERICO   E: "+oeesf);
		print.println("CILINDRICO E: "+oecil);
	    
	    print.println("<br>");
	    print.println("<H3> OLHO DIREITO: "+converteGrau(odesf,odcil)+"<H3>");
	    
	    print.println("<br>");
	    print.println("<H3> OLHO ESQUERDO: "+converteGrau(oeesf,oecil)+"<H3>");
	    
	    String olhodireito  = converteGrau(odesf,odcil);
	    String olhoesquerdo = converteGrau(oeesf,oecil);
	    Conexao con = new Conexao(); 
	    List<VisaoSimples> od;
	    List<VisaoSimples> oe;
	    
	    try {
        	
		     od  = con.getListaGrauSql(olhodireito);
		     oe  = con.getListaGrauSql(olhoesquerdo);
		     
		     
		     
		     for (VisaoSimples lente : od) {
					
					
		 		System.out.println("Olho Direito  :" + lente.getDescricao()+" Chave "+ lente.getChave());			
		 	
		     }
		     for (VisaoSimples lente : oe) {
					
					
			 	System.out.println("Olho Esquerdo :" + lente.getDescricao()+" Chave "+ lente.getChave());			
			 	
			     }
	  	     
	        } catch (SQLException e) {
		                              e.printStackTrace();
	                                 }
		
		}
	 
	    
	    
    
    public String converteGrau(Double esf,Double cil)
    {
    	if (esf > 0 && cil >0)
    	{
    		  esf = esf+cil;
    		  cil = cil*-1;
    		  NovaChave nv = new NovaChave();
  	          return nv.limite(esf, cil);
        }
    	else 
        {
    	if (esf < 0 && cil <0)
    	{
    		esf= esf+cil;
    	    cil = cil*-1;
    	    NovaChave nv = new NovaChave();
	          return nv.limite(esf, cil);
    	}else
    	{
    		 NovaChave nv = new NovaChave();
 	          return nv.limite(esf, cil);
        }
    }
    	
    }
    	
    	
    	
    	
		
 
    
    
}
	    
	    
	    
	    
	    
	    
	    

	
        
    	
	
        


