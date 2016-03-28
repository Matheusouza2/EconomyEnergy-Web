package com.infopower.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infopower.entidades.Cliente;
import com.infopower.jdbcConnection.clienteDAO;

@WebServlet("/AutenticadorCliente")
public class AutenticadorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AutenticadorCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("user");
		String senha = request.getParameter("pass");
		Cliente cliente = new Cliente();
		cliente.setLogin(login);
		cliente.setSenha(senha);
		
		clienteDAO clienteDao = new clienteDAO();
		Cliente clienteRetorno = clienteDao.autenticar(cliente);
		
		if(clienteRetorno!=null){
			//criançao sessao
			HttpSession session =  request.getSession();
			session.setAttribute("clienteLogado", clienteRetorno);
			
			//encaminhando ao index
			request.getRequestDispatcher("JSP/Logado.jsp").forward(request, response);
		}else{
			response.sendRedirect("JSP/naoLogado.jsp");
		}
		
	}

}
