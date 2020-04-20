package esercizio2;

public class Consumatore extends Thread{
	Buffer b2;
	private int id;
	
	public Consumatore (Buffer b2, int id) {
		this.b2 = b2;
		this.id=id;
	}
	
	private void dividi() {
		int x = b2.extract();
		int result = x/2;
		System.out.println("Consumatore " + id + " ha estratto: "+ x);
		System.out.println("Consumatore " + id + ", risultato: " + result);
	}
	
	public void run() {
		while(true) {
			this.dividi();
		}
	}
	
	
}
