package com.tabela.auxiliares;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



public class Auxiliar {
	
	
	 List<String> listaColunas = new ArrayList<>();
	 private Enumeration paramNames;
	 private HttpServletRequest request = null;
	
	 public List<String> listaColunas(Enumeration paramNames)
	 {
		this.paramNames = paramNames;
		while(paramNames.hasMoreElements()) 
	         {
			 String paramName = (String)paramNames.nextElement();
	         listaColunas.add(paramName);
	            System.out.println(paramName+ " Print Classe Auxiliar paramNames");
	            System.out.println(listaColunas.size()+ " Print Classe Aulixiar listaColunas"); 
	         } 
		     return listaColunas;
	 }
	 
	 
	 public String MontaFiltro(List<String> listaColunas, HttpServletRequest request)
	 {
		 String sql = "select * from visao_simples where";
	       
	         List<String> lista = listaColunas(paramNames);
	         if(lista.size()== 1){
	        	String colunaUm = lista.get(0);
	           	String valorUm = converteGrau(request.getParameter(colunaUm));
	           	System.out.println(sql+" "+ valorUm);
	           	return sql+" "+valorUm;
	        	
	        }else if(lista.size()==2){
	        	String colunaUm = lista.get(0);
	           	String valorUm = converteGrau(request.getParameter(colunaUm));//retorna a chave pra pesquisar no banco
	        	String colunaDois = lista.get(1);
	        	String valorDois = request.getParameter(colunaDois);
	        	System.out.println(sql+" "+ valorUm+ " and "+colunaDois+" =" +"'"+valorDois+"'"+";");
	        	return sql+" "+valorUm+ " and "+colunaDois+" =" +"'"+valorDois+"'"+";";
	        }else if(lista.size()==3){
	        	String colunaUm = lista.get(0);
	        	String valorUm = converteGrau(request.getParameter(colunaUm));
	        	String colunaDois = lista.get(1);
	        	String valorDois = request.getParameter(colunaDois);
	        	String colunaTres = lista.get(2);
	        	String valorTres = request.getParameter(colunaTres);
	        	System.out.println(sql+" "+valorUm+" and "+colunaDois+" =" +"'"+valorDois+ "'"+" and "+colunaTres+" =" +"'"+valorTres+"'"+";");
	        	return sql+" "+valorUm+" and "+colunaDois+" =" +"'"+valorDois+ "'"+" and "+colunaTres+" =" +"'"+valorTres+"'"+";";
	        	
	        }else if(lista.size()==4){
	        	String colunaUm = lista.get(0);
	        	String valorUm = converteGrau(request.getParameter(colunaUm));
	        	String colunaDois = lista.get(1);
	        	String valorDois = request.getParameter(colunaDois);
	        	String colunaTres = lista.get(2);
	        	String valorTres = request.getParameter(colunaTres);
	        	String colunaQuatro = lista.get(3);
	        	String valorQuatro = request.getParameter(colunaQuatro);
	        	System.out.println(sql+" "+valorUm+" and "+colunaDois+" =" +"'"+valorDois+"'"+" and "+colunaTres+" =" +"'"+valorTres+"'"+ " and "+colunaQuatro+" =" +"'"+valorQuatro+"'"+";");
	        	return sql+" "+valorUm+" and "+colunaDois+" =" +"'"+valorDois+"'"+" and "+colunaTres+" =" +"'"+valorTres+"'"+ " and "+colunaQuatro+" =" +"'"+valorQuatro+"'"+";";
	        }else if(lista.size()==5){
	        	String colunaUm = lista.get(0);
	        	String valorUm = converteGrau(request.getParameter(colunaUm));
	        	String colunaDois = lista.get(1);
	        	String valorDois = request.getParameter(colunaDois);
	        	String colunaTres = lista.get(2);
	        	String valorTres = request.getParameter(colunaTres);
	        	String colunaQuatro = lista.get(3);
	        	String valorQuatro = request.getParameter(colunaQuatro);
	        	String colunaCinco = lista.get(4);
	        	String valorCinco = request.getParameter(colunaCinco);
	        	return sql+" "+valorUm+" and "+colunaDois+" =" +"'"+valorDois+"'"+" and "+colunaTres+" =" +"'"+valorTres+"'"+ " and "+colunaQuatro+" =" +"'"+valorQuatro+"'"+ " and "+colunaCinco+" =" +"'"+valorCinco+"'"+";";
	           }
	      return sql;
	     }

	 
	 public String converteGrau(String grau){
		 if( grau.length()>10){
			 String esf = ""+grau.charAt(0)+grau.charAt(1)+grau.charAt(2)+grau.charAt(3)+grau.charAt(5);
			 String cil = ""+grau.charAt(6)+grau.charAt(7)+grau.charAt(8)+grau.charAt(9)+grau.charAt(10);
			 Double grau_esferico = Double.parseDouble(esf);
			 Double grau_cilindrico = Double.parseDouble(cil);
			   			 if(grau_cilindrico >0){
				         double Transposicao_esf = grau_cilindrico+grau_esferico;
				         double Transposicao_cil = grau_cilindrico*-1;
				         grau_esferico   = Transposicao_esf;
				         grau_cilindrico = Transposicao_cil;
				         ChaveAux ch = new ChaveAux();
				         return grau =  ch.limite(grau_esferico, grau_cilindrico);
			             }else {
			                ChaveAux ch  = new ChaveAux();
							return grau =  ch.limite(grau_esferico, grau_cilindrico);		 
			             }
			             
			   			 
    	}else{
	         String esf = ""+grau.charAt(0)+grau.charAt(1)+grau.charAt(2)+grau.charAt(3)+grau.charAt(4);
	         String cil = ""+grau.charAt(5)+grau.charAt(6)+grau.charAt(7)+grau.charAt(8)+grau.charAt(9);
	         Double grau_esferico = Double.parseDouble(esf);
			 Double grau_cilindrico = Double.parseDouble(cil);
			 
			             if(grau_cilindrico >0){
			             double Transp_esf = grau_cilindrico+grau_esferico;
			             double Trans_cil = grau_cilindrico*-1;
			             grau_esferico= Transp_esf;
			             grau_cilindrico = Trans_cil;
			             ChaveAux ch = new ChaveAux();
				         return grau =  ch.limite(grau_esferico, grau_cilindrico);
			             }else {			 
			            	ChaveAux ch  = new ChaveAux();
							return grau =  ch.limite(grau_esferico, grau_cilindrico);	
	                     		  }
	                     } 
	           }


}
