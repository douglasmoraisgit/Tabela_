package com.tabela.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tabela.beans.TabelaMultifocal;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class Multifocal
 */
@WebServlet("/Multifocal")
public class Multifocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	String sql = request.getParameter("sql");
     	
     	Conexao con = new Conexao();      			 
		List<TabelaMultifocal> produtos;
	    try {
		     produtos = con.getListaTabela(sql);
		     request.setAttribute("produtos", produtos);
		     RequestDispatcher view = request.getRequestDispatcher("resposta_tabela_multifocal.jsp");
		     view.forward(request, response);
	         } 
	    catch (SQLException e) { e.printStackTrace(); }
      

}
}
