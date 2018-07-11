package com.tabela.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.tabela.auxiliares.Chave;
import com.tabela.beans.TabelaMultifocal;
import com.tabela.beans.VisaoSimples;

public class Conexao {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());    
		return DriverManager.getConnection(
		"jdbc:mysql://localhost/lm", "root", "admin");
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		}
		
	public  List<VisaoSimples> ListarGrau(Double grau_esferico, Double grau_cilindrico) throws SQLException {
		List<VisaoSimples> lentes = new ArrayList<VisaoSimples>();
	   	PreparedStatement stmt = new Conexao().getConnection().prepareStatement("order by marcaLente");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		VisaoSimples lente = new VisaoSimples();
		lente.setIdLente(rs.getInt("idLente"));			
		lente.setMarcaLente(rs.getString("marcaLente"));
		lente.setMaterial(rs.getString("material"));
		lente.setIndice(rs.getDouble("indice"));
		lente.setTratamento(rs.getString("tratamento"));
		lente.setDescricao(rs.getString("descricao"));
		//lente.setChave(rs.getString("chave"));
		lente.setEsf_ini(rs.getDouble("esf_ini"));
		lente.setEsf_fim(rs.getDouble("esf_fim"));
		lente.setCil_ini(rs.getDouble("cil_ini"));
		lente.setCil_fim(rs.getDouble("cil_fim"));
		lentes.add(lente);
		}
		return lentes;
	}
	
	public  List<VisaoSimples> getLista() throws SQLException {
		List<VisaoSimples> lentes = new ArrayList<VisaoSimples>();
		PreparedStatement stmt = new Conexao().getConnection().prepareStatement("select * from visao_simples order by marcaLente");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		VisaoSimples lente = new VisaoSimples();
		lente.setIdLente(rs.getInt("idLente"));			
		lente.setMarcaLente(rs.getString("marcaLente"));
		lente.setMaterial(rs.getString("material"));
		lente.setIndice(rs.getDouble("indice"));
		lente.setTratamento(rs.getString("tratamento"));
		lente.setDescricao(rs.getString("descricao"));
	//	lente.setChave(rs.getString("chave"));
		lente.setEsf_ini(rs.getDouble("esf_ini"));
		lente.setEsf_fim(rs.getDouble("esf_fim"));
		lente.setCil_ini(rs.getDouble("cil_ini"));
		lente.setCil_fim(rs.getDouble("cil_fim"));
		lentes.add(lente);
		}
		return lentes;
	}
	
	public  List<VisaoSimples> getListaGrau(Double grau_esferico, Double grau_cilindrico) throws SQLException {
		List<VisaoSimples> lentes = new ArrayList<VisaoSimples>();
	    Chave ch = new Chave();
	   	PreparedStatement stmt = new Conexao().getConnection().prepareStatement(ch.limite(grau_esferico, grau_cilindrico)+"order by marcaLente");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		VisaoSimples lente = new VisaoSimples();
		lente.setIdLente(rs.getInt("idLente"));			
		lente.setMarcaLente(rs.getString("marcaLente"));
		lente.setMaterial(rs.getString("material"));
		lente.setIndice(rs.getDouble("indice"));
		lente.setTratamento(rs.getString("tratamento"));
		lente.setDescricao(rs.getString("descricao"));
		//lente.setChave(rs.getString("chave"));
		lente.setEsf_ini(rs.getDouble("esf_ini"));
		lente.setEsf_fim(rs.getDouble("esf_fim"));
		lente.setCil_ini(rs.getDouble("cil_ini"));
		lente.setCil_fim(rs.getDouble("cil_fim"));
		lentes.add(lente);
		}
		return lentes;
	}
	
	
	public  List<TabelaMultifocal> getListaMult() throws SQLException {
		List<TabelaMultifocal> precos = new ArrayList<TabelaMultifocal>();
		PreparedStatement stmt = new Conexao().getConnection().prepareStatement("SELECT p.descricao, f.nomeFornecedor, tc.valorProduto FROM multifocal p,fornecedor f, tabela_multifocal tc WHERE tc.idMult = p.idMult AND tc.idFornecedor = f.idFornecedor AND p.idMult=1");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		TabelaMultifocal tbl = new TabelaMultifocal();
		tbl.setDescricao(rs.getString("descricao"));			
		tbl.setNomeFornecedor(rs.getString("nomeFornecedor"));
		tbl.setValorMult(rs.getDouble("valorProduto"));
		precos.add(tbl);
		}
		return precos;
	}
    
	public  List<TabelaMultifocal> getListaTabela(String sql) throws SQLException {
		List<TabelaMultifocal> precos = new ArrayList<TabelaMultifocal>();
		PreparedStatement stmt = new Conexao().getConnection().prepareStatement("SELECT p.descricao, f.nomeFornecedor, tc.valorProduto FROM multifocal p,fornecedor f, tabela_multifocal tc WHERE tc.idMult = p.idMult AND tc.idFornecedor = f.idFornecedor AND p.nomeMult="+"'"+sql+"'");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		TabelaMultifocal tbl = new TabelaMultifocal();
		tbl.setDescricao(rs.getString("descricao"));			
		tbl.setNomeFornecedor(rs.getString("nomeFornecedor"));
		tbl.setValorMult(rs.getDouble("valorProduto"));
		precos.add(tbl);
		}
		return precos;
	}

	public List<VisaoSimples> getListaSql(String converteGrau) throws SQLException {
		
		List<VisaoSimples> lentes = new ArrayList<VisaoSimples>();
	    PreparedStatement stmt = new Conexao().getConnection().prepareStatement(converteGrau+";");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
		VisaoSimples lente = new VisaoSimples();
		lente.setIdLente(rs.getInt("idLente"));			
		lente.setMarcaLente(rs.getString("marcaLente"));
		
		lente.setMaterial(rs.getString("material"));
		lente.setIndice(rs.getDouble("indice"));
		lente.setTratamento(rs.getString("tratamento"));
		lente.setDescricao(rs.getString("descricao"));
		//lente.setChave(rs.getString("chave"));
		lente.setEsf_ini(rs.getDouble("esf_ini"));
		lente.setEsf_fim(rs.getDouble("esf_fim"));
		lente.setCil_ini(rs.getDouble("cil_ini"));
		lente.setCil_fim(rs.getDouble("cil_fim"));
		lentes.add(lente);
		}
		return lentes;
		
	}
