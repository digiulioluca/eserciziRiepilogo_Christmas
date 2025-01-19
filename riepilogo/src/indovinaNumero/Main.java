/*
Scrivere un programma che genera in maniera casuale, senza farlo vedere all'utente, un numero da 1 a 100.
L'utente deve cercare di indovinare il numero generato. 
Dopo ogni tentativo, il programma mostra un messaggio che dice se il tentativo dell'utente è maggiore, 
minore o uguale al numero generato.

Si continua a chiedere all'utente fino a quando il numero non viene indovinato.
Al termine del programma, mostrare quanti tentativi sono stati effettuati
 */
package indovinaNumero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Gioco.svolgimento(scanner);
		scanner.close();
		System.exit(0);

	}

}
