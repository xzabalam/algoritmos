/**
 * Clase BusquedaBinaria.java 28 oct. 2021
 */
package algoritmos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xzabalam
 *
 */
public class BusquedaBinaria {

	public static String busquedaBinaria(List<String> lista, String itemABuscar) {
		int posicionInicial = 0;
		int posicionActual = 0;
		int posicionFinal = lista.size() - 1;

		final AtomicInteger numeroRepeticiones = new AtomicInteger(1);
		while (posicionInicial <= posicionFinal) {
			final int posicionMedia = (posicionInicial + posicionFinal) / 2;
			final String adivinarItemBuscado = lista.get(posicionMedia);
			final int peso = adivinarItemBuscado.compareToIgnoreCase(itemABuscar);

			if (peso == 0) {
				posicionActual = posicionMedia;
				posicionInicial = -1;
				break;
			}

			if (peso > 0) {
				posicionActual = posicionFinal = posicionMedia - 1;
			} else {
				posicionActual = posicionInicial = posicionMedia + 1;
			}

			imprimirRepeticion(adivinarItemBuscado, itemABuscar, posicionActual, numeroRepeticiones.getAndIncrement(),
					peso);
		}

		if (posicionInicial == -1) {
			return lista.get(posicionActual);
		}
		return "No existe";

	}

	private static void imprimirRepeticion(String textoEncontrado, String textoBuscado, Integer posicion,
			Integer numeroIntento, Integer peso) {
		System.out.println(
				MessageFormat.format("textoEncontrado {0}, textoBuscado {1}, posicion {2}, numeroIntento {3}, peso {4}",
						textoEncontrado, textoBuscado, posicion, numeroIntento, peso));
	}

	public static void main(String[] args) {
		final List<String> nombres = nombres();

		for (int i = 0; i <= 1000; i++) {
			final int posicionRandomABuscar = new Random().nextInt(nombres.size());
			System.out.println("============================================");
			final String resultado = busquedaBinaria(nombres, nombres.get(posicionRandomABuscar));
			System.out.println(resultado);
		}

	}

	private static List<String> nombres() {
		return Arrays.asList("Abigail", "Abraham", "Adam", "Adrian", "Alan", "Alexander", "Alexandra", "Alison",
				"Allan", "Alsop", "Amanda", "Amelia", "Amy", "Anderson", "Andrea", "Andrew", "Angela", "Anna", "Anne",
				"Anthony", "Arnold", "Audrey", "Austin", "Ava", "Avery", "Bailey", "Baker", "Ball", "Bell", "Bella",
				"Benjamin", "Bernadette", "Berry", "Black", "Blake", "Blake", "Bond", "Boris", "Bower", "Brandon",
				"Brian", "Brown", "Buckland", "Burgess", "Butler", "Cameron", "Cameron", "Campbell", "Carl", "Carol",
				"Caroline", "Carolyn", "Carr", "Chapman", "Charles", "Chloe", "Christian", "Christopher", "Churchill",
				"Claire", "Clark", "Clarkson", "Coleman", "Colin", "Connor", "Cornish", "Dan", "David", "Davidson",
				"Davies", "Deirdre", "Diana", "Diane", "Dickens", "Dominic", "Donna", "Dorothy", "Dowd", "Duncan",
				"Dyer", "Dylan", "Edmunds", "Edward", "Elizabeth", "Ella", "Ellison", "Emily", "Emma", "Eric", "Evan",
				"Faith", "Felicity", "Ferguson", "Fiona", "Fisher", "Forsyth", "Frank", "Fraser", "Gabrielle", "Gavin",
				"Gibson", "Gill", "Glover", "Gordon", "Grace", "Graham", "Grant", "Gray", "Greene", "Hamilton",
				"Hannah", "Hardacre", "Harris", "Harry", "Hart", "Heather", "Hemmings", "Henderson", "Hill", "Hodges",
				"Howard", "Hudson", "Hughes", "Hunter", "Ian", "Ince", "Irene", "Isaac", "Jack", "Jackson", "Jacob",
				"Jake", "James", "Jan", "Jane", "Jasmine", "Jason", "Jennifer", "Jessica", "Joan", "Joanne", "Joe",
				"John", "Johnston", "Jonathan", "Jones", "Joseph", "Joshua", "Julia", "Julian", "Justin", "Karen",
				"Katherine", "Keith", "Kelly", "Kerr", "Kevin", "Kimberly", "King", "Knox", "Kylie", "Lambert",
				"Langdon", "Lauren", "Lawrence", "Leah", "Lee", "Leonard", "Lewis", "Liam", "Lillian", "Lily", "Lisa",
				"Lucas", "Luke", "Lyman", "MacDonald", "MacLeod", "Mackay", "Mackenzie", "Madeleine", "Manning",
				"Maria", "Marshall", "Martin", "Mary", "Mathis", "Matt", "Max", "May", "McDonald", "McGrath", "McLean",
				"Megan", "Melanie", "Metcalfe", "Michael", "Michelle", "Miller", "Mills", "Mitchell", "Molly", "Morgan",
				"Morrison", "Murray", "Nash", "Natalie", "Nathan", "Neil", "Newman", "Nicholas", "Nicola", "Nolan",
				"North", "Ogden", "Oliver", "Oliver", "Olivia", "Owen", "Paige", "Parr", "Parsons", "Paterson", "Paul",
				"Payne", "Peake", "Penelope", "Peter", "Peters", "Phil", "Piers", "Piper", "Pippa", "Poole", "Powell",
				"Pullman", "Quinn", "Rachel", "Rampling", "Randall", "Rebecca", "Rees", "Reid", "Richard", "Robert",
				"Roberts", "Robertson", "Rose", "Ross", "Russell", "Ruth", "Rutherford", "Ryan", "Sally", "Sam",
				"Samantha", "Sanderson", "Sarah", "Scott", "Sean", "Sebastian", "Sharp", "Short", "Simon", "Simpson",
				"Skinner", "Slater", "Smith", "Sonia", "Sophie", "Springer", "Stephanie", "Stephen", "Steven",
				"Stewart", "Sue", "Sutherland", "Taylor", "Terry", "Theresa", "Thomas", "Thomson", "Tim", "Tracey",
				"Trevor", "Tucker", "Turner", "Una", "Underwood", "Vance", "Vanessa", "Vaughan", "Victor", "Victoria",
				"Virginia", "Walker", "Wallace", "Walsh", "Wanda", "Warren", "Watson", "Welch", "Wendy", "White",
				"Wilkins", "William", "Wilson", "Wright", "Young", "Yvonne", "Zoe");
	}
}
