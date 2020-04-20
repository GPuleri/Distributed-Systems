import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		Calculator calc = new CalculatorImpl();
	    Naming.rebind("rmi://localhost:1099/HelloService", calc);
	}
}
