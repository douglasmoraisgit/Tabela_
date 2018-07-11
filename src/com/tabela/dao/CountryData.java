package com.tabela.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.tabela.beans.Country;


public class CountryData {
	
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());    
		return DriverManager.getConnection("jdbc:mysql://localhost/lm", "root", "admin");
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
		}
	

	public Country getInfo(String countryCode) throws SQLException {
		
		Country country = new Country();
		
		String sql = "Select * from COUNTRY where code = ?"; 
		PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
		stmt.setString(1, countryCode.trim());
       
		ResultSet rs = stmt.executeQuery();
    
        while(rs.next()){ 
            country.setCode(rs.getString("code").trim());
            country.setName(rs.getString("name").trim());
            country.setContinent(rs.getString("continent").trim());
            country.setRegion(rs.getString("region").trim());
            country.setLifeExpectancy(rs.getString("lifeExpectancy") == null ? new Double(0) : Double.parseDouble(rs.getString("lifeExpectancy").trim()));
            country.setGnp(rs.getString("gnp") == null ? new Double(0)  : Double.parseDouble(rs.getString("gnp").trim()));
        }
		return country;
	   
		}



}
