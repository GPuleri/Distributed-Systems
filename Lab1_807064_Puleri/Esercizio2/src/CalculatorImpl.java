import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator{

	private static final long serialVersionUID = 1L;

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public double add(double n, double m) throws RemoteException {
		return n+m;
	}
	
	@Override
	public double sub(double n, double m) throws RemoteException {
		return n-m;
	}
	
	@Override
	public double mul(double n, double m) throws RemoteException {
		return n*m;
	}
	
	@Override
	public double div(double n, double m) throws RemoteException {
		return n/m;
	}
}
