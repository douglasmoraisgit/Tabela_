package com.tabela.teste;

import java.sql.SQLException;
import java.util.List;

import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

public class Listar {

	public static void main(String[] args) throws SQLException {
		
		Conexao con = new Conexao();
		List<VisaoSimples> produtos = con.getListaGrau(+3.00, -2.00);
		
		for (VisaoSimples produto : produtos) {
			
			
		System.out.println("Nome do Produto :"+produto.getDescricao()+" Chave "+ produto.getChave());			
	
		
			}

	}



}
