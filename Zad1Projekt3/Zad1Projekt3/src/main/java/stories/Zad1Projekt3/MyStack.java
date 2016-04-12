package stories.Zad1Projekt3;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	
	private List<Integer> list;
	
	public MyStack() {
		list = new ArrayList<Integer>();
	}

	
	public MyStack(List<Integer> list) {
		this.list = list;
	}
	
	public void MyPush(int a)
	{
		list.add(a);
	}
	
	public void MyPoP() throws NullPointerException
	{
		if (list.isEmpty()) {
			throw new NullPointerException();
		}
		else {
			list.remove(list.size()-1);
		} 
	}
	
	public int MyTop() throws NullPointerException
	{
		if (list.isEmpty()) {
			throw new NullPointerException();
		}
		return list.get(list.size()-1);
	}
	
	public boolean IsNull()
	{
		if (list.isEmpty()) return true;
		else return false;
	}

}
