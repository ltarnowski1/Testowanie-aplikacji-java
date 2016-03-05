package maven.Zad1Projekt1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import maven.Zad1Projekt1.MyStack;

public class MyStackTest {

	private MyStack stack;
	
	@Before
	public void setup()
	{
		stack = new MyStack();
		stack.setList(new ArrayList<Integer>());
		//stack.setList(Arrays.asList(1,2,3));
	}
	
	@Test
	public void MyPushTest() {
		stack.MyPush(1);
		stack.MyPush(2);
		stack.MyPush(3);
		assertThat(stack.getList(), contains(1,2,3));
		for(int i = 0; i < 5; i++)
			assertThat(stack.MyTop(),is(3));
	}
	
	@Test
	public void MyPoPTest() {
		stack.MyPush(1);
		stack.MyPush(2);
		stack.MyPush(3);
		stack.MyPoP(3);
		assertThat(stack.getList(), contains(1,2));
	}
	
	@Test
	public void MyTopTest() {
		stack.MyPush(1);
		stack.MyPush(2);
		assertThat(stack.MyTop(), is(2));
	}
	
	@Test
	public void IsNullTest() {
		assertThat(stack.IsNull(), equalTo(true));
		stack.MyPush(1);
		assertThat(stack.IsNull(), equalTo(false));
	}
	
	@After
	public void teardown()
	{
		stack = null;
	}
}
