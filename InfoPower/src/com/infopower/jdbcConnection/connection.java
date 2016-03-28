package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connection {
	
	public static Connection getConnection(){
	Connection con = null;
	
	try{
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/infopower", "postgres", "890");
		System.out.println("Conectado com SUCESSO!");
	}catch (SQLException e){
		
		JOptionPane.showMessageDialog(null, "Não foi possível Conectar ao Banco!");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "Driver não Encontrado!");
	}
	return con;
	}

}
