package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.BuracosNegros;

public class BNedit implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));	
		String nome = request.getParameter("nome");
		double vol = Double.parseDouble(request.getParameter("volume"));
		String pos = request.getParameter("posicao");
		double vel = Double.parseDouble(request.getParameter("velocidade"));
		
		ArrayList<BuracosNegros> lista2 = (ArrayList<BuracosNegros>) request.getSession().getAttribute("listabn");

		if (lista2.isEmpty()) {			
			request.getSession().setAttribute("listabn", lista2);
		} else {
			for (int i = 0; i < lista2.size(); i++) {
				if(lista2.get(i).getId() == id) {
					lista2.get(i).setNome(request.getParameter("nome"));
					lista2.get(i).setVolume(Double.parseDouble(request.getParameter("volume")));
					lista2.get(i).setPosicao(request.getParameter("posicao"));
					lista2.get(i).setVelocidade(Double.parseDouble(request.getParameter("velocidade")));
				}
			}
			request.getSession().setAttribute("listabn", lista2);
		}
		return "listarbn.jsp";
	}

}
