package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.interfaces.Tarefa;


/**
 * Servlet implementation class Controller - Pegar todas as requisicoes e redirecionar
 */
@WebServlet(description = "Servlet resposável pegar todas as requisições", urlPatterns = { "/executa" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//tarefa e o nome da classe no pacote web
			//Qual Tarefa?
			//Para tnde redirecionar?
			// URI /Controller?tarefa=<nomedaclasse>
			String tarefa = request.getParameter("tarefa");
			if(tarefa == null){
				throw new IllegalArgumentException("Acao nao foi passada!");
			}
			String classeNome = "br.com.alura.gerenciador.web." + tarefa;
			Class<?> tipo =  Class.forName(classeNome);
			Tarefa instancia = (Tarefa)tipo.newInstance();
			String pagina = instancia.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			throw new ServletException();
		} catch (InstantiationException e) {
			throw new ServletException();
		} catch (IllegalAccessException e) {
			throw new ServletException();
		}
	}
}