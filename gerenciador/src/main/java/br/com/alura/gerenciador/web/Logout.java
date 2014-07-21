package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}
}
