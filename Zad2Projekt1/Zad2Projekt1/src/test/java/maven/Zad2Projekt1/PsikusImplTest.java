package maven.Zad2Projekt1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PsikusImplTest {

	private PsikusImpl p;
	private List<Integer> l;
	
	@Before
	public void setUp() throws Exception {
		p = new PsikusImpl();
		l = new ArrayList<Integer>(); 
		l.add(12);
		l.add(23);
		l.add(13);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void test() {
		Assert.assertNull(p.CyfroKrad(0));
		assertThat(p.CyfroKrad(12), is(not(nullValue())));
		assertThat(p.CyfroKrad(123), is(not(nullValue())));
		assertThat(p.CyfroKrad(123), isIn(l));
		assertThat(1, is(p.CyfroKrad(12).toString().length()));
	}

}
