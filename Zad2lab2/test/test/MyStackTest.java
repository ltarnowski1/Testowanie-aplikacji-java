package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.ListView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.MyStack;

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
	}
	
	@After
	public void teardown()
	{
		stack = null;
	}

}
