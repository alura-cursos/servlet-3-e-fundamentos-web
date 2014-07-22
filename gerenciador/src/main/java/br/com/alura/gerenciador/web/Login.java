package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa{
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		HttpSession session = req.getSession();
		if(usuario != null){
			session.setAttribute("usuarioLogado", usuario);
		}
		
		if(usuario == null){
			return "/WEB-INF/paginas/loginErro.jsp";
		}else{
			return "index.jsp";			
		}

	}
}
