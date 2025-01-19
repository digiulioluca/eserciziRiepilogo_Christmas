/*
 *Esercizio 11: Bingo

Scrivere un programma che simuli il gioco "Bingo"

All'avvio del programma generare la scheda dell'utente con 15 numeri casuali da 1 a 90 tutti diversi tra loro.

Generare quindi i numeri estratti dal tabellone: i numeri vanno da 1 a 90 e
non può essere estratto due volte lo stesso numero.

Dopo ogni numero estratto, verificare se l'utente ha fatto "cinquina" oppure "bingo"
 */
package bingo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bingo.svolgimento(scanner);
		scanner.close();
		System.exit(0);
	}

}
