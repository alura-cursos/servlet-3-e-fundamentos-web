package br.com.alura.web;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	
	String nome = req.getParameter("nome");
	Empresa empresa = new Empresa(nome);
	new EmpresaDAO().adiciona(empresa);
	
	return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

}
