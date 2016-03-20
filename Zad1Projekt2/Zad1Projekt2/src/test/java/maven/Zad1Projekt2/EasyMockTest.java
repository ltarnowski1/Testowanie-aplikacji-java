package maven.Zad1Projekt2;
import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EasyMockTest
{
	Messenger messenger;
	MessageService msMock;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = ".eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp()
	{
		msMock = EasyMock.createMock(MessageService.class);
		messenger = new Messenger(msMock);
	}

	@Test
	public void sendMessage_1_Test() throws MalformedRecipientException
	{
		EasyMock.expect(msMock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		EasyMock.replay(msMock);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		EasyMock.verify(msMock);
	}
	
	@Test
	public void sendMessage_0_Test() throws MalformedRecipientException
	{
		EasyMock.expect(msMock.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		EasyMock.replay(msMock);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		EasyMock.verify(msMock);
	}
	
	@Test
	public void sendMessage_2_Test() throws MalformedRecipientException
	{
		EasyMock.expect(msMock.send(INVALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(msMock);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
		EasyMock.verify(msMock);
	}
	
	@Test
	public void testConnection_1_Test()
	{
		EasyMock.expect(msMock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(msMock);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
		EasyMock.verify(msMock);
	}
	
	@Test
	public void testConnection_0_Test()
	{
		EasyMock.expect(msMock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(msMock);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		EasyMock.verify(msMock);
	}
	
	@After
	public void tearDown()
	{
		msMock = null;
		messenger = null;
	}
}
