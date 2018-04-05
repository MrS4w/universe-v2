package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Galaxias;

public class Galaxia implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String pos = request.getParameter("posicao");
		double dimensao = Double.parseDouble(request.getParameter("dimen"));
		int quantidade = Integer.parseInt(request.getParameter("qtd"));
		
		Galaxias galaxia = new Galaxias();
		galaxia.setNome(nome);
		galaxia.setPosicao(pos);
		galaxia.setDimensao(dimensao);
		galaxia.setQuantidade(quantidade);
		
		request.setAttribute("nome", galaxia.getNome());
		request.setAttribute("pos", galaxia.getPosicao());
		request.setAttribute("dimensao", galaxia.getDimensao());
		request.setAttribute("quantidade", galaxia.getQuantidade());
		request.setAttribute("id", galaxia.getId());
		
ArrayList<Galaxias> listagal = (ArrayList<Galaxias>) request.getSession().getAttribute("listagal");
		
		if (listagal == null) {
			listagal = new ArrayList<Galaxias>();
			galaxia.setId(listagal.size()+1);
			listagal.add(galaxia);
			request.getSession().setAttribute("listagal", listagal);
		} else {
			galaxia.setId(listagal.size()+1);
			listagal.add(galaxia);
			request.getSession().setAttribute("listagal", listagal);
		}
		
		return "inserido.jsp";
	}

}
