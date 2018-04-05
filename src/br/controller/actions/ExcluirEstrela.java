package br.controller.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Estrelas;

public class ExcluirEstrela implements Action, Serializable {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));	
		ArrayList<Estrelas> lista3 = (ArrayList<Estrelas>) request.getSession().getAttribute("lista");
		if (lista3.isEmpty()) {			
			request.getSession().setAttribute("lista", null);
		} else {	
		for (int i = 0; i < lista3.size(); i++) {
				if(lista3.get(i).getId() == id) {
				 lista3.remove(i);
				}
			}
			request.getSession().setAttribute("lista", lista3);
		

		}
		return "excluido.jsp";
	}
}