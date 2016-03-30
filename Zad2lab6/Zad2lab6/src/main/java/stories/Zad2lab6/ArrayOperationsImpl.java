package stories.Zad2lab6;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Array;

public class ArrayOperationsImpl implements ArrayOperations {
	
	List<Integer> ArrayAsList = new ArrayList<Integer>();
	
	public ArrayOperationsImpl()
	{
		
	}
	
	public Integer largest(Integer[] array) {
		ArrayAsList = Arrays.asList(array);
		return Collections.max(ArrayAsList);
	}

	public Integer least(Integer[] array) {
		ArrayAsList = Arrays.asList(array);
		return Collections.min(ArrayAsList);
	}

}
