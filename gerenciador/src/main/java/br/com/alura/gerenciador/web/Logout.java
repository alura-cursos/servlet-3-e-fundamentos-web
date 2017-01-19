package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.interfaces.Tarefa;

//Modificacao para refatorar o codigo
//@WebServlet(urlPatterns="/logout")
//public class Logout extends HttpServlet {
public class Logout implements Tarefa{
	///**
	// * 
	// */
	//private static final long serialVersionUID = 1L;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		//Logout utilizando a session
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		return "WEB-INF/paginas/logout.html";
	}
    
	//Metodo comentado pois nao a classe nao herda de HttpServlet
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Logout utilizando o cookie
		Cookie cookie = new Cookies(req.getCookies()).buscarUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if (cookie == null){
			writer.println("<html><body>Usuário não estava logado!</html></body>");
		} else{
			
			//Rescrevendo o cookie no browser
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			writer.println("<html><body>Usuário deslogado com sucesso!</html></body>");
			//Logout utilizando a session
		}
		//Logout utilizando a session
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		
		//Utilizando o writer para escrever a página
		//PrintWriter writer = resp.getWriter();
		//writer.println("<html><body>Usuário deslogado com sucesso!</html></body>");
		
		//Apenas redirecionando do lado do cliente
		//resp.sendRedirect("logout.html");
		
		//Apenas redirecionando do lado do servidor
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		requestDispatcher.forward(req, resp);
	}*/
}