package com.tabela.auxiliares;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.tabela.beans.VisaoSimples;
import com.tabela.dao.Conexao;

public class MontaFiltro {
	
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
		   
		String	esf_d= request.getParameter("odesf");
	    String	cil_d= request.getParameter("odcil");
	    String	esf_e= request.getParameter("oeesf");
	    String	cil_e= request.getParameter("oecil");
	    Double odesf = Double.parseDouble(esf_d);
	    Double odcil = Double.parseDouble(cil_d);
	    Double oeesf = Double.parseDouble(esf_e);
	    Double oecil = Double.parseDouble(cil_e);
		
	    
		
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
            return Grau(odesf,odcil)+" AND "+Sqlstring(resultMaterial, resultTratamento, resultFotossensivel, resultIndice);       
	}
                






public String Sqlstring( StringBuilder material, StringBuilder tratamento, StringBuilder fotossensivel, StringBuilder indice  ) {
	 if (material ==null){
		  System.out.println("Zero");
	  }
	  else { 
		  String materialString = material.toString().substring(0, (material.toString().length()-4)).concat(") AND ");
	      Sql.append(materialString);
	  } 
	  if (tratamento==null) {
		  System.out.println("Zero");
	  }
	  else {
	   String tratamentoString = tratamento.toString().substring(0, (tratamento.toString().length()-4)).concat(") AND ");
      Sql.append(tratamentoString); 		
	  } 
	  if (fotossensivel==null) {
		  System.out.println("Zero");
		
	  }else {
	   fotossensivel.toString().substring(0, (fotossensivel.toString().length()-4)).concat(") AND ");
	   String fotoString = fotossensivel.toString().substring(0, fotossensivel.toString().length()-4).concat(") AND ");
	   Sql.append(fotoString);
	  } 
	  if (indice==null){
	  System.out.println("Zero");
	  }    
	  else {    	  
	  indice.toString().substring(0, (indice.toString().length()-4)).concat(") AND ");
	  String indiceString = indice.toString().substring(0, (indice.toString().length()-4)).concat(") AND ");
	  Sql.append(indiceString);
	  }
	  if(Sql.length()<2){System.out.println(Sql.toString() +" vazio");
	  return "";}
  	  String retorno = Sql.toString().substring(0,(Sql.length()-4)).concat(";");
	
	  return retorno;
 } 

 public String Grau(Double esf, Double cil){
	 
	 
	    String olhodireito  = new ConverteLimita().converteGrau(esf,cil);

	 
	 
	 return olhodireito;
 }


}
