package com.tabela.teste;



import java.io.Console;
import java.sql.SQLException;
import java.util.List;

import com.tabela.auxiliares.Auxiliar;
import com.tabela.auxiliares.Chave;
import com.tabela.auxiliares.ChaveAux;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;



public class TestaChaveAux {

	

	public static void main(String[] args) throws SQLException {
		
	
		String grau ="+0.50+0.50";
		
		Auxiliar aux = new Auxiliar();
		System.out.println(aux.converteGrau(grau));
		
		Conexao con = new Conexao();
		VisaoSimples prod = new VisaoSimples();
				
		List<VisaoSimples> produtos = con.getListaGrauSql(aux.converteGrau(grau));
		
		for (VisaoSimples produto : produtos) {
			
			
		System.out.println("Nome do Produto :"+produto.getDescricao()+" Chave "+ produto.getChave());			
	
		
		
		
		}	
}

}