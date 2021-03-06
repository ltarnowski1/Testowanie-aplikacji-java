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

	public Integer Heheszki(Integer liczba) throws NieudanyPsikusException
	{	
		if(liczba == 0)
			throw new NieudanyPsikusException();
		if(liczba < 0)
		{
			liczba = -liczba;
		}	
		return r.nextInt(liczba);
	}
	
	public boolean Titit(Integer liczba_dziel) {
		if(liczba%liczba_dziel == 0)
			return true;
		else
		return false;
	}
	
	public Integer HultajChochla(Integer liczba) throws NieudanyPsikusException{
		boolean czy_ujemna = false;
		if(liczba < 0)
		{
			czy_ujemna = true;
			liczba = -liczba;
		}	
		String liczba_ciag = liczba.toString();
		StringBuilder sb = new StringBuilder(liczba_ciag);
		if(liczba_ciag.length() < 2)
			throw new NieudanyPsikusException();
		else
		{	
			int liczba1 = r.nextInt(liczba_ciag.length());
			int liczba2;
			do
			liczba2 = r.nextInt(liczba_ciag.length());
			while(liczba1 == liczba2);
			char znak1 = sb.charAt(liczba1);
			char znak2 = sb.charAt(liczba2);
			sb.setCharAt(liczba2, znak1);
			sb.setCharAt(liczba1, znak2);	
		}	
		if (czy_ujemna)
			return -Integer.parseInt(sb.toString());
		else
		return Integer.parseInt(sb.toString());
	}
}
