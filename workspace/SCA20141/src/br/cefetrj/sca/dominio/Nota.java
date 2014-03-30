package br.cefetrj.sca.dominio;

public class Nota {
	
	private Float valor;
	private String descritor;
	
	public Nota(Float valor, String descritor) {
		super();
		this.valor = valor;
		this.descritor = descritor;
	}

	public Float getValor() {
		return valor;
	}

	public String getDescritor() {
		return descritor;
	}

}
