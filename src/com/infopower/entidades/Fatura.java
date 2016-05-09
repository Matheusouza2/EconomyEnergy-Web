package com.infopower.entidades;
import java.util.Date;

public class Fatura {
	private int id;
	private Date data;
	private double consumoKw;
	private double consumoRs;
	private double consumoDia;
	private double consumoMes;
	
	public Fatura(){
		
	}
	
	public Fatura(int id, Date data, double consumoKw,
			double consumoRs, double consumoDia, double consumoMes) {

		this.id = id;
		this.data = data;
		this.consumoKw = consumoKw;
		this.consumoRs = consumoRs;
		this.consumoDia = consumoDia;
		this.consumoMes = consumoMes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public double getConsumoKw() {
		return consumoKw;
	}
	public void setConsumoKw(double consumoKw) {
		this.consumoKw = consumoKw;
	}
	public double getConsumoRs() {
		return consumoRs;
	}
	public void setConsumoRs(double consumoRs) {
		this.consumoRs = consumoRs;
	}
	public double getConsumoDia() {
		return consumoDia;
	}
	public void setConsumoDia(double consumoDia) {
		this.consumoDia = consumoDia;
	}
	public double getConsumoMes() {
		return consumoMes;
	}
	public void setConsumoMes(double consumoMes) {
		this.consumoMes = consumoMes;
	}
}
