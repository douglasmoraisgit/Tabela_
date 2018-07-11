package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tabela.auxiliares.AuxiliarFormulario;
import com.tabela.auxiliares.NovaChave;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class FormularioAjax
 */
@WebServlet("/FormularioAjax")
public class FormularioAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter print = response.getWriter();
		
		
		
		AuxiliarFormulario auxiliar = new AuxiliarFormulario();	 
	    Enumeration paramNames = request.getParameterNames();
	    List<String> listas = auxiliar.listaColunas(paramNames);
		
	    String	esf_d= request.getParameter("odesf");
	    String	cil_d= request.getParameter("odcil");
	    String	esf_e= request.getParameter("oeesf");
	    String	cil_e= request.getParameter("oecil");
	    Double odesf = Double.parseDouble(esf_d);
	    Double odcil = Double.parseDouble(cil_d);
	    Double oeesf = Double.parseDouble(esf_e);
	    Double oecil = Double.parseDouble(cil_e);
	   
	    String olhodireito  = converteGrau(odesf,odcil);
	    String olhoesquerdo = converteGrau(oeesf,oecil);
	    Conexao con = new Conexao(); 
	    List<VisaoSimples> od;
	    List<VisaoSimples> oe;
	    
	    try {
        	
		     od  = con.getListaGrauSql(olhodireito);
		     oe  = con.getListaGrauSql(olhoesquerdo);
		     
		     String json = new Gson().toJson(od);

			  response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);  
		  
	  	     
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