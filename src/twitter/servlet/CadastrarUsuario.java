package twitter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.model.Usuario;
import twitter.service.UsuarioService;
import twitter.util.Criptografia;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/CadastrarUsuario.do")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		UsuarioService userService = new UsuarioService();
		
		try {
			user.setNome(nome);
			user.setNickname(nickname);
			user.setTelefone(telefone);
			user.setEmail(email);
			user.setSenha(senha);
			
			int idAuto = userService.cadastrar(user);
			Usuario userTeste = userService.consultar2(idAuto);
			
			if(idAuto == userTeste.getId()) {
				response.sendRedirect("login.jsp?cadastro=true");
			} else {
				response.sendRedirect("login.jsp?cadastro=true");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
