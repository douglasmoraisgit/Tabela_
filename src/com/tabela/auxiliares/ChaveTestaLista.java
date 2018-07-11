package com.tabela.auxiliares;

public class ChaveTestaLista {
	
	private Double  grau_grau_esferico;
	 private Double  grau_grau_cilindrico;
	 
	 
public String limite(Double grau_esferico,Double grau_cilindrico) {
	 
	 this.grau_grau_esferico = grau_esferico;
	 this.grau_grau_cilindrico = grau_cilindrico;
	 
	 
/*	 if (grau_esferico >=0.00 && grau_esferico <=+2.00 && grau_esferico >=-2.00 && grau_esferico >=-0.25 ){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			String chave = "-2.00/+2.00 <> -0.25/-2.00 ";
			String esf_fim = "+2.00";
			String esf_ini = "-2.00";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini >="+cil_ini+";";
		 }}	 
	 if (grau_esferico >2.25 && grau_esferico <=+4.00 && grau_esferico >=-4.00 && grau_esferico >=-2.25 ){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			String chave = "-4.00/+4.00 <> -0.25/-2.00 ";
			String esf_fim = "+4.00";
			String esf_ini = "+2.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini >="+cil_ini+";";
		 }} */	
	 
	 if(grau_cilindrico >0){
			 
			 double Transp_esf = grau_cilindrico+grau_esferico;
			 double Trans_cil = grau_cilindrico*-1;
			 
			 grau_esferico= Transp_esf;
			 grau_cilindrico = Trans_cil;
			 System.out.println("Esferico "+grau_esferico+ " Cilindirico "+grau_cilindrico);
	 
	  
	 
	 if (grau_esferico >=0.00 && grau_esferico <=2.00){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "0.00/2.00 <> -0.25/-2.00";
			String chave ="";
			String esf_fim = "+2.00";
			String esf_ini = "+0.00";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			//Double soma = grau_esferico+grau_cilindrico;
			Double soma = grau_esferico;
return chave+" select * from visao_simples where limite >="+soma+"and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }		
			}	 
	 if (grau_esferico >=2.25 && grau_esferico <=4.00){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			//String chave = "2.25/4.00 <> -0.25/-2.00";
			String chave ="";
			String esf_fim = "+4.00";
			String esf_ini = "+2.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			//Double soma = grau_esferico+grau_cilindrico;
			Double soma = grau_esferico;
			return chave+" select * from visao_simples where limite >="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }			
			}
	 if (grau_esferico >=4.25 && grau_esferico <=6.00){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			//String chave = "4.25/6.00 <> -0.25/-2.00";
			String chave ="";
			String esf_fim = "+6.00";
			String esf_ini = "+4.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			//Double soma = grau_esferico+grau_cilindrico;
			Double soma = grau_esferico;
			return chave+" select * from visao_simples where limite >="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			}
	 if (grau_esferico >=0.00 && grau_esferico <=3.00){
		 if (grau_cilindrico >=-3.00 && grau_cilindrico <=-2.25){
			
			//String chave = "0.00/2.00 <> -2.25/-3.00";
			String chave ="";
			String esf_fim = "+2.00";
			String esf_ini = "+0.00";
			String cil_fim = "-3.00";
			String cil_ini = "-2.25";
			//Double soma = grau_esferico+grau_cilindrico;
			Double soma = grau_esferico;
			return chave+" select * from visao_simples where limite >="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
}
	
	 if (grau_esferico >=-2.00 && grau_esferico <=-0.25){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "0.00/2.00 <> -0.25/-2.00";
			String chave ="";
			String esf_fim = "-2.00";
			String esf_ini = "-0.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	 if (grau_esferico >=-2.00 && grau_esferico <=-0.25){
		 if (grau_cilindrico >=-3.00 && grau_cilindrico <=-2.25){
			
			//String chave = "-0.25/-2.00 <> -2.25/-3.00";
			//String chave = "0.00/2.00 <> -0.25/-2.00";
				String chave ="";
			String esf_fim = "-2.00";
			String esf_ini = "-0.25";
			String cil_fim = "-3.00";
			String cil_ini = "-2.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	 if (grau_esferico >=-4.00 && grau_esferico <=-2.25){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "-2.25/-4.00 <> -0.25/-2.00";
			//String chave = "0.00/2.00 <> -0.25/-2.00";
				String chave ="";
			String esf_fim = "-4.00";
			String esf_ini = "-2.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>= "+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	 
	 
	 
	 if (grau_esferico >=-6.00 && grau_esferico <=-4.25){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "-4.25/-6.00 <> -0.25/-2.00";
			//String chave = "0.00/2.00 <> -0.25/-2.00";
				String chave ="";
			String esf_fim = "-6.00";
			String esf_ini = "-4.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>= "+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	 
	   if (grau_esferico >=-6.00 && grau_esferico <=-4.25){
	    	 if (grau_cilindrico >=-3.00 && grau_cilindrico <=-2.25){
			 
			
			//String chave = "-4.25/-6.00 <> -2.25/-3.00";
	    		//String chave = "0.00/2.00 <> -0.25/-2.00";
	 			String chave ="";
			String esf_fim = "-6.00";
			String esf_ini = "-4.25";
			String cil_fim = "-3.00";
			String cil_ini = "-2.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite >="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_ini >="+cil_ini+" and cil_fim <="+cil_fim;
		 }
			
			}
	 
	 if (grau_esferico >=-4.00 && grau_esferico <=-2.25){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "-2.25/-4.00 <> -0.25/-2.00";
			//String chave = "0.00/2.00 <> -0.25/-2.00";
				String chave ="";
			String esf_fim = "-4.00";
			String esf_ini = "-2.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>= "+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	
	 
	 if (grau_esferico >=-8.00 && grau_esferico <=-0.25){
		 if (grau_cilindrico >=-2.00 && grau_cilindrico <=-0.25){
			
			//String chave = "-0.25/-8.00 <> -0.25/-2.00";
			//String chave = "0.00/2.00 <> -0.25/-2.00";
				String chave ="";
			String esf_fim = "-8.00";
			String esf_ini = "-0.25";
			String cil_fim = "-2.00";
			String cil_ini = "-0.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
if (grau_esferico >=-8.00 && grau_esferico <=-0.25){
		 if (grau_cilindrico >=-3.00 && grau_cilindrico <=-2.25){
			
			//String chave = "-0.25/-8.00 <> -2.25/-3.00";
			String chave ="";
			String esf_fim = "-8.00";
			String esf_ini = "-0.25";
			String cil_fim = "-3.00";
			String cil_ini = "-2.25";
			Double soma = grau_esferico+grau_cilindrico;
			soma= soma*-1;
			return chave+" select * from visao_simples where limite>="+soma+" and esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
			//return chave+" select * from visao_simples where esf_fim>="+esf_fim+ " and esf_ini<="+esf_ini+" and cil_fim >="+cil_fim+" and cil_ini <="+cil_ini;
		 }
			
			}
	 
	  return "Não existe lente pronta";	

}


}
