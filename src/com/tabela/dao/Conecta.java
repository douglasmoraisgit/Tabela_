package com.tabela.dao;

import java.sql.DriverManager;
import java.sql.SQLException;



public class Conecta {
	
	//final private String driver = "com.mysql.jdbc.Driver";
    String driver;	
    //final private String url = "jdbc:mysql://localhost/produtos";
    String url; 
    //final private String usuario = "root";
    String usuario;
    //final private String senha = "admin";
    String senha;
    private java.sql.Connection conexao;
    public java.sql.Statement statement;
    public java.sql.ResultSet resultset;

    public boolean conexao(String driver,String url,String usuario,String senha  ){ 
    boolean result = true;
        try{
           Class.forName(driver);
           conexao = DriverManager.getConnection(url,usuario,senha);
           //JOptionPane.showMessageDialog(null,"CONECTADO");
           }
      catch(ClassNotFoundException Driver){ 
                                           System.out.println("Driver não Localizado"+Driver);
                                           result = false;                      
                                           } 
      catch(SQLException Fonte){
    	   System.out.println("Deu erro com fonte de dados"+Fonte);
                                result = false;
                                }
       return result;
                                       
       }


public void desconecta() { 
	boolean result = true;
         try{
            conexao.close();
            System.out.println("BANCO FECHADO");
            }
       catch(SQLException ErroSql){        
    	   System.out.println("NAO FOI POSSÍVEL FECHAR BANCO"+ErroSql);
                                  result = false;
                                  }
       }

public void executeSQL(String sql) {
                  try{
                     statement = conexao.createStatement();
                     resultset = statement.executeQuery(sql);
                     }
                 catch(SQLException sqlex){
                	 System.out.println("NAO EXECUTOU   "+sqlex+" "  +sql);
                                          }
                 
                 }    



public void grava(String insertsql) { 
                    try{ statement = conexao.createStatement();
                         int insnum = statement.executeUpdate(insertsql);	 
                       } 
                    catch(SQLException erro) {System.out.println("FUDEU");
                                             }
                   }  
}

	                     
	                    



	                     
	
	
	
	
	
	
	


