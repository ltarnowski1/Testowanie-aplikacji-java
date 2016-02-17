package test;

public class NWDImpl implements NWD {
	
	@Override
    public int NWD1(int pierwsza, int druga)
    {
		if(pierwsza < 0 || druga < 0)
			throw new IllegalArgumentException();
		
        while (pierwsza != druga) 
        {
            if (pierwsza > druga)  
            {
                pierwsza = pierwsza - druga; 
            }                               
            else
            {
                druga = druga - pierwsza;
            }
        }
        return pierwsza; 
    }

}
