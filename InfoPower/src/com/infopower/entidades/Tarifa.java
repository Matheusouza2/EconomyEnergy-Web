package com.infopower.entidades;

public class Tarifa {

	private int id;
	private double valorKw;
	private double valorBandeiraVermelha;
	private double valorBandeiraAmarela;
	private double valorBandeiraVerde;
	
	public Tarifa(int id, double valorKw, double valorBandeiraVermelha, double valorBandeiraAmarela, 
			double valorBandeiraVerde) {
	
		this.id = id;
		this.valorKw = valorKw;
		this.valorBandeiraVermelha = valorBandeiraVermelha;
		this.valorBandeiraAmarela = valorBandeiraAmarela;
		this.valorBandeiraVerde = valorBandeiraVerde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorKw() {
		return valorKw;
	}

	public void setValorKw(double valorKw) {
		this.valorKw = valorKw;
	}

	public double getValorBandeiraVermelha() {
		return valorBandeiraVermelha;
	}

	public void setValorBandeiraVermelha(double valorBandeiraVermelha) {
		this.valorBandeiraVermelha = valorBandeiraVermelha;
	}

	public double getValorBandeiraAmarela() {
		return valorBandeiraAmarela;
	}

	public void setValorBandeiraAmarela(double valorBandeiraAmarela) {
		this.valorBandeiraAmarela = valorBandeiraAmarela;
	}

	public double getValorBandeiraVerde() {
		return valorBandeiraVerde;
	}

	public void setValorBandeiraVerde(double valorBandeiraVerde) {
		this.valorBandeiraVerde = valorBandeiraVerde;
	}
}
