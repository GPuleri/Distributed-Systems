package esercizio2;

public class Main {
	public static void main(String[] args) {
		Buffer b1 = new Buffer();
		Buffer b2 = new Buffer();

		Produttore p1 = new Produttore(b1, 1);
		Produttore p2 = new Produttore(b1, 2);
		Produttore p3 = new Produttore(b1, 3);
		Quadratico q1 = new Quadratico(b1, b2, 1);
		Quadratico q2 = new Quadratico(b1, b2, 2);
		Quadratico q3 = new Quadratico(b1, b2, 3);
		Consumatore c1= new Consumatore(b2, 1);
		Consumatore c2= new Consumatore(b2, 2);
		Consumatore c3= new Consumatore(b2, 3);
		
		p1.start();
		p2.start();
		p3.start();

		q1.start();
		q2.start();
		q3.start();

		c1.start();
		c2.start();
		c3.start();

	}
}