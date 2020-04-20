import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class PrenotazioneServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		Prenotazione prenot = new PrenotazioneImpl();
	    Naming.rebind("rmi://localhost:1099/HelloService", prenot);
	}
}
