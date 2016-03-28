package com.infopower.main;

import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.jdbcConnection.clienteDAO;

public class testeDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		testeExcluir();
		//testeListar();
		//testeAutenticar();

	}

	private static void testeCadastrar() {
		Cliente cliente = new Cliente();
		cliente.setNome("pedro");
		cliente.setLogin("pe");
		cliente.setSenha("5678");
		cliente.setTelefone("555555");
		cliente.setCpf(8888888);
		cliente.setLogradouro("Rua dois");
		cliente.setNumero(23);
		cliente.setBairro("centro");
		cliente.setCidade("São Joaquim");
		cliente.setEstado("Pernambuco");
		cliente.setCep(55670000);
		cliente.setPais("Brasil");

		clienteDAO clientedao = new clienteDAO();
		clientedao.cadastrar(cliente);
	}

	private static void testeAlterar() {

		Cliente cliente = new Cliente();
		cliente.setId(001);
		cliente.setCpf(777777777);
		cliente.setNome("Mary kat");
		cliente.setId(cliente.getEnd().getId(001));
		cliente.setLogradouro(cliente.getLogradouro());
		cliente.setNumero(cliente.getNumero());
		cliente.setBairro(cliente.getBairro());
		cliente.setCidade(cliente.getCidade());
		cliente.setEstado(cliente.getEstado());
		cliente.setCep(cliente.getCep());
		cliente.setPais(cliente.getPais());
		cliente.setLogin("mary");
		cliente.setSenha("mk5678");
		cliente.setTelefone("444444443");

		clienteDAO clientedao = new clienteDAO();
		clientedao.alterar(cliente);

	}

	private static void testeExcluir() {

		Cliente cliente = new Cliente();
		cliente.setId(0);

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
		Cliente cliente = new Cliente();
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
