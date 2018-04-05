package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Estrelas;

public class Estrela implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		double vol = Double.parseDouble(request.getParameter("volume"));
		String pos = request.getParameter("posicao");
		int visivel = Integer.parseInt(request.getParameter("group1"));
		
		Estrelas estrela = new Estrelas();
		estrela.setNome(nome);
		estrela.setVolume(vol);
		estrela.setPosicao(pos);
		if (visivel == 1) {
			estrela.setVisivel(true);
		} else {
			estrela.setVisivel(false);
		}
		
		request.setAttribute("nome", estrela.getNome());
		request.setAttribute("volume", estrela.getVolume());
		request.setAttribute("posicao", estrela.getPosicao());
		request.setAttribute("visivel", estrela.isVisivel());
		request.setAttribute("id", estrela.getId());
		
		ArrayList<Estrelas> lista = (ArrayList<Estrelas>) request.getSession().getAttribute("lista");
		
		if (lista == null) {
			lista = new ArrayList<Estrelas>();
			estrela.setId(lista.size()+1);
			lista.add(estrela);
			request.getSession().setAttribute("obj", estrela);
			request.getSession().setAttribute("lista", lista);
		} else {
			estrela.setId(lista.size()+1);
			lista.add(estrela);
			request.getSession().setAttribute("obj", estrela);
			request.getSession().setAttribute("lista", lista);
		}

		return "inserido.jsp";
	}

}
