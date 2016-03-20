package maven.Zad1Projekt2;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MessageAppTest 
{
	Messenger messenger;
	MessageServiceImpl messageServiceImpl;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER_2 = ".eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp()
	{
		messageServiceImpl = new MessageServiceImpl();
		messenger = new Messenger(messageServiceImpl);
	}

	@Test
	public void check_sendMessage_error()
	{
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void check_sendMessage_sent()
	{
		messageServiceImpl.setSend(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void check_sendMessage_exception()
	{
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		assertEquals(2, messenger.sendMessage(INVALID_SERVER_2, VALID_MESSAGE));
	}
	
	@Test
	public void check_testConnection_failure()
	{
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void check_testConnection_success()
	{
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void tearDown()
	{
		messageServiceImpl = null;
		messenger = null;
	}
}
