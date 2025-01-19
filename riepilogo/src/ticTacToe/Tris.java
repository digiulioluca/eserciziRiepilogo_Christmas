package ticTacToe;

import java.util.Scanner;

public class Tris {
	// attributi
	static String[][] griglia = new String[3][3];
	static boolean[][] vuoto = new boolean[3][3];

	/*
	 * metodo per inizializzare tutti i valori della griglia (matrice di stringhe) e
	 * di vuoto (matrice boolean) a true
	 */
	public static void inizializzaGriglia() {
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				griglia[i][j] = " ";
				vuoto[i][j] = true;
			}
		}
	}

	// metodo per visualizzare la griglia
	public static void stampaGriglia() {
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia.length; j++) {
				System.out.print("|" + griglia[i][j] + "|");
				if (j == 2)
					System.out.println("\n---------");
			}
		}
	}

	/*
	 * svolgimento partita: ricevuto il valore di estrazione, dettiamo i turni con
	 * un ciclo do-while, che andrà avanti fino al riempimento di tutte le caselle o
	 * fino alla vittoria di uno dei due giocatori
	 */
	public static void svolgimento(Scanner scanner) {
		int riga = 0;
		int colonna = 0;

		int estrazione = (int) (Math.random() * 2 + 1);
		
		// variabile per le mosse
		boolean ciclo = false;

		System.out.println("Risultato estrazione: " + estrazione);

		// richiamo il metodo estrazione per far conoscere al giocatore chi inizierà
		if (estrazione == 1) {
			System.out.println("Inizierà il giocatore 1, simbolo X");
		} else {
			System.out.println("Inizierà il giocatore 2, simbolo O");
		}
		
		// richiamiamo il metodo per azzerare la griglia
		inizializzaGriglia();

		do {
			if (estrazione == 1) {
				/*
				 * gestisco tramite due do-while e un altro metodo l'inserimento dei valori.
				 * Raccolti gli input delle coordinate richiamo il metodo, che andrà avanti fino
				 * a che il valore inserito non potrà essere accettato (casella selezionata =
				 * true nella matrice boolean)
				 */
				do {
					System.out.println("Giocatore 1. Inserire le coordinate della tua mossa.\nN.B."
							+ " Inserire valori tra 0 e 2\nRiga:");
					/* circondo gli input con un try-catch, così da evitare 
					 l'inserimento di numeri che causerebbero l'errore
					 "Index out of bound"*/
					try {
						riga = scanner.nextInt();
						System.out.println("Colonna:");
						colonna = scanner.nextInt();
						if (mossaValida(riga, colonna, "X")) {
							ciclo = true;
						} else {
							System.out.println("Riprovare, casella occupata.");
							ciclo = false;
						}
					} catch (Exception e) {
						System.out.println("Valore non esistente nella matrice. Ritentare");
					}
					
				} while (ciclo == false);

				/*
				 * controllo "mediano" tra le due mosse, nel caso in cui il giocatore che ha la
				 * precedenza dovesse chiudere la partita in anticipo, evitando così di mostrare
				 * due tris. In questo l'istruzione che ci aiuterà a far sì che non si vada
				 * avanti è il break
				 */

				if (controllo())
					break;

				do {
					System.out.println("Giocatore 2. Inserire le coordinate della tua mossa.\nN.B."
							+ " Inserire valori tra 0 e 2\nRiga:");
					try {
						riga = scanner.nextInt();
						System.out.println("Colonna:");
						colonna = scanner.nextInt();
						if (mossaValida(riga, colonna, "O")) {
							ciclo = true;
						} else {
							System.out.println("Riprovare, casella occupata.");
							ciclo = false;
						}
					} catch (Exception e) {
						System.out.println("Valore non esistente nella matrice. Ritentare");
					}
				} while (ciclo == false);

			} else {

				do {
					System.out.println("Giocatore 2. Inserire le coordinate della tua mossa.\nN.B."
							+ " Inserire valori tra 0 e 2\nRiga:");
					try {
						riga = scanner.nextInt();
						System.out.println("Colonna:");
						colonna = scanner.nextInt();
						if (mossaValida(riga, colonna, "O")) {
							ciclo = true;
						} else {
							System.out.println("Riprovare, casella occupata.");
							ciclo = false;
						}
					} catch (Exception e) {
						System.out.println("Valore non esistente nella matrice. Ritentare");
					}
				} while (ciclo == false);

				if (controllo())
					break;

				do {
					System.out.println("Giocatore 1. Inserire le coordinate della tua mossa.\nN.B."
							+ " Inserire valori tra 0 e 2\nRiga:");
					try {
						riga = scanner.nextInt();
						System.out.println("Colonna:");
						colonna = scanner.nextInt();
						if (mossaValida(riga, colonna, "X")) {
							ciclo = true;
						} else {
							System.out.println("Riprovare, casella occupata.");
							ciclo = false;
						}
					} catch (Exception e) {
						System.out.println("Valore non esistente nella matrice. Ritentare");
					}

				} while (ciclo == false);

			}

			System.out.println("Stato attuale griglia.");
			stampaGriglia();
		} while (controllo() == false);

		System.out.println("Partita conclusa.");
		stampaGriglia();
	}

	/*
	 * metodo per controllare se la mossa è valida: se la casella corrispondente
	 * alla coordinate inserite dall'utente (o dal pc) ha un valore boolean true,
	 * allora il valore può essere inserito (e cambierà il suo stato in false)
	 */
	public static boolean mossaValida(int riga, int colonna, String valore) {
		if (vuoto[riga][colonna]) {
			griglia[riga][colonna] = valore;
			vuoto[riga][colonna] = false;
			System.out.println("Mossa registrata.");
			return true;
		} else {
			System.out.println("Mossa non registrata.");
			return false;
		}
	}

	public static boolean controllo() {
		boolean status = false;

		// controllo riga 0
		if (griglia[0][0].equals("X") && griglia[0][1].equals("X") && griglia[0][2].equals("X")) {
			status = true;
		} else if (griglia[0][0].equals("O") && griglia[0][1].equals("O") && griglia[0][2].equals("O")) {
			status = true;
		}

		// controllo riga 1
		if (griglia[1][0].equals("X") && griglia[1][1].equals("X") && griglia[1][2].equals("X")) {
			status = true;
		} else if (griglia[1][0].equals("O") && griglia[1][1].equals("O") && griglia[1][2].equals("O")) {
			status = true;
		}

		// controllo riga 2
		if (griglia[2][0].equals("X") && griglia[2][1].equals("X") && griglia[2][2].equals("X")) {
			status = true;
		} else if (griglia[2][0].equals("O") && griglia[2][1].equals("O") && griglia[2][2].equals("O")) {
			status = true;
		}

		// controllo colonna 0
		if (griglia[0][0].equals("X") && griglia[1][0].equals("X") && griglia[2][0].equals("X")) {
			status = true;
		} else if (griglia[0][0].equals("O") && griglia[1][0].equals("O") && griglia[2][0].equals("O")) {
			status = true;
		}

		// controllo colonna 1
		if (griglia[0][1].equals("X") && griglia[1][1].equals("X") && griglia[2][1].equals("X")) {
			status = true;
		} else if (griglia[0][1].equals("O") && griglia[1][1].equals("O") && griglia[2][1].equals("O")) {
			status = true;
		}

		// controllo colonna 2
		if (griglia[0][2].equals("X") && griglia[1][2].equals("X") && griglia[2][2].equals("X")) {
			status = true;
		} else if (griglia[0][2].equals("O") && griglia[1][2].equals("O") && griglia[2][2].equals("O")) {
			status = true;
		}

		// controllo diagonale sx-dx
		if (griglia[0][0].equals("X") && griglia[1][1].equals("X") && griglia[2][2].equals("X")) {
			status = true;
		} else if (griglia[0][0].equals("O") && griglia[1][1].equals("O") && griglia[0][2].equals("O")) {
			status = true;
		}

		// controllo diagonale dx-sx
		if (griglia[0][2].equals("X") && griglia[1][1].equals("X") && griglia[2][0].equals("X")) {
			status = true;
		} else if (griglia[0][2].equals("O") && griglia[1][1].equals("O") && griglia[2][0].equals("O")) {
			status = true;
		}

		return status;
	}

}
