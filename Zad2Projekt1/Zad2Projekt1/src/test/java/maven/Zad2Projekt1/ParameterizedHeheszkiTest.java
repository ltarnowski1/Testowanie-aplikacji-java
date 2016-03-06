package maven.Zad2Projekt1;
import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedHeheszkiTest {

	private Integer input;
	private Integer expected;
	private PsikusImpl p;
	
	@Before
	public void initialize()
	{
		p = new PsikusImpl(50);
	}
	   
	@Parameterized.Parameters
	public static Collection primeNumbers() {
	return Arrays.asList(new Object[][] {
		{ -1, 0 }
	    });
	 }
	 public ParameterizedHeheszkiTest(Integer input, Integer expected)
	 {
		 this.input = input;
		 this.expected = expected;
	 }
	 
	 @Test  
	 public void HeheszkiTest() throws NieudanyPsikusException
	 {
		 System.out.println("Parameterized Number is : " + input);
	     assertEquals(expected, p.Heheszki(input));
	 }
}
