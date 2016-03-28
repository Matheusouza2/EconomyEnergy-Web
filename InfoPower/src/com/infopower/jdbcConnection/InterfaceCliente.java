package com.infopower.jdbcConnection;

import java.util.List;

import com.infopower.entidades.Cliente;

public interface InterfaceCliente {
	
	public void cadastrar (Cliente cliente);
	public void alterar (Cliente cliente);
	public void excluir (Cliente cliente);
	public List<Cliente> listar();
	public Cliente procurar(Integer id);
	public List<Cliente> procurarNome(String nome);
	public Cliente autenticar(Cliente cliente);
	public Boolean autenticarExiste(Cliente cliente);
}
