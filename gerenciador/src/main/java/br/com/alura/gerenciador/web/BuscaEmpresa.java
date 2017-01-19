package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.DispatcherType;
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
//@WebServlet(urlPatterns="/busca")
//public class BuscaEmpresa extends HttpServlet{
public class BuscaEmpresa implements Tarefa {
	///**
	// * 
	// */
	//private static final long serialVersionUID = 1L;
	//Testando a concorrencia de recursos
	//String filtro = "";
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		String filtro = req.getParameter("filtro");
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> emps = empresaDAO.buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", emps);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
	
	//Modificacao para refatorar o codigo - nao e mais um servlet
	/*public BuscaEmpresa() {
	    System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}*/
	
	//Modificacao para refatorar o codigo - nao e mais um servlet
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp ) 
			                                          throws ServletException, IOException{
		PrintWriter wr = resp.getWriter();
		String filtro = req.getParameter("filtro");
		
		//Testando a concorrencia de recursos
		filtro = req.getParameter("filtro");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // tempo em milisegundos		
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> emps = empresaDAO.buscaPorSimilaridade(filtro);
		
		//Utilizando o writer para escrever a página
		wr.println("<html>");
		wr.println("<body>");
		wr.println("Resultado da Busca: ");
		wr.println("<ul>");
		for (Empresa empresa : emp){
			wr.println("<li>"+ empresa.getId() + ": " + empresa.getNome() +  "</li>" );
		}
		wr.println("</ul>");
		wr.println("</body>");
		wr.println("</html>");
		
		//Redirecionando do lado do servidor
		req.setAttribute("empresas", emps);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		requestDispatcher.forward(req, resp);
	}*/
	
	//Modificacao para refatorar o codigo - nao e mais um servlet
	/*@Override
	public void init() throws ServletException {
	    super.init();
	    System.out.println("Inicializando a Servlet " + this);
	}*/
	
	//Modificacao para refatorar o codigo - nao e mais um servlet
	/*@Override
	public void destroy() {
	    super.destroy();
	    System.out.println("Destruindo a Servlet " + this);
	}*/
}