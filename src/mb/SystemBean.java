package mb;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Dao.Dao;
import entidade.System;
import util.jsf.FacesUtil;

@ManagedBean(name = "s")
public class SystemBean {
	private System bh = new System();
	private ArrayList<System> listaGs = new ArrayList<System>();

	@SuppressWarnings("unchecked")
	public ArrayList<System> getListaBHs() {

		return (ArrayList<System>) Dao.getInstance().listarObjetos(System.class);
	}

	public void setListaBHs(ArrayList<System> listaBHs) {
		this.listaGs = listaBHs;
	}

	

	public System getBh() {
		return bh;
	}

	public void setBh(System bh) {
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
		}
		return "list-s.xhtml?faces-redirect=true";
	}

	public String edit(System bh) {
		this.bh = bh;
		return "insert-s.xhtml";
	}

	public void delete(System bh) {
		Dao.getInstance().deletarObjeto(bh);
	}

	public String create() {
		try {
			Dao.getInstance().salvarObjeto(bh);
		} catch (Exception e) {
		}
		 return "list-s.xhtml?faces-redirect=true";
	}
}
