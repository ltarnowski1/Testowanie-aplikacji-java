package test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
		assertThat(calc.add(2, 2), is(4));
	}
	
	@Test
	public void Subtest() {
		assertThat(calc.sub(4, 2), is(2));
	}
	
	@Test
	public void Divtest() {
		assertThat(calc.div(4, 2), is(2));
	}
	
	@Test
	public void Multitest() {
		assertThat(calc.multi(4, 2), is(8));
	}

	@Test
	public void Greatertest() {
		assertThat(calc.greater(4, 2), is(true));
	}
	
	@Test
	public void GreetShouldThrowEx_Null()
	{

		try{
			calc.div(2, 0);
		}
		catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
	}
}
