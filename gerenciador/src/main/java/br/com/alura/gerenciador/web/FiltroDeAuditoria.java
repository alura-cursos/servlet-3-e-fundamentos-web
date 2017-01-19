package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requisicao = (HttpServletRequest)req;
		HttpServletResponse resposta = (HttpServletResponse)resp;
		//Buscando usuário utilizando cookie
		//String usuario = getUsuarioCookie(requisicao, resposta);
		//Buscando usuário utilizando a session
		HttpSession session = requisicao.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String usuario = "<deslogado>";
		if(usuarioLogado != null){
			usuario = usuarioLogado.getEmail();
		}
		System.out.println("Usuario " + usuario + " acessando a URI - " + requisicao.getRequestURI());
		chain.doFilter(req, resp);
	}

	/**
	 * @param requisicao
	 * @return
	 */
	private String getUsuarioCookie(HttpServletRequest requisicao, HttpServletResponse resposta) {
		/*String usuario = "<deslogado>";
		Cookie[] cookies = requisicao.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies){
				if( cookie.getName().equals("usuario.logado")){
					cookie.setMaxAge(60); //Tempo em segundos
					// resp.addCookie(cookie); //Reescrevendo o cookie no browser
					usuario = cookie.getValue();
				}
			}
		}
		return usuario; */ //Código Reescrito para logout
		String retorno = "";
		Cookie cookie = new Cookies(requisicao.getCookies()).buscarUsuarioLogado();
		if (cookie == null){
			retorno = "<deslogado>";
		} else{
			//Atualizando o tempo do cookie após cada requisição
			cookie.setMaxAge(60); //Tempo em segundos
			resposta.addCookie(cookie);
			retorno = cookie.getValue();
		}
		
		return retorno;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
