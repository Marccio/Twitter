package twitter.service;

import java.util.ArrayList;

import twitter.dao.PostagemDao;
import twitter.model.Postagem;

public class PostagemService {

	PostagemDao postagemDao;
	
	public PostagemService() {
		this.postagemDao = new PostagemDao();
	}
	
	public int cadastrar(Postagem postagem) {
		return this.postagemDao.cadastrar(postagem);
	}
	
	public Postagem consultar(int id) {
		return this.postagemDao.consultar(id);
	}
	
	public void excluir(int id) {
		this.postagemDao.excluir(id);
	}
	
	public ArrayList<Postagem> listarPostagemSeguindo(String nickname){
		return this.postagemDao.listarPostagemSeguindo(nickname);
	}
	
	public ArrayList<Integer> listarIds(){
		return this.postagemDao.listarIds();
	}
	
	public ArrayList<Integer> listaPerfil(String nickname){
		return this.postagemDao.listaPerfil(nickname);
	}
}
