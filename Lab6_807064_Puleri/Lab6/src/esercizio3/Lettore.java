package esercizio3;

public class Lettore extends Thread{

	Monitor m;
	private int id;

	public Lettore(Monitor m, int id) {
		this.m = m;
		this.id = id;
	}

	private void leggiDato() {
		m.leggi();
		System.out.println("lettore " + id + " ha letto "+m.get());
		m.fineLettura();
	}

	public void run() {
		while(true) {
			this.leggiDato();
		}
	}

}
