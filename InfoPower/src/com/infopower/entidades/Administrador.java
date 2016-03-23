//Classe filha de usuario
package com.infopower.entidades;

public class Administrador extends Usuario{
	
//	declaraçãpo do contrutor
	public Administrador(String nome, String login, String senha, int telefone) {
		//uso da herança
		super(nome,login,senha,telefone);
	}
	private int matricula;

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
}