public List<VisaoSimples> getListaGrauSql(String converteGrau) throws SQLException {
		
		List<VisaoSimples> lentes = new ArrayList<VisaoSimples>();
	    PreparedStatement stmt = new Conexao().
	    getConnection().
	    prepareStatement("select * from visao_simples where "+converteGrau);
		ResultSet rs = stmt.executeQuery();
		NumberFormat moeda = NumberFormat.getCurrencyInstance();
		while(rs.next()){
		VisaoSimples lente = new VisaoSimples();
		lente.setIdLente(rs.getInt("idLente"));			
		lente.setMarcaLente(rs.getString("marcaLente"));
		lente.setMaterial(rs.getString("material"));
		lente.setCor(rs.getString("cor"));
		lente.setTratamento(rs.getString("tratamento"));
		lente.setDescricao(rs.getString("descricao"));
		lente.setFotossensivel(rs.getString("fotossensivel"));
		lente.setIndice(rs.getDouble("indice"));
		//lente.setChave(rs.getString("chave"));
		lente.setEsf_ini(rs.getDouble("esf_ini"));
		lente.setEsf_fim(rs.getDouble("esf_fim"));
		lente.setCil_ini(rs.getDouble("cil_ini"));
		lente.setCil_fim(rs.getDouble("cil_fim"));
		lente.setValor(moeda.format(rs.getDouble("valor")));
		lentes.add(lente);
		}
		return lentes;
		
	}
	
	}
