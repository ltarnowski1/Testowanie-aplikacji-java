package maven.Zad2Projekt1;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajChochlaTest {

	private PsikusImpl p;
	
	@Before
	public void setUp() throws Exception {
		p = new PsikusImpl(50);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}
	
	@Test
	(expected = NieudanyPsikusException.class)
	public void HultajChochlaTestException() throws NieudanyPsikusException
	{
		p.HultajChochla(8);
	}
	
	@Test
	public void HultajChochlaTest() throws NieudanyPsikusException
	{
		assertThat(p.HultajChochla(12), is(21));
		assertThat(p.HultajChochla(123), either(is(321)).or(is(132)).or(is(213)));
		assertThat(p.HultajChochla(-12), is(-21));
		assertThat(p.HultajChochla(-123), either(is(-321)).or(is(-132)).or(is(-213)));
	}
}
