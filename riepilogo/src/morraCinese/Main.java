/*
Scrivere un programma che simula il gioco "morra cinese".

Il computer "genera" in maniera casuale la sua mossa ("carta", "forbice", "sasso") senza mostrarla all'utente.

All'utente viene chiesto di inserire la sua mossa, e a questo punto viene mostrata anche la mossa del computer.
Il programma mostra quindi chi ha vinto, secondo le seguenti regole:


il sasso vince sulla forbice
la forbice vince sulla carta
la carta vince sul sasso
dopo ogni partita, mostrare il punteggio dell'utente e del computer

Il programma termina quando uno dei due giocatori arriva a 5.
 */
package morraCinese;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Gioco.svolgimento(scanner);
		scanner.close();
		System.exit(0);

	}

}
