package q2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FormatoTest {

	@Test
	public void deveRetornarEmOrdemDescrescente() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(-5);
		Formato formato = new Formato();
		assertEquals("2;1;-5", formato.toString(lista));
	}

	@Test
	public void listaUnitaria() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		Formato formato = new Formato();
		assertEquals("1", formato.toString(lista));
	}

	@Test
	public void deveRetornarCadeiaVazia() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Formato formato = new Formato();
		assertEquals("", formato.toString(lista));
	}

	@Test(expected = IllegalArgumentException.class)
	public void listaNaoDeveSerNula() {
		ArrayList<Integer> lista = null;
		Formato formato = new Formato();
		formato.toString(lista);
	}

}
