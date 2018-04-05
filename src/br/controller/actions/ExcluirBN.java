package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.BuracosNegros;

public class ExcluirBN implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ArrayList<BuracosNegros> b = (ArrayList<BuracosNegros>)request.getSession().getAttribute("listabn");
		if (b.isEmpty()) {			
			request.getSession().setAttribute("listabn", null);
		} else {	
		for (int i = 0; i < b.size(); i++) {
				if(b.get(i).getId() == id) {
				 b.remove(i);
				}
			}
			request.getSession().setAttribute("listasp", b);
		

		}
		
		
		return "excluido.jsp";
	}

}
