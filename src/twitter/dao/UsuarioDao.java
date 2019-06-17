package twitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import twitter.model.Usuario;

public class UsuarioDao {

	Connection conexao;

	public UsuarioDao() {
		try {
			this.conexao = ConnectionFactory.conectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public int cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome, telefone, nickname, email, senha) VALUES (?,?, ?, ?, ?) ";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getTelefone());
			ps.setString(3, usuario.getNickname());
			ps.setString(4, usuario.getEmail());
			ps.setString(5, usuario.getSenha());

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

	public Usuario consultar(String id) {
		String sql = "SELECT nome, telefone, nickname, email FROM usuario WHERE nickname = ?";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql);) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Usuario a = new Usuario();
					a.setNome(rs.getString("nome"));
					a.setTelefone(rs.getString("telefone"));
					a.setNickname(rs.getString("nickname"));
					a.setEmail(rs.getString("email"));

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
	
	public Usuario consultar2(int id) {
		String sql = "SELECT nome, telefone, nickname, email FROM usuario WHERE id = ?";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Usuario a = new Usuario();
					a.setNome(rs.getString("nome"));
					a.setTelefone(rs.getString("telefone"));
					a.setNickname(rs.getString("nickname"));
					a.setEmail(rs.getString("email"));

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
	
	public Usuario consultarLogin(String id) {
		String sql = "SELECT * FROM usuario WHERE email = ?";

		try (PreparedStatement ps = this.conexao.prepareStatement(sql);) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Usuario a = new Usuario();
					a.setId(rs.getInt(1));
					a.setNome(rs.getString(2));
					a.setTelefone(rs.getString(3));
					a.setNickname(rs.getString(4));
					a.setEmail(rs.getString(5));
					a.setSenha(rs.getString(6));

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

	public void excluir(String email) {
		try {
			String sql = "DELETE FROM usuario WHERE email = ?";

			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void alterar(Usuario novo) {
		try {
			String sql = "UPDATE usuario SET nome = ?, telefone = ?, nickname = ?, senha = ? WHERE email = ?";
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, novo.getNome());
			ps.setString(2, novo.getTelefone());
			ps.setString(3, novo.getNickname());
			ps.setString(4, novo.getSenha());
			ps.setString(5, novo.getEmail());

			ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Usuario> listarMeusSeguidores(String nickname) {
		String sqlSelect = "SELECT nickname FROM segue WHERE seguido = ?";

		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, nickname);
			stm.execute();
			
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Usuario a = new Usuario();
				a.setNickname(rs.getString(1));
				lista.add(a);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Usuario> listarQuemSigo(String nickname) {
		String sqlSelect = "SELECT nickname FROM segue WHERE segue = ?";

		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			this.conexao = ConnectionFactory.conectar();
			PreparedStatement stm = conexao.prepareStatement(sqlSelect);
			stm.setString(1, nickname);
			stm.execute();
			
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Usuario a = new Usuario();
				a.setNickname(rs.getString(1));
				lista.add(a);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
