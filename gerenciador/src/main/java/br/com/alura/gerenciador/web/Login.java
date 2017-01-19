package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import br.com.alura.gerenciador.interfaces.Tarefa;

//Modificacao para refatorar o codigo
//@WebServlet(urlPatterns="/login")
//public class Login extends HttpServlet {
public class Login implements Tarefa{


	//Modificacao para refatorar o codigo
	///**
	// * 
	// */
	//private static final long serialVersionUID = 1L;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if (usuario == null ) {
			return "/WEB-INF/paginas/ErrorLogin.html";
		} else{
			//Implementação utilizando sessão
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "/WEB-INF/paginas/SucessLogin.html";
		}
	}
	

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String email = req.getParameter("email");
			String senha = req.getParameter("senha");
			PrintWriter writer = resp.getWriter();
			Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
			if (usuario == null ) {
				writer.println("<html><body>Senha invalida: " + email +"</body></html>");
			} else{
                //Implementação utilizando somente o cookie
				Cookie cookie = new Cookie("usuarioLogado", email);
				resp.addCookie(cookie);
				writer.println("<html><body>Usuario logado: " + usuario.getEmail() + "</body></html>");
				//Implementação utilizando sessão
				HttpSession session = req.getSession();
				session.setAttribute("usuarioLogado", usuario);
				writer.println("<html><body>Usuario logado: " + usuario.getEmail() + "</body></html>");
			}
	}*/
}