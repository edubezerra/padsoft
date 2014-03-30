package br.cefetrj.sca.dominio;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	private static final int TAMANHO_MATRICULA = 7;

	@OneToMany
	private Set<GradeDisponibilidade> grades;

	private Set<Disciplina> habilitacoes;

	private String nome;
	private String matricula;

	@Id
	@GeneratedValue
	private Long id;

	private Departamento departamento;

	private String email;

	public Long getId() {
		return id;
	}

	public Professor(String matricula, String nome, String email) {
		this(matricula, nome);
		this.email = email;
	}

	public Professor(String matricula, String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome é obrigatório.");
		}
		this.nome = nome;
		if (matricula == null || matricula.isEmpty()) {
			throw new IllegalArgumentException("Matrícula é obrigatório.");
		}
		if (matricula.length() != TAMANHO_MATRICULA) {
			throw new IllegalArgumentException("Matrícula deve ter tamanho "
					+ TAMANHO_MATRICULA + ".");
		}
		if (!contemApenasDigitos(matricula)) {
			throw new IllegalArgumentException(
					"Matrícula deve conter apenas dígitos.");
		}
		this.matricula = matricula;
	}

	private boolean contemApenasDigitos(String str) {

		if (str == null || str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++) {

			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}

	public boolean estaHabilitado(Disciplina d) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNome() {
		return nome;
	}

	public Set<Disciplina> getHabilitacoes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMatricula() {
		return matricula;
	}

	public Disciplina getHabilitacao(String nomeDisciplina) {
		for (Disciplina d : habilitacoes) {
			if (d.getNome().equals(nomeDisciplina))
				return d;
		}
		return null;
	}

	public void removerHabilitacoes(List<String> nomesDisciplinas) {
		// TODO Auto-generated method stub

	}

	public Departamento getDepartmento() {
		return departamento;
	}
}