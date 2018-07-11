package com.tabela.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tabela.beans.Composer;
import com.tabela.beans.Produto;

/**
 *
 * @author nbuser
 */
public class ProdutosData {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    

    public List<Produto> getProduto() {
        return produtos;
    }
    
    public ProdutosData() {
        
        produtos.add(new Produto(1,"Visao Simples", "Acrilico"));
        produtos.add(new Produto(2,"Bifocal", "Cristal"));
        produtos.add(new Produto(3,"Multifocal","Policarbonato"));
        
    }

}
