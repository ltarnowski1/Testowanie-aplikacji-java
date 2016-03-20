package maven.Zad1Projekt2;

public class MessageServiceImpl implements MessageService {

	private boolean isSend = false;
	
	public void setSend(boolean isSend)
	{
		this.isSend = isSend;
	}
	
	public ConnectionStatus checkConnection(String server) {
		if(server.endsWith("pl"))
			return ConnectionStatus.SUCCESS;
		else
			return ConnectionStatus.FAILURE;
	}

	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		
		if(server.length() < 4 || message.length() < 3)
			throw new MalformedRecipientException();
		if(isSend == true)
			return SendingStatus.SENT;
		else
			return SendingStatus.SENDING_ERROR;
	}

}
