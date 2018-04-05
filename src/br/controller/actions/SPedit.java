package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.SistemasPlanetarios;

public class SPedit implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String pos = request.getParameter("posicao");
		double dimensao = Double.parseDouble(request.getParameter("dimen"));
		String constelacao = request.getParameter("const");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		ArrayList<SistemasPlanetarios> listas=(ArrayList<SistemasPlanetarios>) request.getSession().getAttribute("listasp");
		if(listas.isEmpty()) {
			request.getSession().setAttribute("listasp", listas);
		}else {
			for(int i=0;i<listas.size();i++) {
				if(listas.get(i).getId()==id) {
					listas.get(i).setNome(request.getParameter("nome"));
					listas.get(i).setPosicao(request.getParameter("posicao"));
					listas.get(i).setDimensao(Double.parseDouble(request.getParameter("dimen")));
					listas.get(i).setConstelacao(request.getParameter("const"));
				}
			}
			request.getSession().setAttribute("listasp", listas);
		}
		
		return "listarsp.jsp";
	}

}
