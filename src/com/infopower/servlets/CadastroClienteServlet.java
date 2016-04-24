package com.infopower.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infopower.controladores.ControladorCliente;
import com.infopower.criptografia.Criptografia;
import com.infopower.entidades.Cliente;
import com.infopower.entidades.Endereco;

@WebServlet("/ClienteServlet")
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroClienteServlet() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebe dados da tela
		String nome = request.getParameter("nomeUser");
		String login = request.getParameter("loginUser");
		String senha = Criptografia.criptografar(request.getParameter("senhaUser"));
		String telefone = request.getParameter("telefoneUser");
		String logradouro = request.getParameter("enderecoUser");
		int numero = Integer.parseInt(request.getParameter("numeroUser"));
		String bairro = request.getParameter("bairroUser");
		int cep = Integer.parseInt(request.getParameter("cepUser"));
		String cidade = request.getParameter("cidadeUser");
		String estado = request.getParameter("estadoUser");
		String pais = request.getParameter("paisUser");
		String cpf = request.getParameter("cpfUser");
		
		//cria objeto usuario e endereco seta os valores vindos da tela
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, cep, estado, pais);
		Cliente cliente = new Cliente(nome, cpf, login, senha, endereco, telefone);
	
		//pede para ControladorCliente cadastrar no banco de dados
		
		ControladorCliente clienteControler = new ControladorCliente();
		clienteControler.cadastar(cliente,endereco);
		
	      String site = new String("JSP/adminLogado.jsp");

	      response.setStatus(response.SC_MOVED_TEMPORARILY);
	      response.setHeader("Location", site);  
	}
}