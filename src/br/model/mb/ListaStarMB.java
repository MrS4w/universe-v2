package br.model.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.model.Star;
import br.model.service.StarService;

@Named
@ViewScoped
public class ListaStarMB implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private StarService starService;
	private List<Star> stars = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		stars = starService.listAll();
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

}
