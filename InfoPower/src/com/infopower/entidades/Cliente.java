//Classe filha de usuario
package com.infopower.entidades;

public class Cliente extends Pessoa{

	public Cliente(String nome, String login, String senha, Endereco endereco, String telefone) {
		//Utilização da herança
		super(nome,login,senha,endereco,telefone);
	}
	public Cliente(){
		super();
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
