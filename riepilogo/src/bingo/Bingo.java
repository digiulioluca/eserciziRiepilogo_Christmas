package bingo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Bingo {
	// attributi "giocatore"
	static int[][] scheda = new int[3][5];
	static boolean[][] usciti = new boolean[3][5];

	// attributi "PC"
	static ArrayList<Integer> tabellone = new ArrayList<Integer>();

	// metodo per inizializzare il tabellone
	public static void setTabellone() {
		for (int i = 1; i <= 90; i++) {
			tabellone.add(i);
		}
		Collections.shuffle(tabellone);
	}

	/*
	 * metodo per inizializzare e stampare la scheda del giocatore In questo caso
	 * andremo ad applicare lo shuffle per inserire i primi 15 numeri dell'ArrayList
	 * all'interno della matrice. Prima di cominciare con l'estrazione richiameremo
	 * un'altra volta i due metodi setTabellone e shuffle
	 */
	public static void setScheda() {
		
		setTabellone();

		// inseriamo i primi 15 numeri nella scheda
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				scheda[i][j] = tabellone.get(j);
				if (i == 1)
					scheda[i][j] = tabellone.get(j + 5);
				else if (i == 2)
					scheda[i][j] = tabellone.get(j + 10);
				usciti[i][j] = false;
			}
		}

		// riordiniamo la matrice procediamo alla stampa della scheda
		for (int[] array : scheda) {
			Arrays.sort(array);
		}

		for (int[] array : scheda) {
			System.out.println(Arrays.toString(array));
		}
	}

	public static void svolgimento(Scanner scanner) {
		boolean continua=true;
		int cont = 0;
		setScheda();
		setTabellone();
		for (int a:tabellone) {
			System.out.print(a + "|");
		}
		do {
			System.out.println("Numero estratto: " + tabellone.get(cont));
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					if (tabellone.get(cont) == scheda[i][j]) {
						usciti[i][j] = true;
					}
				}
			}
			if (checkCinquina()) {
				if (checkBingo()) continua=false;
			}
			cont++;
		} while (continua);
	}

	public static boolean checkCinquina() {
		boolean controllo = false;
		for (int i = 0; i < 3; i++) {
			int cinquina = 0;
			for (int j = 0; j < 5; j++) {
				if (usciti[i][j]) {
					cinquina++;
				}

				if (cinquina == 5) {
					controllo = true;
				}
			}
		}
		return controllo;
	}

	public static boolean checkBingo() {
		boolean controllo = false;
		int bingo = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (usciti[i][j])
					bingo++;
				if (bingo == 15) {
					System.out.println("Hai fatto bingo!");
					controllo = true;
				}
			}
		}

		return controllo;
	}
}
