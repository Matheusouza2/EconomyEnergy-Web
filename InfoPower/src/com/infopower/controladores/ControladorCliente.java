package com.infopower.controladores;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;
import com.infopower.exception.ClienteExisteException;
import com.infopower.exception.CpfExistenteException;
import com.infopower.exception.EnderecoExistenteException;
import com.infopower.jdbcConnection.InterfaceCliente;
import com.infopower.jdbcConnection.ClienteDAO;

public class ControladorCliente {
	
	private String idClicado;
	public String getIdClicado() {
		return idClicado;
	}

	public void setIdClicado(String idClicado) {
		this.idClicado = idClicado;
	}
	
	private List<Cliente> cpf;
	private InterfaceCliente repositorioCliente = new ClienteDAO();
	
	public void cadastar(Cliente cliente, Endereco endereco) throws ClienteExisteException, EnderecoExistenteException, CpfExistenteException, SQLException{
		if(repositorioCliente.autenticarExiste(cliente) == true) throw new ClienteExisteException();
		if(repositorioCliente.enderecoExiste(endereco) == true) throw new EnderecoExistenteException();
		cpf = repositorioCliente.listar();
		for (Cliente cliente2 : cpf) {
			if(cliente.getCpf().equals(cliente2.getCpf()))throw new CpfExistenteException();
		}
		repositorioCliente.cadastrar(cliente, endereco);
	}
	
	public List<Cliente> listar()throws SQLException{
		return repositorioCliente.listar();
	}
	
	public void alterar(Cliente cliente, Endereco endereco)throws SQLException{
		repositorioCliente.alterar(cliente, endereco);
	}
	
	public Cliente procurarId(Integer id)throws SQLException{
		return repositorioCliente.procurar(id);
	}
	public List<Cliente> procurarNome(String nome)throws SQLException{
		return repositorioCliente.procurarNome(nome);
	}
	
	public void excluir(Cliente cliente)throws SQLException{
		repositorioCliente.excluir(cliente);
	}
	
	public Cliente autenticar(Cliente cliente)throws SQLException{
		return repositorioCliente.autenticar(cliente);
	}
	public Boolean existe(Cliente cliente) throws SQLException{
		return repositorioCliente.existe(cliente);
	}
	public Boolean existeLogin(Cliente cliente)throws SQLException{
		return repositorioCliente.autenticarExiste(cliente);
	}

}