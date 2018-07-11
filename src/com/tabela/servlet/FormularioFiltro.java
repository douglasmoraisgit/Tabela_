package com.tabela.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tabela.auxiliares.MontaFiltro;

/**
 * Servlet implementation class FormularioFiltro
 */
@WebServlet("/FormularioFiltro")
public class FormularioFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioFiltro() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MontaFiltro mf = new MontaFiltro();
		String retorno = mf.filtro(request);
		
		System.out.println(retorno);
	}

	
}
