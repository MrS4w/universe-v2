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
		String c = request.getParameter("const");
		SistemasPlanetarios sp = new SistemasPlanetarios();
		sp.setNome(nome);
		sp.setPosicao(pos);
		sp.setDimensao(dimensao);
		sp.setConstelacao(c);
		
		request.setAttribute("nome", sp.getNome());
		request.setAttribute("pos", sp.getPosicao());
		request.setAttribute("dimensao", sp.getDimensao());
		request.setAttribute("const", sp.getConstelacao());
		request.setAttribute("id", sp.getId());
		
ArrayList<SistemasPlanetarios> listasp = (ArrayList<SistemasPlanetarios>) request.getSession().getAttribute("listasp");
		
		if (listasp == null) {
			listasp = new ArrayList<SistemasPlanetarios>();
			sp.setId(listasp.size()+1);
			listasp.add(sp);
			request.getSession().setAttribute("listasp", listasp);
		} else {
			sp.setId(listasp.size()+1);
			listasp.add(sp);
			request.getSession().setAttribute("listasp", listasp);
		}
		
		return "inserido.jsp";
	}

}
