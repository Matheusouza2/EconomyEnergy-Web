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

import com.infopower.controladores.ControladorTarifa;
import com.infopower.entidades.Tarifa;
import com.infopower.exception.TarifaExistenteException;
import com.infopower.jdbcConnection.TarifaDAO;

@WebServlet("/TarifaControle")
public class CadastroTarifaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public CadastroTarifaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		TarifaDAO tarifaDao = new TarifaDAO();
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession sessao = httpServletRequest.getSession();
			if(acao != null && acao.equals("exc")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Tarifa tarifa = new Tarifa();
			tarifa.setIdTarifa(id);
			try {
				tarifaDao.excluir(tarifa);
			} catch (SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/listaTarifa.jsp");
			}
			sessao.setAttribute("mensagem", "sucesso-exc");
			response.sendRedirect("JSP/listaTarifa.jsp");
		}

		if(acao != null && acao.equals("alt")){
			
			String id = request.getParameter("id");
			
			Tarifa tarifa = new Tarifa();
			try {
				tarifa = tarifaDao.procurar(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				sessao.setAttribute("mensagem", "erro-banco");
				sessao.setAttribute("erro", e.getMessage());
				response.sendRedirect("JSP/atualizarTarifa.jsp");
			}
			request.setAttribute("tarifa", tarifa);
			RequestDispatcher saida = request.getRequestDispatcher("JSP/atualizarTarifa.jsp");
			saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String acao = request.getParameter("acao");
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession sessao = httpServletRequest.getSession();
			
			if(acao != null && acao.equals("salv")){
				// recebe dados da tela
				String nome = request.getParameter("nomeTarifa");
				String valor = request.getParameter("valorTarifa");
				double valorTarifa = Double.parseDouble(valor.replace(",", "."));	
				
				ControladorTarifa controladorTarifa = new ControladorTarifa();
				Tarifa tarifa = new Tarifa(nome, valorTarifa);
				
				try {
					controladorTarifa.cadastar(tarifa);
					sessao.setAttribute("mensagem", "sucesso");
					response.sendRedirect("JSP/cadastroTarifa.jsp");
				} catch (TarifaExistenteException e) {
					sessao.setAttribute("mensagem", "erro-existe");
					response.sendRedirect("JSP/cadastroTarifa.jsp");
				} catch (SQLException e) {
					sessao.setAttribute("mensagem", "erro-banco");
					sessao.setAttribute("erro", e.getMessage());
					response.sendRedirect("JSP/cadastroTarifa.jsp");
				}
			}
			if(acao != null && acao.equals("alt")){
				
				int id = Integer.parseInt(request.getParameter("id_tarifa"));
				String nome = request.getParameter("nome");
				double valor = Double.parseDouble(request.getParameter("valor"));
				
				//cria objeto usuario e endereco seta os valores vindos da tela
				Tarifa tarifa = new Tarifa(nome, valor);
				tarifa.setIdTarifa(id);
				//pede para ControladorCliente cadastrar no banco de dados
				
				ControladorTarifa tarifaControler = new ControladorTarifa();
				try {
					tarifaControler.alterar(tarifa);
				} catch (SQLException e) {
					sessao.setAttribute("mensagem", "erro-banco");
					sessao.setAttribute("erro", e.getMessage());
					response.sendRedirect("JSP/atualizarTarifa.jsp");
				}
				
				sessao.setAttribute("mensagem", "sucesso-alt");
				response.sendRedirect("JSP/listaTarifa.jsp");
			}
	}
}