package com.tabela.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tabela.auxiliares.Filtro;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class ParametersMontaFiltro
 */
@WebServlet("/ParametersMontaFiltro")
public class ParametersMontaFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public ParametersMontaFiltro() {
        super();
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String olhodireito="";
		String olhoesquerdo="";
		String grau_d;
		String grau_e;
		
		Filtro f = new Filtro();
		String opcoes = f.filtro(request);
	    grau_d = f.grau(odesf, odcil);
	    grau_e = f.grau(oeesf,oecil);
		if(opcoes.length()>1){
		olhodireito = grau_d+" AND "+opcoes;
		olhoesquerdo = grau_e+" AND "+opcoes;
		}else{
			olhodireito = grau_d;
			olhoesquerdo = grau_e;
		}
	    Conexao con = new Conexao(); 
	    List<VisaoSimples> od;
	    List<VisaoSimples> oe;
	    
	    try {
		     od  = con.getListaGrauSql(olhodireito);
	         oe  = con.getListaGrauSql(olhoesquerdo);
		     int qtditensOD = od.size();
		     System.out.println("OD "+qtditensOD);
		     int qtditensOE = oe.size();
		     System.out.println("OE "+qtditensOE);
		     if(qtditensOD > qtditensOE){
		    	 escolhido = oe;
		     }else 
		    	 escolhido = od;
		     	         
		     String json = new Gson().toJson(escolhido);

			  response.setContentType("application/json");
			  response.setCharacterEncoding("UTF-8");
			  out.println(json);
		  
	  	     
	        } catch (SQLException e) {
		                              e.printStackTrace();
	                                 }
	    }
		
	}
	

	


