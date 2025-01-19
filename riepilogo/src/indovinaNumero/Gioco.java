package indovinaNumero;

import java.util.Scanner;

public class Gioco {
	// attributi classe
	static int numeroGenerato;
	static int numeroInserito;
	
	// genero il numero tramite il Math.random
	public static int generatore() {
		numeroGenerato = (int) (Math.random()*100+1);
		return numeroGenerato;
	}
	
	/* Svolgimento del gioco:
	 dopo aver lanciato il metodo generatore, dichiaro una variabile tentativi che terrà conto
	 di quanti tentativi verranno effettuati durante il corso della partita. Detto ciò, passiamo al do-while.
	 Per far sì che il gioco vada avanti fino a che l'utente non indovina il numero generatore, è necessario
	 porre come condizione del ciclo che il numero generato e il numero inserito siano diversi.
	 Inserito il numero aggiorniamo il counter e passiamo al controllo. Ogni volta che il numero è sbagliato
	 viene effettuato un controllo per suggerire all'utente cosa fare nella prossima mossa (inserire un numero
	 più grande o più piccolo). 
	 */
	public static void svolgimento(Scanner scanner) {
		generatore();
		System.out.println("Benvenuto nel gioco!");
		int tentativi = 0;
		do {
			System.out.println("Inserisci un numero: ");
			numeroInserito=scanner.nextInt();
			tentativi++;
			if (numeroInserito<numeroGenerato) {
				System.out.println("Numero sbagliato! Riprova con un numero maggiore.");
			} else if (numeroInserito>numeroGenerato) {
				System.out.println("Numero sbagliato! Riprova con un numero minore.");
			} else if (numeroInserito==numeroGenerato) {
				System.out.println("Complimenti, hai indovinato!");
			}
		} while (numeroInserito!=numeroGenerato);
			
		System.out.println("Gioco concluso!\nTentativi effettuati: "+tentativi);
	}
}
