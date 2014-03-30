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
	 * Matr�cula do aluno, composta de <code>TAM_MATRICULA</code> carateres.
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
			throw new IllegalArgumentException("Nome n�o pode ser vazio.");
		}
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("Matr�cula n�o pode ser vazia.");
		}
		if (matricula.length() != TAM_MATRICULA) {
			throw new IllegalArgumentException("Matr�cula deve ter "
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
//			Aluno a = new Aluno("Jos� da Silva", "1011217WEB", "13/10/1980", "jose.silva@gmail.com");
//			System.out.println("Aluno criado:" + a.getNome());
//		} catch (IllegalArgumentException e) {
//			System.out.println("Erro na cria��o de aluno: " + e.getMessage());
//		}
//	}

	/**
	 * @return cole��o de turmas cujas disciplinas da grade curricular est�o
	 *         dispon�veis para o aluno cursar.
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
	 * @return a cole��o de disciplinas que o aluno j� cursou com sucesso.
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
	 * @return cole��o de disciplinas da grade curricular que n�o est�o
	 *         dispon�veis para o aluno cursar.
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
