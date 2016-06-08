package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;

public class AdministradorDAO implements InterfaceAdministrador {
	
	private Connection con = (Connection) Conexao.getInstacia().getConector();
	PreparedStatement preparador = null;
	List<Cliente> lista = new ArrayList<Cliente>();

	@Override
	public void cadastrar(Administrador administrador, Endereco endereco)throws SQLException{
		
		String sql = "INSERT INTO ADMINISTRADOR (nome, login, senha, telefone, logradouro, numero, bairro, cidade, cep, estado, pais) values (?,?,?,?,?,?,?,?,?,?,?)";
			
			preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getNome());
			preparador.setString(2, administrador.getLogin());
			preparador.setString(3, administrador.getSenha());
			preparador.setString(4, administrador.getTelefone());
			preparador.setString(5, endereco.getLogradouro());
			preparador.setInt(6, endereco.getNumero());
			preparador.setString(7, endereco.getBairro());
			preparador.setString(8, endereco.getCidade());
			preparador.setString(9, endereco.getCep());
			preparador.setString(10, endereco.getEstado());
			preparador.setString(11, endereco.getPais());
			preparador.execute();
			preparador.close();
}

	public void alterar(Administrador administrador) throws SQLException{
		String sql = "UPDATE ADMINISTRADOR SET id_admin=?, nome=?, endereco=?, login=?, senha=?, telefone=?, cpf_cliente=? WHERE id_pessoa=?";
		
			preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getNome());
			preparador.setString(2, administrador.getEnd().getLogradouro());
			preparador.setString(3, administrador.getLogin());
			preparador.setString(4, administrador.getSenha());
			preparador.setString(5, administrador.getTelefone());

			preparador.close();
	}

	@Override
	public void excluir(Administrador administrador) throws SQLException{
		String sql = "DELETE FROM ADMINISTRADOR WHERE matricula=?";

			preparador = con.prepareStatement(sql);
			preparador.setInt(1, administrador.getMatricula());

			preparador.execute();
			preparador.close();
	}

	@Override
	public List<Administrador> listar() throws SQLException{
		String sql = "SELECT * FROM ADMINISTRADOR";
		List<Administrador> listaAdministrador = new ArrayList<Administrador>();

			preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Administrador administrador = new Administrador();
				administrador.setMatricula(resultado.getInt("matricula"));
				administrador.setNome(resultado.getString("nome"));
				administrador.setLogin(resultado.getString("login"));
				administrador.setSenha(resultado.getString("senha"));
				administrador.setTelefone(resultado.getString("telefone"));
				administrador.setBairro(resultado.getString("bairro"));
				administrador.setLogradouro(resultado.getString("logradouro"));
				administrador.setNumero(resultado.getInt("numero"));
				administrador.setCidade(resultado.getString("cidade"));
				administrador.setCep(resultado.getString("cep"));
				administrador.setEstado(resultado.getString("estado"));
				administrador.setPais(resultado.getString("pais"));
				
				listaAdministrador.add(administrador);
			}

			preparador.close();

			return listaAdministrador;
	}

	@Override
	public Administrador procurar(Integer id) throws SQLException{
		String sql = "SELECT * FROM Administrador WHERE matricula=?";
		Administrador admin = null;
	
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();
			
			resultado.next();
			
			admin = new Administrador();
			admin.setMatricula(resultado.getInt("matricula"));
			admin.setNome(resultado.getString("nome"));
			admin.setLogin(resultado.getString("login"));
			admin.setSenha(resultado.getString("senha"));
			admin.setTelefone(resultado.getString("telefone"));
			admin.setBairro(resultado.getString("bairro"));
			admin.setLogradouro(resultado.getString("logradouro"));
			admin.setNumero(resultado.getInt("numero"));
			admin.setCidade(resultado.getString("cidade"));
			admin.setCep(resultado.getString("cep"));
			admin.setEstado(resultado.getString("estado"));
			admin.setPais(resultado.getString("pais"));	
			resultado.close();

		return admin;
	}

	@Override
	public List<Administrador> procurarNome(String nome) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE nome like";
		List<Administrador> lista = new ArrayList<Administrador>();

			preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + nome + "%");

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Administrador admin = new Administrador();

				admin.setNome(resultado.getString("nome"));
				admin.setLogin(resultado.getString("login"));
				admin.setSenha(resultado.getString("senha"));
				admin.setTelefone(resultado.getString("telefone"));
				lista.add(admin);
			}

		return lista;
	}

	@Override
	public Administrador autenticar(Administrador administrador) throws SQLException{
		String sql = "SELECT * FROM ADMINISTRADOR WHERE login=? and senha=?";
		Administrador adminRetorno = null;
		
			preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getLogin());
			preparador.setString(2, administrador.getSenha());

			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				adminRetorno = new Administrador();
				adminRetorno.setLogin(resultado.getString("login"));
				adminRetorno.setSenha(resultado.getString("senha"));

			}else{
				System.out.println("Login ou senha errado!");
				adminRetorno = null;
			}

		return adminRetorno;
	}

	@Override
	public Boolean autenticarExiste(Administrador administrador) throws SQLException{
		String sql = "SELECT * FROM ADMINISTRADOR WHERE login=?";
		boolean existe = false;

			preparador = con.prepareStatement(sql);
			preparador.setString(1, administrador.getLogin());
	
			ResultSet resultado = preparador.executeQuery();
			existe = resultado.next();
		
		return existe;
	}
	
	@Override
	public Administrador autenticar2(String login, String senha) throws SQLException{
		
		String sql = "SELECT * FROM ADMINISTRADOR WHERE login=? and senha=?";
		Administrador adminRetorno = null;
		
			preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, senha);

			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				adminRetorno = new Administrador();
				adminRetorno.setLogin(login);
				adminRetorno.setSenha(senha);
				adminRetorno.setNome(resultado.getString("nome"));

			}else{
				System.out.println("Login ou senha errado!");
				adminRetorno = null;
			}

		return adminRetorno;
		
	}
}