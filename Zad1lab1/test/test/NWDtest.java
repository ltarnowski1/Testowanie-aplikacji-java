package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NWDtest {

	private NWDImpl test;
	
	@Before
	public void setup()
	{
		test = new NWDImpl();
	}
	
	@Test
	public void NWDTest() {
		
		assertEquals(test.NWD1(10, 2),2);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDIllegalArgumentTest() {
		test.NWD1(-2, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NWDIllegalArgumentTest2() {
		test.NWD1(2, -2);
	}
	
	@After
	public void teardown()
	{
		test = null;
	}
}
