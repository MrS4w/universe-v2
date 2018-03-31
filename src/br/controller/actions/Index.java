package br.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.controller.Action;

public class Index implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "index.jsp";
	}

}
