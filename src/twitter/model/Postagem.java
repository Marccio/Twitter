package twitter.model;

import java.util.Date;

public class Postagem {
	String texto;
	Date dataEhora;
	String imagem;
	Usuario usuario;
	
	public Postagem() {
	}
	
	public Postagem(String texto, Date dataEhora, String imagem, Usuario usuario) {
		this.texto = texto;
		this.dataEhora = dataEhora;
		this.imagem = imagem;
		this.usuario = usuario;
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

	public Date getDataEhora() {
		return dataEhora;
	}

	public void setDataEhora(Date dataEhora) {
		this.dataEhora = dataEhora;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}
