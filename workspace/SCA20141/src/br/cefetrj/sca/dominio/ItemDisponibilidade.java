package br.cefetrj.sca.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemDisponibilidade implements Cloneable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private DiaSemana dia;

	@Embedded
	private Intervalo intervalo;

	private ItemDisponibilidade() {
	}

	public ItemDisponibilidade(DiaSemana dia, String inicio, String fim) {
		this.intervalo = new Intervalo(inicio, fim);
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public DiaSemana getDia() {
		return dia;
	}

	public Object clone() {
		ItemDisponibilidade copia = new ItemDisponibilidade();
		copia.dia = this.dia;
		copia.intervalo = this.intervalo;
		return copia;
	}

	public String getFim() {
		return intervalo.getFim();
	}

	public String getInicio() {
		return intervalo.getInicio();
	}

	public boolean colide(ItemDisponibilidade item) {
		return (this.dia == item.dia)
				&& (this.intervalo.colide(item.intervalo));
	}
}
