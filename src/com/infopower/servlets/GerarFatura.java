package com.infopower.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infopower.entidades.Fatura;
import com.infopower.jdbcConnection.Conexao;
import com.infopower.jdbcConnection.faturaDAO;
import com.infopower.relatorio.GeradorDeRelatorios;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/GerarFatura")
public class GerarFatura extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GerarFatura() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GerarPDF(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Você pode chamar esse método no DoGet ou DoPost!
	 public void GerarPDF(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 

	try{
		
		System.out.println("Gerando relatório 2...");
		Fatura fatura = new Fatura();
		faturaDAO faturaDAO = new faturaDAO();
		List<Fatura> lista = faturaDAO.listar();
		fatura = lista.get(0);
		
		JREmptyDataSource jed = new JREmptyDataSource();
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		//passa os valores da fatura para Ireport
		parametros.put("idFatura", fatura.getId());
		parametros.put("dataFatura", fatura.getData());
		parametros.put("consumoDia", fatura.getConsumoDia());
		parametros.put("consumoMes", fatura.getConsumoMes());
		parametros.put("consumoKw", fatura.getConsumoKw());
		parametros.put("consumoReal", fatura.getConsumoRs());
	
	  String pathJasper = getServletContext().getRealPath("relatorios/relatorio.jasper");


	  try {
	   // Aqui ele cria o relatório
	   JasperPrint impressao = JasperFillManager.fillReport(pathJasper + "", parametros, jed);
	   // Grava o relatório em disco em pdf 
	   //JasperManager.printReportToPdfFile(impressao, path + "Relatorio.pdf");
	   // Redireciona para o pdf gerado
	   //response.sendRedirect("relatorio.pdf");
	  
	  } catch (Exception e) {
	   response.getWriter().println("Erro ao gerar o relatório :"+ e);
	   
	  }

	  }catch(Exception e){
	   System.out.println("Erro: "+ e);
	  }

	}
	 


}
