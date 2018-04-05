package br.controller.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.SistemasPlanetarios;

public class ExcluirSistema implements Action, Serializable {
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ArrayList<SistemasPlanetarios> s = (ArrayList<SistemasPlanetarios>)request.getSession().getAttribute("listasp");
		
		if (s.isEmpty()) {			
			request.getSession().setAttribute("listasp", null);
		} else {	
		for (int i = 0; i < s.size(); i++) {
				if(s.get(i).getId() == id) {
				 s.remove(i);
				}
			}
			request.getSession().setAttribute("listasp", s);
		

		}
		
		return "excluido.jsp";
	}

}
