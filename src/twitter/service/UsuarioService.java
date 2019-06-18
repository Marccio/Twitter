package twitter.service;

import java.util.ArrayList;

import twitter.dao.UsuarioDao;
import twitter.model.Usuario;

public class UsuarioService {

	UsuarioDao usuarioDao;
	
	public UsuarioService() {
		this.usuarioDao = new UsuarioDao();
	}
	
	public int cadastrar(Usuario usuario) {
		return this.usuarioDao.cadastrar(usuario);
	}
	
	public Usuario consultar(String id) {
		return this.usuarioDao.consultar(id);
	}
	
	public Usuario consultar2(int id) {
		return this.usuarioDao.consultar2(id);
	}
	
	public Usuario consultarLogin(String email) {
		return this.usuarioDao.consultarLogin(email);
	}
	
	public void excluir(String email) {
		this.usuarioDao.excluir(email);
	}
	
	public void alterar(Usuario novo) {
		this.usuarioDao.alterar(novo);
	}
	
	public ArrayList<Usuario> listarMeusSeguidores(String nickname){
		return this.usuarioDao.listarMeusSeguidores(nickname);
	}
	
	/*public ArrayList<Usuario> listarQuemSigo(String nickname){
		return this.usuarioDao.listarQuemSigo(nickname);
	}*/
	
}
