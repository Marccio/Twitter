package twitter.model;

import java.util.ArrayList;

public class Usuario {

	String nome, senha;
	ArrayList<Usuario> seguindo = new ArrayList<>();
	
	public Usuario() {
	}
	
	public Usuario(String nome, String senha, ArrayList<Usuario> seguindo) {
		this.nome = nome;
		this.senha = senha;
		this.seguindo = seguindo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Usuario> getSeguindo() {
		return seguindo;
	}

	public void setSeguindo(ArrayList<Usuario> seguindo) {
		this.seguindo = seguindo;
	}
	
	
}
