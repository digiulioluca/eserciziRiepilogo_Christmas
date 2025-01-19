/* Scrivere un programma che simuli il gioco "7 e 1/2" tra l'utente e il PC.

All'avvio del programma l'utente ha a disposizione una somma di 100 euro.

Viene chiesto all'utente quanto puntare, e viene estratta una carta dal mazzo.

Dopo ogni carta, viene chiesto all'utente se si vuole un'altra carta oppure se si vuole fermare.

L'obiettivo è raggiungere il punteggio più alto possibile senza superare il valore 7.5.

I valori delle carte sono: 

da 1 a 7: stesso valore della carta
da 8 a 10: mezzo punto
se si supera il 7.5 vince il computer

se non si supera il 7.5, il computer inizia a giocare cercando di battere l'utente. 

In caso di pareggio, vince il computer.

Dopo ogni partita aggiornare la somma disponibile dell'utente (in caso di vittoria 
aumentarla dello stesso valore della puntata, in caso di sconfitta diminuirla), 
quindi chiedere se si vuole fare un'altra partita.

Suggerimenti:

iniziare generando un'arraylist di numeri interi da 1 a 40 tutti diversi tra loro
simulare l'estrazione di una carta alla volta prendendo in sequenza i numeri generati nel punto 1), 
seguendo queste regole:

da 1 a 10: carta di bastoni
da 11 a 20: carta di denari
da 21 a 30: carta di spade
da 31 a 40: carta di coppe
(ad esempio se "esce" il numero 27 la carta è il "7 di spade")
iniziare ad implementare la logica del gioco solo con un giocatore, continuando
ad estrarre le carte fino a quando il giocatore si ferma o supera il 7.5
aggiungere il secondo giocatore e la puntata
 */
package setteEMezzo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Gioco.svolgimento(scanner);
		
		scanner.close();
		
		System.out.println("Uscita dal programma");
		System.exit(0);

	}

}
