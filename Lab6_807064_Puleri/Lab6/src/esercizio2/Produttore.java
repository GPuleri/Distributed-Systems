package esercizio2;

public class Produttore extends Thread {

	Buffer b1;
	private int id;

	public Produttore (Buffer b1, int id) {
		this.b1 = b1;
		this.id = id;
	}

	private void deposit() {	
		int x=(int) (Math.random()*10);
		System.out.println("Produttore " + id + " ha prodotto " + x);
		b1.deposit(x);
		System.out.println("Produttore " + id + " ha depositato " + x);
	}

	public void run() {
		while(true) {
			this.deposit();
		}
	}
}



