package twitter.model;

import java.util.ArrayList;

public class Usuario {

	String nome, telefone, nickname, email, senha;

	public Usuario() {
	}
	
	public Usuario(String nome, String telefone, String nickname, String email, String senha) {
		this.nome = nome;
		this.telefone = telefone;
		this.nickname = nickname;
		this.email = email;
		this.senha = senha;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
