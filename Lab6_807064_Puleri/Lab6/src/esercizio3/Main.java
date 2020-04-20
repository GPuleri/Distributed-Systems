package esercizio3;

public class Main {

	public static void main(String[] args) {

		Monitor m=new Monitor();
		Scrittore s1= new Scrittore(m, 1);
		Scrittore s2= new Scrittore(m, 2);
		Scrittore s3= new Scrittore(m, 3);
		Lettore l1= new Lettore(m, 1);
		Lettore l2= new Lettore(m, 2);
		Lettore l3= new Lettore(m, 3);
		Lettore l4= new Lettore(m, 4);
		Lettore l5= new Lettore(m, 5);
		Lettore l6= new Lettore(m, 6);
		Lettore l7= new Lettore(m, 7);
		Lettore l8= new Lettore(m, 8);

		s1.start();
		s2.start();
		s3.start();
		l1.start();
		l2.start();
		l3.start();
		l4.start();
		l5.start();
		l6.start();
		l7.start();
		l8.start();

	}
}


