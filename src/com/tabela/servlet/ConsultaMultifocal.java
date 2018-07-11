package com.tabela.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tabela.auxiliares.Auxiliar;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class ConsultaMultifocal
 */
@WebServlet("/ConsultaMultifocal")
public class ConsultaMultifocal extends HttpServlet {
private static final long serialVersionUID = 1L;
   
	
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	    String grau = request.getParameter("grau");
		Auxiliar aux =  new Auxiliar();
	    Enumeration paramNames = request.getParameterNames();		
		List<String> listas =	aux.listaColunas(paramNames);
		String filtro = aux.MontaFiltro(listas,request);
		Conexao con = new Conexao();      			 
		List<VisaoSimples> produtos;
		Map<Integer, Object> mapa =  new HashMap<>();
		 
	        try {
	        	
		     produtos = con.getListaSql(filtro);
		     mapa.put(1, produtos);
		     mapa.put(2, grau);
	  	     request.setAttribute("produtos", mapa);
		     RequestDispatcher view = request.getRequestDispatcher("mapa.jsp");
		     view.forward(request, response);
	        } catch (SQLException e) {
		                              e.printStackTrace();
	                                 }
		
		}

}
