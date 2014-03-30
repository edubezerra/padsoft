import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainGenerics {

	public static void main(String[] args) {

		List<String> palavras0 = new ArrayList<String>();
		List<String> palavras1 = new ArrayList<String>();
		List<Integer> palavras2 = new ArrayList<Integer>();

		Set<String> palavras3 = new HashSet<String>();

		palavras0.add("Eduardo");
		palavras0.add("Bezerra");
		palavras0.add("Silva");
		for (String string : palavras0) {
			System.out.println(string);
		}

		palavras3.add("Eduardo");
		palavras3.add("Bezerra");
		palavras3.add("Silva");
		for (String string : palavras3) {
			System.out.println(string);
		}

		palavras1.add("Eduardo");
		palavras1.add("Bezerra");

		palavras2.add(1);

		// System.out.println(palavras0.size());
		//
		// System.out.println(palavras1.size());
		//
		// System.out.println(palavras0.get(0));

	}

}
