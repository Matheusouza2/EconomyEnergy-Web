//Classe filha de usuario
package com.infopower.entidades;

public class Cliente extends Usuario{

	public Cliente(String nome, String login, String senha, int telefone) {
		//Utilização da herança
		super(nome,login,senha,telefone);
	}

	private int id;
	private int cpf;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
}
