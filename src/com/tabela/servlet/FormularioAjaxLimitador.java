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
import com.tabela.auxiliares.ConverteLimita;
import com.tabela.auxiliares.NovaChave;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class FormularioAjaxLimitador
 */
@WebServlet("/FormularioAjaxLimitador")
public class FormularioAjaxLimitador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		List<VisaoSimples> escolhido;	
	    String	esf_d= request.getParameter("odesf");
	    String	cil_d= request.getParameter("odcil");
	    String	esf_e= request.getParameter("oeesf");
	    String	cil_e= request.getParameter("oecil");
	    Double odesf = Double.parseDouble(esf_d);
	    Double odcil = Double.parseDouble(cil_d);
	    Double oeesf = Double.parseDouble(esf_e);
	    Double oecil = Double.parseDouble(cil_e);
	   
	    String olhodireito  = new ConverteLimita().converteGrau(odesf,odcil);
	    String olhoesquerdo = new ConverteLimita().converteGrau(oeesf,oecil);
	    Conexao con = new Conexao(); 
	    List<VisaoSimples> od;
	    List<VisaoSimples> oe;
	    
	    try {
        	
		     od  = con.getListaGrauSql(olhodireito);
	         oe  = con.getListaGrauSql(olhoesquerdo);
		     int qtditensOD = od.size();
		     int qtditensOE = oe.size();
		     System.out.println("OD "+qtditensOD);
		     System.out.println("OE "+qtditensOE);
		    
		     
		     
		     if(qtditensOD > qtditensOE){
		    	 escolhido = oe;
		     }else 
		    	 escolhido = od;
		     
	         
	         
		     String json = new Gson().toJson(escolhido);

			  response.setContentType("application/json");
			  response.setCharacterEncoding("UTF-8");
			 // response.getWriter().write(json);  
			  out.println(json);
		  
	  	     
	        } catch (SQLException e) {
		                              e.printStackTrace();
	                                 }
		
		}
	 
	    
	    
    
   
    	
    	
		
 
    
    
}