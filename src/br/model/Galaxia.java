package br.model;

public abstract class Galaxia {
	protected int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String nome;
	protected String posicao;
	protected double dimensao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public double getDimensao() {
		return dimensao;
	}

	public void setDimensao(double dimensao) {
		this.dimensao = dimensao;
	}
}
