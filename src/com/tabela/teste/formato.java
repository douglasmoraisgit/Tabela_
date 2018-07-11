package com.tabela.teste;

import java.text.*;
import java.util.Locale;

public class formato {
public static void main(String[] args) {

double d = 5;
double n = 5;
NumberFormat nf = NumberFormat.getInstance(Locale.US);
nf.setMinimumFractionDigits(2);
String numero = String.valueOf(nf.format(d));
String Descricao = "POLICARBONATO" + " " +numero;
System.out.println(Descricao);

 DecimalFormat df1 = new DecimalFormat( "#.##" );
 DecimalFormat df2 = new DecimalFormat( "#.00" );

System.out.println(df1.format(7.80));
System.out.println(df1.format(85));
System.out.println(df1.format(85.786));

System.out.println(df2.format(7.80));
System.out.println(df2.format(85));
System.out.println(df2.format(85.786));

}
}

         