package massaCorporea;

import java.util.Scanner;

public class Calcoli {
	// attributi
	static double peso;
	static double altezza;
	static double indiceMC;
	
	/* metodo per il calcolo:
	 * utilizzo un do-while per controllare se l'altezza e il peso inseriti sono esatti. Verificate le condizioni
	 * passo al calcolo dell'indice. Metodo di tipo double che restituirà il valore dell'indice
	 */
	public static double calcoloBMI(Scanner scanner) {
		
		int uscita = 0;
		
		do {
			System.out.println("Inserisci peso (kg):");
			peso=scanner.nextDouble();
			System.out.println("Inserisci altezza (m): ");
			altezza=scanner.nextDouble();
			if (peso>0) {
				if (altezza<=250 && altezza>0) {
					uscita=1;
				} else {
					System.out.println("Valore altezza non accettato. Reinserire tutti e due i valori.");
				}
			} else {
				System.out.println("Valore peso non accettato. Reinserire tutti e due i valori.");
			}
		}while (uscita == 0);
		
		indiceMC = peso/(altezza*altezza);
		
		return indiceMC;
	}
	
	
	/* metodo risultato.
	 * Eseguo il metodo precedente all'inizio per ottenere il valore dell'indice MC.
	 * raccolto il valore passo al controllo tramite una serie di if-else che restituirà una stampa in output
	 * con i dati inseriti e la fascia di appartenenza
	 */
	public static void risultati(Scanner scanner) {
		
		calcoloBMI(scanner);
		
		if (indiceMC < 16) {
			System.out.println("Dati: \nPeso: "+peso+" kg\nAltezza: "+altezza+" m");
			System.out.format("Risultato BMI: %.2f\nFascia: grave magrezza", indiceMC);
		} else if (indiceMC >= 16 && indiceMC < 18.50) {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: sottopeso", indiceMC);
		} else if (indiceMC >= 18.50 && indiceMC < 25) {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: normopeso", indiceMC);
		} else if (indiceMC >= 25 && indiceMC < 30) {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: sovrappeso", indiceMC);
		} else if (indiceMC >= 30 && indiceMC < 35) {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: obeso classe 1", indiceMC);
		} else if (indiceMC >= 35 && indiceMC < 40) {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: obeso classe 2", indiceMC);
		} else {
			System.out.println("Dati: \n Peso: "+peso+" kg\nAltezza: "+altezza+" m\n");
			System.out.format("Risultato BMI: %.2f\nFascia: obeso classe 3", indiceMC);
		}
	}
	
}
