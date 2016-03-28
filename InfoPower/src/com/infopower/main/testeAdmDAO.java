package com.infopower.main;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Cliente;
import com.infopower.jdbcConnection.adminstradorDAO;
import com.infopower.jdbcConnection.clienteDAO;

public class testeAdmDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testeCadastrar();
		testeExcluir();
		

	}
	private static void testeCadastrar() {
		Administrador adm = new Administrador();
		adm.setNome("maria");
		adm.setLogin("maria");
		adm.setSenha("123");
		adm.setTelefone("44444");
		adm.setLogradouro("Rua da silva");
		adm.setNumero(23);
		adm.setBairro("centro");
		adm.setCidade("Caruaru");
		adm.setEstado("Pernambuco");
		adm.setCep(55670000);
		adm.setPais("Brasil");

		adminstradorDAO admDAO = new adminstradorDAO();
		admDAO.cadastrar(adm);
	}
	private static void testeExcluir() {

		Administrador adm = new Administrador();
		adm.setId(0);

		adminstradorDAO admDAO = new adminstradorDAO();
		admDAO.excluir(adm);

	}

}
