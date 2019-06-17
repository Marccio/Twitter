package twitter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter.model.Usuario;
import twitter.service.UsuarioService;
import twitter.util.Criptografia;


/**
 * Servlet implementation class UsuarioLogin
 */
@WebServlet("/UsuarioLogin.do")
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLogin() {
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
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		System.out.println(email);

		Usuario user = new Usuario();
		UsuarioService userService = new UsuarioService();
		Criptografia cripto = new Criptografia();

		user.setEmail(email);
		Usuario userAutentica = userService.consultarLogin(email);

		if (request.getParameter("login") != null) {
			String login = request.getParameter("login");
			String teste = null;
			if (userAutentica != null) {
				boolean senhaCorreta = cripto.matching(userAutentica.getSenha(), senha);
				if (email.equals(userAutentica.getEmail()) && senhaCorreta == true) {
					HttpSession session = request.getSession();
					session.setAttribute("user", userAutentica);
					response.sendRedirect("index.jsp");
				} else {
					response.sendRedirect("pagLogin.html?senha=false");
				} 
			} else {
			response.sendRedirect("pagLogin.html?login=null");
			}
		} else {
			response.sendRedirect("pagLogin.html");
		}
	}
}
