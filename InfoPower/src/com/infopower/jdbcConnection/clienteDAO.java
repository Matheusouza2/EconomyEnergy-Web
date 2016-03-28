package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.infopower.entidades.Cliente;

public class clienteDAO implements InterfaceCliente{

	Connection con = connection.getConnection();
	List<Cliente> lista = new ArrayList<Cliente>();

	public void cadastrar(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE (nome, login, senha, telefone, cpf_cliente) values (?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone());
			preparador.setInt(5, cliente.getCpf());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String sql2 = "INSERT INTO ENDERECO (logradouro, numero, bairro, cidade, cep, estado, pais) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql2);
			preparador.setString(1, cliente.getLogradouro());
			preparador.setInt(2, cliente.getNumero());
			preparador.setString(3, cliente.getBairro());
			preparador.setString(4, cliente.getCidade());
			preparador.setInt(5, cliente.getCep());
			preparador.setString(6, cliente.getEstado());
			preparador.setString(7, cliente.getPais());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com SUCESSO!");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Não foi possível salvar no banco!"+ e);
		}
	}

	public void alterar(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET id_pessoa=?, nome=?, endereco=?, login=?, senha=?, telefone=?, cpf_cliente=? WHERE id_pessoa=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());
			preparador.setString(2, cliente.getNome());
			preparador.setString(3, cliente.getEnd().getLogradouro());
			preparador.setString(4, cliente.getLogin());
			preparador.setString(5, cliente.getSenha());
			preparador.setString(6, cliente.getTelefone());
			preparador.setInt(7, cliente.getCpf());
			preparador.setInt(8, cliente.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Alterado com SUCESSO!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void excluir(Cliente cliente) {
		String sql = "DELETE FROM CLIENTE WHERE id_cliente=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Apagado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Cliente> listar() {
		String sql = "SELECT * FROM CLIENTE";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getString("telefone"));
				clientes.add(cliente);
			}

			preparador.close();

			System.out.println("Lista Apresentada");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return clientes;
	}

	public Cliente procurar(Integer id) {
		String sql = "SELECT * FROM Cliente WHERE ID=?";
		Cliente cliente = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();
			cliente = new Cliente();
			cliente.setId(resultado.getInt("id"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setLogin(resultado.getString("login"));
			cliente.setSenha(resultado.getString("senha"));
			cliente.setTelefone(resultado.getString("telefone"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	public List<Cliente> procurarNome(String nome) {
		String sql = "SELECT * FROM Cliente WHERE nome like";
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + nome + "%");

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getString("telefone"));
				lista.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public Cliente autenticar(Cliente cliente) {
		String sql = "SELECT * FROM Cliente WHERE login=? and senha=?";
		Cliente clienteRetorno = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getLogin());
			preparador.setString(2, cliente.getSenha());

			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				clienteRetorno = new Cliente();

				clienteRetorno.setId(resultado.getInt("id"));
				clienteRetorno.setNome(resultado.getString("nome"));
				clienteRetorno.setLogin(resultado.getString("login"));
				clienteRetorno.setSenha(resultado.getString("senha"));
				clienteRetorno.setTelefone(resultado.getString("telefone"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clienteRetorno;
	}

	public Boolean autenticarExiste(Cliente cliente) {
		String sql = "SELECT * FROM Cliente WHERE login=? and senha=?";
		boolean existe = false;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getLogin());
			preparador.setString(2, cliente.getSenha());

			ResultSet resultado = preparador.executeQuery();
			existe = resultado.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

}
