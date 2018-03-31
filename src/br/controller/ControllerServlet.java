package br.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("action");
		String nomeDaClasse = "br.controller.actions." + param;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);

			Action action = (Action) classe.newInstance();

			String pagina = action.run(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);

		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("404.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
