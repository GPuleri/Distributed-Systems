package esercizio3;

public class Scrittore extends Thread {
	
	Monitor m;
	private int id;
	
	public Scrittore (Monitor m, int id) {
		this.m = m;
		this.id = id;
	}

	private void scriviDato() {
		m.scrivi();
		System.out.println("scrittore " + id + " ha scritto "+m.get());
		m.fineScrittura();
	}

	public void run() {
		while(true) {
			this.scriviDato();
		}
	}
}
