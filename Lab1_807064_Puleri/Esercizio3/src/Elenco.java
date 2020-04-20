
public class Elenco implements java.io.Serializable {
	private static final long serialVersionUID = 2L;
	public String elencoIscritti[];
	
	
	public Elenco() {
		elencoIscritti = new String[20];
	}

	public void registra(String cognome) {

		int i=0;
		while(i<20){
			if(elencoIscritti[i]==null){
				elencoIscritti[i]=cognome;
				return;
			}
			i++;
		}
		
		System.out.println("Evento al completo.");
			
	}
	
	public void stampa(){
		
		int i=0;
		while(i<20){
			if(elencoIscritti[i]!=null){
				System.out.println(elencoIscritti[i]);
				i++;
			}
			else 
				return;
		}
	}
	
}