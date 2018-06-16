package mb;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Dao.Dao;
import entidade.BlackHole;
import util.jsf.FacesUtil;

@ManagedBean(name = "bh")
public class BhBean {
	private BlackHole bh = new BlackHole();
	private ArrayList<BlackHole> listaBHs = new ArrayList<BlackHole>();

	@SuppressWarnings("unchecked")
	public ArrayList<BlackHole> getListaBHs() {

		return (ArrayList<BlackHole>) Dao.getInstance().listarObjetos(BlackHole.class);
	}

	public void setListaBHs(ArrayList<BlackHole> listaBHs) {
		this.listaBHs = listaBHs;
	}

	

	public BlackHole getBh() {
		return bh;
	}

	public void setBh(BlackHole bh) {
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
		return "list-bh.xhtml?faces-redirect=true";
	}

	public String edit(BlackHole bh) {
		this.bh = bh;
		return "insert-bh.xhtml";
	}

	public void delete(BlackHole bh) {
		Dao.getInstance().deletarObjeto(bh);
	}

	public String create() {
		try {
			Dao.getInstance().salvarObjeto(bh);
		} catch (Exception e) {
			System.out.println(e);
		}
		 return "list-bh.xhtml?faces-redirect=true";
	}
}
