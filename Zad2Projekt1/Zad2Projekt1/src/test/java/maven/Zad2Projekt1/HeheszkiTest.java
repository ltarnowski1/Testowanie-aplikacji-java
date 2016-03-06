package maven.Zad2Projekt1;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeheszkiTest {
	
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
	public void HeheszkiTestEsception() throws NieudanyPsikusException
	{
		p.Heheszki(0);
	}
	
	
	@Test
	public void HeheszkiTest() throws NieudanyPsikusException
	{
		assertThat(p.Heheszki(-1), either(greaterThanOrEqualTo(0)).or(lessThan(1)));
		assertThat(p.Heheszki(1), either(greaterThanOrEqualTo(0)).or(lessThan(1)));
		assertThat(p.Heheszki(10), either(greaterThanOrEqualTo(0)).or(lessThan(10)));
		assertThat(p.Heheszki(100), either(greaterThanOrEqualTo(0)).or(lessThan(100)));
	}
}
