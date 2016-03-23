package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infopower.entidades.Cliente;

public class clienteDAO {

	Connection con = connection.getConnection();
	List<Cliente> lista = new ArrayList<Cliente>();

	public void cadastrar(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE (id, nome, login, senha, telefone) values (?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());
			preparador.setString(2, cliente.getNome());
			preparador.setString(3, cliente.getLogin());
			preparador.setString(4, cliente.getSenha());
			preparador.setInt(5, cliente.getTelefone());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void alterar(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET id=?, nome=?, login=?, senha=?, telefone=? WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());
			preparador.setString(2, cliente.getNome());
			preparador.setString(3, cliente.getLogin());
			preparador.setString(4, cliente.getSenha());
			preparador.setInt(5, cliente.getTelefone());
			preparador.setInt(6, cliente.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Alterado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void excluir(Cliente cliente) {
		String sql = "DELETE FROM CLIENTE WHERE id=?";

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

				Cliente cliente = new Cliente("", "", "", 0);
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getInt("telefone"));
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
			cliente = new Cliente("", "", "", 0);
			cliente.setId(resultado.getInt("id"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setLogin(resultado.getString("login"));
			cliente.setSenha(resultado.getString("senha"));
			cliente.setTelefone(resultado.getInt("telefone"));

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
				Cliente cliente = new Cliente("", "", "", 0);

				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getInt("telefone"));
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
				clienteRetorno = new Cliente("", "", "", 0);

				clienteRetorno.setId(resultado.getInt("id"));
				clienteRetorno.setNome(resultado.getString("nome"));
				clienteRetorno.setLogin(resultado.getString("login"));
				clienteRetorno.setSenha(resultado.getString("senha"));
				clienteRetorno.setTelefone(resultado.getInt("telefone"));

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
