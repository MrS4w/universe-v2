package br.model.mb;

import java.io.Serializable;

import javax.inject.Inject;

import br.model.Star;
import br.model.service.StarService;

public class CadastroStarMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Star star = new Star();
	private Long idStar;
	@Inject
	private StarService starService;

	public void inicializar() {
		if (idStar != null) {
			star = starService.porId(idStar);
		}
	}

	public String salvar() {
		starService.salvar(star);
		return "list-star.xhtml?faces-redirect=true";
	}

	public String excluir() {
		starService.excluir(star);
		return "list-star.xhtml?faces-redirect=true";
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Long getIdStar() {
		return idStar;
	}

	public void setIdStar(Long idStar) {
		this.idStar = idStar;
	}

}
