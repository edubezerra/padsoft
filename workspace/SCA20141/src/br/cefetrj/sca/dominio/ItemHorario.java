package br.cefetrj.sca.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemHorario {
	@Id
	@GeneratedValue
	Long id;

	private ItemHorario() {
	}

	public Long getId() {
		return id;
	}
}
