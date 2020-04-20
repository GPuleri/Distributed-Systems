import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Prenotazione extends Remote {

	Elenco e1=new Elenco();
	Elenco e2=new Elenco();	
	Elenco e3=new Elenco();	
	public Elenco[] eventi = {e1,e2,e3};
	
	public void registrazione(String cognome, int evento) throws RemoteException;
	public Elenco stampaElenco(int evento) throws RemoteException;
}
