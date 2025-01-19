/*Scrivere un programma che simuli il gioco "Tic-Tac-Toe", altrimenti noto come "Tris".

Simulare il campo da gioco con una matrice stringa 3x3.

Ci sono due giocatori: il giocatore 1 (simbolo "X") e il giocatore 2 (simbolo "0") che si alternano.
Il programma chiede al giocatore di turno la posizione in cui mettere il proprio simbolo (riga,colonna)
 e viene visualizzata la matrice.

Se la posizione è già occupata, mostrare un messaggio di errore.

Il programma termina quando uno dei due giocatori vince oppure tutte le caselle sono occupate (pareggio).
 */
package ticTacToe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tris.svolgimento(scanner);
		scanner.close();
		System.exit(0);
	}

}
