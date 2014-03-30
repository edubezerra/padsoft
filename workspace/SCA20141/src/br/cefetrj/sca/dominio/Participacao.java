package br.cefetrj.sca.dominio;

import java.math.BigDecimal;

/**
 * Representa a inscri��o de um aluno em um turma em um determinado semestre letivo.
 * 
 * @author Eduardo
 *
 */
public class Participacao {
	Aluno aluno;
	private Avaliacao avaliacao = null;
	private Turma turma;

	/**
	 * Depend�ncia injetada automaticamente.
	 */
	private EstrategiaAvaliacaoAluno estrategiaAvaliacao;

	public Turma getTurma() {
		return turma;
	}

	public Participacao(Aluno aluno, Turma turma) {
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Aluno � obrigat�rio na cria��o de uma inscri��o.");
		}
		if (turma == null) {
			throw new IllegalArgumentException(
					"Turma � obrigat�ria na cria��o de uma inscri��o.");
		}
		this.aluno = aluno;
		this.turma = turma;
		this.avaliacao = new Avaliacao();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public BigDecimal getNotaFinal() {
		if (avaliacao == null)
			throw new IllegalStateException(
					"Avalia��o ainda n�o foi registrada.");
		return this.estrategiaAvaliacao.getNotaFinal(this.avaliacao);
	}

	public String getGrau() {
		if (avaliacao == null)
			throw new IllegalStateException(
					"Avalia��o ainda n�o foi registrada.");
		return this.estrategiaAvaliacao.getGrau(this.avaliacao);
	}

	public void setEstrategiaCalculoGrau(EstrategiaAvaliacaoAluno strategia) {
		this.estrategiaAvaliacao = strategia;
	}

	public String getAvaliacao() {
		if (avaliacao == null)
			throw new IllegalStateException(
					"Avalia��o ainda n�o foi registrada.");
		return this.estrategiaAvaliacao.getAvaliacao(this.avaliacao);
	}

	public void registrarAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public EnumAvaliacao getSituacao() {
		// TODO Auto-generated method stub
		return null;
	}
}