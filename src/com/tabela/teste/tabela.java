package com.tabela.teste;



import java.io.Console;
import java.sql.SQLException;
import java.util.List;

import com.tabela.auxiliares.Chave;
import com.tabela.beans.VisaoSimples;



public class tabela {

	

	public static void main(String[] args) throws SQLException {
		
	
		String chave ="+0.50+0.50";
		
		if( chave.length()>10){
			 String esf = ""+chave.charAt(0)+chave.charAt(1)+chave.charAt(2)+chave.charAt(3)+chave.charAt(5);
			 String cil = ""+chave.charAt(6)+chave.charAt(7)+chave.charAt(8)+chave.charAt(9)+chave.charAt(10);
			 Double grau_esferico = Double.parseDouble(esf);
   			 Double grau_cilindrico = Double.parseDouble(cil);
			 
   			       if(grau_cilindrico > 0){
  				   double Transp_esf = grau_cilindrico+grau_esferico;
  				   double Trans_cil = grau_cilindrico*-1;
  				   grau_esferico= Transp_esf;
  				   grau_cilindrico = Trans_cil;
   			       Chave ch = new Chave();
   	     		   ch.limite(grau_esferico, grau_cilindrico);
   	               System.out.println(ch.limite(grau_esferico, grau_cilindrico));
   			       System.out.println(grau_esferico+" "+grau_cilindrico);
   			       }
		           else {    
                   Chave ch = new Chave();
	               System.out.println(ch.limite(grau_esferico, grau_cilindrico));
		           System.out.println(grau_esferico+" "+grau_cilindrico);
	              }
	         } else {		
		    String esf = ""+chave.charAt(0)+chave.charAt(1)+chave.charAt(2)+chave.charAt(3)+chave.charAt(4);
		    String cil = ""+chave.charAt(5)+chave.charAt(6)+chave.charAt(7)+chave.charAt(8)+chave.charAt(9);
		    Double grau_esferico = Double.parseDouble(esf);
		    Double grau_cilindrico = Double.parseDouble(cil);
		    
		          if(grau_cilindrico > 0){
				   double Transp_esf = grau_cilindrico+grau_esferico;
				   double Trans_cil = grau_cilindrico*-1;
				   grau_esferico= Transp_esf;
				   grau_cilindrico = Trans_cil;
			       Chave ch = new Chave();
	     		   ch.limite(grau_esferico, grau_cilindrico);
	               System.out.println(ch.limite(grau_esferico, grau_cilindrico));
			       System.out.println(grau_esferico+" "+grau_cilindrico);
			       }
		           else {    
                   Chave ch = new Chave();
	               System.out.println(ch.limite(grau_esferico, grau_cilindrico));
		           System.out.println(grau_esferico+" "+grau_cilindrico);
	              }
		    
		        }

}
}

