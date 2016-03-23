package com.infopower.main;

import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.jdbcConnection.clienteDAO;

public class testeDAO {

	public static void main(String[] args) {
		// testeCadastrar();
		// testeAlterar();
		// testeExcluir();
		// testeListar();
		testeAutenticar();

	}

	private static void testeCadastrar() {
		Cliente cliente = new Cliente("", "", "", 0);
		cliente.setId(004);
		cliente.setCpf(89977666);
		cliente.setNome("Pedro Silva");
		cliente.setLogin("pesil");
		cliente.setSenha("5678");
		cliente.setTelefone(95544433);

		clienteDAO clientedao = new clienteDAO();
		clientedao.cadastrar(cliente);
	}

	private static void testeAlterar() {

		Cliente cliente = new Cliente("", "", "", 0);
		cliente.setId(002);
		cliente.setCpf(777777777);
		cliente.setNome("Mary kat");
		cliente.setLogin("mary");
		cliente.setSenha("mk5678");
		cliente.setTelefone(444444443);

		clienteDAO clientedao = new clienteDAO();
		clientedao.alterar(cliente);

	}

	private static void testeExcluir() {

		Cliente cliente = new Cliente("", "", "", 0);
		cliente.setId(004);

		clienteDAO clientedao = new clienteDAO();
		clientedao.excluir(cliente);

	}

	private static void testeListar() {

		clienteDAO clientedao = new clienteDAO();
		List<Cliente> lista = clientedao.listar();

		for (Cliente c : lista) {
			System.out.println("ID: " + c.getId() + " Nome: " + c.getNome() + "Login: " + c.getLogin() + "Senha: "
					+ c.getSenha() + "Telefone: " + c.getTelefone());
		}
	}

	public static void testeAutenticar() {
		Cliente cliente = new Cliente("", "", "", 0);
		cliente.setLogin("majo");
		cliente.setSenha("4321");

		clienteDAO clientedao = new clienteDAO();
		System.out.println(clientedao.autenticar(cliente));

	}

	public static void testeBuscar() {

		clienteDAO clientedao = new clienteDAO();

		Cliente clienteRetorno = clientedao.procurar(4);
		if (clienteRetorno != null) {
			System.out.println("nome: " + clienteRetorno.getNome());
		}

	}

}
