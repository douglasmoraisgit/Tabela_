package com.tabela.beans;

public class Produto {
	
	private Integer	idProduto;
	private String  nomeProduto;
	private String	nomeMaterial;
	private String	tratamento;
	private String	descricao;
	private Double	indice;
	private String chave;
	private Double	esf_ini;
	private Double	esf_fim;
	private Double	cil_ini;
	private Double	cil_fim;
	
	public Produto(Integer idProduto,String nomeProduto, String nomeMaterial ){
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.nomeMaterial = nomeMaterial;
	}
	

public Integer getIdProduto() {
	return idProduto;
}
public String getNomeProduto() {
	return nomeProduto;
}
public void setNomeProduto(String nomeProduto) {
	this.nomeProduto = nomeProduto;
}
public String getNomeMaterial() {
	return nomeMaterial;
}
public void setNomeMaterial(String nomeMaterial) {
	this.nomeMaterial = nomeMaterial;
}
public Double getIndice() {
	return indice;
}
public String getChave() {
	return chave;
}
public void setChave(String chave) {
	this.chave = chave;
}
public void setIndice(Double indice) {
	this.indice = indice;
}
public String getTratamento() {
	return tratamento;
}
public void setTratamento(String tratamento) {
	this.tratamento = tratamento;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public Double getEsf_ini() {
	return esf_ini;
}
public void setEsf_ini(Double esf_ini) {
	this.esf_ini = esf_ini;
}
public Double getEsf_fim() {
	return esf_fim;
}
public void setEsf_fim(Double esf_fim) {
	this.esf_fim = esf_fim;
}
public Double getCil_ini() {
	return cil_ini;
}
public void setCil_ini(Double cil_ini) {
	this.cil_ini = cil_ini;
}
public Double getCil_fim() {
	return cil_fim;
}
public void setCil_fim(Double cil_fim) {
	this.cil_fim = cil_fim;
}
public void setIdProduto(int int1) {
	// TODO Auto-generated method stub
	
}


}
