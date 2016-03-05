package maven.Zad2Projekt1;

import java.util.Random;

public class PsikusImpl implements Psikus {

	private Integer liczba;
	
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
			Random r = new Random();
			int liczba_dl = liczba_ciag.length();
			int losowa = r.nextInt(liczba_dl);
			StringBuilder sb = new StringBuilder(liczba_ciag);
			sb.deleteCharAt(losowa);
			return Integer.parseInt(sb.toString());
		}
	}

	public Integer Nieksztaltek(Integer liczba) {
		liczba.toString();
		return null;
	}

	public Integer Heheszki(Integer liczba) {
		Random r = new Random();
		r.nextInt(liczba);
		return null;
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
