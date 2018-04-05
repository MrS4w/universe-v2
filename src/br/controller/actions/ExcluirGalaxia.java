package br.controller.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Galaxias;

public class ExcluirGalaxia implements Action, Serializable {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Galaxias> g = (ArrayList<Galaxias>)request.getSession().getAttribute("listagal");
		if (g.isEmpty()) {			
			request.getSession().setAttribute("listagal", null);
		} else {	
		for (int i = 0; i < g.size(); i++) {
				if(g.get(i).getId() == id) {
				 g.remove(i);
				}
			}
			request.getSession().setAttribute("listagal", g);
		

		}
		
		return "excluido.jsp";
	}

}
