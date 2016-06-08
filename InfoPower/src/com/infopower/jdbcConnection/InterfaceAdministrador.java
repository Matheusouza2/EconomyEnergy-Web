package com.infopower.jdbcConnection;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Endereco;

public interface InterfaceAdministrador {
	
	public void cadastrar (Administrador administrador, Endereco endereco)throws SQLException;
	public void alterar (Administrador administrador)throws SQLException;
	public void excluir (Administrador administrador)throws SQLException;
	public List<Administrador> listar()throws SQLException;
	public Administrador procurar(Integer id)throws SQLException;
	public List<Administrador> procurarNome(String nome)throws SQLException;
	public Administrador autenticar(Administrador administrador)throws SQLException;
	public Administrador autenticar2(String login, String senha)throws SQLException;
	public Boolean autenticarExiste(Administrador administrador)throws SQLException;

}
