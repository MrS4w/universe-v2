package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.Galaxias;

public class BuscarGalaxia implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String buscag = request.getParameter("txtgalaxia");
		ArrayList<Galaxias> gal = (ArrayList<Galaxias>) request.getSession().getAttribute("listagal");
if(gal==null) {
			
		}else {
		
		int encontrado = 0;
		for (int i = 0; i < gal.size(); i++) {
			if (buscag.equals(gal.get(i).getNome())) {
				encontrado = 1;
				String nome = gal.get(i).getNome();
				String pos = gal.get(i).getPosicao();
				double dimen = gal.get(i).getDimensao();
				int qtd = gal.get(i).getQuantidade();
				Galaxias g = new Galaxias();
				g.setNome(nome);
				g.setPosicao(pos);
				g.setDimensao(dimen);
				g.setQuantidade(qtd);
				request.getSession().setAttribute("galaxiaencontrada", g);
			}
		}
		}
		return "encontrargalaxia.jsp";
	}

}
