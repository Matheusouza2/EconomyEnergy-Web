package com.infopower.servlets;

import java.io.IOException;
import java.sql.SQLException;

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
import com.infopower.exception.ClienteExisteException;
import com.infopower.exception.CpfExistenteException;
import com.infopower.exception.EnderecoExistenteException;
import com.infopower.jdbcConnection.ClienteDAO;

@WebServlet("/ClienteServlet")
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroClienteServlet() {
        super();
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		ClienteDAO clienteDao = new ClienteDAO();
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession sessao = httpServletRequest.getSession();
		if(acao != null && acao.equals("exc")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Cliente cliente = new Cliente();
			cliente.setId(id);
			try {
				clienteDao.excluir(cliente);
			} catch (SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/listaCliente.jsp");
			}
			
			sessao.setAttribute("mensagem", "sucesso-excluir");
			response.sendRedirect("JSP/listaCliente.jsp");
		}
		if(acao != null && acao.equals("alt")){
			
			String id = request.getParameter("id");
			
			Cliente cliente = new Cliente();
			try {
				cliente = clienteDao.procurar(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/atualizarCliente.jsp");
			}
			request.setAttribute("cliente", cliente);
			RequestDispatcher saida = request.getRequestDispatcher("JSP/atualizarCliente.jsp");
			saida.forward(request, response);
				
		}
		
		
		
	}//Fim do metodo doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession sessao = httpServletRequest.getSession();
		
		if(acao != null && acao.equals("salv")){
			
			String nome = request.getParameter("nomeUser");
			String login = request.getParameter("loginUser");
			String senha = Criptografia.criptografar(request.getParameter("senhaUser"));
			String telefone = request.getParameter("telefoneUser");
			String logradouro = request.getParameter("enderecoUser");
			int numero = Integer.parseInt(request.getParameter("numeroUser"));
			String bairro = request.getParameter("bairroUser");
			String cep = request.getParameter("cepUser");
			//int cep = Integer.parseInt(txtCnpj.getText().replaceAll("[./-]",""));
			String cidade = request.getParameter("cidadeUser");
			String estado = request.getParameter("estadoUser");
			String pais = request.getParameter("paisUser");
			String cpf = request.getParameter("cpfUser");
			
			//cria objeto usuario e endereco seta os valores vindos da tela
			Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, cep, estado, pais);
			Cliente cliente = new Cliente(nome, cpf, login, senha, endereco, telefone);
			
			//instancia o controlador 
			ControladorCliente clienteControler = new ControladorCliente();
			
				try {
					//pede pro controlador cadastrar no banco
					clienteControler.cadastar(cliente,endereco);
					sessao.setAttribute("mensagem", "sucesso");
					response.sendRedirect("JSP/cadastroCliente.jsp");
				} catch (ClienteExisteException e) {
					sessao.setAttribute("mensagem", "erro-cadastro");
					response.sendRedirect("JSP/cadastroCliente.jsp");
				}catch (EnderecoExistenteException e) {
					sessao.setAttribute("mensagem", "erro-endereço");
					response.sendRedirect("JSP/cadastroCliente.jsp");
				}catch (CpfExistenteException e) {
					sessao.setAttribute("mensagem", "erro-cpf");
					response.sendRedirect("JSP/cadastroCliente.jsp");
				}catch (SQLException e) {
					sessao.setAttribute("mensagem", "erro-banco");
					sessao.setAttribute("erro", e.getMessage());
					response.sendRedirect("JSP/cadastroCliente.jsp");
				}
				request.setAttribute("cliente", cliente);
				}//fim do if cadastrar
		
		if(acao != null && acao.equals("alt")){
			
			int id = Integer.parseInt(request.getParameter("id_cliente"));
			String nome = request.getParameter("nomeUser");
			String login = request.getParameter("loginUser");
			String senha = Criptografia.criptografar(request.getParameter("senhaUser"));
			String telefone = request.getParameter("telefoneUser");
			String logradouro = request.getParameter("enderecoUser");
			int numero = Integer.parseInt(request.getParameter("numeroUser"));
			String bairro = request.getParameter("bairroUser");
			String cep = request.getParameter("cepUser");
			String cidade = request.getParameter("cidadeUser");
			String estado = request.getParameter("estadoUser");
			String pais = request.getParameter("paisUser");
			String cpf = request.getParameter("cpfUser");
			
			//cria objeto usuario e endereco seta os valores vindos da tela
			Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, cep, estado, pais);
			Cliente cliente = new Cliente(nome, cpf, login, senha, endereco, telefone);
			cliente.setId(id);
			//pede para ControladorCliente cadastrar no banco de dados
			
			ControladorCliente clienteControler = new ControladorCliente();
			try {
				clienteControler.alterar(cliente, endereco);
				sessao.setAttribute("mensagem", "sucesso-atualiza");
				response.sendRedirect("JSP/listaCliente.jsp");
			} catch (SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/atualizaCliente.jsp");
			}
			
			
		}
	}//fim do metodo doPost 
}//Fim da classe