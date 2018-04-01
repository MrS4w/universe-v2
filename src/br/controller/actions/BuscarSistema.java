package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.SistemasPlanetarios;

public class BuscarSistema implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String buscasp = request.getParameter("txtsistema");
		ArrayList<SistemasPlanetarios> sis = (ArrayList<SistemasPlanetarios>) request.getSession()
				.getAttribute("listasp");
if(sis==null) {
			
		}else {
		
		int encontrado = 0;
		for (int i = 0; i < sis.size(); i++) {
			if (buscasp.equals(sis.get(i).getNome())) {
				encontrado = 1;
				String nome = sis.get(i).getNome();
				String pos = sis.get(i).getPosicao();
				double dimen = sis.get(i).getDimensao();
				String cons = sis.get(i).getConstelacao();
				SistemasPlanetarios sp = new SistemasPlanetarios();
				sp.setNome(nome);
				sp.setPosicao(pos);
				sp.setDimensao(dimen);
				sp.setConstelacao(cons);
				request.getSession().setAttribute("sistemaencontrado", sp);
			}
			}
		}
		return "encontrarsistema.jsp";
	}
}