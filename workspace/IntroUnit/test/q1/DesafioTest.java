package q1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DesafioTest {

	private static int domingo = 6;
	private static int segunda = 0;
	private static int terca = 1;
	private static int quarta = 2;
	private static int quinta = 3;
	private static int sexta = 4;
	private static int sabado = 5;

	@Test
	public void testDomingo() {
		assertEquals(Desafio.diaSemana(24, 11, 2013), domingo);
	}

	@Test
	public void testSegundaFeira() {
		assertEquals(Desafio.diaSemana(25, 11, 2013), segunda);
	}

	@Test
	public void testTercaFeira() {
		assertEquals(Desafio.diaSemana(26, 11, 2013), terca);
	}

	@Test
	public void testQuartaFeira() {
		assertEquals(Desafio.diaSemana(27, 11, 2013), quarta);
	}

	@Test
	public void testQuintaFeira() {
		assertEquals(Desafio.diaSemana(28, 11, 2013), quinta);
	}

	@Test
	public void testSextaFeira() {
		assertEquals(Desafio.diaSemana(29, 11, 2013), sexta);
	}

	@Test
	public void testSabado() {
		assertEquals(Desafio.diaSemana(30, 11, 2013), sabado);
	}

	@Test(expected=RuntimeException.class)
	public void deveSerMesValido() {
		Desafio.diaSemana(29, 15, 2013);
	}

	@Test(expected=RuntimeException.class)
	public void dataInvalida() {
		Desafio.diaSemana(30, 02, 2013);
	}
}
