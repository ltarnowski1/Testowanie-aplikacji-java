package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calc;
	
	@Before
	public void setup()
	{
		calc = new Calculator();
	}
	
	@Test
	public void Addtest() {
		assertEquals(calc.add(2, 2),4);
	}
	
	@Test
	public void Subtest() {
		assertEquals(calc.sub(4, 2),2);
	}
	
	@Test
	public void Divtest() {
		assertEquals(calc.div(4, 2),2);
	}
	
	@Test
	public void Multitest() {
		assertEquals(calc.multi(4, 2),8);
	}

	@Test
	public void Greatertest() {
		assertEquals(calc.greater(4, 2),true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void GreetShouldThrowEx_Null()
	{
		
		calc.div(2, 0);
	}
}
