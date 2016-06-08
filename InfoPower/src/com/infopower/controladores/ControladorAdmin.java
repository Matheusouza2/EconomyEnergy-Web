package com.infopower.controladores;

import java.sql.SQLException;
import java.util.List;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Endereco;
import com.infopower.exception.AdministradorExistenteException;
import com.infopower.jdbcConnection.InterfaceAdministrador;
import com.infopower.jdbcConnection.AdministradorDAO;

public class ControladorAdmin {
	private InterfaceAdministrador repositorioAdmin = new AdministradorDAO();
	
	public void cadastrar(Administrador administrador, Endereco endereco) throws AdministradorExistenteException, SQLException {
		if(repositorioAdmin.autenticarExiste(administrador) == true) throw new AdministradorExistenteException();
		repositorioAdmin.cadastrar(administrador, endereco);
	}

	public List<Administrador> listar() throws SQLException{
		return repositorioAdmin.listar();
	}
	
	public void alterar(Administrador administrador) throws SQLException{
		repositorioAdmin.alterar(administrador);
	}
		
	public void excluir(Administrador administrador) throws SQLException{
		repositorioAdmin.excluir(administrador);
	}
		
	public Administrador autenticar(Administrador administrador) throws SQLException{
		return repositorioAdmin.autenticar(administrador);
	}
	public Administrador autenticar2(String login, String senha) throws SQLException{
		return repositorioAdmin.autenticar2(login, senha);
	}
	
	public Administrador procurar(int matricula)throws SQLException{
		return repositorioAdmin.procurar(matricula);
	}
}