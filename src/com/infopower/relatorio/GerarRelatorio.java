package com.infopower.relatorio;


import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import com.infopower.entidades.Fatura;
import com.infopower.jdbcConnection.faturaDAO;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
public class GerarRelatorio {
	
	public void GerarRelatorio(){
		
	}
	
	
public void gerarRelatorio(Fatura relatorio) throws JRException, SQLException{

		
		System.out.println("Gerando relatório...");
		faturaDAO faturaDAO = new faturaDAO();
		relatorio = (Fatura) faturaDAO.listar();
		
		JREmptyDataSource jed = new JREmptyDataSource();
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("idFatura", relatorio.getId());
		parametros.put("dataFatura", relatorio.getData());
		parametros.put("consumoDia", relatorio.getConsumoDia());
		parametros.put("consumoMes", relatorio.getConsumoMes());
		parametros.put("consumoKw", relatorio.getConsumoKw());
		parametros.put("consumoReal", relatorio.getConsumoRs());
		
		JasperPrint jp = JasperFillManager.fillReport("relatorio/reportex.jasper", parametros,jed);
		
		JRViewer jr = new JRViewer(jp);
		JasperExportManager.exportReportToPdfFile("relatorio/reportex.pdf");
		
		/*
		JasperReport pathjrxml = JasperCompileManager.compileReport("relatorio/reportex.jrxml");
		JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(listaFatura));
		JasperExportManager.exportReportToPdfFile(printReport, "relatorio/reportex.pdf");
		System.out.println("Relatorio gerado" + listaFatura);
		*/
		
		
	}
}
