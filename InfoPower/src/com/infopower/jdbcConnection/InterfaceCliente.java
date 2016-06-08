package com.infopower.jdbcConnection;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;

public interface InterfaceCliente {
	
	public void cadastrar (Cliente cliente, Endereco endereco)throws SQLException;
	public void alterar (Cliente cliente, Endereco endereco)throws SQLException;
	public void excluir (Cliente cliente)throws SQLException;
	public List<Cliente> listar()throws SQLException;
	public Cliente procurar(Integer id)throws SQLException;
	public List<Cliente> procurarNome(String nome)throws SQLException;
	public Cliente autenticar(Cliente cliente)throws SQLException;
	public Boolean autenticarExiste(Cliente cliente)throws SQLException;
	public Boolean existe(Cliente cliente) throws SQLException;
	public boolean enderecoExiste(Endereco endereco)throws SQLException;
}
