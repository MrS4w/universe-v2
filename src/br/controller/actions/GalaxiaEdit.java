package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Galaxias;

public class GalaxiaEdit implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String pos = request.getParameter("posicao");
		double dimensao = Double.parseDouble(request.getParameter("dimen"));
		int quantidade = Integer.parseInt(request.getParameter("qtd"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Galaxias> listag = (ArrayList<Galaxias>) request.getSession().getAttribute("listagal");
		if(listag.isEmpty()) {
			request.getSession().setAttribute("listagal", listag);
		}else {
			for(int i=0;i<listag.size();i++) {
				if(listag.get(i).getId()==id) {
					listag.get(i).setNome(request.getParameter("nome"));
					listag.get(i).setPosicao(request.getParameter("posicao"));
					listag.get(i).setDimensao(Double.parseDouble(request.getParameter("dimen")));
					listag.get(i).setQuantidade(Integer.parseInt(request.getParameter("qtd")));
				}
			}
			request.getSession().setAttribute("listagal", listag);
		}
		
		return "listargalaxia.jsp";
	}

}
