package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Cliente;

public class adminstradorDAO implements InterfaceAdministrador {
	
	Connection con = connection.getConnection();
	List<Cliente> lista = new ArrayList<Cliente>();

	@Override
	public void cadastrar(Administrador administrador) {
		
		String sql = "INSERT INTO ADMINISTRADOR (nome, login, senha, telefone) values (?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getNome());
			preparador.setString(2, administrador.getLogin());
			preparador.setString(3, administrador.getSenha());
			preparador.setString(4, administrador.getTelefone());
			preparador.execute();
			preparador.close();

			System.out.println("ADMINISTRADOR Cadastrado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String sql2 = "INSERT INTO ENDERECO (logradouro, numero, bairro, cidade, cep, estado, pais) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql2);
			preparador.setString(1, administrador.getLogradouro());
			preparador.setInt(2, administrador.getNumero());
			preparador.setString(3, administrador.getBairro());
			preparador.setString(4, administrador.getCidade());
			preparador.setInt(5, administrador.getCep());
			preparador.setString(6, administrador.getEstado());
			preparador.setString(7, administrador.getPais());
			preparador.execute();
			preparador.close();

			System.out.println("ENDERECO CADASTRADO com SUCESSO!");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Não foi possível salvar no banco!"+ e);
		}
		
	}

	@Override
	public void alterar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Administrador administrador) {
		String sql = "DELETE FROM ADMINISTRADOR WHERE matricula=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, administrador.getMatricula());

			preparador.execute();
			preparador.close();

			System.out.println("Apagado com SUCESSO!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Administrador> listar() {
		String sql = "SELECT * FROM ADMINISTRADOR";
		List<Administrador> listaAdministrador = new ArrayList<Administrador>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Administrador administrador = new Administrador();
				administrador.setMatricula(resultado.getInt("matricula"));
				administrador.setNome(resultado.getString("nome"));
				administrador.setLogin(resultado.getString("login"));
				administrador.setSenha(resultado.getString("senha"));
				administrador.setTelefone(resultado.getString("telefone"));
				listaAdministrador.add(administrador);
			}

			preparador.close();

			System.out.println("Lista Apresentada");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listaAdministrador;
	}

	@Override
	public Administrador procurar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> procurarNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador autenticar(Administrador administrador) {
		String sql = "SELECT * FROM ADMINISTRADOR WHERE login=? and senha=?";
		Administrador adminRetorno = null;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getLogin());
			preparador.setString(2, administrador.getSenha());

			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				adminRetorno = new Administrador();
				adminRetorno.setLogin(resultado.getString("login"));
				adminRetorno.setSenha(resultado.getString("senha"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adminRetorno;
	}

	@Override
	public Boolean autenticarExiste(Administrador administrador) {
		String sql = "SELECT * FROM Cliente WHERE login=? and senha=?";
		boolean existe = false;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getLogin());
			preparador.setString(2, administrador.getSenha());

			ResultSet resultado = preparador.executeQuery();
			existe = resultado.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

}
