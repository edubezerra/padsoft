package q1;

import java.util.Calendar;

public class Desafio {
	public static int diaSemana(int dia, int mes, int ano) {
		if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1753)
			throw new RuntimeException("argumento invalido");
		
		if (mes == 1 || mes == 2) {
			mes = mes + 12;
			ano--;
		}

		int semana = dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano
				/ 100 + ano / 400;
		return semana % 7;
		
	}
    
	public static void main(String[] args) {
		System.out.println("teste");
		int dia = 1;
		int mes = 0;
		int ano = Calendar.getInstance().get(Calendar.YEAR); // Ano corrente
		if (args.length != 0)
			ano = Integer.parseInt(args[0]);
		Calendar data = Calendar.getInstance();
		data.set(ano, mes, dia);
	 
	//System.out.println ( ano + "-" + mes +"-" + dia);
		 
		while (data.get(Calendar.YEAR) == ano) {
			dia = data.get(Calendar.DAY_OF_MONTH);
			mes = data.get(Calendar.MONTH);
			System.out.println ( ano + "-" + mes +"-" + dia + "--" + data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH));
			int oficial = data.get(Calendar.DAY_OF_WEEK); // Dom (1), Seg (2),
															// ...
			int algoritmo = diaSemana(dia, mes + 1, ano); // Dom (6), Seg
															// (0),...
			System.out.println(oficial + "--" + algoritmo);
			
 			if ((oficial + 5) % 7 != algoritmo)
	 			throw new RuntimeException("Data: " + data.toString());
			
			data.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}