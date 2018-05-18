package br.controller;

import java.util.ArrayList;
import java.util.List;
import br.model.dao.Star;
import br.model.dao.StarDAO;

public class StarManagedBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String selectedID;
	private Star star;
	private List<Star> stars;

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	private String getselectedID() {
		return selectedID;
	}

	private void setMsg(String message) {
	}

	public void limparStar() {
		this.star.setName("");
		this.star.setPosition("");
		this.star.setVisible(false);
		this.star.setVolume(0);
	}

	public String editStar() {

		StarDAO starDAO = new StarDAO();
		Star star = starDAO.getStar(this.getselectedID());

		if (star != null) {
			this.star.setName(star.getName());
			this.star.setPosition(star.getPosition());
			this.star.setVisible(star.isVisible());
			this.star.setVolume(star.getVolume());
		} else {
			this.setMsg("Star nao encontrada!");
		}
		return "update";
	}

	public String createStar() {

		String str = "index";

		try {
			StarDAO starDAO = new StarDAO();
			starDAO.createStar(this.star);
			limparStar();
			this.setMsg("Star cadastrada!");
		} catch (Exception e) {
			this.setMsg(e.getMessage());
			str = "insert";
		}

		return str;
	}

	public String deleteStar() {

		String str = "index";

		try {
			StarDAO starDAO = new StarDAO();
			starDAO.deleteStar(this.getselectedID());

			limparStar();
			this.setMsg("Excluido com sucesso!");

		} catch (Exception e) {
			this.setMsg(e.getMessage());
		}

		return str;
	}

	public List<StarManagedBean> getListaStars() {
		limparStar();
		List<StarManagedBean> stars = new ArrayList<StarManagedBean>();
		try {
			StarDAO starDAO = new StarDAO();
			for (Star star : starDAO.listStars()) {
				StarManagedBean bean = new StarManagedBean();
				bean.setStar(star);
				stars.add(bean);
			}

		} catch (Exception e) {
			this.setMsg(e.getMessage());
		}

		return stars;
	}

	public String updateStar() {
		String str = "index";
		try {
			StarDAO starDAO = new StarDAO();
			starDAO.updateStar(this.star);

			limparStar();

			this.setMsg("Atualizado com sucesso!");
		} catch (Exception e) {
			this.setMsg(e.getMessage());
			str = "deleteUpdate";
		}

		return str;
	}
}
