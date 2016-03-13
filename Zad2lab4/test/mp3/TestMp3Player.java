package mp3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMp3Player {

	private MockMp3Player mp3;
	private ArrayList<String> list;
	
	@Before
	public void setUp()
	{
		mp3 = new MockMp3Player();
		list = new ArrayList<String>();
		list.add("Frontside - Katharsis");
		list.add("Behemoth - Ov the Fire and the Void");
		list.add("All pigs must die - Sadistic Vindicator");
		list.add("Bloodspot - Volcanos");
	}
	
	@Test
	public void testPlay()
	{
		mp3.loadSongs(list);
		Assert.assertEquals(mp3.getSongs(), list);
		Assert.assertTrue(mp3.currentPosition() == 0.0);
		Assert.assertEquals(mp3.currentSong(), "Frontside - Katharsis");
		
		mp3.play();
		Assert.assertTrue(mp3.isPlaying() == true);
		
		mp3.pause();
		Assert.assertEquals(mp3.isPlaying(), false);
		Assert.assertTrue(mp3.currentPosition() == 1.0);
		
		mp3.stop();
		Assert.assertEquals(mp3.isPlaying(), false);
		Assert.assertTrue(mp3.currentPosition() == 0.0);
	}
	
	@Test
	public void testPlayNoList()
	{
		assertFalse(mp3.isPlaying());
		
		mp3.play();
		assertFalse(mp3.isPlaying());
		
		mp3.pause();
		assertFalse(mp3.isPlaying());
		
		mp3.stop();
		assertFalse(mp3.isPlaying());
	}
	
	@Test
	public void testAdvance()
	{
		mp3.loadSongs(list);
		
		mp3.play();
		Assert.assertTrue(mp3.isPlaying() == true);
		
		mp3.prev();
		Assert.assertEquals(mp3.currentSongIndex(), 3);
		
		mp3.next();
		Assert.assertEquals(mp3.currentSongIndex(), 0);
		
		mp3.next();
		Assert.assertEquals(mp3.currentSongIndex(), 1);
		
		mp3.prev();
		Assert.assertEquals(mp3.currentSongIndex(), 0);
		
		mp3.next();
		Assert.assertEquals(mp3.currentSongIndex(), 1);
		
		mp3.next();
		Assert.assertEquals(mp3.currentSongIndex(), 2);
		
		mp3.next();
		Assert.assertEquals(mp3.currentSongIndex(), 3);
	}
	
	@After
	public void teardown()
	{
		mp3=null;
		list=null;
	}
}
