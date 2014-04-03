package br.cefetrj.sca.servico;

import br.cefetrj.sca.dominio.Aluno;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.TurmaRepositorio;

public class RealizarInscricaoService {
	TurmaRepositorio turmaRepositorio;

	public void registrarInscricao(String codigoTurma, Aluno aluno) {
		Turma t = turmaRepositorio.getTurma(codigoTurma);
		if (t == null) {
			throw new IllegalArgumentException("Código da turma não fornecido.");
		} else {
			t.inscrever(aluno);
		}
	}
}
