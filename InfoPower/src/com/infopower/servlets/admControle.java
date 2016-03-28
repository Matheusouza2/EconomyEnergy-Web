package com.infopower.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Cliente;
import com.infopower.jdbcConnection.adminstradorDAO;
import com.infopower.jdbcConnection.clienteDAO;

@WebServlet("/admControle")
public class admControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public admControle() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		adminstradorDAO AdmDao = new adminstradorDAO();
		List<Administrador> lista = AdmDao.listar();
		//coloca o request na lista
		request.setAttribute("lista", lista);
		//encaminha a lista pra a pagina jsp
		RequestDispatcher saida = request.getRequestDispatcher("JSP/listaAdministrador.jsp");
		saida.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("cadastro"); 
		if ( operacao.equals("salvar")){
			
			//recebe dados da tela
			String nome = request.getParameter("nomeAdm");
			String login = request.getParameter("loginAdm");
			String senha = request.getParameter("senhaAdm");
			String telefone = request.getParameter("telefoneAdm");
			String logradouro = request.getParameter("enderecoAdm");
			String bairro = request.getParameter("bairroAdm");
			String cep = request.getParameter("cepAdm");
			String estado = request.getParameter("estadoAdm");
			String pais = request.getParameter("paisAdm");
			
			//cria objeto usuario e seta os valores vindos da tela
			
			Administrador adm = new Administrador();
			adm.setNome(nome);
			adm.setLogin(login);
			adm.setSenha(senha);
			adm.setTelefone(telefone);
			adm.setLogradouro(logradouro);
			adm.setBairro(bairro);
			adm.setCep(Integer.parseInt(cep));
			adm.setEstado(estado);
			adm.setPais(pais);
			
			//pede para clienteDao cadastrar no banco de dados
			
			adminstradorDAO admDao = new adminstradorDAO();
			admDao.cadastrar(adm);
			
			response.setContentType("text/html");
		      // New location to be redirected
		      String site = new String("JSP/admLogado.jsp");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}
		if ( operacao.equals("cadastrar")){
			response.setContentType("text/html");

		      // New location to be redirected
		      String site = new String("HTML/administrador.html");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}
		if ( operacao.equals("cadastrarCliente")){
			response.setContentType("text/html");

		      // New location to be redirected
		      String site = new String("JSP/cadastroCliente.jsp");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}
		if ( operacao.equals("listarCliente")){
			response.setContentType("text/html");

		      // New location to be redirected
		      String site = new String("/InfoPower/ClienteServlet");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}if ( operacao.equals("listarAdm")){
			response.setContentType("text/html");

		      // New location to be redirected
		      String site = new String("/InfoPower/admControle");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}
		if ( operacao.equals("cadastrarTarifa")){
			response.setContentType("text/html");

		      // New location to be redirected
		      String site = new String("HTML/cadastroTarifa.html");

		      response.setStatus(response.SC_MOVED_TEMPORARILY);
		      response.setHeader("Location", site);  
			
		}

		}
	

}
