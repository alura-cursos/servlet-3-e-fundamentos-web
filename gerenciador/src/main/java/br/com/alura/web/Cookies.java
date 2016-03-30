package br.com.alura.web;

import javax.servlet.http.Cookie;

public class Cookies {

	Cookie[] cookies = null;
	
	public Cookies (Cookie[] cookies){
		this.cookies = cookies;
	}
	
	public Cookie getUsuarioLogado() {

		if (cookies == null)
			return null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}

		return null;
	}
}
