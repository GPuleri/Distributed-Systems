import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PrenotazioneImpl extends UnicastRemoteObject implements Prenotazione{

	private static final long serialVersionUID = 1L;

	protected PrenotazioneImpl() throws RemoteException {
		super();
	}
	
	@Override
	public void registrazione(String cognome, int evento) throws RemoteException{
		eventi[evento-1].registra(cognome);
	}
	
	@Override
	public Elenco stampaElenco(int evento) throws RemoteException{
		return eventi[evento-1];
	}
}
