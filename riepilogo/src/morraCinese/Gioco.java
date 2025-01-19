package morraCinese;

import java.util.Scanner;

public class Gioco {
	// attributi
	static String[] mosse = { "Sasso", "Carta", "Forbice" };
	static String mossaUtente;
	static int counterPC = 0;
	static int counterPlayer = 0;

	/*
	 * Metodo svolgimento: dichiaro due stringhe, che verrano utilizzate per
	 * memorizzare i valori generati per il pc e i valori inseriti dall'utente.
	 * Fatto ciò viene avviato il giocato, uno while che, ciclicamente, genera la
	 * mossa del pc e ne chiede una all'utente. Effettuati i due passaggi parte il
	 * metodo controlloMosse che aggiornerà i counter e verrà stampato il risultato.
	 * Non appena uno dei due valori supera 5, si esce dal ciclo e verrà decretato
	 * il vincitore
	 */
	public static void svolgimento(Scanner scanner) {
		String mossaPC = " ";

		while (counterPC < 5 && counterPlayer < 5) {
			mossaPC = mosse[(int) (Math.random() * 3)];
			System.out.println("Fai una mossa:\n- Sasso - Carta - Forbice");
			mossaUtente = scanner.nextLine();
			if (mossaUtente.equalsIgnoreCase("Forbice") || mossaUtente.equalsIgnoreCase("Carta")
					|| mossaUtente.equalsIgnoreCase("Sasso")) {
				controlloMosse(mossaPC, mossaUtente);
			} else {
				System.out.println("Mossa inesistente. Punteggio non aggiornato.");
			}
			System.out.println("Punteggio\nPC: " + counterPC + ", Player: " + counterPlayer);
		}

		if (counterPC == 5) {
			System.out.println("PC vince!\nPunteggio finale: PC " + counterPC + ", Player " + counterPlayer);
		} else if (counterPlayer == 5) {
			System.out.println("Player vince!\nPunteggio finale: PC " + counterPC + ", Player " + counterPlayer);
		}
	}

	/*
	 * Metodo per il controllo delle mosse: raccolti come parametri i valori delle
	 * stringhe, passiamo al controllo tramite una serie di if-else. In base al
	 * risultato viene aggiornato il counter
	 */
	public static void controlloMosse(String mossaPC, String mossaUtente) {
		if (mossaPC.equalsIgnoreCase("Sasso") && mossaUtente.equalsIgnoreCase("Forbice")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPC++;
		} else if (mossaUtente.equalsIgnoreCase("Sasso") && mossaPC.equalsIgnoreCase("Forbice")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPlayer++;
		} else if (mossaPC.equalsIgnoreCase("Forbice") && mossaUtente.equalsIgnoreCase("Carta")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPC++;
		} else if (mossaUtente.equalsIgnoreCase("Forbice") && mossaPC.equalsIgnoreCase("Carta")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPlayer++;
		} else if (mossaPC.equalsIgnoreCase("Carta") && mossaUtente.equalsIgnoreCase("Sasso")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPC++;
		} else if (mossaUtente.equalsIgnoreCase("Carta") && mossaPC.equalsIgnoreCase("Sasso")) {
			System.out.println("Mossa PC: " + mossaPC);
			counterPlayer++;
		} else if (mossaUtente.equalsIgnoreCase(mossaPC)) {
			System.out.println("Mossa PC: " + mossaPC + "\nParità");
		}
	}
}
