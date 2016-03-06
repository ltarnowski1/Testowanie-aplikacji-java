package maven.Zad2Projekt1;

import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CyfroKradTest {

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
	public void CyfroKradTest()
	{
		Assert.assertNull(p.CyfroKrad(0));
		assertThat(p.CyfroKrad(12), is(not(nullValue())));
		assertThat(p.CyfroKrad(123), is(not(nullValue())));
		assertThat(p.CyfroKrad(123), either(is(12)).or(is(23)).or(is(13)));
		assertThat(1, is(p.CyfroKrad(12).toString().length()));
	}
}
