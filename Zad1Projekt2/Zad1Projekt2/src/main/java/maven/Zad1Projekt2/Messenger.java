package maven.Zad1Projekt2;

import javax.print.attribute.standard.RequestingUserName;

import maven.Zad1Projekt2.MalformedRecipientException;
import maven.Zad1Projekt2.MessageService;
import maven.Zad1Projekt2.SendingStatus;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}
	
	public Messenger()
	{
		
	}

	public int testConnection(String server) {
		if(ms.checkConnection(server) == ConnectionStatus.FAILURE)
			return 1;
		else
			return 0;
	}

	public int sendMessage(String server, String message)
	{
		int result = 3;	
		try
		{	
			SendingStatus ss = ms.send(server, message);
			if(ss == SendingStatus.SENT)
				result = 0;
			if(ss == SendingStatus.SENDING_ERROR)
				result = 1;
		}
		catch(MalformedRecipientException e)
		{
			result = 2;
		}
		return result;
	}
}
