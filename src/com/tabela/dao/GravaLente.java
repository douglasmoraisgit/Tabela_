package com.tabela.dao;

public class GravaLente {
	
	

public static void main(String args[]){

int inicio = -1000000;
double Esferico;
double Cilindrico;
int Eixo;
String Descricao = "";
int contador =0;

for( Esferico=inicio; Esferico<=6;Esferico=Esferico+0.25) {
	contador =contador+1;
	System.out.println(contador);
for( Cilindrico=0.25; Cilindrico<=3;Cilindrico=Cilindrico+0.25) {
for( Eixo=1; Eixo<=180;Eixo=Eixo+1){
//System.out.println(Esferico +"  "+Cilindrico);

Descricao = "policarbonato  " + Esferico +" +"+ Cilindrico +" X "+Eixo;
contador =contador+1;
System.out.println(Descricao);
}
}

System.out.println(contador); }
}
}