package stories.Zad1Projekt3;
import java.util.List;

import org.jbehave.core.annotations.*;
import org.jbehave.core.embedder.StoryManager.ThrowableStory;
import org.jbehave.core.steps.Steps;

public class MySteps extends Steps {

	MyStack myStack;

	//@BeforeScenario
	//public void up() {
	//	myStack = new MyStack();
	//}

	int element;

	@Given("stack is empty")
	public void givenTheEmptyStack() {
		myStack = new MyStack();
	}

	@Then("IsNull should be true")
	public void thenIsEmptyShouldBeTrue() {
		try {
			if (myStack.IsNull() == true) {
				throw new RuntimeException("Error in IsEmpty method. It's ok");
			}
		} catch (Exception e) {
		}
	}

	@Given("stack by $list")
	public void givenTheStackBylist(@Named("list") List<Integer> list) {
		myStack = new MyStack(list);
	}

	@Then("IsNull should be false")
	public void thenIsEmptyShouldBeFalse() {
		if (myStack.IsNull() == true) {
			throw new RuntimeException("Error in IsEmpty method. It's ok");
		}
	}

	// pop
	@Given("the nonEmpty stack by $list")
	public void givenTheNonemptyStackBylist(@Named("list") List<Integer> list) {
		myStack = new MyStack(list);
	}

	@When("MyPop occurs")
	public void whenMyPopOccurs() {
		myStack.MyPoP();
	}

	@Then("the top of stack should be $elem")
	public void thenTheTopOfStackShouldBeelem(@Named("elem") int elem) {
		if (myStack.MyTop() != elem) {
			throw new RuntimeException("Is Ok");
		}
	}

	@Given("an element by $elem")
	public void givenAnElementByelem(@Named("elem") int elem) {
		element = elem;
	}

	@When("an element is added to the stack")
	public void whenAnElementIsAddedToTheStack() {
		myStack.MyPush(element);
	}

	@Then("the stack should have $elem")
	public void thenTheStackShouldHaveelem(@Named("elem") int elem) {
		if (myStack.MyTop() != elem) {
			throw new RuntimeException("Is Ok");
		}
	}

	@When("stack is empty")
	public void whenTheStackIsEmpty() {
	}

	@Then("MyTop should throw an exception")
	public void thenMyTopShouldThrowAnExcetion() {
		try {
			myStack.MyTop();
		} catch (NullPointerException e) {
		}
	}



	@Then("MyPop should throw an exception")
	public void thenMyPopShouldThrowAnException() {
		try {
			myStack.MyPoP();
		} catch (NullPointerException e) {
		}
	}
	
	
	@When("Add new element $elem")
	public void whenAddNewElementelem(@Named("elem") int elem){
		element = elem;
	}
	
	
	@Then("MyTop should be $elem")
	public void thenMyTopShouldBeelem(@Named("elem") int elem){
		myStack.MyPush(elem);
		if (myStack.MyTop() != elem)
			throw new RuntimeException("Error in MyTop method. It's ok");
	}
	
	

}