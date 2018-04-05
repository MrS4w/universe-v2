package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.BuracosNegros;
import br.model.Estrelas;

public class BuracoNegro implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		double vol = Double.parseDouble(request.getParameter("volume"));
		String pos = request.getParameter("posicao");
		double velocidade = Double.parseDouble(request.getParameter("velocidade"));
		
		BuracosNegros bn = new BuracosNegros();
		bn.setNome(nome);
		bn.setVolume(vol);
		bn.setPosicao(pos);
		bn.setVelocidade(velocidade);
		
		request.setAttribute("nome", bn.getNome());
		request.setAttribute("volume", bn.getVolume());
		request.setAttribute("posicao", bn.getPosicao());
		request.setAttribute("velocidade", bn.getVelocidade());
		request.setAttribute("id", bn.getId());
		
		ArrayList<BuracosNegros> listabn = (ArrayList<BuracosNegros>) request.getSession().getAttribute("listabn");
		
		if (listabn == null) {
			listabn = new ArrayList<BuracosNegros>();
			bn.setId(listabn.size()+1);
			listabn.add(bn);
			request.getSession().setAttribute("listabn", listabn);
		} else {
			bn.setId(listabn.size()+1);
			listabn.add(bn);
			request.getSession().setAttribute("listabn", listabn);
		}
		return "inserido.jsp";
	}

}
