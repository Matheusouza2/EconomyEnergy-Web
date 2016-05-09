package com.infopower.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.relatorio.GeradorDeRelatorios;

@WebServlet("/GerarFaturaServlet")
public class GerarFaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GerarFaturaServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gera relatório
        GeradorDeRelatorios gerador = new GeradorDeRelatorios();
        gerador.geraPdf();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
