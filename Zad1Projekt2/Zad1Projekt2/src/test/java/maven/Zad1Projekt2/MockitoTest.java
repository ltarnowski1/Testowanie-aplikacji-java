package maven.Zad1Projekt2;

import static org.junit.Assert.*;

import java.nio.file.WatchEvent;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {

	Messenger messenger;
	MessageService msMockito;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = ".eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp()
	{
		msMockito = Mockito.mock(MessageService.class);
		messenger = new Messenger(msMockito);
	}

	@Test
	public void sendMessage_1_Test() throws MalformedRecipientException
	{
		Mockito.when(msMockito.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		Mockito.verify(msMockito).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void sendMessage_0_Test() throws MalformedRecipientException
	{
		Mockito.when(msMockito.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		Mockito.verify(msMockito).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void sendMessage_2_Test() throws MalformedRecipientException
	{
		Mockito.when(msMockito.send(INVALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
		Mockito.verify(msMockito).send(INVALID_SERVER, INVALID_MESSAGE);
	}
	
	@Test
	public void testConnection_1_Test()
	{
		Mockito.when(msMockito.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
		Mockito.verify(msMockito).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testConnection_0_Test()
	{
		Mockito.when(msMockito.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		Mockito.verify(msMockito).checkConnection(VALID_SERVER);
	}
	
	@After
	public void tearDown()
	{
		msMockito = null;
		messenger = null;
	}
}
