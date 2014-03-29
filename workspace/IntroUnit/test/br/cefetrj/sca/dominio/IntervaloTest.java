package br.cefetrj.sca.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntervaloTest {
	@Test
	public void testComColisao() {
		Intervalo tempo1 = new Intervalo("12:40", "13:30");
		Intervalo tempo2 = new Intervalo("13:00", "14:30");
		assertEquals(tempo1.colide(tempo2), true);
	}

	@Test
	public void testSemColisao() {
		Intervalo tempo1 = new Intervalo("12:40", "13:30");
		Intervalo tempo2 = new Intervalo("13:40", "14:30");
		assertEquals(tempo1.colide(tempo2), false);
	}

	@Test
	public void devemSerCompativeisParaUniao() {
		Intervalo tempo1 = new Intervalo("12:40", "13:30");
		Intervalo tempo2 = new Intervalo("13:30", "14:30");
		assertEquals(tempo1.unir(tempo2).getInicio(), "12:40");
		assertEquals(tempo1.unir(tempo2).getFim(), "14:30");
		assertEquals(tempo2.unir(tempo1).getInicio(), "12:40");
		assertEquals(tempo2.unir(tempo1).getFim(), "14:30");
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDevemSerCompativeisParaUniao() {
		Intervalo tempo1 = new Intervalo("12:40", "13:30");
		Intervalo tempo2 = new Intervalo("13:40", "14:30");
		tempo2.unir(tempo1);
	}
}
