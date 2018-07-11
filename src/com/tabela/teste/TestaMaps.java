package com.tabela.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestaMaps {

	public static void main(String[] args) {
		
		String  jose = "Jose";
		String paulo = "Paulo";
		String  joao = "Joao";
		
		List<String> nome = new ArrayList<>();
		nome.add(jose);
		nome.add(paulo);
		nome.add(joao);
		
		
		String texto = "Aqui esta o texto";
		
	
		
		 Map<Integer, Object> mapaNomes = new HashMap<Integer, Object>();
	        mapaNomes.put(1, "João Delfino");
	        mapaNomes.put(2, "Maria do Carmo");
	        mapaNomes.put(3, "Claudinei Silva");
	        mapaNomes.put(4, nome);
	        mapaNomes.put(5, texto);
	        
	       List<String> matriz =  (List<String>) mapaNomes.get(4);
	    //   matriz.get(2);	   
	
	         
	        //resgatando o nome da posição 2
	     System.out.println(matriz.get(0));
	      System.out.println(matriz.get(1));
	      System.out.println(matriz.get(2));
	      
	      System.out.println(mapaNomes.keySet());
	      System.out.println(mapaNomes.entrySet());
	      System.out.println(mapaNomes.toString());
	      System.out.println(mapaNomes.get(1));


		
		
	//	System.out.println(selecionado);
		

	}

	

}
