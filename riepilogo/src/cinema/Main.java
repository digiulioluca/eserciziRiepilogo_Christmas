/*
 *Scrivere un programma che calcoli il biglietto di ingresso di un cinema.

Il proprietario del cinema ha deciso che:

    i bambini con meno di 10 anni entrano gratis
    i ragazzi tra 10 anni e 14 anni pagano 6 euro
    da 15 anni in poi si paga il biglietto intero di 8 euro
    il mercoledì sconto per tutti di 2 euro

Dopo aver visualizzato il costo del biglietto, chiedere all'utente
se si vuole calcolare il costo di un altro biglietto.
In caso affermativo, ripetere l'inserimento dei dati ed il calcolo
*/
package cinema;

import java.util.Scanner;

public class Main {

	/*
	 * gestione del menù: utilizziamo un do-while con all'interno uno switch. è
	 * stato aggiunto anche un try-catch per evitare che nel momento della scelta
	 * venga inserito un carattere. Il case 1 ha al suo interno un altro do-while
	 * per permettere all'utente di effettuare ulteriori calcoli.
	 */
	public static void menu(Scanner scanner) {

		int scelta = 0;
		int proseguimento = 0;
		do {
			System.out.println("Benvenuto al cinema!\n" + "Scegli cosa fare: \n 1) Acquisto biglietti" + "\n 2) Esci");
			try {
				scelta = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Inserimento dei caratteri non consentito.");
				scanner.next();
			}
			switch (scelta) {
			case 1:
				Biglietto.calcoloGiorno();
				do {
					Biglietto.calcoloPrezzo(scanner);
					System.out.println("Vuoi calcolare il prezzo per un altro biglietto?\n"
							+ "Premere un numero diverso da 1 per continuare");
					proseguimento = scanner.nextInt();
				} while (proseguimento != 1);

				break;
			case 2:
				System.out.println("Stai uscendo dal programma.");
				break;
			default:
				System.out.println("Codice errato.");
			}

		} while (scelta != 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
		scanner.close();
		System.exit(0);

	}

}