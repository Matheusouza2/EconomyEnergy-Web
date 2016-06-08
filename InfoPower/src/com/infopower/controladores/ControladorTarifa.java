package com.infopower.controladores;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Tarifa;
import com.infopower.exception.TarifaExistenteException;
import com.infopower.jdbcConnection.InterfaceTarifa;
import com.infopower.jdbcConnection.TarifaDAO;

public class ControladorTarifa {
private InterfaceTarifa repositorioTarifa = new TarifaDAO();
	
	public void cadastar(Tarifa tarifa) throws TarifaExistenteException, SQLException{
		if(repositorioTarifa.existe(tarifa) == true)throw new TarifaExistenteException();
		repositorioTarifa.cadastrar(tarifa);
	}
	
	public List<Tarifa> listar()throws SQLException{
		return repositorioTarifa.listar();
	}
	
	public void alterar(Tarifa tarifa)throws SQLException{
		repositorioTarifa.alterar(tarifa);
	}
	
	public void excluir(Tarifa tarifa)throws SQLException{
		repositorioTarifa.excluir(tarifa);
	}
	public Tarifa procurarId(Integer id)throws SQLException{
		return repositorioTarifa.procurar(id);
	}
}