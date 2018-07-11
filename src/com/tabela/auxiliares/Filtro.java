package com.tabela.auxiliares;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

public class Filtro {
	
	private static final long serialVersionUID = 1L;
	StringBuilder          Sql = new StringBuilder();
    StringBuilder     material = new StringBuilder();
    StringBuilder   tratamento = new StringBuilder();
    StringBuilder fotossensivel= new StringBuilder();
    StringBuilder       indice = new StringBuilder();
	StringBuilder resultMaterial;
	StringBuilder resultTratamento;
	StringBuilder resultFotossensivel;
	StringBuilder resultIndice;
	String materialString ="";
	String tratamentoString="";
    String fotoString="";
    String grau;
    
    List<VisaoSimples> escolhido;	
    
	
	public String filtro(HttpServletRequest request){
		   
		Map m=request.getParameterMap();
        Set s = m.entrySet();
        
        Iterator it = s.iterator();
 
            while(it.hasNext()){
 
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
 
                String key             = entry.getKey();
                String[] value         = entry.getValue();
                
                
                if(key.startsWith("material")){
                	if(value.length!=0){
                		for(int i = 0; i < value.length; i++) {
                			material.append(key+ "=" + "'"+value[i].toString()+ "' or ");
                		}
                	} resultMaterial = material;
                	
                	
                }else material.toString();
                
                if(key.startsWith("tratamento")){
                	if(value.length!=0){
                		for(int i = 0; i < value.length; i++) {
                			tratamento.append(key+ "=" + "'"+value[i].toString()+ "' or ");
                		}
                	} resultTratamento = tratamento;
                	
                	
                } else tratamento.toString();
                
                if(key.startsWith("fotossensivel")){
                	if(value.length!=0){
                		for(int i = 0; i < value.length; i++) {
                			fotossensivel.append(key+ "=" + "'"+value[i].toString()+ "' or ");
                		}
                	} resultFotossensivel = fotossensivel;
                	
                	
                }else fotossensivel.toString();
                
                if(key.startsWith("indice")){
                	if(value.length!=0){
                		for(int i = 0; i < value.length; i++) {
                			indice.append(key+ "=" + "'"+value[i].toString()+ "' or ");
                		}
                	}  resultIndice = indice;
                	
                	
                }else indice.toString();
 
            }
            material.insert(0,"(");
        	material.substring(0, material.length()-1);   
        	tratamento.insert(0,"(");
            fotossensivel.insert(0,"(");
            indice.insert(0,"(");  
           
            //System.out.println(Grau(odesf,odcil)+" AND "+Sqlstring(resultMaterial, resultTratamento, resultFotossensivel, resultIndice));
            //return Grau(odesf,odcil) + Sqlstring(resultMaterial, resultTratamento, resultFotossensivel, resultIndice);
            return Sqlstring(resultMaterial, resultTratamento, resultFotossensivel, resultIndice);       
	}
      

     public String Sqlstring( StringBuilder material, StringBuilder tratamento, StringBuilder fotossensivel, StringBuilder indice  ) {
	 if (material ==null){
		  System.out.println("Material Nao Especificado");
	  }
	  else { 
		  String materialString = material.toString().substring(0, (material.toString().length()-4)).concat(") AND ");
	      Sql.append(materialString);
	      System.out.println(materialString);
	  } 
	  if (tratamento==null) {
		  System.out.println("Tratamento Nao Especificado");
	  }
	  else {
	   String tratamentoString = tratamento.toString().substring(0, (tratamento.toString().length()-4)).concat(") AND ");
      Sql.append(tratamentoString); 		
	  } 
	  if (fotossensivel==null) {
		  System.out.println("Fotossensivel Nao Especificado");
		
	  }else {
	   fotossensivel.toString().substring(0, (fotossensivel.toString().length()-4)).concat(") AND ");
	   String fotoString = fotossensivel.toString().substring(0, fotossensivel.toString().length()-4).concat(") AND ");
	   Sql.append(fotoString);
	  } 
	  if (indice==null){
	  System.out.println("Indice Nao Especificado");
	  }    
	  else {    	  
	  indice.toString().substring(0, (indice.toString().length()-4)).concat(") AND ");
	  String indiceString = indice.toString().substring(0, (indice.toString().length()-4)).concat(") AND ");
	  Sql.append(indiceString);
	  }
	  if(Sql.length()<2){
	  System.out.println(Sql.toString() +"vazio");
	  System.out.println(Sql.length());
	  return "";
	  }
  	  String retorno = Sql.toString().substring(0,(Sql.length()-4)).concat(";");
	  System.out.println(retorno);
	  return retorno;
 } 

      public String grau(Double esf, Double cil){
      String grau  = new ConverteLimita().converteGrau(esf,cil);
      return grau;
 }


}
