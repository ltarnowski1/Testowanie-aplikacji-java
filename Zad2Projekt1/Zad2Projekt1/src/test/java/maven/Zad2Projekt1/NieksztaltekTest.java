package maven.Zad2Projekt1;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NieksztaltekTest {

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
	public void NieksztaltekTest()
	{
		assertThat(p.Nieksztaltek(120), is(120));
		assertThat(p.Nieksztaltek(170), is(110));
		assertThat(p.Nieksztaltek(369), either(is(399)).or(is(869)));
		assertThat(p.Nieksztaltek(376), either(is(876)).or(is(316)).or(is(379)));
	}
}
