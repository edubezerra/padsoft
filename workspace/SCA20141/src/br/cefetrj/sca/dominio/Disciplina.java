package br.cefetrj.sca.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue
	Long id;

	private String nome;
	private String codigo;
	private Integer quantidadeCreditos;

	Set<Disciplina> preReqs = new HashSet<Disciplina>();
	
	public Disciplina(String nome, String codigo, Integer quantidadeCreditos) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.quantidadeCreditos = quantidadeCreditos;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public Integer getQuantidadeCreditos() {
		return quantidadeCreditos;
	}

	public void setQuantidadeCreditos(Integer quantidadeCreditos) {
		if (this.quantidadeCreditos <= 0) {
			throw new IllegalArgumentException(
					"Valor inválido para quantidade de créditos.");
		}
		this.quantidadeCreditos = quantidadeCreditos;
	}

	public Set<Disciplina> getPreRequisitos() {
		return preReqs;
	}
	
	public Long getId() {
		return id;
	}
}
