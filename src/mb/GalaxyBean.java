package mb;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Dao.Dao;
import entidade.Galaxy;
import util.jsf.FacesUtil;

@ManagedBean(name = "g")
public class GalaxyBean {
	private Galaxy bh = new Galaxy();
	private ArrayList<Galaxy> listaGs = new ArrayList<Galaxy>();

	@SuppressWarnings("unchecked")
	public ArrayList<Galaxy> getListaBHs() {

		return (ArrayList<Galaxy>) Dao.getInstance().listarObjetos(Galaxy.class);
	}

	public void setListaBHs(ArrayList<Galaxy> listaBHs) {
		this.listaGs = listaBHs;
	}

	

	public Galaxy getBh() {
		return bh;
	}

	public void setBh(Galaxy bh) {
		this.bh = bh;
	}

	public String salvar() {
		try {
			if (bh.getId() == 0L || bh.getId() == null) {
				Dao.getInstance().salvarObjeto(bh);
			} else {
				Dao.getInstance().salvarOuAtualizarObjeto(bh);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return "list-g.xhtml?faces-redirect=true";
	}

	public String edit(Galaxy bh) {
		this.bh = bh;
		return "insert-g.xhtml";
	}

	public void delete(Galaxy bh) {
		Dao.getInstance().deletarObjeto(bh);
	}

	public String create() {
		try {
			Dao.getInstance().salvarObjeto(bh);
		} catch (Exception e) {
			System.out.println(e);
		}
		 return "list-g.xhtml?faces-redirect=true";
	}
}
