package br.controller.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;
import br.model.SistemasPlanetarios;

public class Sistema implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String pos = request.getParameter("posicao");
		double dimensao = Double.parseDouble(request.getParameter("dimen"));
		String constelacao = request.getParameter("const");
		
		SistemasPlanetarios sp = new SistemasPlanetarios();
		sp.setNome(nome);
		sp.setPosicao(pos);
		sp.setDimensao(dimensao);
		sp.setConstelacao(constelacao);
		
		request.setAttribute("nome", sp.getNome());
		request.setAttribute("posicao", sp.getPosicao());
		request.setAttribute("dimensao", sp.getDimensao());
		request.setAttribute("constelacao", sp.getConstelacao());
		
ArrayList<SistemasPlanetarios> listasp = (ArrayList<SistemasPlanetarios>) request.getSession().getAttribute("listasp");
		
		if (listasp == null) {
			listasp = new ArrayList<SistemasPlanetarios>();
			listasp.add(sp);
			request.getSession().setAttribute("listasp", listasp);
		} else {
			listasp.add(sp);
			request.getSession().setAttribute("listasp", listasp);
		}
		
		
		return "inserido.jsp";
	}

}
