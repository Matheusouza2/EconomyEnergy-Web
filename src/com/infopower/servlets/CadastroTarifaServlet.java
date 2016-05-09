package com.infopower.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.entidades.Administrador;
import com.infopower.entidades.Tarifa;
import com.infopower.jdbcConnection.AdministradorDAO;
import com.infopower.jdbcConnection.TarifaDAO;

@WebServlet("/TarifaControle")
public class CadastroTarifaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public CadastroTarifaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			// recebe dados da tela
			String nome = request.getParameter("nomeTarifa");
			String valor = request.getParameter("valorTarifa");

			// cria objeto usuario e seta os valores vindos da tela

			Tarifa tarifa = new Tarifa();
			tarifa.setNome(nome);
			tarifa.setValor(Double.parseDouble(valor));
			
			// pede para clienteDao cadastrar no banco de dados

			TarifaDAO tarifaDao = new TarifaDAO();
			tarifaDao.cadastrar(tarifa);

			response.setContentType("text/html");
			// New location to be redirected
			String site = new String("JSP/cadastroTarifa.jsp");

			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		
	}
}