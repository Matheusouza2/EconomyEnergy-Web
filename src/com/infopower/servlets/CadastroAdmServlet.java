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

import com.infopower.controladores.ControladorAdmin;
import com.infopower.criptografia.Criptografia;
import com.infopower.entidades.Administrador;
import com.infopower.entidades.Endereco;


@WebServlet("/admControle")
public class CadastroAdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CadastroAdmServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			int cep = Integer.parseInt(request.getParameter("cepAdm"));
			String cidade = request.getParameter("cidadeAdm");
			String estado = request.getParameter("estadoAdm");
			String pais = request.getParameter("paisAdm");
			
			//cria objeto usuario e endereço seta os valores vindos da tela
			Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, cep, estado, pais);
			Administrador adm = new Administrador(nome, login, senha, endereco, telefone);
			
			//pede para controlador cadastrar no banco de dados
			ControladorAdmin controladorAdmin = new ControladorAdmin();
			controladorAdmin.cadastrar(adm,endereco);
			
			response.setContentType("text/html");
		      // grava no banco e retorna pra pagina de admin logado
			 response.sendRedirect("JSP/adminLogado.jsp"); 
		

		}
	

}
