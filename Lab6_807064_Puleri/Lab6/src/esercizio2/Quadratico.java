package esercizio2;


public class Quadratico extends Thread{
	
	Buffer b1;
	Buffer b2;
	private int id;
	
	public Quadratico (Buffer b1, Buffer b2, int id) {
		this.b1 = b1;
		this.b2 = b2;
		this.id=id;
	}
	
	private void eleva() {
		int x = b1.extract();
		int result = x*x;
		System.out.println("Quadratico " + id + " ha estratto: " + x);
		System.out.println("Quadratico " + id + ", risultato: " + result);
		b2.deposit(x);
		System.out.println("Quadratico " + id + " ha depositato " + x);
	}

	public void run() {
		while(true) {
			this.eleva();
		}
	}
}
