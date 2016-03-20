package maven.Zad1Projekt2;

public interface MessageService {
		
	ConnectionStatus checkConnection(String server);
	
	SendingStatus send(String server, String message) throws MalformedRecipientException;

}
