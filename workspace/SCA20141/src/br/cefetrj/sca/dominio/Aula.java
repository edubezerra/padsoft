package br.cefetrj.sca.dominio;

public class Aula {
	private DiaSemana dia;
	private Intervalo intervalo;

	public Aula(DiaSemana dia, String strInicio, String strFim) {
		super();
		this.dia = dia;
		this.intervalo = new Intervalo(strInicio, strFim);
	}

	public DiaSemana getDia() {
		return dia;
	}

	public String getHoraInicio() {
		return intervalo.getInicio();
	}

	public String getHoraTermino() {
		return intervalo.getFim();
	}

}