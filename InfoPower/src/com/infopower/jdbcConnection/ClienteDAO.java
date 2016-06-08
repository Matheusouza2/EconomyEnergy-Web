package com.infopower.jdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;

public class ClienteDAO implements InterfaceCliente{

	Connection con = (Connection) Conexao.getInstacia().getConector();
	List<Cliente> lista = new ArrayList<Cliente>();

	
	public void cadastrar(Cliente cliente, Endereco endereco) throws SQLException{
		String sql = "INSERT INTO CLIENTE (nome, login, senha, telefone, cpf_cliente, logradouro, numero, bairro, cidade, cep, estado, pais) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		//System.out.println(cliente.getBairro()+""+cliente.getCidade()+"\n"+endereco.getBairro()+""+endereco.getCidade());
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone());
			preparador.setString(5, cliente.getCpf());
			preparador.setString(6, endereco.getLogradouro());
			preparador.setInt(7, endereco.getNumero());
			preparador.setString(8, endereco.getBairro());
			preparador.setString(9, endereco.getCidade());
			preparador.setString(10, endereco.getCep());
			preparador.setString(11, endereco.getEstado());
			preparador.setString(12, endereco.getPais());
			preparador.execute();
			preparador.close();
	}

	public void alterar(Cliente cliente, Endereco endereco) throws SQLException{
		String sql = "UPDATE CLIENTE SET  nome=?, login=?, senha=?, telefone=?, cpf_cliente=?, logradouro=?, numero=?, bairro=?, cidade=?, cep=?, estado=?, pais=? WHERE id_cliente=?";

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone());
			preparador.setString(5, cliente.getCpf());
			preparador.setString(6, endereco.getLogradouro());
			preparador.setInt(7, endereco.getNumero());
			preparador.setString(8, endereco.getBairro());
			preparador.setString(9, endereco.getCidade());
			preparador.setString(10, endereco.getCep());
			preparador.setString(11, endereco.getEstado());
			preparador.setString(12, endereco.getPais());
			preparador.setInt(13, cliente.getId());

			preparador.execute();
			preparador.close();
	}

	public void excluir(Cliente cliente) throws SQLException{
		String sql = "DELETE FROM CLIENTE WHERE id_cliente=?";

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());

			preparador.execute();
			preparador.close();

	}

	public List<Cliente> listar() throws SQLException{
		String sql = "SELECT * FROM CLIENTE";
		List<Cliente> clientes = new ArrayList<Cliente>();

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getString("telefone"));
				cliente.setBairro(resultado.getString("bairro"));
				cliente.setLogradouro(resultado.getString("logradouro"));
				cliente.setNumero(resultado.getInt("numero"));
				cliente.setCidade(resultado.getString("cidade"));
				cliente.setCep(resultado.getString("cep"));
				cliente.setEstado(resultado.getString("estado"));
				cliente.setPais(resultado.getString("pais"));
				cliente.setCpf(resultado.getString("cpf_cliente"));
				clientes.add(cliente);
			}
			preparador.close();

			return clientes;
	}

	public Cliente procurar(Integer id) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE ID_CLIENTE=?";
		Cliente cliente = null;
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();
			
			resultado.next();
			
			cliente = new Cliente();
			cliente.setId(resultado.getInt("id_cliente"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setLogin(resultado.getString("login"));
			cliente.setSenha(resultado.getString("senha"));
			cliente.setTelefone(resultado.getString("telefone"));
			cliente.setBairro(resultado.getString("bairro"));
			cliente.setLogradouro(resultado.getString("logradouro"));
			cliente.setNumero(resultado.getInt("numero"));
			cliente.setCidade(resultado.getString("cidade"));
			cliente.setCep(resultado.getString("cep"));
			cliente.setEstado(resultado.getString("estado"));
			cliente.setPais(resultado.getString("pais"));
			cliente.setCpf(resultado.getString("cpf_cliente"));
			resultado.close();
			
		return cliente;
	}

	public List<Cliente> procurarNome(String nome) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE nome like";
		List<Cliente> lista = new ArrayList<Cliente>();
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%" + nome + "%");

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				cliente.setTelefone(resultado.getString("telefone"));
				lista.add(cliente);
			}

		return lista;
	}
	
	public Cliente autenticar(Cliente cliente) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE login=? and senha=?";
		Cliente clienteRetorno = null;
		
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getLogin());
			preparador.setString(2, cliente.getSenha());

			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) {
				clienteRetorno = new Cliente();

				clienteRetorno.setId(resultado.getInt("id_cliente"));
				clienteRetorno.setNome(resultado.getString("nome"));
				clienteRetorno.setLogin(resultado.getString("login"));
				clienteRetorno.setSenha(resultado.getString("senha"));
				clienteRetorno.setTelefone(resultado.getString("telefone"));

			}
			
		return clienteRetorno;
	}

	public Boolean autenticarExiste(Cliente cliente) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE login=?";
		boolean existe = false;

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getLogin());
			
			ResultSet resultado = preparador.executeQuery();
			existe = resultado.next();

		return existe;
	}
	
	public Boolean existe(Cliente cliente) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE id_cliente=?";
		boolean existe = false;

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, cliente.getId());

			ResultSet resultado = preparador.executeQuery();
			existe = resultado.next();
		
		return existe;
	}

	@Override
	public boolean enderecoExiste(Endereco endereco) throws SQLException{
		String sql = "SELECT * FROM CLIENTE";
		List<Cliente> clientes = new ArrayList<Cliente>();
		boolean existe = false;

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Cliente clienteConfirma = new Cliente();
				clienteConfirma.setBairro(resultado.getString("bairro"));
				clienteConfirma.setLogradouro(resultado.getString("logradouro"));
				clienteConfirma.setNumero(resultado.getInt("numero"));
				clienteConfirma.setCidade(resultado.getString("cidade"));
				clienteConfirma.setEstado(resultado.getString("estado"));
				clienteConfirma.setPais(resultado.getString("pais"));
				clientes.add(clienteConfirma);
			}
			preparador.close();
			
			for (Cliente cliente2 : clientes) {
				String bairro = cliente2.getBairro().replace(" ", "");
				String logradouro = cliente2.getLogradouro().replace(" ", "");
				int numero = cliente2.getNumero();
				String cidade = cliente2.getCidade().replace(" ", "");
				String estado = cliente2.getEstado().replace(" ", "");
				String pais = cliente2.getPais().replace(" ", "");
			
				if(bairro.equals(endereco.getBairro().replace(" ", ""))&&
						logradouro.equals(endereco.getLogradouro().replace(" ", ""))&&
						numero == endereco.getNumero()&&
						cidade.equals(endereco.getCidade().replace(" ", ""))&&
						estado.equals(endereco.getEstado().replace(" ", ""))&&
						pais.equals(endereco.getPais().replace(" ", ""))){
					existe = true;
				}
			}
		return existe;	
	}
}