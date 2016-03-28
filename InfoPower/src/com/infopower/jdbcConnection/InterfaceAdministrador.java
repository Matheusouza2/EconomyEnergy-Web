package com.infopower.jdbcConnection;

import java.util.List;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Cliente;

public interface InterfaceAdministrador {
	
	public void cadastrar (Administrador administrador);
	public void alterar (Administrador administrador);
	public void excluir (Administrador administrador);
	public List<Administrador> listar();
	public Administrador procurar(Integer id);
	public List<Administrador> procurarNome(String nome);
	public Administrador autenticar(Administrador administrador);
	public Boolean autenticarExiste(Administrador administrador);

}
