package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.BuracosNegros;

public class BuscarBN implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String buscabn = request.getParameter("txtbn");
		ArrayList<BuracosNegros> listabn2 = (ArrayList<BuracosNegros>) request.getSession().getAttribute("listabn");
		if(listabn2==null) {
			
		}else {
		
		int encontrado = 0;
		for (int i = 0; i < listabn2.size(); i++) {
			if (buscabn.equals(listabn2.get(i).getNome())) {
				encontrado = 1;
				String nome = listabn2.get(i).getNome();
				double vol = listabn2.get(i).getVolume();
				String pos = listabn2.get(i).getPosicao();
				double vel = listabn2.get(i).getVelocidade();
				BuracosNegros bn = new BuracosNegros();
				bn.setNome(nome);
				bn.setVolume(vol);
				bn.setPosicao(pos);
				bn.setVelocidade(vel);
				request.getSession().setAttribute("bnencontrado", bn);
			}
			}
		}

		return "encontrarbn.jsp";
	}

}
