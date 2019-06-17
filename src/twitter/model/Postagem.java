package twitter.model;

import java.util.Date;

public class Postagem {
	int id;
	String texto;
	String dataEhora;
	String imagem;
	Usuario usuario;
	
	public Postagem() {
	}
	
	public Postagem(int id, String texto, String dataEhora, String imagem, Usuario usuario) {
		this.id = id;
		this.texto = texto;
		this.dataEhora = dataEhora;
		this.imagem = imagem;
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getDataEhora() {
		return dataEhora;
	}

	public void setDataEhora(String dataEhora) {
		this.dataEhora = dataEhora;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}
