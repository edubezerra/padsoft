package br.cefetrj.sca.dominio;

import java.math.BigDecimal;

public interface EstrategiaAvaliacaoAluno {
	public String getGrau(Avaliacao avaliacao);
	public String getAvaliacao(Avaliacao avaliacao);
	public BigDecimal getNotaFinal(Avaliacao avaliacao);
}
