package setteEMezzo;

import java.util.ArrayList;
import java.util.Scanner;

public class Gioco {
	static ArrayList<Integer> mazzo = new ArrayList<Integer>();
	static boolean[] estratto = new boolean[40];

	/*
	 * metodo per inizializzare il mazzo (arrayList) e settare tutti i valori
	 * dell'array di boolean su false
	 */
	public static void inizializzaMazzo() {
		for (int i = 0; i < estratto.length; i++) {
			mazzo.add(i, (i + 1));
			estratto[i] = false;
		}
	}

	/*
	 * metodo per stampare il seme della carta. Lo lanceremo una volta generato il
	 * numero e tramite una serie di if-else ritorneremo la stringa
	 */
	public static String determinaSeme(int numero) {
		if (numero <= 10) {
			return " di bastoni";
		} else if (numero <= 20) {
			return " di denari";
		} else if (numero <= 30) {
			return " di spade";
		} else {
			return " di coppe";
		}
	}

	public static void svolgimento(Scanner scanner) {
		// settiamo il budget iniziale
		double budget = 100;

		inizializzaMazzo();

		// variabili per ciclo do-while e partita
		int scelta = 0;
		double punteggioGiocatore;
		double puntata;
		double punteggioBanco;
		int estrazione = 0;

		do {
			// inizializziamo a 0 il punteggio per il banco e per il giocatore
			punteggioGiocatore = 0;
			punteggioBanco = 0;
			System.out.println("Budget iniziale: " + budget);
			if (budget == 0) {
				System.out.println("Sei rimasto senza budget, stai uscendo dal programma");
				scelta = 1;
			} else {
				System.out.println("Quanto vuoi puntare?");
				puntata = scanner.nextDouble();

				// se la puntata dovesse essere maggiore del budget chiediamo di reinserire un
				// valore
				if (puntata > budget) {
					System.out.println("Non puoi puntare questa cifra. Inserisci un altro valore");
					scelta = 0;
				} else {
					do {
						/*
						 * andiamo a sottrarre il valore della puntata dal budget, che in caso di
						 * vittoria restituiremo
						 */
						budget -= puntata;
						System.out.println("Estrazione carta...");

						// con un math random andiamo a generare un numero da 1 a 40
						estrazione = (int) (Math.random() * (estratto.length + 1) + 1);
						// se quella carta non è stata estratta, allora mostriamo il valore della carta
						if (estratto[estrazione - 1] == false) {
							int numero = estrazione;
							System.out
									.println("Carta estratta: " + riduzioneValore(estrazione) + determinaSeme(numero));
							// cambiamo "lo stato" di quella carta nell'array boolean
							estratto[estrazione - 1] = true;
						}
						// aggiorniamo il punteggio
						punteggioGiocatore += valoreCarta(riduzioneValore(estrazione));
						if (punteggioGiocatore > 7.5) {
							// se il valore sfora usciamo dal ciclo
							scelta = 1;
						} else {
							// altrimenti lasciamo la scelta al giocatore...
							System.out.println("Punteggio giocatore: " + punteggioGiocatore + "\nVuoi continuare?"
									+ "\n1) no 2) sì (2 o altri numeri) ");
							scelta = scanner.nextInt();
						}
					} while (scelta != 1);

					// se il valore è maggiore a 7.5, concludiamo la partita
					if (punteggioGiocatore > 7.5) {
						System.out.printf("Punteggio: % .1f\nHai sforato.", punteggioGiocatore);
					} else {
						// altrimenti passiamo al banco
						System.out.println("Turno del banco.");

						do {
							/*
							 * grossomodo, si ripetono gli stessi passaggi di prima, senza i vari input che
							 * raccogliamo dall'utente
							 */
							System.out.println("Estrazione carta...");

							estrazione = (int) (Math.random() * (estratto.length + 1) + 1);

							if (estratto[estrazione - 1] == false) {
								int numero = estrazione;
								System.out.println(
										"Carta estratta: " + riduzioneValore(estrazione) + determinaSeme(numero));
							}

							punteggioBanco += valoreCarta(riduzioneValore(estrazione));

							System.out.println("Punteggio banco: " + punteggioBanco);

							if (punteggioBanco >= punteggioGiocatore || punteggioBanco == 7.5)
								scelta = 100;

						} while (scelta != 100);
					}

					// if-else finale per stabilire chi ha vinto, con tutti i casi possibili
					if (punteggioBanco == 7.5 || punteggioBanco >= punteggioGiocatore && punteggioBanco <= 7.5
							|| punteggioGiocatore > 7.5) {
						System.out.println("Il banco ha vinto");
					} else if (punteggioBanco < punteggioGiocatore
							|| punteggioBanco > 7.5 && punteggioGiocatore <= 7.5) {
						System.out.println("Hai vinto!\nPremio: € " + puntata);
						budget += puntata;
					}

					System.out.println("Vuoi rigiocare?\n1) no\t2) sì");
					scelta = scanner.nextInt();
				}
			}
		} while (scelta != 1);

	}

	// metodo per ridurre a un numero da 1 a 10 il numero estratto
	public static int riduzioneValore(int estrazione) {
		while (estrazione >= 11) {
			estrazione -= 10;
		}

		return estrazione;
	}

	/*
	 * metodo per determinare il valore della carta (da 1 a 7 il valore non cambia,
	 * da 8 a 10 il valore cambia in 0.5)
	 */
	public static double valoreCarta(int numero) {

		if (numero < 8) {
			return numero;
		} else {
			return 0.5;
		}
	}
}
