package br.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.model.Star;

public class StarDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public Star salvar(Star star) {
		return manager.merge(star);
	}

	public void excluir(Star star) {
		try {
			star = porId(star.getId());
			manager.remove(star);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Star porId(Long id) {
		return manager.find(Star.class, id);
	}

	public List<Star> listAll() {
		return manager.createNativeQuery("SELECT * FOM Star", Star.class).getResultList();
	}
}
