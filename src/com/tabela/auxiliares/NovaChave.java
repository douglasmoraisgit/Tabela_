package com.tabela.auxiliares;

import java.text.NumberFormat;
import java.util.Locale;

public class NovaChave {
	
	public String limite(Double grau_esferico,Double grau_cilindrico) {
		 
		
	 	         Double esferico_final = grau_esferico  ;
	             Double esferico_inical = grau_esferico ;
		         Double cilindrico_final = grau_cilindrico;
		         Double cilindrico_inicial= grau_cilindrico ;

		        NumberFormat nf = NumberFormat.getInstance(Locale.US);
		        nf.setMinimumFractionDigits(2);
		        String esf_fim = String.valueOf(nf.format(esferico_final));
		        String esf_ini = String.valueOf(nf.format(esferico_inical));
		        String cil_fim = String.valueOf(nf.format(cilindrico_final));
		        String cil_ini = String.valueOf(nf.format(cilindrico_inicial));
				
		        return "esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim;
				//return "esf_fim>=" +esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			 }


}
