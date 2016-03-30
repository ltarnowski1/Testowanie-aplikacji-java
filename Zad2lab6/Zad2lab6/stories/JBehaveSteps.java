
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import stories.*;
import stories.Zad2lab6.ArrayOperationsImpl;
public class JBehaveSteps extends Steps{
	
	private Integer[] array = new Integer[3];
	ArrayOperationsImpl impl = new ArrayOperationsImpl();
	
	@Then("largest should be equal $value")
	public void largestShouldBeEqual3(@Named("value") int value){
		 if(impl.largest(array) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
	
	@Given("an array by value $value")
	public void variableWithIndex0ByValue1(@Named("value") Integer[] value){
		array = value;
	}
}
