package br.cefetrj.sca.dominio;

import java.math.BigDecimal;

public class EstrategiaAvaliacaoAlunoImpl2009 implements
		EstrategiaAvaliacaoAluno {

	public EstrategiaAvaliacaoAlunoImpl2009() {
	}

	public BigDecimal getNotaFinal(Avaliacao avaliacao) {
		double notaFinal = 0.0;
		notaFinal = (avaliacao.getNotaP1().doubleValue() + avaliacao
				.getNotaP2().doubleValue()) / 2;
		return new BigDecimal(notaFinal);
	}

	@Override
	public String getGrau(Avaliacao avaliacao) {
		String grau;
		if (avaliacao.getFrequencia().doubleValue() < 0.75)
			grau = "I";
		else {
			BigDecimal notaFinal = getNotaFinal(avaliacao);
			if (notaFinal.doubleValue() >= 9.0)
				grau = "A";
			else if (notaFinal.doubleValue() >= 7.0)
				grau = "B";
			else if (notaFinal.doubleValue() >= 5.0)
				grau = "C";
			else
				grau = "I";
		}
		return grau;
	}

	@Override
	public String getAvaliacao(Avaliacao avaliacao) {
		String grau = this.getGrau(avaliacao);
		if (avaliacao.getFrequencia().doubleValue() < 0.75) {
			return "RF";
		} else if (grau.equals("A") || grau.equals("B") || grau.equals("C")) {
			return "AP";
		} else {
			return "RM";
		}
	}
}
