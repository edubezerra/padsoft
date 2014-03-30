package br.cefetrj.sca.dominio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aluno {

	private static final int TAM_MATRICULA = 10;

	/**
	 * Nome do aluno.
	 */
	private String nome;

	/**
	 * Matrícula do aluno, composta de <code>TAM_MATRICULA</code> carateres.
	 */
	private String matricula;

	private Set<Participacao> participacoes = new HashSet<Participacao>();

	private Email email;

	private Date dataNascimento;

	private Aluno() {
	}

	public Aluno(String nome, String matricula, Date dataNascimento, String enderecoEmail) {
		super();
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Nome não pode ser vazio.");
		}
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("Matrícula não pode ser vazia.");
		}
		if (matricula.length() != TAM_MATRICULA) {
			throw new IllegalArgumentException("Matrícula deve ter "
					+ TAM_MATRICULA + " caracteres.");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.email = new Email(enderecoEmail);
		this.participacoes = new HashSet<Participacao>();
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	public String getMatricula() {
		return matricula;
	}

	public Set<Participacao> getInscricoes() {
		return participacoes;
	}

//	public static void main(String[] args) {
//		try {
//			Aluno a = new Aluno("José da Silva", "1011217WEB", "13/10/1980", "jose.silva@gmail.com");
//			System.out.println("Aluno criado:" + a.getNome());
//		} catch (IllegalArgumentException e) {
//			System.out.println("Erro na criação de aluno: " + e.getMessage());
//		}
//	}

	/**
	 * @return coleção de turmas cujas disciplinas da grade curricular estão
	 *         disponíveis para o aluno cursar.
	 */
	public Set<Turma> getTurmasPossiveis() {
		return null;

//		Set<Turma> possiveis = new HashSet<Turma>();
//
//		Set<Disciplina> cursadas = getDisciplinasCursadasComAprovacao();
//		Set<Disciplina> indisponiveis = getDisciplinasIndisponiveis();
//
//		TurmaRepositorio repoTurma = FabricaRepositorios.getTurmaRepositorio();
//
//		Set<Turma> abertas = repoTurma.getTurmasAbertas(SemestreLetivo.SEMESTRE_LETIVO_CORRENTE);
//		for (Turma turma : abertas) {
//			Disciplina disciplina = turma.getDisciplina();
//			if (!cursadas.contains(turma.getDisciplina())
//					&& !indisponiveis.contains(disciplina)) {
//				possiveis.add(turma);
//			}
//		}
//		return possiveis;
	}

	/**
	 * @return a coleção de disciplinas que o aluno já cursou com sucesso.
	 */
	public Set<Disciplina> getDisciplinasCursadasComAprovacao() {
		Set<Disciplina> disciplinas = new HashSet<Disciplina>();
		for (Participacao participacao : participacoes) {
			if (participacao.getSituacao() == EnumAvaliacao.AP) {
				disciplinas.add(participacao.getTurma().getDisciplina());
			}
		}
		return disciplinas;
	}

	/**
	 * @return coleção de disciplinas da grade curricular que não estão
	 *         disponíveis para o aluno cursar.
	 */
	public Set<Disciplina> getDisciplinasIndisponiveis() {
//		Set<Disciplina> cursadas = getDisciplinasCursadasComAprovacao();
//		Set<Disciplina> disciplinas = new HashSet<Disciplina>();
//		DisciplinaRepositorio repoDisciplina = FabricaRepositorios
//				.getDisciplinaRepositorio();
//		List<Disciplina> todas = repoDisciplina.getDisciplinas();
//		for (Disciplina disciplina : todas) {
//			Set<Disciplina> preReqs = disciplina.getPreRequisitos();
//			if (!repoDisciplina.estaContidaEm(preReqs, cursadas)) {
//				disciplinas.add(disciplina);
//			}
//		}
//		return disciplinas;
		return null;
	}

	public String getEmail() {
		return email.getEndereco();
	}

}
