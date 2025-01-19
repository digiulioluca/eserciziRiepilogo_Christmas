package battagliaNavale;

import java.util.Scanner;

public class Gioco {
	static String[][] griglia = new String[8][8];
	static boolean[][] vuoto = new boolean[8][8];
	static boolean[][] colpito = new boolean[8][8];

	public static void inizializzaGriglia() {
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				griglia[i][j] = " ";
				vuoto[i][j] = true;
				colpito[i][j] = false;
			}
		}
	}

	// metodo per visualizzare la griglia
	public static void stampaGriglia() {
		System.out.println("  0  1  2  3  4  5  6  7");
		for (int i = 0; i < griglia.length; i++) {
			System.out.print(i);
			for (int j = 0; j < griglia.length; j++) {
				if (colpito[i][j]) {
					System.out.print("|" + griglia[i][j] + "|");
				} else {
					System.out.print("| |");
				}
				if (j == 7)
					System.out.println("\n ------------------------");
			}
		}
	}
	
	// metodo per generare la nostra nave di lunghezza 3
	public static void generaNave() {
		// generiamo due numeri per stabilire la prima coordinata
		int riga = (int) (Math.random() * (griglia.length));
		int colonna = (int) (Math.random() * (griglia.length));

		// cambiamo i valori nelle due matrici
		griglia[riga][colonna] = "X";
		vuoto[riga][colonna] = false;
		
		// generiamo un terzo numero per capire se costruire in orizzontale o verticale
		// se verrà fuori 1, costruiremo in verticale; 2 in orizzontale
		int costruzione = (int) (Math.random() * 2 + 1);

		// da qui vengono effettuati una serie di controlli per evitare l'out of bound e costruire
		if (costruzione == 1 && riga <= 6 && riga >= 1) {
			if (vuoto[riga - 1][colonna]) {
				griglia[riga - 1][colonna] = "X";
				vuoto[riga - 1][colonna] = false;
			}
			if (vuoto[riga + 1][colonna]) {
				griglia[riga + 1][colonna] = "X";
				vuoto[riga + 1][colonna] = false;
			}
		}

		if (costruzione == 1 && riga == 7) {
			if (vuoto[riga - 1][colonna]) {
				griglia[riga - 1][colonna] = "X";
				vuoto[riga - 1][colonna] = false;
			}
			if (vuoto[riga - 2][colonna]) {
				griglia[riga - 2][colonna] = "X";
				vuoto[riga - 2][colonna] = false;
			}

		} else if (costruzione == 1 && riga == 0) {
			if (vuoto[riga + 2][colonna]) {
				griglia[riga + 2][colonna] = "X";
				vuoto[riga + 2][colonna] = false;
			}
			if (vuoto[riga + 1][colonna]) {
				griglia[riga + 1][colonna] = "X";
				vuoto[riga + 1][colonna] = false;
			}
		}

		if (costruzione == 2 && colonna <= 6 && colonna >= 1) {
			if (vuoto[riga][colonna - 1]) {
				griglia[riga][colonna - 1] = "X";
				vuoto[riga][colonna - 1] = false;
			}
			if (vuoto[riga][colonna + 1]) {
				griglia[riga][colonna + 1] = "X";
				vuoto[riga][colonna + 1] = false;
			}
		}

		if (costruzione == 2 && colonna == 7) {
			if (vuoto[riga][colonna - 1]) {
				griglia[riga][colonna - 1] = "X";
				vuoto[riga][colonna - 1] = false;
			}
			if (vuoto[riga][colonna - 2]) {
				griglia[riga][colonna - 2] = "X";
				vuoto[riga][colonna - 2] = false;
			}
		} else if (costruzione == 2 && colonna == 0) {
			if (vuoto[riga][colonna + 1]) {
				griglia[riga][colonna + 1] = "X";
				vuoto[riga][colonna + 1] = false;
			}
			if (vuoto[riga][colonna + 2]) {
				griglia[riga][colonna + 2] = "X";
				vuoto[riga][colonna + 2] = false;
			}
		}
	}

	// svolgimento
	public static void svolgimento(Scanner scanner) {
		// inizializziamo la griglia e generiamo la nave
		inizializzaGriglia();
		generaNave();
		
		// variabili per raccogliere gli input dell'utente
		int riga = 0;
		int colonna = 0;
		
		// counter per i colpi andati a segni (a 3 finirà il gioco)
		int segno = 0;
		do {
			System.out.println("Inserisci coordinate mossa\nN.B. Inserisci un numero tra 0 e 7\nRiga:");
			riga = scanner.nextInt();
			System.out.println("Colonna:");
			colonna = scanner.nextInt();
			
			/* con i primi due if controlliamo se le coordinate sono valide per la matrice
			 Se questi valori saranno validi, procediamo a controllare se la nave è stata colpita o meno*/
			if (riga <= 7 && riga >= 0) {
				if (colonna <= 7 && colonna >= 0) {
					if (vuoto[riga][colonna] == false) {
						System.out.println("Nave colpita!");
						colpito[riga][colonna] = true;
						// incrementiamo il counter
						segno++;
					} else {
						System.out.println("Acqua!");
						/* come vediamo qui, se non è stata colpita la nave, andiamo a sostituire il valore
						puntato nella matrice di stringhe con un 'O'. Qui, infatti, si spiega l'utilizzo
						della terza matrice (colpito). Come fatto in precedenza, il valore false iniziale
						ci era utile principalmente per non mostrare all'utente la posizione delle X. Una volta
						raccolte le coordinate da tastiera, andremo a settare quel valore nella matrice
						colpito su true, così da iniziare a mostrare l'utente i tentativi andati a segno o meno*/
						griglia[riga][colonna] = "O";
						colpito[riga][colonna] = true;
					}
				}
			} else {
				System.out.println("Valori non validi.");
			}
			// dopo ogni mossa stampiamo la griglia per tenere aggiornato l'utente
			stampaGriglia();

		} while (controllo(segno) == false);

		System.out.println("Nave affondata!");
	}

	public static boolean controllo(int segno) {
		// se i colpi andati a segno sono 3 (lunghezza della nave), la partita si concluderà
		if (segno == 3) {
			return true;
		} else {
			return false;
		}
	}
}
