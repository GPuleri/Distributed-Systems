package esercizio2;

public class Buffer {
	int n;
	boolean full = false;

	public synchronized void deposit(int val) {
		while(full) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		n=val;
		full = true;
		notifyAll();
	}

	public synchronized int extract() {
		int val;
		while(!full) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		full = false;
		val=n;
		notifyAll();
		return val;
	}
}
