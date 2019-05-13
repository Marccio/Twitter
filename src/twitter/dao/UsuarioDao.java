package twitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import twitter.model.Usuario;

public class UsuarioDao {
	
	Usuario usuario = new Usuario();
	Connection conexao;
	
	public void cadastrar(Usuario usuario) {
		
		
		String sql = "INSERT INTO usuario(nome, senha, seguidores) VALUES (?,?,?)";
		
		try(PreparedStatement ps = this.conexao.prepareStatement(sql)){
			ps.setString(1,usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setArray(3, usuario.getSeguindo());// SLA O Q FAZER
			
			ps.execute();
			ps.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
