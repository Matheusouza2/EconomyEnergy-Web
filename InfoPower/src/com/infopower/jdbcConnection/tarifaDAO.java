package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.infopower.entidades.Tarifa;

public class tarifaDAO implements InterfaceTarifa {

	Connection con = connection.getConnection();
	List<Tarifa> lista = new ArrayList<Tarifa>();

	@Override
	public void cadastrar(Tarifa tarifa) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PUBLIC.TARIFA (nome, valor) values (?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, tarifa.getNome());
			preparador.setDouble(2, tarifa.getValor());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Tarifa tarifa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Tarifa tarifa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tarifa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Existe(Tarifa tarifa) {
		// TODO Auto-generated method stub
		return null;
	}

}
