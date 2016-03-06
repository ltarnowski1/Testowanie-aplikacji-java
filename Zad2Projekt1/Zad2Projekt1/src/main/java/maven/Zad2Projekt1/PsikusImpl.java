package maven.Zad2Projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PsikusImpl implements Psikus {

	private Integer liczba;
	Random r = new Random();
	
	public PsikusImpl(Integer liczba)
	{
		this.liczba = liczba;
	}
	
	public Integer CyfroKrad(Integer liczba) {
		String liczba_ciag = liczba.toString();
		if(liczba_ciag.length() == 1)
			return null;
		else
		{
			int liczba_dl = liczba_ciag.length();
			int losowa = r.nextInt(liczba_dl);
			StringBuilder sb = new StringBuilder(liczba_ciag);
			sb.deleteCharAt(losowa);
			return Integer.parseInt(sb.toString());
		}
	}

	public Integer Nieksztaltek(Integer liczba) {
		
		List<Integer> l = new ArrayList<Integer>();
		String liczba_ciag = liczba.toString();
		StringBuilder sb = new StringBuilder(liczba_ciag);
		for (int i = 0; i<liczba_ciag.length(); i++)
		{
			if(sb.charAt(i) == '3' || sb.charAt(i) == '7' || sb.charAt(i) == '6')
			{
				l.add(i);
			}	
		}
		

		if(l.size() == 0)
			return Integer.parseInt(sb.toString());
		else
		{
			int losowa = r.nextInt(l.size());
		switch (sb.charAt(l.get(losowa)))
		{
		  case '3':
			  sb.setCharAt(l.get(losowa), '8');
			  break;
			  
		  case '7':
			  sb.setCharAt(l.get(losowa), '1');
			  break;
			  
		  case '6':
			  sb.setCharAt(l.get(losowa), '9');
			  break;
		}
		
		return Integer.parseInt(sb.toString());
		}
	}

	public Integer Heheszki(Integer liczba) {
		return r.nextInt(liczba);
	}
	
	public boolean Titit(Integer liczba_dziel) {
		if(liczba%liczba_dziel == 0)
			return true;
		else
		return false;
	}
	
	public Integer HultajChochla(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}
}
