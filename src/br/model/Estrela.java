package br.model;

public abstract class Estrela {
	protected int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String nome;
	protected double volume;
	protected String posicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
}
