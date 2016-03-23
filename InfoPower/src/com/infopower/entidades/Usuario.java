//Classe pai de Administrador e Cliente
package com.infopower.entidades;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private int telefone;
	
	public Usuario(String nome, String login, String senha, int telefone) {
	this.nome = nome;
	this.login = login;
	this.senha = senha;
	this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
