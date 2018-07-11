package com.tabela.teste;

import java.util.ArrayList;
import java.util.List;

public class TesteOject {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String nome = "Douglas";
		String[] cidade = {"Barueri","Carapicuiba"};
		

	List<Object>cesto = new ArrayList<Object>();
			cesto.add(nome);
		cesto.add(cidade);
		
		String[] city = (String[]) cesto.get(1);
		
		
		
		System.out.println(cesto.get(0));
		System.out.print(city[1]);
		
	}

}
