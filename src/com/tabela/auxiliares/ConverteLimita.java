package com.tabela.auxiliares;

import java.text.NumberFormat;
import java.util.Locale;

public class ConverteLimita {
	
	
	private Double esf_ini;
	private Double esf_fim;
	private Double cil_ini;
	private Double cil_fim;

	public String converteGrau(Double esf,Double cil)
    {
		this.esf_ini = esf;
		this.esf_fim = esf;
		this.cil_ini = cil;
		this.cil_fim = cil;
		
    	if (esf > 0 && cil >0)
    	{
    		  esf = esf+cil;
    		  cil = cil*-1;
    	
		        NumberFormat nf = NumberFormat.getInstance(Locale.US);
		        nf.setMinimumFractionDigits(2);
		        String esf_fim = String.valueOf(nf.format(esf));
		        String esf_ini = String.valueOf(nf.format(esf));
		        String cil_fim = String.valueOf(nf.format(cil));
		        String cil_ini = String.valueOf(nf.format(cil));
				
		     System.out.println("+ com +");
		     System.out.println("(esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")");
		        return " (esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")";
  	        
        }
    	else 
        {
    	if (esf < 0 && cil <0)
    	{
    		double esferico = esf+cil;
    	    double cilindrico = cil*-1;
    	    
    	    NumberFormat nf = NumberFormat.getInstance(Locale.US);
	        nf.setMinimumFractionDigits(2);
	        String esf_fim = String.valueOf(nf.format(esferico));
	        String esf_ini = String.valueOf(nf.format(esferico));
	        String cil_fim = String.valueOf(nf.format(cilindrico));
	        String cil_ini = String.valueOf(nf.format(cilindrico));
	        
	    //    System.out.println("- com -");
	   //     System.out.println("Esfrico  "+esferico+"  Cilindrico  "+cilindrico);
	   //     System.out.println("(esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")");
	        return "(esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")";
    	}else
    	    
    		//System.out.println("+ com -  OU  - com +");
    	 //   System.out.println("(esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")");
    		return "(esf_ini<=" +esf_ini+ " and esf_fim>="+esf_fim+" and cil_ini <="+cil_ini+" and cil_fim >="+cil_fim+")";
    		 
        
    }
    	
    }
	

}
