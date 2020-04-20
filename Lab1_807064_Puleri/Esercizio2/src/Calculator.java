import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

	public double add(double n, double m) throws RemoteException;
	public double sub(double n, double m) throws RemoteException;
	public double mul(double n, double m) throws RemoteException;
	public double div(double n, double m) throws RemoteException;

}
