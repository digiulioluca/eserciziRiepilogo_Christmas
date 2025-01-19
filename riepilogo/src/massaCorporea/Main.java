/*
 Scrivere un programma che, in base all'altezza e al peso di una persona,
 ne calcola l'indice di massa corporea (BMI).

La formula per calcolarlo è:
BMI=peso/(altezza*altezza)

dove il peso è indicato in kg e l'altezza è indicata in cm

Se il peso inserito è < 0 oppure l'altezza inserita non è compresa tra 0 e 2.50 mostrare
all'utente un messaggio di errore e richiedere l'inserimento.

Mostrare all'utente il valore del suo BMI e la fascia di appartenenza, secondo la tabella
nella pagina seguente:
https://www.salute.gov.it/portale/nutrizione/dettaglioIMCNutrizione.jsp?lingua=italiano&id=5479&area=nutrizione&menu=vuoto

valori possibili:
<16.00 = grave magrezza
16.00 < x < 18.49 = sottopeso 
18.50 < x < 24.99 = normopeso
25.00 < x < 29.99 = sovrappeso
30.00 < x < 34.99 = obeso classe 1
35.00 < x < 39.99 = obeso classe 2
>= 40.00 = obeso classe 3 

Dopo aver mostrato i risultati all'utente, chiedere se si vuole effettuare un altro calcolo. 
In caso affermativo ripetere l'inserimento



*/
package massaCorporea;

import java.util.Scanner;

public class Main {
	
	
	/* menù gestito tramite do-while e switch. Nel case 1 è presente un altro do-while 
	per permettere all'utente di effettuare più volte  di seguito il calcolo*/
	public static void menu(Scanner scanner) {
		int scelta = 0;
		int ricalcolo=0;
		do {
			System.out.println("Benvenuto nel sistema di calcolo del BMI (Body-Mass Index)!\n"
					+"Scegliere un'opzione:\n1) Calcolo\n2) Esci");
			try {
			scelta=scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Inserimento dei caratteri non consentito. Riprovare con dei numeri.");
				scanner.next();
			}
			switch(scelta) {
			case 1:
				do {
					Calcoli.risultati(scanner);
					System.out.println("\nVuoi continuare?\n"
							+"Inserire un numero diverso da 1 per proseguire con i calcoli.");
					ricalcolo=scanner.nextInt();
				} while (ricalcolo==1);
				break;
			case 2:
				System.out.println("Uscita dal programma.");
				break;
			default:
				System.out.println("Codice errato.");
			}
		} while (scelta!=2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		menu(scanner);
		
		scanner.close();
		
		System.exit(0);
	}

}
