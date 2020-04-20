package esercizio3;

import java.util.Random;

public class Monitor {
	private char c;
	
	private boolean turnoLettori = true; 
	private boolean turnoScrittori = true;
	private int scrittoriInCoda = 0; 
	private int lettoriAttivi = 0; 
	private int lettoriInCoda = 0; 
	private boolean busy = false; 
	
	public synchronized void leggi() {
		lettoriInCoda++;
		while ((scrittoriInCoda > 0) && turnoScrittori)
			try {
				wait();
			} catch(InterruptedException e){}
		lettoriInCoda--;
		lettoriAttivi++;
	}
	
	public synchronized void fineLettura() {
		lettoriAttivi--;
		if (scrittoriInCoda > 0) {
			turnoScrittori = true;
			turnoLettori = false;
		}
		if (lettoriAttivi == 0) 
			notifyAll();
	}
	
	public synchronized void scrivi() {
		scrittoriInCoda++;
		while (busy || (lettoriAttivi > 0) || ((lettoriInCoda > 0) && turnoLettori))
			try {
				wait();
			} catch(InterruptedException e){}
		Random r=new Random();
		c=(char) (r.nextInt(26)+'a');
		busy = true;
	}
	
	public char get() {
		return c;
	}

	public synchronized void fineScrittura() {
		busy = false;
		scrittoriInCoda--;
		if (lettoriInCoda > 0) {
			turnoLettori = true;
			turnoScrittori = false;
		}
		notifyAll();
	}
}
