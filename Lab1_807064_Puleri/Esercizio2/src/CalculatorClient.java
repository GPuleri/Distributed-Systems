import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {

	public static void main(String[] args) throws Exception {
		Calculator service = (Calculator)Naming.lookup("rmi://localhost/HelloService");
		Scanner t=new Scanner(System.in);
		double ris=0;
		int scelta=0;
		
		System.out.println("Che operazione vuoi eseguire?");
		System.out.println("1 per la somma");
		System.out.println("2 per la sottrazione");
		System.out.println("3 per la moltiplicazione");
		System.out.println("4 per la divisione");
		
		scelta=t.nextInt();
		while(scelta!=1 && scelta!=2 && scelta!=3 && scelta!=4){
			System.out.println("Hai sbagliato ad inserire la scelta, reinserisci:");
			scelta=t.nextInt();
		}
		
		System.out.print("Inserisci il primo numero:");
		double n=t.nextDouble();
		
		System.out.print("Inserisci il secondo numero:");
		double m=t.nextDouble();
		
		switch (scelta){
		case 1:
			ris=service.add(n, m);
			break;
		case 2:
			ris=service.sub(n, m);
			break;
		case 3:
			ris=service.mul(n, m);
			break;
		case 4:
			ris=service.div(n, m);
			break;
			
		}
		
		t.close();
		System.out.println("Il risultato e': "+ris);
		
	}
}
