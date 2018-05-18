package br.model.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Star extends StarMom {

	private boolean visible;

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
