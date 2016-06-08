package com.infopower.controladores;

import java.io.IOException;

import java.sql.SQLException;

import com.infopower.entidades.Tarifa;
import com.infopower.jdbcConnection.ArduinoDAO;
import com.infopower.jdbcConnection.InterfaceArduino;
import com.infopower.jdbcConnection.TarifaDAO;

public class ControladorArduino {

	private InterfaceArduino arduino = new ArduinoDAO();
	private TarifaDAO tarifa = new TarifaDAO();
	public ControladorArduino() {
	
	}
	
	public void cadastrar(double kw, String data) throws SQLException, IOException{
			arduino.cadastrar(kw, data);
			
			cadastrarJDBC();
	}
	
	private double somatoriaDiaria() throws IOException{
		
		double somatorio = 0;
		
		
			for(double soma : arduino.somatoriaDiaria()){
				somatorio += soma; 
			}	
		return somatorio;
	}
	
	public void cadastrarJDBC() throws SQLException, IOException{
		double valor = 0;
		for (Tarifa tarifaT: tarifa.listar()) {
			if(tarifaT.getNome().equals("preço kw")){
				valor = tarifaT.getValor();
			}
		}
		double valorCadastra = somatoriaDiaria() * valor;
		arduino.cadastrarJDBC(somatoriaDiaria(), valorCadastra);
	}
}