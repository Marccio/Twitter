package twitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import twitter.model.Postagem;
import twitter.model.Usuario;

public class PostagemDao {
	
	Connection conexao;

	public PostagemDao() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public int cadastrar(Postagem postagem) {
		String sql = "INSERT INTO postagem(texto, dataEhora, imagem, usuario_nickname) VALUES (?, ?, ?, ?) ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, postagem.getTexto());
			ps.setString(2, postagem.getDataEhora());
			ps.setString(3, postagem.getImagem());
			ps.setString(4, postagem.getUsuario().getNickname());

			ps.execute();
			try (ResultSet rs = ps.getGeneratedKeys();) {
				if (rs.next()) {
					int idGerado = rs.getInt(1);
					return idGerado;
				} else {
					return -1;
				}
			} catch (SQLException e) {
				System.out.println(e.getStackTrace());
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getStackTrace());
			}
		}
		return -1;
	}

	public Postagem consultar(int id) {
		String sql = "SELECT texto, dataEhora, imagem, usuario_nickname FROM postagem WHERE id = ?";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Usuario u = new Usuario();
					Postagem a = new Postagem();
					a.setTexto(rs.getString("texto"));
					a.setDataEhora(rs.getString("dataEhora"));
					a.setImagem(rs.getString("imagem"));
					u.setNickname(rs.getString("usuario_nickname"));
					a.setUsuario(u);

					return a;
				} else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return null;
	}

	public void excluir(int id) {
		try {
			String sql = "DELETE FROM postagem WHERE id = ?";

			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Integer> listarPostagemSeguindo(String nickname) {
		String sqlSelect = "SELECT id FROM postagem AS p JOIN segue AS s \r\n" + 
				"WHERE p.usuario_nickname = s.segue_nickname AND s.seguido = ?";

		ArrayList<Integer> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, nickname);
			stm.execute();
			
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				lista.add(rs.getInt("id"));
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Integer> listarIds() {
		try {
			this.conexao = ConnectionFactory.conectar();
			
			String sql = "SELECT id FROM postagem ORDER BY id DESC";
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while(rs.next()) {
				lista.add(rs.getInt("id"));
			}
			
			return lista;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Integer> listaPerfil(String nickname){
		
		String sql = "SELECT id FROM postagem WHERE usuario_nickname=?";
		
		try {
			this.conexao = ConnectionFactory.conectar();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, nickname);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while(rs.next()) {
				lista.add(rs.getInt("id"));
			}
			return lista;
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
}
