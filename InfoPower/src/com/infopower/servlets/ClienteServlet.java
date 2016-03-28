package com.infopower.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;
import com.infopower.jdbcConnection.clienteDAO;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteServlet() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		clienteDAO clienteDao = new clienteDAO();
		List<Cliente> lista = clienteDao.listar();
		//coloca o request na lista
		req.setAttribute("lista", lista);
		//encaminha a lista pra a pagina jsp
		RequestDispatcher saida = req.getRequestDispatcher("JSP/listaCliente.jsp");
		saida.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebe dados da tela
		String nome = request.getParameter("nomeUser");
		String login = request.getParameter("loginUser");
		String senha = request.getParameter("senhaUser");
		String telefone = request.getParameter("telefoneUser");
		String logradouro = request.getParameter("enderecoUser");
		String bairro = request.getParameter("bairroUser");
		String cep = request.getParameter("cepUser");
		String estado = request.getParameter("estadoUser");
		String pais = request.getParameter("paisUser");
		
		//cria objeto usuario e seta os valores vindos da tela
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setTelefone(telefone);
		cliente.setLogradouro(logradouro);
		cliente.setBairro(bairro);
		cliente.setCep(Integer.parseInt(cep));
		cliente.setEstado(estado);
		cliente.setPais(pais);
		
		//pede para clienteDao cadastrar no banco de dados
		
		clienteDAO clienteDao = new clienteDAO();
		clienteDao.cadastrar(cliente);
		
		//PrintWriter saida = response.getWriter();
		//saida.print("Cadastrado!");
		
		// Set response content type
	      response.setContentType("text/html");

	      // New location to be redirected
	      String site = new String("JSP/admLogado.jsp");

	      response.setStatus(response.SC_MOVED_TEMPORARILY);
	      response.setHeader("Location", site);  
	}
	

}
