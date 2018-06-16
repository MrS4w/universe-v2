package mb;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Dao.Dao;
import entidade.Star;
import util.jsf.FacesUtil;

@ManagedBean(name = "star")
public class StarBean {
	private Star star = new Star();
	private ArrayList<Star> listaStars = new ArrayList<Star>();

	@SuppressWarnings("unchecked")
	public ArrayList<Star> getListaStars() {

		return (ArrayList<Star>) Dao.getInstance().listarObjetos(Star.class);
	}

	public void setListaStars(ArrayList<Star> listaStars) {
		this.listaStars = listaStars;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public String salvar() {
		try {
			if (star.getId() == 0L || star.getId() == null) {
				Dao.getInstance().salvarObjeto(star);
			} else {
				Dao.getInstance().salvarOuAtualizarObjeto(star);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "list-star.xhtml?faces-redirect=true";
	}

	public String edit(Star star) {
		this.star = star;
		return "insert-star.xhtml";
	}

	public void delete(Star star) {
		Dao.getInstance().deletarObjeto(star);
	}

	public String create() {
		try {
			Dao.getInstance().salvarObjeto(star);
		} catch (Exception e) {
			System.out.println(e);
		}
		 return "list-star.xhtml?faces-redirect=true";
	}
}
