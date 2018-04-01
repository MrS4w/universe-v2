package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Estrelas;

public class BuscarEstrela implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String busca = request.getParameter("txtestrela");

		ArrayList<Estrelas> lista2 = (ArrayList<Estrelas>) request.getSession().getAttribute("lista");

		
if(lista2==null) {
			
		}else {
		
			int encontrado = 0;
			for (int i = 0; i < lista2.size(); i++) {
				if (busca.equals(lista2.get(i).getNome())) {
					encontrado = 1;
					String nome = lista2.get(i).getNome();
					double vol = lista2.get(i).getVolume();
					String pos = lista2.get(i).getPosicao();
					boolean visivel = lista2.get(i).isVisivel();
					Estrelas e = new Estrelas();
					e.setNome(nome);
					e.setVolume(vol);
					e.setPosicao(pos);
					e.setVisivel(visivel);
					request.getSession().setAttribute("estrelaencontrada", e);
				}
			}
		}
		return "encontrarestrela.jsp";
	}

}
