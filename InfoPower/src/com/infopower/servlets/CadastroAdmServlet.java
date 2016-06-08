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

import com.infopower.controladores.ControladorAdmin;
import com.infopower.criptografia.Criptografia;
import com.infopower.entidades.Administrador;
import com.infopower.entidades.Endereco;
import com.infopower.exception.AdministradorExistenteException;
import com.infopower.jdbcConnection.AdministradorDAO;

@WebServlet("/admControle")
public class CadastroAdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CadastroAdmServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		AdministradorDAO adminDao = new AdministradorDAO();
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession sessao = httpServletRequest.getSession();
		if(acao != null && acao.equals("exc")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Administrador admin = new Administrador();
			admin.setMatricula(id);
			try {
				adminDao.excluir(admin);
				sessao.setAttribute("mensagem", "sucesso");
				response.sendRedirect("JSP/listaAdmin.jsp");
			} catch (SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/listaAdmin.jsp");
			}
			
		}
		if(acao != null && acao.equals("alt")){
			
			String id = request.getParameter("id");
			
			Administrador admin = new Administrador();
			try {
				admin = adminDao.procurar(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/atualizarAdministrador.jsp");
			}
			request.setAttribute("admin", admin);
			RequestDispatcher saida = request.getRequestDispatcher("JSP/atualizarAdministrador.jsp");
			saida.forward(request, response);
				
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//recebe dados da tela
			String nome = request.getParameter("nomeAdm");
			String login = request.getParameter("loginAdm");
			String senha = Criptografia.criptografar(request.getParameter("senhaAdm"));
			String telefone = request.getParameter("telefoneAdm");
			String logradouro = request.getParameter("enderecoAdm");
			String bairro = request.getParameter("bairroAdm");
			int numero = Integer.parseInt(request.getParameter("numeroAdm"));
			String cep = request.getParameter("cepAdm");
			String cidade = request.getParameter("cidadeAdm");
			String estado = request.getParameter("estadoAdm");
			String pais = request.getParameter("paisAdm");
			
			//cria objeto usuario e endereço seta os valores vindos da tela
			Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, cep, estado, pais);
			Administrador adm = new Administrador(nome, login, senha, endereco, telefone);
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession sessao = httpServletRequest.getSession();
	
			//pede para controlador cadastrar no banco de dados
			ControladorAdmin controladorAdmin = new ControladorAdmin();
			
			try {
				controladorAdmin.cadastrar(adm,endereco);
				sessao.setAttribute("mensagem", "sucesso");
				response.sendRedirect("JSP/cadastroAdmin.jsp");
			} catch (AdministradorExistenteException e) {
				sessao.setAttribute("mensagem", "erro");
				response.sendRedirect("JSP/cadastroAdmin.jsp");
			} catch (SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/cadastroAdmin.jsp");
			}	
		}	
}