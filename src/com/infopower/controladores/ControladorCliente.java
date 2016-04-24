package com.infopower.controladores;

import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;
import com.infopower.jdbcConnection.InterfaceCliente;
import com.infopower.jdbcConnection.ClienteDAO;

public class ControladorCliente {
	
	private InterfaceCliente repositorioCliente = new ClienteDAO();
	
	public void cadastar(Cliente cliente, Endereco endereco){
		repositorioCliente.cadastrar(cliente, endereco);
	}
	
	public List<Cliente> listar(){
		return repositorioCliente.listar();
	}
	
	public void alterar(Cliente cliente){
		repositorioCliente.alterar(cliente);
	}
	
	public void excluir(Cliente cliente){
		repositorioCliente.excluir(cliente);
	}
	
	public Cliente autenticar(Cliente cliente){
		return repositorioCliente.autenticar(cliente);
	}

}