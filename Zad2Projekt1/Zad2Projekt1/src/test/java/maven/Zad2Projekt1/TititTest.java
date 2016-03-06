package maven.Zad2Projekt1;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TititTest {

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
	public void TititTest() {
		assertThat(p.Titit(1), is(true));
		assertThat(p.Titit(2), is(true));
		assertThat(p.Titit(51), is(false));
		assertThat(p.Titit(62), is(false));
	}
}
