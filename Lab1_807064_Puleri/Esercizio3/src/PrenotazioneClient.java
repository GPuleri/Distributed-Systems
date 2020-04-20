import java.rmi.Naming;
import java.util.Scanner;

public class PrenotazioneClient {

	public static void main(String[] args) throws Exception {
	Prenotazione service = (Prenotazione)Naming.lookup("rmi://localhost/HelloService");
	Scanner t=new Scanner(System.in);
	
	int scelta=-1;
	int evento;
	Elenco e1=new Elenco();
	do{
		System.out.println("Inserisci 1 per aggiungere una persona ad un evento");
		System.out.println("Inserisci 2 per visualizzare l'elenco di un evento");
		System.out.println("Inserisci -1 per terminare il programma");
		scelta=t.nextInt();
		switch(scelta){
			case 1:
				System.out.print("Inserisci il cognome utente per la registrazione: ");
				String cognome=t.next();
			
				System.out.print("A quale evento vorresti iscriverti? (1, 2, 3) ");
				evento=t.nextInt();
				service.registrazione(cognome, evento);
				break;
				
			case 2:
				System.out.print("Quale evento vorresti visualizzare? (1, 2, 3) ");
				evento=t.nextInt();
				e1=service.stampaElenco(evento);
				System.out.println("Iscritti all'evento "+evento+": ");
				e1.stampa();
				break;
				
			case -1:
				System.out.println("Programma terminato");
				break;
			
			default:
				System.out.println("Comando sbagliato!");
				break;			
		}
	} while(scelta!=-1);
	 t.close();
	
	}
}
