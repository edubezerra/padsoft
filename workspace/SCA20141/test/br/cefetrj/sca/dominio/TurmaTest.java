package br.cefetrj.sca.dominio;

import org.junit.Test;

import br.cefetrj.sca.dominio.SemestreLetivo.Periodo;

public class TurmaTest {
	@Test(expected=IllegalArgumentException.class)
	public void alunoDeveSerFornecido() {
		Disciplina disciplina = new Disciplina("Padr�es de Software",
				"GSTI7502", 4);
		SemestreLetivo sl = new SemestreLetivo(2014, Periodo.PRIMEIRO);
		Turma turma = new Turma("1000", 40, sl, disciplina);
		turma.inscrever(null);
	}
}
