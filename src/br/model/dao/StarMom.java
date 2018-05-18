package br.model.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class StarMom {

	@Id
	private String name;
	private double volume;
	private String position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
