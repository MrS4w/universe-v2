package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Estrelas;

public class EstrelaEdit implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id = Integer.parseInt(request.getParameter("id"));	
		String nome = request.getParameter("nome");
		double vol = Double.parseDouble(request.getParameter("volume"));
		String pos = request.getParameter("posicao");
		int visivel = Integer.parseInt(request.getParameter("group1"));
		
		ArrayList<Estrelas> lista2 = (ArrayList<Estrelas>) request.getSession().getAttribute("lista");

		if (lista2.isEmpty()) {			
			request.getSession().setAttribute("lista", lista2);
		} else {
			for (int i = 0; i < lista2.size(); i++) {
				if(lista2.get(i).getId() == id) {
					lista2.get(i).setNome(request.getParameter("nome"));
					lista2.get(i).setVolume(Double.parseDouble(request.getParameter("volume")));
					lista2.get(i).setPosicao(request.getParameter("posicao"));
					lista2.get(i).setVisivel(Integer.parseInt(request.getParameter("group1")) == 1);
				}
			}
			request.getSession().setAttribute("lista", lista2);
		}
		
		return "listarestrela.jsp";
	}

}
