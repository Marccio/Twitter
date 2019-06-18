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
@WebServlet("/Login.do")
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
		

		//Usuario user = new Usuario();
		UsuarioService userService = new UsuarioService();

		//user.setEmail(email);
		Usuario userAutentica = userService.consultarLogin(email);
		//System.out.println(userAutentica.getNickname());
		String login = request.getParameter("login");
		//System.out.println(login);
		
		if (request.getParameter("login") != null) {
			
			if (userAutentica != null) {
				if (email.equals(userAutentica.getEmail()) && senha.equals(userAutentica.getSenha())) {					
					HttpSession session = request.getSession();
					session.setAttribute("usuario", userAutentica);
					response.sendRedirect("Feed.jsp?nickname="+userAutentica.getNickname());
				} else {
					response.sendRedirect("login.html?senha=false");
					//System.out.println(login);
				} 
			} /*else {
			response.sendRedirect("login.html?login=null");
			System.out.println(login);
			}*/
		} else {
			 //response.sendRedirect("login.html");
			//System.out.println(login);
		}
	}
}