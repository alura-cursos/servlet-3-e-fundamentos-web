package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import br.com.alura.gerenciador.interfaces.Tarefa;
//Modificacao para refatorar o codigo
//@WebServlet(urlPatterns="/novaEmpresa")
//public class NovaEmpresa extends HttpServlet {
public class NovaEmpresa implements Tarefa{
	///**
	// * 
	// */
	//private static final long serialVersionUID = 1L;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		String nomeEmpresa = req.getParameter("nomeEmp");
		Empresa empresa = new Empresa(nomeEmpresa );
		new EmpresaDAO().adiciona(empresa);
		req.setAttribute("empresa", empresa); // poderia passar nomeEmpresa e pegaria no EL ${empresa}
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
	
	//Metodo comentado pois nao a classe nao herda de HttpServlet
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String nomeEmpresa = req.getParameter("nomeEmp");
			Empresa empresa = new Empresa(nomeEmpresa );
			new EmpresaDAO().adiciona(empresa);
			//Utilizando o writer para escrever a página
			//PrintWriter print = resp.getWriter();
			//print.println("<html><body><li>Empresa Adiconada com sucesso: " + nomeEmpresa+ "</li></body></html>");
			
			//Apenas redirecionando do lado do servidor
			req.setAttribute("empresa", empresa); // poderia passar nomeEmpresa e pegaria no EL ${empresa}
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
			requestDispatcher.forward(req, resp);
	}*/
}