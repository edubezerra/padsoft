package br.cefetrj.sca.dominio;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.cefetrj.sca.dominio.SemestreLetivo.Periodo;

public class Turma {
	private static final int TAM_MAX_CODIGO = 7;
	private String codigo;
	private SemestreLetivo periodo;
	private int capacidadeMaxima;
	Disciplina disciplina;
	Professor professor;
	private List<Aula> aulas;
	private Set<Participacao> inscricoes;
	SemestreLetivo semestreLetivo;
	HashMap<Aluno, Participacao> alunos;

	/**
	 * RN02: Uma turma não pode ter mais alunos inscritos do que a capacidade
	 * máxima definida para ela.
	 * 
	 * O código da turma possui sete caracteres (e.g., 6100009)
	 * 
	 */
	public Turma(String codigo, Integer numeroVagas, SemestreLetivo periodo,
			Disciplina disciplina) {

		this.disciplina = disciplina;

		if (codigo == null || codigo.isEmpty()) {
			throw new IllegalArgumentException("Código da turma é obrigatório.");
		}
		if (codigo.length() != TAM_MAX_CODIGO) {
			throw new IllegalArgumentException("Código da turma deve ter "
					+ TAM_MAX_CODIGO + " caracteres necessariamente.");
		}
		this.codigo = codigo;

		if (numeroVagas == null) {
			throw new IllegalArgumentException("Número de vagas é obrigatório.");
		}
		if (numeroVagas <= 0) {
			throw new IllegalArgumentException(
					"Número de vagas deve ser positivo.");
		}
		this.capacidadeMaxima = numeroVagas;

		if (periodo == null) {
			throw new IllegalArgumentException("Período é obrigatório.");
		}
		this.periodo = periodo;
	}

	public SemestreLetivo getPeriodo() {
		return periodo;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public String getCodigo() {
		return codigo;
	}

	public Set<Participacao> getInscricoes() {
		return Collections.unmodifiableSet(this.inscricoes);
	}

	public void adicionarAula(DiaSemana dia, String inicio, String fim) {
		this.aulas.add(new Aula(dia, inicio, fim));
	}

	public void lancarAvaliacao(Aluno aluno, Avaliacao avaliacao) {
		Participacao inscricao = alunos.get(aluno);
		inscricao.registrarAvaliacao(avaliacao);
	}

	public boolean inscreverAluno(Aluno aluno) {
		if (inscricoes.size() + 1 > capacidadeMaxima) {
			throw new IllegalStateException("Limite de vagas já alcançado.");
		}
		if (inscricoes.size() < capacidadeMaxima) {
			Participacao inscricao = new Participacao(aluno, this);
			for (Participacao umaInscricao : inscricoes) {
				if (umaInscricao.getAluno().getMatricula()
						.equals(aluno.getMatricula())) {
					throw new IllegalArgumentException(
							"Aluno já inscrito na turma.");
				}
			}
			alunos.put(aluno, inscricao);
			inscricoes.add(inscricao);
			return true;
		}
		return false;
	}

	public void setCapacidadeMaxima(Integer capacidadeMaxima) {
		if (capacidadeMaxima == null) {
			throw new IllegalArgumentException("Número de vagas é obrigatório.");
		}
		if (capacidadeMaxima <= 0) {
			throw new IllegalArgumentException(
					"Número de vagas deve ser positivo.");
		}
		if (capacidadeMaxima < inscricoes.size()) {
			throw new IllegalArgumentException(
					"Há mais inscritos do que a capacidade máximo fornecida.");
		}
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public void inscrever(Aluno aluno) {
		if (this.inscricoes.size() <= capacidadeMaxima) {
			Participacao e = new Participacao(aluno, this);
			this.inscricoes.add(e);
		} else {
			throw new IllegalStateException(
					"Não há vagas para uma nova inscrição.");
		}
	}
}
