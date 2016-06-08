package com.infopower.controladores;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Fatura;
import com.infopower.jdbcConnection.InterfaceFatura;
import com.infopower.jdbcConnection.faturaDAO;

public class ControladorFatura {
private InterfaceFatura repositorioFatura = new faturaDAO();
	
	public void cadastar(Fatura fatura) throws SQLException{
		repositorioFatura.cadastrar(fatura);
	}
	
	public List<Fatura> listar()throws SQLException{
		return repositorioFatura.listar();
	}
	
	public void alterar(Fatura fatura)throws SQLException{
		repositorioFatura.alterar(fatura);
	}
	
	public void excluir(Fatura fatura)throws SQLException{
		repositorioFatura.excluir(fatura);
	}
}


