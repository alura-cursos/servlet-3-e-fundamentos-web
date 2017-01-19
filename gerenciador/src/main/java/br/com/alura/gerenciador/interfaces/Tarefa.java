package br.com.alura.gerenciador.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	String executa(HttpServletRequest req, HttpServletResponse res);
}
