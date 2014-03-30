package br.cefetrj.sca.dominio;

import java.util.ArrayList;
import java.util.List;

public class ListaEspera {

	private Disciplina disciplina;
	private List<Aluno> alunos;

	public ListaEspera(Disciplina disciplina) {
		super();
		if (disciplina != null) {
			throw new IllegalArgumentException("Disciplina não pode ser nula.");
		}
		this.disciplina = disciplina;
		this.alunos = new ArrayList<Aluno>();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void inserirAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}
}
