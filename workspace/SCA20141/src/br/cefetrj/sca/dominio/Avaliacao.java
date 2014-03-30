package br.cefetrj.sca.dominio;

import java.math.BigDecimal;

public class Avaliacao {
	private static final BigDecimal MEDIA_APROVACAO_DIRETA = new BigDecimal(7);
	private static final BigDecimal MEDIA_APROVACAO_RECUPERACAO = new BigDecimal(
			5);
	BigDecimal p1;
	BigDecimal p2;
	BigDecimal pf;
	private BigDecimal frequencia;

	/**
	 * TODO: completar para considerar reprovações por falta.
	 * 
	 * @return
	 */

	public EnumAvaliacao getSituacao() {
		if (p1 == null || p2 == null) {
			return EnumAvaliacao.INDEFINIDA;
		}
		BigDecimal divisor = new BigDecimal(2);
		BigDecimal mediaSemestral = p1.add(p2).divide(divisor);
		if (mediaSemestral.compareTo(MEDIA_APROVACAO_DIRETA) >= 0) {
			return EnumAvaliacao.AP;
		} else {
			if (pf != null) {
				if (mediaSemestral.add(pf).divide(divisor)
						.compareTo(MEDIA_APROVACAO_RECUPERACAO) >= 0) {
					return EnumAvaliacao.AP;
				} else {
					return EnumAvaliacao.RM;
				}
			} else {
				return EnumAvaliacao.INDEFINIDA;
			}
		}
	}

	public BigDecimal getNotaP1() {
		return p1;
	}

	public BigDecimal getNotaP2() {
		return p2;
	}

	public BigDecimal getNotaPF() {
		return pf;
	}

	public BigDecimal getFrequencia() {
		return frequencia;
	}

}
