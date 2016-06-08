package com.infopower.jdbcConnection;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Tarifa;

public interface InterfaceTarifa {
	
	public void cadastrar (Tarifa tarifa)throws SQLException;
	public void alterar (Tarifa tarifa)throws SQLException;
	public void excluir (Tarifa tarifa)throws SQLException;
	public List<Tarifa> listar()throws SQLException;
	public Boolean existe(Tarifa tarifa)throws SQLException;
	public Tarifa procurar(Integer id)throws SQLException;

}
