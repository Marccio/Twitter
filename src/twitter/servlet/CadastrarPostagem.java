package twitter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.model.Postagem;
import twitter.model.Usuario;
import twitter.service.PostagemService;
import twitter.service.UsuarioService;

/**
 * Servlet implementation class CadastrarPostagem
 */
@WebServlet("/CadastrarPostagem.do")
public class CadastrarPostagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPostagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("texto");
		String nickname = request.getParameter("nickname");
		
		PostagemService post = new PostagemService();
		Postagem postagem = new Postagem();
		
		UsuarioService user = new UsuarioService();
		
		try {
			Usuario usuario = new Usuario();
			postagem.setTexto(texto);
			postagem.setDataEhora("0000-00-00 00:00:00");
			usuario.setNickname(nickname);
			postagem.setUsuario(usuario);
			int id = post.cadastrar(postagem);
			
			System.out.println(id);
			
			if (id > -1) {
				response.sendRedirect("Feed.jsp?nickname="+nickname);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
