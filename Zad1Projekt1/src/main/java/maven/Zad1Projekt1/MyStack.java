package maven.Zad1Projekt1;


import java.util.List;

public class MyStack {
	
	private List<Integer> list;
	
	public void MyPush(int a)
	{
		list.add(a);
	}
	
	public void MyPoP(int a)
	{
		
		list.remove(list.size()-1);
	}
	
	public int MyTop()
	{
	  return	list.get(list.size()-1);
	}
	
	public boolean IsNull()
	{
		if (list.isEmpty()) return true;
		else return false;
	}
	
	public List<Integer> getList()
	{
		return list;
	}

	public void setList(List<Integer> asList) {
		list = asList;
		
	}

}


