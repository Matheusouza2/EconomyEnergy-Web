package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	
	public static Connection getConnection(){
	Connection con = null;
	
	try{
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/infopower", "postgres", "890");
		System.out.println("Conectado com SUCESSO!");
	}catch (SQLException e){
		
		System.out.println("Não pode conectar" + e.getMessage());
	}
	return con;
	}

}
