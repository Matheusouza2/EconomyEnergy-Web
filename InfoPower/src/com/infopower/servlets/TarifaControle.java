package com.infopower.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Tarifa;
import com.infopower.jdbcConnection.adminstradorDAO;
import com.infopower.jdbcConnection.tarifaDAO;

@WebServlet("/TarifaControle")
public class TarifaControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public TarifaControle() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("cadastro");
		if (operacao.equals("salvar")) {

			// recebe dados da tela
			String nome = request.getParameter("nomeTarifa");
			String valor = request.getParameter("valorTarifa");

			// cria objeto usuario e seta os valores vindos da tela

			Tarifa tarifa = new Tarifa();
			tarifa.setNome(nome);
			tarifa.setValor(Double.parseDouble(valor));
			
			// pede para clienteDao cadastrar no banco de dados

			tarifaDAO tarifaDao = new tarifaDAO();
			tarifaDao.cadastrar(tarifa);

			response.setContentType("text/html");
			// New location to be redirected
			String site = new String("HTML/cadastroTarifa.html");

			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
	}

}
