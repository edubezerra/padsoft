package q2;

import java.util.Collections;
import java.util.List;

public class Formato {
	public String toString(List<Integer> inteiros) {
		if (inteiros == null) {
			throw new IllegalArgumentException("Lista é nula!");
		}

		Collections.sort(inteiros);
		Collections.reverse(inteiros);
		String retorno = "";
		int n = 0;

		for (Integer integer : inteiros) {
			retorno += integer.toString();
			if (n < inteiros.size() - 1) {
				retorno += ";";
			}
			n++;
		}
		return retorno;
	}
}
