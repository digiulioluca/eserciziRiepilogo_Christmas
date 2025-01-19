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
		
		for (int i = 0; i < 90; i++) {
			tabellone.add(i, i+1);
		}
		// faccio lo shuffe per assegnare i primi 15 numeri alla matrice "scheda"
		Collections.shuffle(tabellone);
	}

	/*
	 * metodo per inizializzare e stampare la scheda del giocatore In questo caso
	 * andremo ad applicare lo shuffle per inserire i primi 15 numeri dell'ArrayList
	 * all'interno della matrice.
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
		boolean continua=true;	// variabile per il ciclo
		int pallina = 0;	// variabile per l'estrazione che aumenteremo alla fine di ogni giro
		int cinquina=0;	// counter per stampare solo una volta la cinquina 
		setScheda();	// richiamo il metodo per inizializzare e stampare la scheda del giocatore
		
		// richiamo lo shuffle per iniziare l'estrazione
		Collections.shuffle(tabellone);
		
		do {
			System.out.println("Numero estratto: " + tabellone.get(pallina));
			// controllo se il numero estratto è presente nella scheda del giocatore
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					if (tabellone.get(pallina) == scheda[i][j]) {
						usciti[i][j] = true;
					}
				}
			}
			// richiamo il metodo per controllare se è stata effettuata la cinquina
			if (checkCinquina()) {
				if (cinquina==0) System.out.println("Hai fatto cinquina!");
				cinquina++;
				// ... se il metodo precedente è vero passo al controllo del bingo
				if (checkBingo()) continua=false;
			}
			pallina++;
		} while (continua);
	}

	/*
	 * metodo per controllare se il giocatore ha effettuato la cinquina
	 *
	 * @return boolean per passare al controllo del bingo
	 */
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

	
	/*
	 * metodo per controllare se il giocatore ha fatto bingo
	 * 
	 * @return boolean per uscire dal ciclo while (set "continua" su false)
	 * 
	 */
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
