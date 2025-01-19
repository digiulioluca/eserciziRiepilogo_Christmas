package cinema;

import java.util.Scanner;

public class Biglietto {
	/*
	 * attributi classe biglietto: - giorno, di tipo intero, per utilizzare il math
	 * random - prezzo, di tipo double
	 */
	static int giorno;
	static double prezzo;

	/*metodo CalcoloPrezzo: inserità l'età si procedere a controllare il numero
	 inserito per stampare il prezzo del biglietto. Se il valore di giorno, che
	 calcoleremo con l'altro metodo, corrisponderà a 3, diminuiremo di 2 il valore di prezzo */
	public static void calcoloPrezzo(Scanner scanner) {
		System.out.println("Inserisci età: ");
		int eta = scanner.nextInt();
		if (eta < 0) eta *= -1;
		if (eta < 10) {
			prezzo = 0;
			System.out.println("Biglietto gratis");
		} else if (eta < 15 && eta > 9) {
			prezzo = 6;
			if (giorno == 3) {
				prezzo -= 2;
			}
		} else if (eta > 14) {
			prezzo = 8;
			if (giorno == 3) {
				prezzo -= 2;
			}
		}
		System.out.println("Costo del biglietto: € " + prezzo);
	}

	/*per il calcolo del giorno utilizziamo un metodo, unicamente
	 per la catena di if-else che stamperà a video il giorno estratto */
	public static int calcoloGiorno() {
		giorno = (int) (Math.random() * 7 + 1);
		
		if (giorno == 1) {
			System.out.println("Giorno: lunedì");
		} else if (giorno == 2) {
			System.out.println("Giorno: martedì");
		} else if (giorno == 3) {
			System.out.println("Giorno: mercoledì \n"
					+ "Sconto di € 2 su tutti i biglietti");
		} else if (giorno == 4) {
			System.out.println("Giorno: giovedì");
		} else if (giorno == 5) {
			System.out.println("Giorno: venerdì");
		} else if (giorno == 6) {
			System.out.println("Giorno: sabato");
		} else if (giorno == 7) {
			System.out.println("Giorno: domenica");
		}

		return giorno;
	}

}
