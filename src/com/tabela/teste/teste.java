package com.tabela.teste;

import java.sql.SQLException;
import java.util.List;

import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

public class teste {

	public static void main(String[] args) throws SQLException {
		
		
			
			Conexao con = new Conexao();
			
			List<VisaoSimples> lentes = con.getLista();
			
			for (VisaoSimples lente : lentes) {
							
		      System.out.println("Produto:"+ lente.getMarcaLente());
			
				}

		}

	}


