package com.infopower.jdbcConnection;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Fatura;


public interface InterfaceFatura {
	
	public void cadastrar (Fatura fatura)throws SQLException;
	public void alterar (Fatura fatura)throws SQLException;
	public void excluir (Fatura fatura)throws SQLException;
	public List<Fatura> listar()throws SQLException;
	public Boolean Existe(Fatura fatura)throws SQLException;

}
