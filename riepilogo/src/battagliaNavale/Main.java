/*
 * Scrivere un programma che simula il gioco "battaglia navale".

Il campo da gioco è una matrice 8x8.

All'avvio del programma "posizionare" in maniera random (senza visualizzare all'utente)
una nave di lunghezza 3 (in orizzontale o in verticale).

Chiedere all'utente di inserire la sua mossa (riga,colonna) e visualizzare:

"acqua" se la nave non è stata colpita
"colpita" se la nave è stata colpita ma non affondata
"affondata" se tutte le caselle della nave sono state individuate
Mostrare con una "X" le caselle dove il colpo è andato a buon fine.

Il gioco termina quando la nave (o tutte le navi) sono affondate.
 */
package battagliaNavale;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Gioco.inizializzaGriglia();
		Gioco.svolgimento(scanner);
		scanner.close();
	}

}
