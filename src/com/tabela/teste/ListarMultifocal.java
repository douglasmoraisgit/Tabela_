package com.tabela.teste;

import java.sql.SQLException;
import java.util.List;

import com.tabela.beans.TabelaMultifocal;
import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;


public class ListarMultifocal {

	public static void main(String[] args) throws SQLException {
		
		Conexao con = new Conexao();
	
		
		String sql="Varilux";
		
		
		List<TabelaMultifocal> precos = con.getListaTabela(sql);
		
		for (TabelaMultifocal tbl : precos) {
			
			
		System.out.println("Descricao :"+tbl.getDescricao()+" Fornecedor "+tbl.getNomeFornecedor()+ " Preço "+tbl.getValorMult());			
	
		
			}

	}



}
