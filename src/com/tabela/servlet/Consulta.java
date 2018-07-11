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

import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */

    
        // TODO Auto-generated constructor stub
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	String chave = request.getParameter("sql");
        	
        	if( chave.length()>10){
   			 String esf = ""+chave.charAt(0)+chave.charAt(1)+chave.charAt(2)+chave.charAt(3)+chave.charAt(5);
   			 String cil = ""+chave.charAt(6)+chave.charAt(7)+chave.charAt(8)+chave.charAt(9)+chave.charAt(10);
   			 Double grau_esferico = Double.parseDouble(esf);
   			 Double grau_cilindrico = Double.parseDouble(cil);
   			   			 if(grau_cilindrico >0){
   				         double Transp_esf = grau_cilindrico+grau_esferico;
   				         double Trans_cil = grau_cilindrico*-1;
   				         grau_esferico= Transp_esf;
   				         grau_cilindrico = Trans_cil;
   				         Conexao con = new Conexao();      			 
   	   			         List<VisaoSimples> pr;
   				         try {
   					     pr = con.getListaGrau(grau_esferico, grau_cilindrico);
   					     request.setAttribute("produtos", pr);
   					     RequestDispatcher view = request.getRequestDispatcher("visao_simples.jsp");
   					     view.forward(request, response);
   				         } catch (SQLException e) {
   					                              e.printStackTrace();
   				                                  }
   			             }else {			 
   			             Conexao con = new Conexao();
   			             List<VisaoSimples> pr;
			             try {
				         pr = con.getListaGrau(grau_esferico, grau_cilindrico);
				         request.setAttribute("produtos", pr);
				         RequestDispatcher view = request.getRequestDispatcher("visao_simples.jsp");
   					     view.forward(request, response);
			             } catch (SQLException e) {
			                        		      e.printStackTrace();
			                                      }  			 
   	    	             }
   			   			 
        	}else{
   	         String esf = ""+chave.charAt(0)+chave.charAt(1)+chave.charAt(2)+chave.charAt(3)+chave.charAt(4);
   	         String cil = ""+chave.charAt(5)+chave.charAt(6)+chave.charAt(7)+chave.charAt(8)+chave.charAt(9);
   	         Double grau_esferico = Double.parseDouble(esf);
			 Double grau_cilindrico = Double.parseDouble(cil);
			             if(grau_cilindrico >0){
			             double Transp_esf = grau_cilindrico+grau_esferico;
			             double Trans_cil = grau_cilindrico*-1;
			             grau_esferico= Transp_esf;
			             grau_cilindrico = Trans_cil;
			             Conexao con = new Conexao();      			 
  			             List<VisaoSimples> pr;
			             try {
			     	     pr = con.getListaGrau(grau_esferico, grau_cilindrico);
				         request.setAttribute("produtos", pr);
				         RequestDispatcher view = request.getRequestDispatcher("visao_simples.jsp");
				         view.forward(request, response);
			            } catch (SQLException e) {
				                                  e.printStackTrace();
			                                      }
		                }else {			 
		                Conexao con = new Conexao();
		                List<VisaoSimples> pr;
	                    try {
		                pr = con.getListaGrau(grau_esferico, grau_cilindrico);
		                request.setAttribute("produtos", pr);
		                RequestDispatcher view = request.getRequestDispatcher("visao_simples.jsp");
				        view.forward(request, response);
	                    } catch (SQLException e) {
	                        		              e.printStackTrace();
	                                             }  			 
   	                    }
			               	         		
   		}
        	
        	
    		
       	}


}
