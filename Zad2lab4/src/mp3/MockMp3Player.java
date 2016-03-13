package mp3;

import java.io.BufferedWriter;
import java.sql.Time;
import java.util.ArrayList;

public class MockMp3Player implements Mp3Player
{
	private ArrayList<String> playList = new ArrayList<String>();
	private String currentSong = new String();
	private double currentPosition = 0.0;
	private boolean isPlaying = false;
	
	@Override
	public String currentSong()
	{
		return currentSong;
	}
	
	@Override
	public double currentPosition()
	{
		return currentPosition;
	}
	
	@Override
	public boolean isPlaying()
	{	
		return isPlaying;
	}
	
	@Override
	public void loadSongs(ArrayList names)
	{
		playList = names;
		currentSong = playList.get(0);
		currentPosition = 0.0;		
	}
	
	public int currentSongIndex()
	{
		return playList.indexOf(currentSong);
	}
	
	public ArrayList<String> getSongs()
	{
		return playList;
	}
	
	@Override
	public void play()
	{
		if(playList.isEmpty())
			return;
		else
			isPlaying = true;	
	}

	@Override
	public void pause()
	{	
		if(isPlaying == true)
		{
			isPlaying = false;
			currentPosition = 1.0;
		}
	}

	@Override
	public void stop()
	{
		isPlaying = false;
		currentPosition = 0.0;
	}

	@Override
	public void next()
	{
		isPlaying = false;
		if(playList.indexOf(currentSong) == playList.size()-1)
			currentSong = playList.get(0);
		else
			currentSong = playList.get(playList.indexOf(currentSong)+1);
		currentPosition = 0.0;
		isPlaying = true;
	}

	@Override
	public void prev()
	{
		isPlaying = false;
		if(playList.indexOf(currentSong) == 0)
			currentSong = playList.get(playList.size()-1);
		else
			currentSong = playList.get(playList.indexOf(currentSong)-1);
		currentPosition = 0.0;
		isPlaying = true;
	}
}
