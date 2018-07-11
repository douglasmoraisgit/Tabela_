package com.tabela.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovoFiltro
 */
@WebServlet("/NovoFiltro")
public class NovoFiltro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovoFiltro() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
    StringBuilder sql = new StringBuilder("select * from lentes where  ");   
    Set<String> set = request.getParameterMap().keySet();   
    for (String nameParameter : set) {   
         if(nameParameter.startsWith("material")){   
             sql.append("material").append("=").append("'"+request.getParameter(nameParameter).concat("'").concat(" or  "));   
         } else if (nameParameter.startsWith("tratamento")){   
             sql.append("tratamento").append("=").append("'"+request.getParameter(nameParameter).concat("'").concat(" or  "));   
         } else if (nameParameter.startsWith("fotossensivel")){   
             sql.append("fotossensivel").append("=").append("'"+request.getParameter(nameParameter).concat("'").concat(" or  "));   
         }  else if (nameParameter.startsWith("ir")){   
             sql.append("ir").append("=").append("'"+request.getParameter(nameParameter).concat("'").concat(" or  "));   
         }  
    }   
    System.out.println(sql.toString().substring(0, (sql.toString().length()-4)).concat(" ;"));   
       
    
} 
}
