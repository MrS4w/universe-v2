package br.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.model.Star;
import br.model.dao.StarDAO;
import br.model.util.Transacional;

public class StarService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private StarDAO starDAO;

	@Transacional
	public void salvar(Star star) {
		starDAO.salvar(star);
	}

	@Transacional
	public void excluir(Star star) {
		starDAO.excluir(star);
	}

	public List<Star> listAll() {
		return starDAO.listAll();
	}

	public Star porId(Long id) {
		return starDAO.porId(id);
	}
}
