package br.com.alura.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa{
	
	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
		
	}

}
